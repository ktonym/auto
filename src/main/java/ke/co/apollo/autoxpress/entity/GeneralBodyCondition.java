package ke.co.apollo.autoxpress.entity;


/**
 * Created by anthony.kipkoech on 09/06/2017.
 */
public class GeneralBodyCondition {

    private Integer genBodyCondId;
    private Boolean lhWiper;
    private Boolean rhWiper;
    private Boolean windscreenChipped;
    private Boolean windscreenCracked;
    private String doorComments;
    private Boolean lhMirrorPresent;
    private Boolean rhMirrorPresent;
    private Boolean dentedFenderAndBumper;
    private Inspection inspection;

    public GeneralBodyCondition() {
    }

    public GeneralBodyCondition(GeneralBodyConditionBuilder builder) {
        this.genBodyCondId = builder.genBodyCondId;
        this.lhWiper = builder.lhWiper;
        this.rhWiper = builder.rhWiper;
        this.windscreenChipped = builder.windscreenChipped;
        this.windscreenCracked = builder.windscreenCracked;
        this.doorComments = builder.doorComments;
        this.lhMirrorPresent = builder.lhMirrorPresent;
        this.rhMirrorPresent = builder.rhMirrorPresent;
        this.dentedFenderAndBumper = builder.dentedFenderAndBumper;
        this.inspection = builder.inspection;
    }

    public static class GeneralBodyConditionBuilder{

        private Integer genBodyCondId;
        private Boolean lhWiper;
        private Boolean rhWiper;
        private Boolean windscreenChipped;
        private Boolean windscreenCracked;
        private String doorComments;
        private Boolean lhMirrorPresent;
        private Boolean rhMirrorPresent;
        private Boolean dentedFenderAndBumper;
        private final Inspection inspection;

        public GeneralBodyConditionBuilder(Inspection inspection) {
            this.inspection = inspection;
        }
        public GeneralBodyConditionBuilder genBodyCondId(Integer genBodyCondId){
            this.genBodyCondId = genBodyCondId;
            return this;
        }
        public GeneralBodyConditionBuilder lhWiper(Boolean lhWiper){
            this.lhWiper = lhWiper;
            return this;
        }
        public GeneralBodyConditionBuilder rhWiper(Boolean rhWiper){
            this.rhWiper = rhWiper;
            return this;
        }
        public GeneralBodyConditionBuilder windscreenChipped(Boolean windscreenChipped){
            this.windscreenChipped = windscreenChipped;
            return this;
        }
        public GeneralBodyConditionBuilder windscreenCracked(Boolean windscreenCracked){
            this.windscreenCracked = windscreenCracked;
            return this;
        }
        public GeneralBodyConditionBuilder doorComments(String doorComments){
            this.doorComments = doorComments;
            return this;
        }
        public GeneralBodyConditionBuilder lhMirrorPresent(Boolean lhMirrorPresent){
            this.lhMirrorPresent = lhMirrorPresent;
            return this;
        }
        public GeneralBodyConditionBuilder rhMirrorPresent(Boolean rhMirrorPresent){
            this.rhMirrorPresent = rhMirrorPresent;
            return this;
        }
        public GeneralBodyConditionBuilder dentedFenderAndBumper(Boolean dentedFenderAndBumper){
            this.dentedFenderAndBumper = dentedFenderAndBumper;
            return this;
        }
        public GeneralBodyCondition build(){
            return new GeneralBodyCondition(this);
        }
    }

    public Integer getGenBodyCondId() {
        return genBodyCondId;
    }

    public Boolean getLhWiper() {
        return lhWiper;
    }

    public Boolean getRhWiper() {
        return rhWiper;
    }

    public Boolean getWindscreenChipped() {
        return windscreenChipped;
    }

    public Boolean getWindscreenCracked() {
        return windscreenCracked;
    }

    public String getDoorComments() {
        return doorComments;
    }

    public Boolean getLhMirrorPresent() {
        return lhMirrorPresent;
    }

    public Boolean getRhMirrorPresent() {
        return rhMirrorPresent;
    }

    public Boolean getDentedFenderAndBumper() {
        return dentedFenderAndBumper;
    }

    public Inspection getInspection() {
        return inspection;
    }
}
