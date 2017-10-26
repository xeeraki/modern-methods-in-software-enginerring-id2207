import model.*;
import org.junit.Test;

import controller.Controller;
import org.junit.Assert;
import model.EventRequest;
import model.Position;

public class TaskTest {
	
	
	@Test
	public void createTask() throws Exception{
		Controller controller = new Controller();
		controller.createClient("adam	", "shafai86@gmail.com", "072000000");
		Client client = controller.getClients().get(0);
		controller.createEventRequest("From", "To", "description", "The event", client, 400,"created");
		EventRequest event = controller.getEvents().get(0);
		
		User PM = new User("SM","0000",Position.ProductionManager);
		User Audio = new User("Audio","0000",Position.AudioSpecialist);
		User Audio2 = new User("Audio2","0000",Position.AudioSpecialist);
		
		Team team = new Team(PM,"Sub team 1");
		
		team.addMember(Audio);
		team.addMember(Audio2);
		
		controller.createTask(PM, 100, 0, "Fix mozart", "", event,team);
		
		Task task = controller.getTasks().get(0);
		
		Assert.assertEquals(team,task.getTeam());
		Assert.assertEquals(PM, task.getTeam().getManager());
		Assert.assertEquals("Sub team 1", task.getTeam().getName());
		
	}
	
	@Test
	public void updateStatus() throws Exception{
		Controller controller = new Controller();
		controller.createClient("adam", "sahfai@gmail.com", "072000000");
		Client client = controller.getClients().get(0);
		controller.createEventRequest("From", "To", "description", "The event", client, 400, "created");
		EventRequest event = controller.getEvents().get(0);

		User PM = new User("SM","0000",Position.ProductionManager);
		User Audio = new User("Audio","0000",Position.AudioSpecialist);
		User Audio2 = new User("Audio2","0000",Position.AudioSpecialist);
		Team team = new Team(PM,"Sub team 1");

		team.addMember(Audio);
		team.addMember(Audio2);

		controller.createTask(PM, 100, 0, "Fix mozart", "", event,team);

		
		Task task = controller.getTasks().get(0);
		
		controller.updateTask(400, "Mozart and beethoven needed", task);
		
		
		Assert.assertEquals(400, task.getAdditionalBudget(),0);
		Assert.assertEquals("Mozart and beethoven needed", task.getExpectedPlan());
	}
}
