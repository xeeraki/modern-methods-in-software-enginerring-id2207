package model;
public class User{
    private String username;
    private String password;
    public Position position;

    public User(String username, String password, Position position) {
        this.username = username;
        this.password = password;
        this.position = position;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Position getPosition() {
        return position;
    }
}
