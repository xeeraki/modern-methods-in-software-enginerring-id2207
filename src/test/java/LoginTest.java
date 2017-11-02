
import model.Login;
import model.Position;
import model.User;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest {
    @Test
    public void isPosition()throws Exception{
        Login login = new Login();

        User user = new User("cs","0000", Position.CustomerService);
        User position = login.login(user.getUsername(),user.getPassword());

        Assert.assertEquals(Position.CustomerService,position.getPosition());
    }

    @Test
    public void isLoggedIn() throws Exception {

        Login login = new Login();
        User user = new User("cs","0000", Position.CustomerService);
        User position = login.login(user.getUsername(),user.getPassword());

        Assert.assertEquals("cs",position.getUsername());
        Assert.assertEquals("0000",position.getPassword());

        Assert.assertEquals(Position.CustomerService,position.getPosition());

    }


}