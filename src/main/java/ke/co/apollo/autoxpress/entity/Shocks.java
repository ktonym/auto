package ke.co.apollo.autoxpress.entity;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
public class Shocks {

    private Integer shocksId;
    private List<String> fitting;
    private List<String> physical;
    private Integer inspectionId;

    public Shocks() {
    }

    public Shocks(ShocksBuilder builder) {
        this.shocksId = builder.shocksId;
        this.fitting = builder.fitting;
        this.physical = builder.physical;
        this.inspectionId = builder.inspectionId;
    }

    public static class ShocksBuilder{

        private Integer shocksId;
        private List<String> fitting;
        private List<String> physical;
        private final Integer inspectionId;

        public ShocksBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }
        public ShocksBuilder shocksId(Integer shocksId){
            this.shocksId = shocksId;
            return this;
        }
        public ShocksBuilder fitting(List<String> fitting){
            this.fitting = fitting;
            return this;
        }
        public ShocksBuilder physical(List<String> physical){
            this.physical = physical;
            return this;
        }
        public Shocks build(){
            return new Shocks(this);
        }
    }

    public Integer getShocksId() {
        return shocksId;
    }

    public List<String> getFitting() {
        return fitting;
    }

    public List<String> getPhysical() {
        return physical;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
