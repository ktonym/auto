package ke.co.apollo.autoxpress.entity;


/**
 * Created by anthony.kipkoech on 09/06/2017.
 */
public class Lighting  {

    private Integer lightingId;
    private Boolean leftHeadLight,rightHeadLight,
            lhBrakeLight,rhBrakeLight,
            lhFrontIndicator,rhFrontIndicator,
            rhRearIndicator,lhRearIndicator,
            frontParkingLight,rearParkingLight,
            leftTailLight,rightTailLight,
            rhReverseLight,lhReverseLight;
    private Inspection inspection;

    public Lighting() {
    }

    public Lighting(LightingBuilder builder) {
        this.lightingId = builder.lightingId;
        this.leftHeadLight = builder.leftHeadLight;
        this.rightHeadLight = builder.rightHeadLight;
        this.lhBrakeLight = builder.lhBrakeLight;
        this.rhBrakeLight = builder.rhBrakeLight;
        this.lhFrontIndicator = builder.lhFrontIndicator;
        this.rhFrontIndicator = builder.rhFrontIndicator;
        this.rhRearIndicator = builder.rhRearIndicator;
        this.lhRearIndicator = builder.lhRearIndicator;
        this.frontParkingLight = builder.frontParkingLight;
        this.rearParkingLight = builder.rearParkingLight;
        this.leftTailLight = builder.leftTailLight;
        this.rightTailLight = builder.rightTailLight;
        this.rhReverseLight = builder.rhReverseLight;
        this.lhReverseLight = builder.lhReverseLight;
        this.inspection = builder.inspection;
    }

    public static class LightingBuilder{
        private Integer lightingId;
        private Boolean leftHeadLight,rightHeadLight,lhBrakeLight,rhBrakeLight,
                lhFrontIndicator,rhFrontIndicator,
                rhRearIndicator,lhRearIndicator,frontParkingLight,rearParkingLight,
                leftTailLight,rightTailLight,rhReverseLight,lhReverseLight;
        private final Inspection inspection;

        public LightingBuilder(Inspection inspection) {
            this.inspection = inspection;
        }
        public LightingBuilder lightingId(Integer lightingId){
            this.lightingId = lightingId;
            return this;
        }
        public LightingBuilder leftHeadLight(Boolean leftHeadLight){
            this.leftHeadLight = leftHeadLight;
            return this;
        }
        public LightingBuilder rightHeadLight(Boolean rightHeadLight){
            this.rightHeadLight = rightHeadLight;
            return this;
        }
        public LightingBuilder lhBrakeLight(Boolean lhBrakeLight){
            this.lhBrakeLight = lhBrakeLight;
            return this;
        }
        public LightingBuilder rhBrakeLight(Boolean rhBrakeLight){
            this.rhBrakeLight = rhBrakeLight;
            return this;
        }
        public LightingBuilder lhFrontIndicator(Boolean lhFrontIndicator){
            this.lhFrontIndicator = lhFrontIndicator;
            return this;
        }
        public LightingBuilder rhFrontIndicator(Boolean rhFrontIndicator){
            this.rhFrontIndicator = rhFrontIndicator;
            return this;
        }
        public LightingBuilder rhRearIndicator(Boolean rhRearIndicator){
            this.rhRearIndicator = rhRearIndicator;
            return this;
        }
        public LightingBuilder lhRearIndicator(Boolean lhRearIndicator){
            this.lhRearIndicator = lhRearIndicator;
            return this;
        }
        public LightingBuilder frontParkingLight(Boolean frontParkingLight){
            this.frontParkingLight = frontParkingLight;
            return this;
        }
        public LightingBuilder rearParkingLight(Boolean rearParkingLight){
            this.rearParkingLight = rearParkingLight;
            return this;
        }
        public LightingBuilder leftTailLight(Boolean leftTailLight){
            this.leftTailLight = leftTailLight;
            return this;
        }
        public LightingBuilder rightTailLight(Boolean rightTailLight){
            this.rightTailLight = rightTailLight;
            return this;
        }
        public LightingBuilder rhReverseLight(Boolean rhReverseLight){
            this.rhReverseLight = rhReverseLight;
            return this;
        }
        public LightingBuilder lhReverseLight(Boolean lhReverseLight){
            this.lhReverseLight = lhReverseLight;
            return this;
        }
        public Lighting build(){
            return new Lighting(this);
        }

    }

    public Integer getLightingId() {
        return lightingId;
    }

    public Boolean getLeftHeadLight() {
        return leftHeadLight;
    }

    public Boolean getRightHeadLight() {
        return rightHeadLight;
    }

    public Boolean getLhBrakeLight() {
        return lhBrakeLight;
    }

    public Boolean getRhBrakeLight() {
        return rhBrakeLight;
    }

    public Boolean getLhFrontIndicator() {
        return lhFrontIndicator;
    }

    public Boolean getRhFrontIndicator() {
        return rhFrontIndicator;
    }

    public Boolean getRhRearIndicator() {
        return rhRearIndicator;
    }

    public Boolean getLhRearIndicator() {
        return lhRearIndicator;
    }

    public Boolean getFrontParkingLight() {
        return frontParkingLight;
    }

    public Boolean getRearParkingLight() {
        return rearParkingLight;
    }

    public Boolean getLeftTailLight() {
        return leftTailLight;
    }

    public Boolean getRightTailLight() {
        return rightTailLight;
    }

    public Boolean getRhReverseLight() {
        return rhReverseLight;
    }

    public Boolean getLhReverseLight() {
        return lhReverseLight;
    }

    public Inspection getInspection() {
        return inspection;
    }
}
