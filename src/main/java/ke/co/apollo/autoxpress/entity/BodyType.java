package ke.co.apollo.autoxpress.entity;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class BodyType {

    private Integer bodyTypeId;
    private String body;

    public BodyType() {
    }

    public BodyType(BodyTypeBuilder builder) {
        this.body = builder.body;
        this.bodyTypeId = builder.bodyTypeId;
    }

    public static class BodyTypeBuilder {
        private Integer bodyTypeId;
        private String body;

        public BodyTypeBuilder() {
        }

        public BodyTypeBuilder bodyTypeId(Integer bodyTypeId) {
            this.bodyTypeId = bodyTypeId;
            return this;
        }

        public BodyTypeBuilder body(String body) {
            this.body = body;
            return this;
        }

        public BodyType build() {
            return new BodyType(this);
        }

    }

    public Integer getBodyTypeId() {
        return bodyTypeId;
    }

    public String getBody() {
        return body;
    }

}


