package classroster;

public class Instructor extends Person {
	private String email;

	// default constructor
	public Instructor() {
		super();
		email = "not set";
	}
	
	// constructor to use to create a new Instructor
	public Instructor(String n, String i, String e) {
		super(n,i);
		email = e;
	}
	
	// getter and setter for the instructor's email address
	public String getEmail() {
		return email;
	}
	public void setEmail(String e) {
		email = e;
	}
	
	// string representation for this instructor
	public String toString () {
		return super.toString()+" email: "+email;
	}	
}
