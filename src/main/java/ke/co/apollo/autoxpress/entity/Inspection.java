package ke.co.apollo.autoxpress.entity;

import java.time.LocalDate;

/**
 * Created by anthony.kipkoech on 07/06/2017.
 */
public class Inspection {

    private Integer inspectionId;
    private LocalDate inspectionDate;
    private Long odometerReading;
    private String regNo;
    private Boolean shocksFitting;
    private Boolean shocksPhysical;
    private Boolean steeringPlay;
    private Boolean gearShiftingProperly;
    private Boolean footBrakes;
    private Boolean handbrakes;
    private Boolean engineOilLeaks;
    private Boolean frontLeftTyre;
    private Boolean frontRightTyre;
    private Boolean rearRightTyre;
    private Boolean rearLeftTyre;
    private Boolean spareTyre;
    private Boolean headLights; //headlight in db
    private Boolean brakeLights; //breaklights in db
    private Boolean indicators;
    private Boolean parkingLights;
    private Boolean tailLights;
    private Boolean reverseLights;
    private Boolean wiringConcerns;
    private Boolean windscreenWipers;
    private Boolean windscreenCrackFree;
    private Boolean doorLocks;
    private Boolean sideMirrors;
    private Boolean fenderAndBumper;
    private Boolean generalCondition;
    private Boolean complete;

    public Inspection() {
    }

    public Inspection(InspectionBuilder builder) {
        this.inspectionId = builder.inspectionId;
        this.inspectionDate = builder.inspectionDate;
        this.odometerReading = builder.odometerReading;
        this.regNo = builder.regNo;
        this.shocksFitting = builder.shocksFitting;
        this.shocksPhysical = builder.shocksPhysical;
        this.steeringPlay = builder.steeringPlay;
        this.gearShiftingProperly = builder.gearShiftingProperly;
        this.footBrakes = builder.footBrakes;
        this.handbrakes = builder.handbrakes;
        this.engineOilLeaks = builder.engineOilLeaks;
        this.frontLeftTyre = builder.frontLeftTyre;
        this.frontRightTyre = builder.frontRightTyre;
        this.rearRightTyre = builder.rearRightTyre;
        this.rearLeftTyre = builder.rearLeftTyre;
        this.spareTyre = builder.spareTyre;
        this.headLights = builder.headLights;
        this.brakeLights = builder.brakeLights;
        this.indicators = builder.indicators;
        this.parkingLights = builder.parkingLights;
        this.tailLights = builder.tailLights;
        this.reverseLights = builder.reverseLights;
        this.wiringConcerns = builder.wiringConcerns;
        this.windscreenWipers = builder.windscreenWipers;
        this.windscreenCrackFree = builder.windscreenCrackFree;
        this.doorLocks = builder.doorLocks;
        this.sideMirrors = builder.sideMirrors;
        this.fenderAndBumper = builder.fenderAndBumper;
        this.generalCondition = builder.generalCondition;
        this.complete = builder.complete;
    }

    public static class InspectionBuilder{
        private Integer inspectionId;
        private LocalDate inspectionDate;
        private Long odometerReading;
        private String regNo;
        private Boolean shocksFitting;
        private Boolean shocksPhysical;
        private Boolean steeringPlay;
        private Boolean gearShiftingProperly;
        private Boolean footBrakes;
        private Boolean handbrakes;
        private Boolean engineOilLeaks;
        private Boolean frontLeftTyre;
        private Boolean frontRightTyre;
        private Boolean rearRightTyre;
        private Boolean rearLeftTyre;
        private Boolean spareTyre;
        private Boolean headLights;    //headlight in db
        private Boolean brakeLights;   //breaklights in db
        private Boolean indicators;
        private Boolean parkingLights;
        private Boolean tailLights;
        private Boolean reverseLights;
        private Boolean wiringConcerns;
        private Boolean windscreenWipers;
        private Boolean windscreenCrackFree;
        private Boolean doorLocks;
        private Boolean sideMirrors;
        private Boolean fenderAndBumper;
        private Boolean generalCondition;
        private Boolean complete;

        public InspectionBuilder() {
        }

        public InspectionBuilder inspectionId(Integer inspectionId){
            this.inspectionId = inspectionId;
            return this;
        }

        public InspectionBuilder inspectionDate(LocalDate inspectionDate){
            this.inspectionDate = inspectionDate;
            return this;
        }

        public InspectionBuilder odometerReading(Long odometerReading){
            this.odometerReading = odometerReading;
            return this;
        }

        public InspectionBuilder regNo(String regNo){
            this.regNo = regNo;
            return this;
        }

        public InspectionBuilder shocksFitting(Boolean shocksFitting){
            this.shocksFitting = shocksFitting;
            return this;
        }

        public InspectionBuilder shocksPhysical(Boolean shocksPhysical){
            this.shocksPhysical = shocksPhysical;
            return this;
        }

        public InspectionBuilder steeringPlay(Boolean steeringPlay){
            this.steeringPlay = steeringPlay;
            return this;
        }

        public InspectionBuilder gearShiftingProperly(Boolean gearShiftingProperly){
            this.gearShiftingProperly = gearShiftingProperly;
            return this;
        }

