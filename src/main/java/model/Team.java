package model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<User> members;
    private User manager;
    private String name;

    public Team(User manager, String name) {
        members = new ArrayList<>();
        this.manager = manager;
        this.setName(name);
    }

    public void addMember(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
