
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCsvTest {

    public static void main(String a[]) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("C:\\apps\\IntellijWorkSpace\\SpringBoot\\src\\test\\java\\moulika.csv"));
            CSVReader csvReader = new CSVReader(reader);
            String[] headers = csvReader.readNext();
            CsvToBean<SegmentVO> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(SegmentVO.class)
                    .withSkipLines(1)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<SegmentVO> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                SegmentVO segmentVO = csvUserIterator.next();
                System.out.println(segmentVO);
                System.out.println("==========================");
            }
            csvReader.close();
            System.out.println("done");
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
