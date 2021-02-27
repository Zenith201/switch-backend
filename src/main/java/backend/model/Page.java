package backend.model;

public class Page {
    Upload[]pageUploads;
    String id,name;
    User[]userFollowingPage;

    public Page(String id,String name){
        this.id=id;
        this.name=name;
    }

    public void setPageUploads(Upload[] pageUploads) {
        this.pageUploads = pageUploads;
    }

    public void setUserFollowingPage(User[] userFollowingPage) {
        this.userFollowingPage = userFollowingPage;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Upload[] getPageUploads() {
        return pageUploads;
    }

    public User[] getUserFollowingPage() {
        return userFollowingPage;
    }
}
