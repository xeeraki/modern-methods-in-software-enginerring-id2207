package model;

public class StaffRequest {


	private EventRequest event;
	private Team team;
	private String description;
	private int id;
	
	public StaffRequest(EventRequest event, Team team, String description, int id) {
		this.event = event;
		this.team = team;
		this.description = description;
		this.id = id;
	}

	public EventRequest getEvent() {
		return event;
	}

	public void setEvent(EventRequest event) {
		this.event = event;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "StaffRequest{" +
				"event=" + event +
				", team=" + team +
				", description='" + description + '\'' +
				", id=" + id +
				'}';
	}
}
