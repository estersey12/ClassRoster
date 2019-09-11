package classroster;

public class Student extends Person {


	private double gpa;
	
	// default constructor
	public Student() {
		super();
		gpa = 4.0;
	}
	
	// constructor to use to create a new student
	public Student(String n, String i, double g) {
		super(n,i);
		gpa = g;
	}

	// getter and setter for gpa
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	// string representation of this Student
	public String toString () {
		return super.toString()+" gpa: "+gpa;
	}
}
