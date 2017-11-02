package model;

public class EventRequest {
    private String from;
    private String to;
    private String description;
    private String name;
    private final Client client;
    private final int id;
    private double budget;
    private String status;



    public EventRequest(String from, String to, String description, String name, Client client, int id, double budget, String status) {
        this.from = from;
        this.to = to;
        this.description = description;
        this.name = name;
        this.client = client;
        this.id = id;
        this.budget = budget;
        this.status=Status.Created.getText();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return id;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}