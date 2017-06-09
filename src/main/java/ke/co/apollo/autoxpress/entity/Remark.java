package ke.co.apollo.autoxpress.entity;

/**
 * Created by anthony.kipkoech on 08/06/2017.
 */
public class Remark {

    private Integer remarkId;
    private String generalCondition;
    private AntiTheftDevice antiTheftDevice;
    private Double estimatedValue;
    private String overallComment;
    private Integer inspectionId;

    public Remark() {
    }

    public Remark(RemarkBuilder builder) {
        this.remarkId = builder.remarkId;
        this.generalCondition = builder.generalCondition;
        this.antiTheftDevice = builder.antiTheftDevice;
        this.estimatedValue = builder.estimatedValue;
        this.overallComment = builder.overallComment;
        this.inspectionId = builder.inspectionId;
    }

    public static class RemarkBuilder{

        private Integer remarkId;
        private String generalCondition;
        private AntiTheftDevice antiTheftDevice;
        private Double estimatedValue;
        private String overallComment;
        private final Integer inspectionId;

        public RemarkBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }
        public RemarkBuilder remarkId(Integer remarkId){
            this.remarkId = remarkId;
            return this;
        }
        public RemarkBuilder generalCondition(String generalCondition){
            this.generalCondition = generalCondition;
            return this;
        }
        public RemarkBuilder antiTheftDevice(AntiTheftDevice antiTheftDevice){
            this.antiTheftDevice = antiTheftDevice;
            return this;
        }
        public RemarkBuilder estimatedValue(Double estimatedValue){
            this.estimatedValue = estimatedValue;
            return this;
        }
        public RemarkBuilder overallComment(String overallComment){
            this.overallComment = overallComment;
            return this;
        }
        public Remark build(){
            return new Remark(this);
        }
    }

    public Integer getRemarkId() {
        return remarkId;
    }

    public String getGeneralCondition() {
        return generalCondition;
    }

    public AntiTheftDevice getAntiTheftDevice() {
        return antiTheftDevice;
    }

    public Double getEstimatedValue() {
        return estimatedValue;
    }

    public String getOverallComment() {
        return overallComment;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