        public InspectionBuilder footBrakes(Boolean footBrakes){
            this.footBrakes = footBrakes;
            return this;
        }

        public InspectionBuilder handbrakes(Boolean handbrakes){
            this.handbrakes = handbrakes;
            return this;
        }

        public InspectionBuilder engineOilLeaks(Boolean engineOilLeaks){
            this.engineOilLeaks = engineOilLeaks;
            return this;
        }

        public InspectionBuilder frontLeftTyre(Boolean frontLeftTyre){
            this.frontLeftTyre = frontLeftTyre;
            return this;
        }

        public InspectionBuilder frontRightTyre(Boolean frontRightTyre){
            this.frontRightTyre = frontRightTyre;
            return this;
        }

        public InspectionBuilder rearRightTyre(Boolean backRightTyre){
            this.rearRightTyre = backRightTyre;
            return this;
        }

        public InspectionBuilder rearLeftTyre(Boolean rearLeftTyre){
            this.rearLeftTyre = rearLeftTyre;
            return this;
        }

        public InspectionBuilder spareTyre(Boolean spareTyre){
            this.spareTyre = spareTyre;
            return this;
        }

        public InspectionBuilder headLights(Boolean headLights){
            this.headLights = headLights;
            return this;
        }

        public InspectionBuilder brakeLights(Boolean brakeLights){
            this.brakeLights = brakeLights;
            return this;
        }

        public InspectionBuilder indicators(Boolean indicators){
            this.indicators = indicators;
            return this;
        }

        public InspectionBuilder parkingLights(Boolean parkingLights){
            this.parkingLights = parkingLights;
            return this;
        }

        public InspectionBuilder tailLights(Boolean tailLights){
            this.tailLights = tailLights;
            return this;
        }

        public InspectionBuilder reverseLights(Boolean reverseLights){
            this.reverseLights = reverseLights;
            return this;
        }

        public InspectionBuilder wiringConcerns(Boolean wiringConcerns){
            this.wiringConcerns = wiringConcerns;
            return this;
        }

        public InspectionBuilder windscreenWipers(Boolean windscreenWipers){
            this.windscreenWipers = windscreenWipers;
            return this;
        }

        public InspectionBuilder windscreenCrackFree(Boolean windscreenCrackFree){
            this.windscreenCrackFree = windscreenCrackFree;
            return this;
        }

        public InspectionBuilder doorLocks(Boolean doorLocks){
            this.doorLocks = doorLocks;
            return this;
        }

        public InspectionBuilder sideMirrors(Boolean sideMirrors){
            this.sideMirrors = sideMirrors;
            return this;
        }

        public InspectionBuilder fenderAndBumper(Boolean fenderAndBumper){
            this.fenderAndBumper = fenderAndBumper;
            return this;
        }

        public InspectionBuilder generalCondition(Boolean generalCondition){
            this.generalCondition = generalCondition;
            return this;
        }

        public InspectionBuilder complete(Boolean complete){
            this.complete = complete;
            return this;
        }

        public Inspection build(){
            return new Inspection(this);
        }

    }

    public Integer getInspectionId() {
        return inspectionId;
    }

    public LocalDate getInspectionDate() {
        return inspectionDate;
    }

    public Long getOdometerReading() {
        return odometerReading;
    }

    public String getRegNo() {
        return regNo;
    }

    public Boolean getShocksFitting() {
        return shocksFitting;
    }

    public Boolean getShocksPhysical() {
        return shocksPhysical;
    }

    public Boolean getSteeringPlay() {
        return steeringPlay;
    }

    public Boolean getGearShiftingProperly() {
        return gearShiftingProperly;
    }

    public Boolean getFootBrakes() {
        return footBrakes;
    }

    public Boolean getHandbrakes() {
        return handbrakes;
    }

    public Boolean getEngineOilLeaks() {
        return engineOilLeaks;
    }

    public Boolean getFrontLeftTyre() {
        return frontLeftTyre;
    }

    public Boolean getFrontRightTyre() {
        return frontRightTyre;
    }

    public Boolean getRearRightTyre() {
        return rearRightTyre;
    }

    public Boolean getRearLeftTyre() {
        return rearLeftTyre;
    }

    public Boolean getSpareTyre() {
        return spareTyre;
    }

    public Boolean getHeadLights() {
        return headLights;
    }

    public Boolean getBrakeLights() {
        return brakeLights;
    }

    public Boolean getIndicators() {
        return indicators;
    }

    public Boolean getParkingLights() {
        return parkingLights;
    }

    public Boolean getTailLights() {
        return tailLights;
    }

    public Boolean getReverseLights() {
        return reverseLights;
    }

    public Boolean getWiringConcerns() {
        return wiringConcerns;
    }

    public Boolean getWindscreenWipers() {
        return windscreenWipers;
    }

    public Boolean getWindscreenCrackFree() {
        return windscreenCrackFree;
    }

    public Boolean getDoorLocks() {
        return doorLocks;
    }

    public Boolean getSideMirrors() {
        return sideMirrors;
    }

    public Boolean getFenderAndBumper() {
        return fenderAndBumper;
    }

    public Boolean getGeneralCondition() {
        return generalCondition;
    }

    public Boolean getComplete(){
        return complete;
    }
}
