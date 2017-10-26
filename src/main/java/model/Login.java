package model;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Login {

    private final List<User>users;

    public Login() {


        users = new ArrayList<>();

        users.add(new User("cs", "0000", Position.CustomerService));
        users.add(new User("scs", "0000", Position.SeniorCustomerService));
        users.add(new User("fm", "0000", Position.FinancialManager));
        users.add(new User("am", "0000", Position.AdministrationManager));
        users.add(new User("sm", "0000", Position.ServiceManager));
        users.add(new User("pm", "0000", Position.ProductionManager));
        users.add(new User("hr", "0000", Position.HR));
        users.add(new User("staff","0000",Position.ServiceProductionStaff));
        users.add(new User("audio", "0000", Position.AudioSpecialist));
        users.add(new User("photo", "0000", Position.Photographer));
        users.add(new User("chef", "0000", Position.Chef));
        users.add(new User("waitress", "0000", Position.Waitress));


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

    public User getUserWithPosition(Position position){

        for(User user: users){
            if(user.getPosition()==position)
                return user;
        }
        return null;
    }
}
