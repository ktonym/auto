package ke.co.apollo.autoxpress.entity;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
public class Brakes {

    private Integer brakesId;
    private List<String> foot;
    private List<String> hand;
    private Integer inspectionId;

    public Brakes() {
    }

    public Brakes(BrakesBuilder builder) {
        this.brakesId = builder.brakesId;
        this.foot = builder.foot;
        this.hand = builder.hand;
        this.inspectionId = builder.inspectionId;
    }

    public static class BrakesBuilder{

        private Integer brakesId;
        private List<String> foot;
        private List<String> hand;
        private final Integer inspectionId;

        public BrakesBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }
        public BrakesBuilder brakesId(Integer brakesId){
            this.brakesId = brakesId;
            return this;
        }
        public BrakesBuilder foot(List<String> foot){
            this.foot = foot;
            return this;
        }
        public BrakesBuilder hand(List<String> hand){
            this.hand = hand;
            return this;
        }
        public Brakes build(){
            return new Brakes(this);
        }
    }

    public Integer getBrakesId() {
        return brakesId;
    }

    public List<String> getFoot() {
        return foot;
    }

    public List<String> getHand() {
        return hand;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
