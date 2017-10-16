package model;

public class ResourceRequest {
    private EventRequest event;
    private String description;
    private String resources;
    private User manager;
    private int id;

    public ResourceRequest(EventRequest event, String description, String resources, User manager, int id) {
        this.event = event;
        this.description = description;
        this.resources = resources;
        this.manager = manager;
        this.id = id;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
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
        return "ResourceRequest{" +
                "event=" + event +
                ", description='" + description + '\'' +
                ", resources='" + resources + '\'' +
                ", manager=" + manager +
                ", id=" + id +
                '}';
    }
}
