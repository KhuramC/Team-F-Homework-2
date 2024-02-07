package homework_2;

import java.io.FileInputStream;
import java.util.*;

public class StudentManager {
	
	private Student students[];
	

	//Method must have this prototype from the doc
	public boolean readFromFile(String fileName) {
		try{
			FileInputStream input = new FileInputStream("files/"+fileName);
			Scanner scanner = new Scanner(input);
			
			List<Student> studentList = new ArrayList<>();
			
			//Read student data to initialize Student objects
			while(scanner.hasNextLine()) {
              String line = scanner.nextLine();
              String[] parts = line.split(" "); //Split by space
              if (parts.length != 4) {
                  //Skip invalid line.
                  continue;
              }
              
              int id = Integer.parseInt(parts[0]);
              String name = parts[1] + " " + parts[2];
              double grade = Double.parseDouble(parts[3]);
              
              //Make new Student object and append to list.
              studentList.add(new Student(id, name, grade));
			}
			//Assign students array to array from studentList.
			students = studentList.toArray(new Student[0]);
			
			scanner.close();
			input.close();
		}
		
		catch(Exception e) {
	        e.printStackTrace();
	        System.out.println("Cannot read/find the file or initialize objects.");
	        return false;
	     }
		
		return true;
	}
	
	//Method must have this prototype from the doc
	public void displayStudents() {
		if(students.length != 0) {
			for (Student student: students) {
				System.out.println(student);
			}	
		}else {
			System.out.println("There are no students being managed by the StudentManager. :(");
		}
		
		
	}
	//Method must have this prototype from the doc
	public boolean searchStudentById(int id) {
			return true;
	}
	
	//Method must have this prototype from the doc
	public boolean updateStudentGradeById(int id, double grade) {
		// Go through student collection using for loop.
		for (Student student : students) {
		    // Check to see if student is null and has ID
		    if (student != null && student.getId() == id) {
		        // If true, use setGrade.
		        student.setGrade(grade);
		        
		        // Print message indicating it was a success.
		        System.out.println("Found Student ID: " + id + ". Grade update success.");
		        
		        // As mentioned in the assignment, return true if success.
		        return true;
		    }
		}

		// Print a message indicating it was failed.
		System.out.println("Could not find Student ID: " + id + ". Grade update failed.");

		// As mentioned in the assignment, return false if failed.
		return false;
		
	}
	
}