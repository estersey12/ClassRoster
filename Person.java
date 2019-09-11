package classroster;

public class Person {
	private String name;
	private String id;
	public Person() {
		name = "not set";
		id = "not set";
	}
	
	public Person(String n, String i) {
		name = n;
		id = i;
	}
	
	// getters and setters for private data
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	public String getId() {
		return id;
	}
	public void setId(String i) {
		id = i;
	}	
	
	// string representation of this person
	public String toString () {
		return name+"("+id+")";
	}
}
