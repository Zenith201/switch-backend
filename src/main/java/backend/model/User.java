package backend.model;



import java.util.ArrayList;


public class User {
    String id;
    String username,password,phoneNumber,profilePicture,type;
    ArrayList<Upload> userUploads;
    ArrayList<User>followers,following;
    ArrayList<Page>pagesFollowing;

    public User(String id,String username,String password,String phoneNumber,String type, String profilePicture, ArrayList<Upload>uploads, ArrayList<User>followers,ArrayList<User>following,ArrayList<Page>pagesFollowing){
        this.id=id;
        this.username=username;
        this.phoneNumber=phoneNumber;
        this.password=password;
        this.type=type;
        this.userUploads=uploads;
        this.followers=followers;
        this.following=following;
        this.pagesFollowing=pagesFollowing;
        this.profilePicture=profilePicture;
    }


    public void setUserUploads(ArrayList<Upload> userUploads) {
        this.userUploads = userUploads;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public void setPagesFollowing(ArrayList<Page> pagesFollowing) {
        this.pagesFollowing = pagesFollowing;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }


    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Upload> getUserUploads() {
        return userUploads;
    }

    public ArrayList<Page> getPagesFollowing() {
        return pagesFollowing;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

}
