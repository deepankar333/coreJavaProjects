package StudentManagement;

public class Student {
	private int rollNo;
	private String name;
	private double marks1;
	private double marks2;
	private double marks3;
	private double avg;
	
	public Student() {}
	
	public Student(int rollNo, String name, double marks1, double marks2, double marks3) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public double getMarks1() {
		return marks1;
	}
	public double getMarks2() {
		return marks2;
	}
	public double getMarks3() {
		return marks3;
	}
	
	public double getTotalMarks() {
		return marks1+marks2+marks3;
	}
	
	public String getGrade() {
		avg=getTotalMarks()/100;
		if (avg >=75) return "A";
		else if(avg >=60) return "B";
		else if (avg >=40) return "C";
		else return"Fail";
	}
	
	public void display() {
		System.out.println("Roll Number : "+rollNo);
		System.out.println("Name : "+name);
		System.out.println("Subject 1 : "+marks1);
		System.out.println("Subject 2 : "+marks2);
		System.out.println("Subject 3 : "+marks3);
		System.out.println("Total Marks : "+getTotalMarks());
		System.out.println("Grade : "+getGrade());
	}
	
}
