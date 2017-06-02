package ke.co.apollo.autoxpress.entity;

import java.time.Year;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class Vehicle {

    private String regNo;
    private Year yom;
    private String policyNo;
    private String logBookPhoto;
    private BodyType bodyType;
    private VehicleModel vehicleModel;
    private Owner owner;

    public Vehicle() {
    }

    public Vehicle(VehicleBuilder builder) {
        this.regNo = builder.regNo;
        this.yom = builder.yom;
        this.policyNo = builder.policyNo;
        this.logBookPhoto = builder.logBookPhoto;
        this.bodyType = builder.bodyType;
        this.vehicleModel = builder.vehicleModel;
        this.owner = builder.owner;
    }

    public static class VehicleBuilder{

       private String regNo;
       private Year yom;
       private String policyNo;
       private String logBookPhoto;
       private BodyType bodyType;
       private VehicleModel vehicleModel;
       private Owner owner;

       public VehicleBuilder() {
       }

       public VehicleBuilder regNo(String regNo){
           this.regNo = regNo;
           return this;
       }

       public VehicleBuilder yom(Year yom){
           this.yom = yom;
           return this;
       }

       public VehicleBuilder policyNo(String policyNo){
           this.policyNo = policyNo;
           return this;
       }

       public VehicleBuilder logBookPhoto(String logBookPhoto){
           this.logBookPhoto = logBookPhoto;
           return this;
       }

       public VehicleBuilder bodyType(BodyType bodyType){
           this.bodyType = bodyType;
           return this;
       }

       public VehicleBuilder vehicleModel(VehicleModel vehicleModel){
           this.vehicleModel = vehicleModel;
           return this;
       }

        public VehicleBuilder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

       public Vehicle build(){
           return new Vehicle(this);
       }
    }
}
