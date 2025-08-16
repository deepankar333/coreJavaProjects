package StudentManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class StudentService {
	private ArrayList<Student> student = new ArrayList<Student>();
	private Scanner sc =new Scanner(System.in);

	
	public void addStudent() {
		System.out.println("Enter Roll Number : ");
		int rollNo=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name : ");
		String name=sc.nextLine();
		System.out.println("Enter Marks attained for Subject 1 :");
		double m1=sc.nextDouble();
		System.out.println("Enter Marks attained for Subject 2 :");
		double m2=sc.nextDouble();
		System.out.println("Enter Marks attained for Subject 3 :");
		double m3=sc.nextDouble();
		
		student.add(new Student(rollNo, name, m1, m2, m3));
	}
	
	public void viewAll() {
		for(Student s: student) {
			s.display();
		}
	}
	
	public void searchByRollNo() {
		System.out.println("Enter Roll No to search : ");
		int rno=sc.nextInt();
		student.stream().filter(ro -> ro.getRollNo()==rno).findFirst().ifPresentOrElse(ro -> {ro.display();},
				() -> System.out.println("Entered Roll No. not found"));
	}
	
	public void sortBymarks() {
		student.sort(Comparator.comparingDouble(Student::getTotalMarks).reversed());
		System.out.println("Students sorted by marks (High to Low)");
	}

	public void sortByName() {
		student.sort(Comparator.comparing(Student::getName));
		System.out.println("Students Names sorted in Alphabetical order (A -> Z)" );
	}
}
