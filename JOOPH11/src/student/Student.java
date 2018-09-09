package student;

public class Student {
	private String name;
	private int age, grade, ECP, NCP;

	Student(String name, int age, int grade, int ECP, int NCP) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.ECP = ECP;
		this.NCP = NCP;
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
}