package backend.model;

public class Upload {
    String id,path;

    public Upload(String id,String path){
        this.id=id;
        this.path=path;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
}
