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
		for(Student student : students) {
			if(student.getId() == id) {
				System.out.println("The student with the ID: " + student.getId() + " found! " );
				System.out.println("Name: " + student.getName());
				System.out.println("Grade: " + student.getGrade());
				
				return true;
				}
		}
		System.out.println("Student with ID " + id + "not found.");
		return false;
	}
	
	//Method must have this prototype from the doc
	public boolean updateStudentGradeById(int id, double grade) {
		// per assignment, using 'searchStudentById' method
		if (searchStudentById(id)) {
	        // use loop to go through student
	        for (Student student : students) {
	        	if (student.getId() == id) {
	            
	            	System.out.println("Student ID " + student.getId() + "'s grade has been updated");
	                System.out.println("Previous Grade: " + student.getGrade());
	                
	                // Use setGrade
	                student.setGrade(grade);
	             
	                System.out.println("New Grade: " + student.getGrade());
	                
	                return true;
	            }
	        }
		} 
	    else {
	        // Extra print stating grade hasn't been updated if not found.
	        System.out.println("Grade not updated.");
	    }
	    	return false;
	}	
	
}
