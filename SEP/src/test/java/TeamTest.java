import java.util.List;

import org.junit.Test;

import controller.Controller;
import model.Position;
import model.Team;
import model.User;

import static org.junit.Assert.assertTrue;

public class TeamTest {

	@Test
	public void Team() throws Exception{
		Controller controller = new Controller();
		
		controller.initTeams();
		
		List<Team> production = controller.getProductionTeam();
		List<Team> service = controller.getServiceTeam();
		
		
		for (Team team : service) {
			for (User user : team.getMembers()) {
				assertTrue(user.getPosition() == Position.Chef || user.getPosition() == Position.Waitress);
			}
		}
		
		for (Team team : production) {
			for (User user : team.getMembers()) {
				assertTrue(user.getPosition() == Position.AudioSpecialist || user.getPosition() == Position.Photographer);
			}
		}
		
	}
	
}
