package ex4;

public class User {
    private String username;
    public User(){
        this.username = "defaultuser";
    }
    public User(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
}
