package model;

public class FinancialRequest {
    private EventRequest event;
    private String description;
    private String finance;
    private User manager;
    private int id;

    public FinancialRequest(EventRequest event, String description, String finance, User manager, int id) {
        this.event = event;
        this.description = description;
        this.finance = finance;
        this.manager = manager;
        this.id = id;
    }

    public String getFinance() {
        return finance;
    }

    public void setFinancial(String finance) {
        this.finance = finance;
    }

    public EventRequest getEvent() {
        return event;
    }

    public void setEvent(EventRequest event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FinancialRequest{" +
                "event=" + event +
                ", description='" + description + '\'' +
                ", finance='" + finance + '\'' +
                ", manager=" + manager +
                ", id=" + id +
                '}';
    }
}
