package ke.co.apollo.autoxpress.entity;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class Owner {

    private Integer ownerId;
    private String name;
    private String email;
    private String mobile;
    private String id_pin;
    private String idPhoto;
    private String dlPhoto;

    public Owner() {
    }

    public Owner(OwnerBuilder builder){
        this.ownerId = builder.ownerId;
        this.name = builder.name;
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.id_pin = builder.id_pin;
        this.idPhoto = builder.idPhoto;
        this.dlPhoto = builder.dlPhoto;
    }

    public static class OwnerBuilder{

        private Integer ownerId;
        private String name;
        private String email;
        private String mobile;
        private String id_pin;
        private String idPhoto;
        private String dlPhoto;

        public OwnerBuilder() {
        }

        public OwnerBuilder ownerId(Integer ownerId){
            this.ownerId = ownerId;
            return this;
        }

        public OwnerBuilder name(String name){
            this.name = name;
            return this;
        }

        public OwnerBuilder email(String email){
            this.email = email;
            return this;
        }

        public OwnerBuilder mobile(String mobile){
            this.mobile = mobile;
            return this;
        }

        public OwnerBuilder id_pin(String id_pin){
            this.id_pin = id_pin;
            return this;
        }

        public OwnerBuilder idPhoto(String idPhoto){
            this.idPhoto = idPhoto;
            return this;
        }

        public OwnerBuilder dlPhoto(String dlPhoto){
            this.dlPhoto = dlPhoto;
            return this;
        }

        public Owner build(){
            return new Owner(this);
        }
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getId_pin() {
        return id_pin;
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public String getDlPhoto() {
        return dlPhoto;
    }
}
