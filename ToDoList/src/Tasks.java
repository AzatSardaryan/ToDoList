import java.util.Date;
public class Tasks {
	
	// basic class with 2 fields that will be the tasks the user adds
		private String name;
		private String description;
		
		public Tasks(String name, String description) {
			this.name = name;
			this.description = description;
			
		}
		
		// getter and setter methods
		// (setters not used so could remove)

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		

		
		
}
