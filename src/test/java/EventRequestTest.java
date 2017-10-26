import controller.Controller;
import model.EventRequest;
import model.Client;
import org.junit.Assert;
import org.junit.Test;


public class EventRequestTest {
    Controller controller = new Controller();



    @Test
    public void isEvent() throws Exception{
        controller.createClient("adam","shafai@gmail.com","07000000");

        Client client = controller.getClients().get(0);

        controller.createEventRequest("From", "To", "description", "The event", client, 400,"created");

        EventRequest event = controller.getEvents().get(0);


        Assert.assertEquals(client.getId(), event.getClient().getId());
        Assert.assertEquals(0, event.getId());
        Assert.assertEquals("From", event.getFrom());
        Assert.assertEquals("To", event.getTo());
        Assert.assertEquals("description", event.getDescription());
        Assert.assertEquals("The event", event.getName());
        Assert.assertEquals(400, event.getBudget(), 0);


    }




}
