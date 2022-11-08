
public class ToDo {
		private ArrayList<Tasks> toDoList;
		
		
		public ToDo() {
			toDoList = new ArrayList<Tasks>();
			
		}
		
		public void showAllTasks() {
			if(toDoList.size() > 0) {
				for(int i = 0; i < toDoList.size(); i++) {  // loops through list and finds
					Tasks t = (Tasks) toDoList.getElement(i);
					System.out.println("Position: " + i + " - " + t.getName() + ": " + t.getDescription()); 
				}
			}
			else {
				System.out.println("No Tasks in List");
			}
		
			}
		
		// methods to allow for easy storing, removing, finding and returning the size
		
		public void addTask(String name, String description) {
			toDoList.add(new Tasks(name, description));
		}
		
		public void removeTask(int index) {
			toDoList.remove(index);
		}
		
		public void findTask(String identifer) {
			toDoList.find(identifer);
		}
		
		public void checkIfTaskExists(String identifer) {
			System.out.println(toDoList.checkIfExists(identifer));
		}
		
		public int getSize() {
			return toDoList.size();
		}
		
	
}
