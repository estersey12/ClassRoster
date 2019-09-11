package classroster;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Roster {
	private int size;
	private static final int DEFAULT_SIZE = 10;
	private Person[] people;
	//private Student[] students;
	//private Instructor[] instructors;
	private String className;
	private String fileName;
	
	public Roster() {
		// default constructor
		size = 0;
		people = new Person[DEFAULT_SIZE];
		className = "a class";
		fileName = null;
	}
	public Roster(String cn, String fn) {
		// constructor with given course name and input file
		this();
		className = cn;
		fileName = fn;
		readFile();
	}	
	public void addStudent(Student s) {
		// method that adds the input Student to the people array
		if (size >= people.length)
			doubleArray();
		people[size] = s;
		size++;
	}
	public void addInstructor(Instructor i) {
		// method that adds the input Instructor to the people array
		if (size >= people.length)
			doubleArray();
		people[size] = i;
		size++;
	}	
	public void addPersonFromKeyboard () {
		// method that prompts the user to enter either a student or instructor
		// then the user inputs the appropriate information for that person type
		// finally adds the new person to the array
		
		// complete for homework #2  
		
		//Variables
		String name = " ";
		String id = " ";
		double gpa = 0.0;
		String email = " ";
		char repeat = 'Y';
		
		//create scanner
		Scanner scan = new Scanner(System.in);
		
		//Prompt for student or instructor
		String entry = " ";
		String student = "student";
		String instructor = "instructor";
		
		do
		{
			scan.nextLine();
			
		//input student or instructor
		System.out.print("Please enter student or instructor: ");
		entry = scan.nextLine();
		
			//If entry == student -> input name, ID, and GPA 
			//Create Student and add to class
			if ((entry).equals(student)) {
				
				System.out.print("Please enter the name: ");
				name = scan.nextLine();
				
				System.out.print("Please enter the last three digits of the id: ");
				id = scan.nextLine();
				
				System.out.print("Please enter the GPA: ");
				gpa = scan.nextDouble();
				
				Student s = new Student(name, id, gpa);
				addStudent(s);
				
			//if entry == instructor -> input name, ID, and email
			//Create Instructor and add to class	
			} else if ((entry).equals(instructor)) {
				
				System.out.print("Please enter the name: ");
				name = scan.nextLine();
				
				System.out.print("Please enter the last three digits of the id: ");
				id = scan.nextLine();
				
				System.out.print("Please enter the email: ");
				email = scan.nextLine();
				
				Instructor i = new Instructor(name, id, email);
				addInstructor(i);
				
			} else {
				System.out.println("Answer not valid. ");
				addPersonFromKeyboard();
			}
			
			//repeat statement
			System.out.print("Would you like to make another entry? (Y/N): ");
			repeat = scan.next().charAt(0);
			
		}while (repeat == 'Y' || repeat == 'y');
			
			
	}
	public void removePerson (String id) {
		// method that removes the Person from the array with the input id
		
		//**** complete for homework #2  
			
			//if (id == id entered)
			//{set that person to last in list and make array one smaller};
			
			for(int i = 0; i < size; i++)
			{
				if((id).equals(people[i].getId()))
				{
					people[i] = people[size - 1];
					size--;
				}
			}
		
	}
	private void doubleArray () {
		// private method used to double the size of the array when needed
		Person[] newPeople = new Person[people.length*2];
		for (int i = 0; i < size; i++) {
			newPeople[i] = people[i];
		}		
		people = newPeople;
	}
	public String toString() {
		// returns a string representation of this roster
		String toReturn = className+"\n";
		for (int i = 0; i < size; i++) {
			if (people[i] instanceof Student)
				toReturn += "Student:  "+people[i]+"\n";
			else
				toReturn += "Instructor:  "+people[i]+"\n";
		}
		return toReturn;
	}
	private void readFile () {
		// private method that reads the file and stores into people array
		BufferedReader lineReader = null;
		
		try {
//			FileReader fr = new FileReader(fileName);
//			lineReader = new BufferedReader(fr);			
			
			lineReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8")));  

			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String name = lineReader.readLine();
				String id = lineReader.readLine();
				if (line.equals("student")) {
					String gpaString = lineReader.readLine();
					addStudent(new Student(name,id,Double.parseDouble(gpaString)));
				}
				else if (line.equals("instructor")) {
					String email = lineReader.readLine();
					addInstructor(new Instructor(name,id,email));
				}
				else {
					System.err.println("error: unnknown person type");
				}
			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file.  either no such file or format error");
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	} // end of readFile method
	
	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method
	
	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (int i = 0; i < size; i++) {
				Person person = people[i];
				if (person instanceof Student) {
					myOutfile.write ("student\n");
					myOutfile.write (person.getName()+"\n");
					myOutfile.write (person.getId()+"\n");
					myOutfile.write (((Student) person).getGpa()+"\n");
				}
				else if (person instanceof Instructor) {
					myOutfile.write ("instructor\n");
					myOutfile.write (person.getName()+"\n");
					myOutfile.write (person.getId()+"\n");
					myOutfile.write (((Instructor) person).getEmail()+"\n");
				}	
				else {
					System.err.println("error in array, instance type not found");
				}
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	
}
