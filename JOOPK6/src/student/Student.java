package student;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name, course;
	private int age, grade, ECP, NCP;

	Student(String name, int age, int grade, int ECP, int NCP, String course) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.ECP = ECP;
		this.NCP = NCP;
		this.course = course;
	}

	public void setGrade(int setGrade) {
		this.grade = setGrade;
	}

	public int getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getEarnedCreditPoints() {
		return ECP;
	}

	public int getNominalCreditPoints() {
		return NCP;
	}

	public List<String> getCourses() {
		List<String> courses = new ArrayList<>();
		courses.add(course);
		return courses;
	}
}