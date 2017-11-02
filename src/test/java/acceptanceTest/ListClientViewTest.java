package acceptanceTest;

import controller.Controller;
import model.Position;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class ListClientViewTest {
    private MainView mainView;
    private CreateClientView listClientView;
    private LoginView test;
    @Before
    public void setUp() throws Exception {
        User user = new User("scs","0000", Position.SeniorCustomerService);
        Controller controller = new Controller();
        test = new LoginView();
        mainView = new MainView(user,controller,test);
        listClientView = new CreateClientView(controller);

        checkListView();


    }
@Test
    public void checkListView(){
        listClientView.setClientName("Adam");
        listClientView.setClientEmail("shafai@gmail.com");
        listClientView.setClientPhone("07220000");
        listClientView.setVisible(true);
        try {
            Thread.sleep(3000);

        }
        catch (InterruptedException ex){
            ex.printStackTrace();

        }

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addListMouseListener() throws Exception {
        listClientView.btnSubmit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listClientView.setVisible(true);
            }
        });

    }



/*

    @Test
    public void getClientNameField() throws Exception {
    }

    @Test
    public void setClientNameField() throws Exception {
    }

    @Test
    public void getEventList() throws Exception {
    }

    @Test
    public void setEventList() throws Exception {
    }
*/

}