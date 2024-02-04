package homework_2;

public class Student {
		
	private int id= -1;
	private String name="";
	private double grade = -1;
	
	public Student() {
		
	}
	public Student(int id, String name, double grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public String toString() {
		String s = this.name + " has an ID of " + this.id + " and has a grade of " + this.grade + ".";
		return s;
	}

}
