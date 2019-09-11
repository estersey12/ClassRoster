package classroster;

public class Main {

	public static void main(String[] args) {
		Roster myClass = new Roster();
	
		//test addPersonFromKeyboard
		myClass.addPersonFromKeyboard();
		
		System.out.println(myClass);
	
	/*	
		//test removePerson
		Student s0 = new Student("queeny","678",3.7);
		myClass.addStudent(s0);
		Student s1 = new Student("q","123",3.1);
		myClass.addStudent(s1);
		System.out.println(myClass);
		
		myClass.removePerson("678");
		
		System.out.println(myClass);
	*/
	/*
		// test creating roster from scratch
		Student s1 = new Student();
//		System.out.println(s1);
		Student s2 = new Student("audrey","123",3.2);
//		System.out.println(s2);
		
		System.out.println(myClass);
		myClass.addStudent(s1);
		myClass.addStudent(s2);
		
		Instructor i1 = new Instructor();
		Instructor i2 = new Instructor("mark","987","m@uca.edu");
		myClass.addInstructor(i1);
		myClass.addInstructor(i2);		
		
		System.out.println(myClass);
		System.out.println();
		System.out.println();
		System.out.println();
	*/

		
	/*	
		// test creating roster from textfile

		Student s4 = new Student("audrey","123",3.2);
//		System.out.println(s2);
		Roster csci3381 = new Roster("CSCI3381","./classroster/data.txt");
		System.out.println("\ntest reading text file");
		System.out.println(csci3381);
		csci3381.addStudent(s4);
		
		Instructor i4 = new Instructor("mark","987","m@uca.edu");
		csci3381.addInstructor(i4);		
		
		System.out.println("\ntest combined data from file and data added manually");
		System.out.println(csci3381);		
		csci3381.writeFile("./classroster/dataWriteTest.txt");
		
		Roster testWrite = new Roster("Test Write","./classroster/dataWriteTest.txt");
		System.out.println("\ntest reading just created file");
		System.out.println(testWrite);

	*/
	}

}
