package ke.co.apollo.autoxpress.entity;

import java.time.Year;
import java.util.List;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class Vehicle {

    private String regNo;
    private Year yom;
    private String policyNo;
    private String logBookPhoto;
    private Integer bodyTypeId;
    private Integer vehicleModelId;
    private Integer ownerId;
    private byte[] logBookImage;
    private List<Inspection> inspectionList;

    public Vehicle() {
    }

    public Vehicle(VehicleBuilder builder) {
        this.regNo = builder.regNo;
        this.yom = builder.yom;
        this.policyNo = builder.policyNo;
        this.logBookPhoto = builder.logBookPhoto;
        this.bodyTypeId = builder.bodyTypeId;
        this.vehicleModelId = builder.vehicleModelId;
        this.ownerId = builder.ownerId;
    }

    public static class VehicleBuilder{

       private String regNo;
       private Year yom;
       private String policyNo;
       private String logBookPhoto;
       private Integer bodyTypeId;
       private Integer vehicleModelId;
       private Integer ownerId;
       private byte[] logBookImage;

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

       public VehicleBuilder bodyTypeId(Integer bodyTypeId){
           this.bodyTypeId = bodyTypeId;
           return this;
       }

       public VehicleBuilder vehicleModelId(Integer vehicleModelId){
           this.vehicleModelId = vehicleModelId;
           return this;
       }

        public VehicleBuilder ownerId(Integer ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public VehicleBuilder logbookImage(byte[] logBookImage){
           this.logBookImage = logBookImage;
           return this;
        }
       public Vehicle build(){
           return new Vehicle(this);
       }
    }

    public String getRegNo() {
        return regNo;
    }

    public Year getYom() {
        return yom;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public String getLogBookPhoto() {
        return logBookPhoto;
    }

    public Integer getBodyTypeId() {
        return bodyTypeId;
    }

    public Integer getVehicleModelId() {
        return vehicleModelId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public List<Inspection> getInspectionList() {
        return inspectionList;
    }
}
