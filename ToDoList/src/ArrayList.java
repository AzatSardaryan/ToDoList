import java.lang.IllegalArgumentException;
import java.lang.NoSuchMethodException;
import java.lang.reflect.Method;

public class ArrayList<E> implements LinearList {
	protected Object[] elementArray;
	protected int size;
	
	public ArrayList() {
		elementArray = new Object[0];  // Default constructor 
		size = 0;
		
	}
	public ArrayList(int initialCapacity) {
		try {
			elementArray = new Object[initialCapacity];
			size = initialCapacity;
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Initial capacity must be > 0");
		}
	}
	
	public boolean isEmpty() {
		
		return size == 0;
	}


	public int size() {
		
		int i = 0;
		for(Object o: elementArray) {
			if(o!= null) {
				i++;
			}
		}
		return i;
	}
	
    public void add(Object obj) {
        int i;
        for(i = 0; i < size; i++){
            if(elementArray[i] == null){
                
                break;
            }                     // if there is a null spot in the array it will break
        }
       
        if(i < elementArray.length) {
           
            elementArray[i] = obj;   // after break, if i is less than size add the object in the null spot
        }
        else {
          
            Object[] newArray = new Object[elementArray.length+1];
            System.arraycopy(elementArray, 0, newArray, 0, elementArray.length); // else copy over the array and extend the size
            elementArray = newArray;
            elementArray[elementArray.length-1] = obj; // add object at the end
            size++;
           }
          }

	
	public Object remove(int index) {
		Object temp = null;
		checkIndex(index); // check if the index is valid 
		temp = elementArray[index]; // 
		for(int  i = index; i < size-1; i++ ) {
			elementArray[i] = elementArray[i+1]; // shifts everything one space left when removing an object
		}
		elementArray[size-1] = null;  // garbage collection 
		
		return temp;
	}

	
	public Object find(String name){
		Object o = null;
		Object found = null;
		Boolean matchingVal = false;
		for(int i = 0; i < size; i++) {
			o = elementArray[i]; // get the object
			if(o.getClass().getName().equals("Tasks")) { 
				Tasks t = null; 
				t = (Tasks) o; // if the object is from tasks class explicitly type cast to tasks object
				if(t.getName().equals(name)) { // check if the parameter is match
					System.out.println("Task Found: "  + i + " - " +  name + ": " + t.getDescription()); // print out information
					found = t;
					matchingVal = true;
				}
			}
		}
		
		if (matchingVal == true) {
			return found;
		}
		else {
			System.out.println("Item does not exist");
			return null;
		}
		
		}
	
	public void checkIndex(int index) {
		if (index < 0 || index >= size) { // check index helper method for checking user inputs
			throw new IndexOutOfBoundsException("Index is not in bounds");
		}
	}
	
	public void checkLength() {
		System.out.println(elementArray.length);
	}
	
	
	public Object getElement(int i) {
        if (i < size) {
            return elementArray[i];
        } else {
            return null;
        }

    }
	
	public boolean checkIfExists(String identifier){
		Object o = null;
		boolean matchingVal = false;
		for(int i = 0; i < size; i++) {
			o = elementArray[i];
			if(o.getClass().getName().equals("Tasks")) { // same as find method, just returns true or false instead
				Tasks t = null;
				t = (Tasks) o;
				if(t.getName().equals(identifier)) {
					matchingVal = true;
				}
			}
		}
		return matchingVal;
	}	
}