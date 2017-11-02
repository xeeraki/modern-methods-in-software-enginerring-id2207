package acceptanceTest;

import controller.Controller;
import model.Position;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.UserException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class LoginViewTest {
    private LoginView test;
    @Before
    public void setUp() throws Exception {
        test = new LoginView();
        test.setVisible(true);
    }

    @Test
    public void checkLogin(){
        test.getUserField().setText("cs");
        test.getPassField().setText("0000");
        test.getLoginButton();
        onClick();
        try {
            Thread.sleep(5000);
        }

        catch (InterruptedException ex){
            ex.printStackTrace();
        }

        Assert.assertNotEquals(null,test.getMainView());

    }

    @After
    public void tearDown(){


    }

    public void onClick(){
        test.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                test.setVisible(false);
            }
        });
    }

    @Test
    public void main() throws Exception {
    }

    @Test
    public void initView() throws Exception {
    }

    @Test
    public void getLoginButton() throws Exception {
    }

    @Test
    public void getUserField() throws Exception {
    }

    @Test
    public void getPassField() throws Exception {
    }

    @Test
    public void getMainView() throws Exception {
    }

}