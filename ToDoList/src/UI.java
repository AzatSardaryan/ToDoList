import java.util.InputMismatchException;
import java.util.Scanner;
public class UI {
	public static void main(String[] args) {
			UI inter = new UI();
			inter.showMenu();
			while(inter.running == true) {
				inter.userInput(); // calls the main loop while running is true
			}
	}
	
	private ToDo myToDo;
	private boolean running;
	public UI() {
		myToDo = new ToDo();
		running = true;
		
	}
	
	public void add() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the name of your task");
		String name = s.nextLine();
		System.out.println("Please enter the description of your task");
		String desc = s.nextLine();
		myToDo.addTask(name, desc);
		System.out.println("Task " + name + " successfully added");
	}
	
	public void remove() {
		
		if(myToDo.getSize() == 0) {
			System.out.println("There are no Tasks to remove");
		}
		
		else {
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter the index of the task you would like to remove");
			int index = s.nextInt();
			if (index < 0 || index >= myToDo.getSize()) {
				System.out.println("Please enter a valid index");
				remove(); // Recursive call if the user enters a wrong index
			}
			else {
				myToDo.removeTask(index);
				System.out.println("Task at index " + index + " removed");
			}
		}
	}
	
	public void findTo() {
		if(myToDo.getSize() == 0) {
			System.out.println("No Items Exists");
		}
		else  {
			Scanner s = new Scanner(System.in);
			System.out.println("Please enter the name of the task you would like to find");
			String name = s.nextLine();
			myToDo.findTask(name);
		} 
	}
	
	public void checkExists() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the name of the task you want to check");
		String name = s.nextLine();
		myToDo.checkIfTaskExists(name);
	}
	
	public void showAll() {
		myToDo.showAllTasks();
	}
	
	public void count() {
		System.out.println(myToDo.getSize());
	}
	
	public void userInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Please select what you would like to do");
		int choice = s.nextInt();
		
		switch(choice) {
		case 1: 			
			add();
			break;
		case 2: 
			remove();
			break;
		case 3: 
			findTo();
			break;
		case 4: 
			checkExists();
			break;
		case 5:
			showAll();
			break;
		case 6:
			count();
			break;
		case 7:
			showMenu();
			break;
		case 8: 
			running = false; // when user calls 8 it will set running to false and terminate the main method
			System.out.println("You have exit the program. Goodbye!");
			break;
		default:
			System.err.println("Please Enter a valid option");
				
		}
			
	}
	
	// shows the menu to the user
	
	public void showMenu() {
		System.out.println("#################################");
		System.out.println("Chose from the following menu");
		System.out.println("1 -> Add");
		System.out.println("2 -> Remove");
		System.out.println("3 -> Find ToDo by Name of Task");
		System.out.println("4 -> Check if it exists Name");
		System.out.println("5 -> Show all tasks");
		System.out.println("6 -> Count Number of Tasks");
		System.out.println("7 -> Show option menu");
		System.out.println("8 -> Exit");
		System.out.println("#################################");
	}
}
