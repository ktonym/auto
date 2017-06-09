package ke.co.apollo.autoxpress.entity;

/**
 * Created by anthony.kipkoech on 08/06/2017.
 */
public class Photo {

    private Integer photoId;
    private String engine;
    private String dashboard;
    private String bonnet;
    private String rear;
    private String left;
    private String right;
    private String interior;
    private String front;
    private Integer inspectionId;

    public Photo() {
    }

    public Photo(PhotoBuilder builder) {
        this.photoId = builder.photoId;
        this.engine = builder.engine;
        this.dashboard = builder.dashboard;
        this.bonnet = builder.bonnet;
        this.rear = builder.rear;
        this.left = builder.left;
        this.right = builder.right;
        this.interior = builder.interior;
        this.front = builder.front;
        this.inspectionId = builder.inspectionId;
    }

    public static class PhotoBuilder{

        private Integer photoId;
        private String engine;
        private String dashboard;
        private String bonnet;
        private String rear;
        private String left;
        private String right;
        private String interior;
        private String front;
        private final Integer inspectionId;

        public PhotoBuilder(Integer inspectionId) {
            this.inspectionId = inspectionId;
        }
        public PhotoBuilder photoId(Integer photoId){
            this.photoId = photoId;
            return this;
        }
        public PhotoBuilder engine(String engine){
            this.engine = engine;
            return this;
        }
        public PhotoBuilder dashboard(String dashboard){
            this.dashboard = dashboard;
            return this;
        }
        public PhotoBuilder bonnet(String bonnet){
            this.bonnet = bonnet;
            return this;
        }
        public PhotoBuilder rear(String rear){
            this.rear = rear;
            return this;
        }
        public PhotoBuilder left(String left){
            this.left = left;
            return this;
        }
        public PhotoBuilder right(String right){
            this.right = right;
            return this;
        }
        public PhotoBuilder interior(String interior){
            this.interior = interior;
            return this;
        }
        public PhotoBuilder front(String front){
            this.front = front;
            return this;
        }
        public Photo build(){
            return new Photo(this);
        }
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public String getEngine() {
        return engine;
    }

    public String getDashboard() {
        return dashboard;
    }

    public String getBonnet() {
        return bonnet;
    }

    public String getRear() {
        return rear;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public String getInterior() {
        return interior;
    }

    public String getFront() {
        return front;
    }

    public Integer getInspectionId() {
        return inspectionId;
    }
}
