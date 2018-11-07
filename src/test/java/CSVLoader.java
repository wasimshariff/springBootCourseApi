import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author viralpatel.net
 *
 */
public class CSVLoader {

    private static final
    String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
    private static final String TABLE_REGEX = "\\$\\{table\\}";
    private static final String KEYS_REGEX = "\\$\\{keys\\}";
    private static final String VALUES_REGEX = "\\$\\{values\\}";

    private Connection connection;
    private char seprator;

    /**
     * Public constructor to build CSVLoader object with
     * Connection details. The connection is closed on success
     * or failure.
     * @param connection
     */
    public CSVLoader(Connection connection) {
        this.connection = connection;
        //Set default separator
        this.seprator = ',';
    }

    /**
     * Parse CSV file using OpenCSV library and load in
     * given database table.
     * @param csvFile Input CSV file
     * @param tableName Database table name to import data
     * @param truncateBeforeLoad Truncate the table before inserting
     *           new records.
     * @throws Exception
     */
    public void loadCSV(String csvFile, String tableName,
                        boolean truncateBeforeLoad) throws Exception {

        CSVReader csvReader = null;
        Iterator<SegmentVO> csvUserIterator = null;
        if(null == this.connection) {
            throw new Exception("Not a valid connection.");
        }
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFile));
            // use below reader just for reading header column names
            csvReader = new CSVReader(reader);

            // use below reader for remaining File and map it to Java Object
            CsvToBean<SegmentVO> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(SegmentVO.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
             csvUserIterator = csvToBean.iterator();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error occured while executing file. "
                    + e.getMessage());
        }

        String[] headerRow = csvReader.readNext();

        if (null == headerRow) {
            throw new FileNotFoundException(
                    "No columns defined in given CSV file." +
                            "Please check the CSV file format.");
        }

        String questionmarks = StringUtils.repeat("?,", headerRow.length);
        questionmarks = (String) questionmarks.subSequence(0, questionmarks
                .length() - 1);

        String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
        query = query
                .replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
        query = query.replaceFirst(VALUES_REGEX, questionmarks);

        System.out.println("Query: " + query);

        String[] nextLine;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = this.connection;
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);

            if(truncateBeforeLoad) {
                //delete data from table before loading csv
                con.createStatement().execute("DELETE FROM " + tableName);
            }

//Getting Error Here
            final int batchSize = 158134;
            int count = 0;
            Date date = null;
            while (csvUserIterator.hasNext()) {
                SegmentVO segmentVO = csvUserIterator.next();
                 ps.setLong(1, segmentVO.getSegmentCode());
                 ps.setString(2, segmentVO.getSegmentDescription());
                 ps.setInt(3, segmentVO.getFamilyCode());
                 ps.setString(4, segmentVO.getFamilyDescription());
                 ps.addBatch();
                if (++count % batchSize == 0) {
                    ps.executeBatch();
                }
            }
            ps.executeBatch(); // insert remaining records
            con.commit();
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new Exception(
                    "Error occured while loading data from file to database."
                            + e.getMessage());
        } finally {
            if (null != ps)
                ps.close();
            if (null != con)
                con.close();
            if (csvReader != null)
                csvReader.close();
        }
    }



    public char getSeprator() {
        return seprator;
    }

    public void setSeprator(char seprator) {
        this.seprator = seprator;
    }

}