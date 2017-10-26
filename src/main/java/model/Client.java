package model;
public class Client {
    private String name;
    private String mail;
    private String phone;
    private int id;

    public Client(String name , String mail, String phone, int id) {
        this.name=name;
        this.mail=mail;
        this.phone=phone;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone=" + phone +
                ", id=" + id +
                '}';
    }
}
