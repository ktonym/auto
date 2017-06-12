package ke.co.apollo.autoxpress.entity;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
public class Gearbox {

    private Integer gearboxId;
    private List<String> shifting;
    private Integer inspectionId;

    public Gearbox() {
    }

    public Gearbox(GearboxBuilder builder) {
        this.gearboxId = builder.gearboxId;
        this.shifting = builder.shifting;
        this.inspectionId = builder.inspectionId;
    }

    public static class GearboxBuilder{
        private Integer gearboxId;
        private List<String> shifting;
        private final Integer inspectionId;

        public GearboxBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }

        public GearboxBuilder geaboxId(Integer gearboxId){
            this.gearboxId = gearboxId;
            return this;
        }
        public GearboxBuilder shifting(List<String> shifting){
            this.shifting = shifting;
            return this;
        }
        public Gearbox build(){
            return new Gearbox(this);
        }

    }

    public Integer getGearboxId() {
        return gearboxId;
    }

    public List<String> getShifting() {
        return shifting;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
