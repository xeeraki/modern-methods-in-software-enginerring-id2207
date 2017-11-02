
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import acceptanceTest.CreateEventView;
import acceptanceTest.ListUpdaterView;
import acceptanceTest.MainView;
import model.Status;


import model.*;

import static model.Position.*;

public class Controller {

    private Login login;

    private int clientCounter;
    private int eventCounter;
    private int taskCounter;
    private int staffCounter;
    private int financeCounter;


    private List<Client> clients;
    private List<EventRequest> events;
    private List<Task> tasks;
    private List<StaffRequest> staffRequest;
    private List<FinancialRequest> financialRequest;


    private Team audio;
    private Team photography;
    private Team chefs;
    private Team waitresses;
    //String [] status = {"Created by CS","Accepted by SCS","Accepted by FM", "Accepted by AM"};


    public Controller() {
        objects();


    }

    private void objects() {
        login = new Login();
        clients = new ArrayList<>();
        events = new ArrayList<>();
        tasks = new ArrayList<>();
        staffRequest = new ArrayList<>();
        financialRequest = new ArrayList<>();


        initTeams();
    }


    public void createEventRequest(String from, String to, String description, String name, Client client, double budget, String status) {
        event(from, to, description, name, client, budget, status);
    }


    private void event(String from, String to, String description, String name, Client client, double budget, String status) {
        EventRequest event = new EventRequest(from, to, description, name, client, eventCounter, budget, status);
        //event.setStatus(Status.Created.getText());
        events.add(event);
        eventCounter++;
    }

    public void createFinancialRequest(EventRequest event, String description, String resources, User manager) {
        finance(event, description, resources, manager);
    }

    private void finance(EventRequest event, String description, String resources, User manager) {
        FinancialRequest req = new FinancialRequest(event, description, resources, manager, financeCounter);
        financialRequest.add(req);
        financeCounter++;
    }

    public void createClient(String name, String email, String phone) {
        Client client = new Client(name, email, phone, clientCounter);
        clients.add(client);
        clientCounter++;
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


    public List<Client> getClients() {
        return clients;
    }

    public List<EventRequest> getEvents() {
        return events;
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

    public void  showList(int currentEventId, User currentUser) {
        for (EventRequest event : events) {
            switch (currentUser.getPosition())
            {
                case FinancialManager:
                    if (event.getStatus() != Status.AcceptedBySCS.getText()) {
                        events.clear();
                    }
                    events.add(event);
                    break;
                case AdministrationManager:
                    if (event.getStatus() == Status.AcceptedByFM.getText() || event.getStatus() == Status.AcceptedBySCS.getText())
                        event.setStatus(Status.AcceptedByAM.getText());
                    break;
                default:
            }
        }

    }
    public void changeStatus(int currentEventId, User currentUser) {
        EventRequest event = events.get(currentEventId);
        Status newStatus;
        switch(currentUser.getPosition()) {
            case SeniorCustomerService :
                if(event.getStatus() == Status.Created.getText()) {
                    newStatus = Status.AcceptedBySCS;
                } else
                    newStatus = Status.Finalized;
                break;
            case  FinancialManager :
                newStatus = Status.AcceptedByFM;
                break;
            case  AdministrationManager :
                newStatus = Status.AcceptedByAM;
                break;
            default: newStatus = null;
        }

        event.setStatus(newStatus.toString());

    }

/*    public void changeStatus(int currentEventId, User currentUser) {
        EventRequest event = events.get(currentEventId);
        switch (currentUser.getPosition()) {
            case SeniorCustomerService:
                if (event.getStatus()==Status.Created.getText())
                    event.setStatus(Status.AcceptedBySCS.getText());
                break;
            case FinancialManager:
                if(event.getStatus()==Status.AcceptedBySCS.getText())
                   event.setStatus(Status.AcceptedByFM.getText());
                break;
            case AdministrationManager:
                if (event.getStatus() == Status.AcceptedByFM.getText() || event.getStatus() == Status.AcceptedBySCS.getText())
                    event.setStatus(Status.AcceptedByAM.getText());
                break;
            default:

        }

    }*/


    public void initTeams() {
        audio = new Team(login.getUserWithPosition(Position.ProductionManager), "audio sub team");
        photography = new Team(login.getUserWithPosition(Position.ProductionManager), "Photography team");

        chefs = new Team(login.getUserWithPosition(ServiceManager), "Chefs sub team ");
        waitresses = new Team(login.getUserWithPosition(ServiceManager), "Waitress sub team");

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

    public List<FinancialRequest> getFinancialReq() {
        return financialRequest;
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

    public void deleteFinancialRequest(FinancialRequest req) {
        for (Iterator<FinancialRequest> iter = financialRequest.listIterator(); iter.hasNext(); ) {
            FinancialRequest r = iter.next();
            if (r.getId() == req.getId()) iter.remove();
        }
    }


}