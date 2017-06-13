package ke.co.apollo.autoxpress.entity;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class VehicleModel {

    private Integer modelId;
    private String model;
    private Integer vehicleMakeId;

    public VehicleModel() {
    }

    public VehicleModel(VehicleModelBuilder builder) {
        this.modelId = builder.modelId;
        this.model = builder.model;
        this.vehicleMakeId = builder.vehicleMakeId;
    }

    public static class VehicleModelBuilder{

        private Integer modelId;
        private String model;
        private Integer vehicleMakeId;

        public VehicleModelBuilder() {
        }

        public VehicleModelBuilder makeId(Integer makeId){
            this.vehicleMakeId = makeId;
            return this;
        }

        public VehicleModelBuilder modelId(Integer modelId){
            this.modelId = modelId;
            return this;
        }

        public VehicleModelBuilder model(String model){
            this.model = model;
            return this;
        }

        public VehicleModel build(){
            return new VehicleModel(this);
        }
    }

    public Integer getModelId() {
        return modelId;
    }

    public String getModel() {
        return model;
    }

    public Integer getVehicleMakeId() {
        return vehicleMakeId;
    }
}
