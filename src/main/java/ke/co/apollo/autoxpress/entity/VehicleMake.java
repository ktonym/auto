package ke.co.apollo.autoxpress.entity;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class VehicleMake {

    private Integer makeId;
    private String make;

    public VehicleMake() {
    }

    public VehicleMake(VehicleMakeBuilder builder) {
        this.makeId = builder.makeId;
        this.make = builder.make;
    }

    public static class VehicleMakeBuilder{
        private Integer makeId;
        private final String make;

        public VehicleMakeBuilder(String make) {
            this.make = make;
        }

        public VehicleMakeBuilder makeId(Integer makeId){
            this.makeId = makeId;
            return this;
        }

        public VehicleMake build(){
            return new VehicleMake(this);
        }
    }

    public Integer getMakeId() {
        return makeId;
    }

    public String getMake() {
        return make;
    }

}
