package homework_2;

public class StudentManager {
	
	private Student students[];
	

	
	
	public static void main(String[] args) {
		StudentManager sd = new StudentManager();
		sd.students[0] = new Student();
		
	}
	
	//Method must have this prototype from the doc
	public boolean readFromFile(String fileName) {
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
		return true;
		
	}
	
}
