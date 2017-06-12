package ke.co.apollo.autoxpress.entity;

import java.util.ArrayList;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
public class Tyres {

    private Integer tyreId;
    private ArrayList<String> frontLeft;
    private ArrayList<String> frontRight;
    private ArrayList<String> backLeft;
    private ArrayList<String> backRight;
    private ArrayList<String> spare;
    private Integer inspectionId;

    public Tyres() {
    }

    public Tyres(TyresBuilder builder) {
        this.tyreId = builder.tyreId;
        this.frontLeft = builder.frontLeft;
        this.frontRight = builder.frontRight;
        this.backLeft = builder.backLeft;
        this.backRight = builder.backRight;
        this.spare = builder.spare;
        this.inspectionId = builder.inspectionId;
    }

    public static class TyresBuilder{

        private Integer tyreId;
        private ArrayList<String> frontLeft;
        private ArrayList<String> frontRight;
        private ArrayList<String> backLeft;
        private ArrayList<String> backRight;
        private ArrayList<String> spare;
        private final Integer inspectionId;

        public TyresBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }
        public TyresBuilder tyreId(Integer tyreId){
            this.tyreId = tyreId;
            return this;
        }
        public TyresBuilder frontLeft(ArrayList<String> frontLeft){
            this.frontLeft=frontLeft;
            return this;
        }
        public TyresBuilder frontRight(ArrayList<String> frontRight){
            this.frontRight=frontRight;
            return this;
        }
        public TyresBuilder backLeft(ArrayList<String> backLeft){
            this.backLeft=backLeft;
            return this;
        }
        public TyresBuilder backRight(ArrayList<String> backRight){
            this.backRight=backRight;
            return this;
        }
        public TyresBuilder spare(ArrayList<String> spare){
            this.spare=spare;
            return this;
        }
        public Tyres build(){
            return new Tyres(this);
        }
    }

    public Integer getTyreId() {
        return tyreId;
    }

    public ArrayList<String> getFrontLeft() {
        return frontLeft;
    }

    public ArrayList<String> getFrontRight() {
        return frontRight;
    }

    public ArrayList<String> getBackLeft() {
        return backLeft;
    }

    public ArrayList<String> getBackRight() {
        return backRight;
    }

    public ArrayList<String> getSpare() {
        return spare;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
