package model;

public class Task {
		private Team team;
		private double budget;
		private double additionalBudget;
		private String description;
		private String expectedPlan;
		private EventRequest event;
		private int id;
		
		public Task(Team team, double budget, double additionalBudget, String description,
					String expectedPlan, EventRequest event, int id) {
			this.team = team;
			this.budget = budget;
			this.additionalBudget = additionalBudget;
			this.description = description;
			this.expectedPlan = expectedPlan;
			this.event = event;
			this.id = id;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
		}

		public double getBudget() {
			return budget;
		}

		public void setBudget(double budget) {
			this.budget = budget;
		}

		public double getAdditionalBudget() {
			return additionalBudget;
		}

		public void setAdditionalBudget(double additionalBudget) {
			this.additionalBudget = additionalBudget;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getExpectedPlan() {
			return expectedPlan;
		}

		public void setExpectedPlan(String expectedPlan) {
			this.expectedPlan = expectedPlan;
		}

		public EventRequest getEvent() {
			return event;
		}

		public void setEvent(EventRequest event) {
			this.event = event;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	@Override
	public String toString() {
		return "Task{" +
				"team=" + team +
				", budget=" + budget +
				", additionalBudget=" + additionalBudget +
				", description='" + description + '\'' +
				", expectedPlan='" + expectedPlan + '\'' +
				", event=" + event +
				", id=" + id +
				'}';
	}
}
