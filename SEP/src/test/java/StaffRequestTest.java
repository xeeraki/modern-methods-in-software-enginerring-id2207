import org.junit.Test;

import controller.Controller;
import org.junit.*;
import model.Client;
import model.EventRequest;
import model.Team;

public class StaffRequestTest {

	@Test
	public void createRequest()throws Exception{
		Controller controller = new Controller();
		controller.createClient("adam", "adam@gmail.com", "07200000");
		Client client = controller.getClients().get(0);
		controller.createEventRequest("From", "To", "description", "", client, 400);
		EventRequest event = controller.getEvents().get(0);
		
		Team team = controller.getProductionTeam().get(0);
		
		
		controller.createStaffRequest(event, team, "need crew");
		
		Assert.assertEquals(1, controller.getStaffReq().size());
	}
	
}
