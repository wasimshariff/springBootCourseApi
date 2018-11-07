import com.opencsv.bean.CsvBindByPosition;

public class SegmentVO {

    @CsvBindByPosition(position = 0)
    private long segmentCode;
    @CsvBindByPosition(position = 1)
    private String segmentDescription;
    @CsvBindByPosition(position = 2)
    private int familyCode;
    @CsvBindByPosition(position = 3)
    private String  familyDescription;
    @CsvBindByPosition(position = 4)
    private int classCode;
    @CsvBindByPosition(position = 5)
    private String classDescription;
    @CsvBindByPosition(position = 6)
    private int brickCode;
    @CsvBindByPosition(position = 7)
    private String brickDescription;

    public long getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(long segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getSegmentDescription() {
        return segmentDescription;
    }

    public void setSegmentDescription(String segmentDescription) {
        this.segmentDescription = segmentDescription;
    }

    public int getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(int familyCode) {
        this.familyCode = familyCode;
    }

    public String getFamilyDescription() {
        return familyDescription;
    }

    public void setFamilyDescription(String familyDescription) {
        this.familyDescription = familyDescription;
    }

    public int getClassCode() {
        return classCode;
    }

    public void setClassCode(int classCode) {
        this.classCode = classCode;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public int getBrickCode() {
        return brickCode;
    }

    public void setBrickCode(int brickCode) {
        this.brickCode = brickCode;
    }

    public String getBrickDescription() {
        return brickDescription;
    }

    public void setBrickDescription(String brickDescription) {
        this.brickDescription = brickDescription;
    }

    @Override
    public String toString() {
        return "SegmentVO{" +
                "segmentCode=" + segmentCode +
                ", segmentDescription='" + segmentDescription + '\'' +
                ", familyCode=" + familyCode +
                ", familyDescription='" + familyDescription + '\'' +
                ", classCode=" + classCode +
                ", classDescription='" + classDescription + '\'' +
                ", brickCode=" + brickCode +
                ", brickDescription='" + brickDescription + '\'' +
                '}';
    }
}
