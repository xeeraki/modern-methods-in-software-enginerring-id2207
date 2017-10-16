package model;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Login {

    private final List<User>users;

    public Login() {


        users = new ArrayList<>();

        users.add(new User("CS", "0000", Position.CustomerService));
        users.add(new User("SCS", "0000", Position.SeniorCustomerService));
        users.add(new User("FM", "0000", Position.FinancialManager));
        users.add(new User("AM", "0000", Position.AdministrationManager));
        users.add(new User("SM", "0000", Position.ServiceManager));
        users.add(new User("PM", "0000", Position.ProductionManager));
        users.add(new User("HR", "0000", Position.HR));
        users.add(new User("STAFF","0000",Position.ServiceProductionStaff));
        users.add(new User("Audio", "0000", Position.AudioSpecialist));
        users.add(new User("Photo", "0000", Position.Photographer));
        users.add(new User("Chef", "0000", Position.Chef));
        users.add(new User("Waitress", "0000", Position.Waitress));


    }

    public User login(String username ,String password ) {



            for (User user : users) {
                if (user.getPassword().equals(password) && user.getUsername().equals(username))
                    return user;
            }

            return null;


    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserPosition(Position position){

        for(User user: users){
            if(user.getPosition()==position)
                return user;
        }
        return null;
    }
}
