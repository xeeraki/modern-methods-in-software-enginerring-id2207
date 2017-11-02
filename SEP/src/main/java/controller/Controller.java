package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.*;

public class Controller {

    private Login login;

    private int clientCounter;
    private int eventCounter;
    private int taskCounter;
    private int staffCounter;
    private int resourceCounter;

    private List<Client> clients;
    private List<EventRequest> events;
    private List<Task> tasks;
    private List<StaffRequest> staffRequest;
    private List<ResourceRequest> resourceRequest;

    private Team audio;
    private Team photography;
    private Team chefs;
    private Team waitresses;
    private Team otherStaff;

    public Controller() {
        objects();


    }

    private void objects() {
        login = new Login();
        clients = new ArrayList<>();
        events = new ArrayList<>();
        tasks = new ArrayList<>();
        staffRequest = new ArrayList<>();
        resourceRequest = new ArrayList<>();

        initTeams();
    }

    public void createEventRequest(String from, String to, String description, String name, Client client, double budget) {
        event(from, to, description, name, client, budget);
    }

    private void event(String from, String to, String description, String name, Client client, double budget) {
        EventRequest event = new EventRequest(from, to, description,
                name, client, eventCounter, budget);
        events.add(event);
        eventCounter++;
    }

    public void createResourceRequest(EventRequest event, String description, String resources, User manager) {
        resource(event, description, resources, manager);
    }

    private void resource(EventRequest event, String description, String resources, User manager) {
        ResourceRequest req = new ResourceRequest(event, description, resources, manager, resourceCounter);
        resourceRequest.add(req);
        resourceCounter++;
    }

    public List<EventRequest> getEventsWithClient(Client client) {
        List<EventRequest> eventsForClient = new ArrayList<>();
        for (EventRequest event : events) {
            if (event.getClient().getId() == client.getId())
                eventsForClient.add(event);
        }
        return eventsForClient;
    }

    public User login(String username, String password) {
        return login.login(username, password);
    }

    public void createClient(String name, String email, String phone) {
        Client client = new Client(name, email, phone, clientCounter);
        clients.add(client);
        clientCounter++;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<EventRequest> getEvents() {
        return events;
    }

    public void changeStatus(int currentEventId, User currentUser) {
        EventRequest event = events.get(currentEventId);
        Status newStatus;

        switch (currentUser.getPosition()) {
            case SeniorCustomerService:
                if (event.getStatus() == Status.Created) {
                    newStatus = Status.AcceptedBySCS;
                } else
                    newStatus = Status.Finalized;
                break;
            case FinancialManager:
                newStatus = Status.AcceptedByFM;
                break;
            case AdministrationManager:
                newStatus = Status.AcceptedByAM;
                break;
            default:
                newStatus = null;
        }

        event.setStatus(newStatus);

    }

    public void createTask(User currentUser, double originalBudget, double additionalBudget, String description,
                           String expectedPlan, EventRequest event, Team team) {
        Task task = new Task(team, originalBudget, additionalBudget, description, expectedPlan, event, taskCounter);
        tasks.add(task);
        taskCounter++;
    }

    public List<Team> getProductionTeam() {
        List<Team> newList = new ArrayList<>();
        newList.add(audio);
        newList.add(photography);
        return newList;
    }

    public List<Team> getServiceTeam() {
        List<Team> newList = new ArrayList<>();
        newList.add(chefs);
        newList.add(waitresses);
        return newList;
    }

    public void initTeams() {
        audio = new Team(login.getUserPosition(Position.ProductionManager), "audio sub team");
        photography = new Team(login.getUserPosition(Position.ProductionManager), "Photography team");

        chefs = new Team(login.getUserPosition(Position.ServiceManager), "Chefs sub team ");
        waitresses = new Team(login.getUserPosition(Position.ServiceManager), "Waitress sub team");

        for (User user : login.getUsers()) {
            switch (user.getPosition()) {
                case AudioSpecialist:
                    audio.addMember(user);
                    break;
                case Photographer:
                    photography.addMember(user);
                    break;
                case Chef:
                    chefs.addMember(user);
                    break;
                case Waitress:
                    waitresses.addMember(user);
                    break;
            }
        }
    }

    public void updateTask(double additionalBudget, String expectedPlan, Task task) {
        for (Task t : tasks) {
            if (t.getId() == task.getId()) {
                t.setExpectedPlan(expectedPlan);
                t.setAdditionalBudget(additionalBudget);
            }
        }
    }

    public void updateEvent(double newBudget, EventRequest event) {
        for (EventRequest e : events) {
            if (e.getId() == event.getId()) {
                e.setBudget(newBudget);
            }
        }
    }

    public void deleteEvent(EventRequest event) {
        for (Iterator<EventRequest> iter = events.listIterator(); iter.hasNext(); ) {
            EventRequest e = iter.next();
            if (e.getId() == event.getId()) iter.remove();
        }
    }

    public void createStaffRequest(EventRequest event, Team team, String description) {
        staffRequest.add(new StaffRequest(event, team, description, staffCounter));
        staffCounter++;
    }

    public List<StaffRequest> getStaffReq() {
        return staffRequest;
    }

    public List<ResourceRequest> getResourceReq() {
        return resourceRequest;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void deleteStaffRequest(StaffRequest req) {
        for (Iterator<StaffRequest> iter = staffRequest.listIterator(); iter.hasNext(); ) {
            StaffRequest r = iter.next();
            if (r.getId() == req.getId()) iter.remove();
        }
    }

    public void deleteResourceRequest(ResourceRequest req) {
        for (Iterator<ResourceRequest> iter = resourceRequest.listIterator(); iter.hasNext(); ) {
            ResourceRequest r = iter.next();
            if (r.getId() == req.getId()) iter.remove();
        }
    }

}