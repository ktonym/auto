package ke.co.apollo.autoxpress.entity;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
public class Steering {

    private Integer steeringId;
    private List<String> play;
    private Integer inspectionId;

    public Steering() {
    }

    public Steering(SteeringBuilder builder) {
        this.steeringId = builder.steeringId;
        this.play = builder.play;
        this.inspectionId = builder.inspectionId;
    }

    public static class SteeringBuilder{
        private Integer steeringId;
        private List<String> play;
        private final Integer inspectionId;

        public SteeringBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }
        public SteeringBuilder steeringId(Integer steeringId){
            this.steeringId = steeringId;
            return this;
        }
        public SteeringBuilder play(List<String> play){
            this.play = play;
            return this;
        }
        public Steering build(){
            return new Steering(this);
        }
    }

    public Integer getSteeringId() {
        return steeringId;
    }

    public List<String> getPlay() {
        return play;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
