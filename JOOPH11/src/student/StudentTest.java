package student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTest {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		Student s1 = new Student("Mari", 19, 4, 68, 60);
		Student s2 = new Student("Mati", 22, 3, 72, 60);
		Student s3 = new Student("Kati", 20, 5, 65, 60);
		Student s4 = new Student("Rita", 18, 3, 61, 60);
		Student s5 = new Student("Teet", 20, 4, 65, 60);
		Student s6 = new Student("Olga", 19, 2, 43, 60);
		Student s7 = new Student("Alan", 19, 4, 58, 60);
		Student s8 = new Student("Peep", 20, 3, 37, 60);
		Student s9 = new Student("Elen", 19, 1, 28, 60);
		Student s10 = new Student("Eva", 20, 2, 44, 60);
		Student s11 = new Student("Anu", 19, 5, 68, 60);
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		students.add(s7);
		students.add(s8);
		students.add(s9);
		students.add(s10);
		students.add(s11);
		for (Student s : students) {
			s.setGrade(4);
		}
		System.out.println("Eleni hinne: " + s9.getGrade());
		students.forEach(s -> s.setGrade(3));
		System.out.println("Eleni hinne: " + s9.getGrade());
		Stream<Student> myStream = students.stream();
		Stream<Student> sEAP1 = myStream
				.filter(s -> s.getEarnedCreditPoints() >= 60);
		long studentsEAP1 = sEAP1.count();
		System.out.println("Tudengite arv, kellel on vähemalt 60 EAP:");
		System.out.println("\tStream: " + studentsEAP1);
		long sEAP2 = students.stream()
				.filter(s -> s.getEarnedCreditPoints() >= 60).count();
		System.out.println("\tMethod chaining: " + sEAP2);
		List<Student> sEAP3 = students.stream()
				.filter(s -> s.getEarnedCreditPoints() >= 60)
				.collect(Collectors.toList());
		System.out.println("\tCollectors to list: " + sEAP3.size());
		List<Student> sEAP4 = students.stream()
				.filter(s -> s.getEarnedCreditPoints() >= 60)
				.collect(Collectors.toCollection(LinkedList::new));
		System.out.println("\tCollectors to linked list: " + sEAP4.size());
		int sEAP5 = students.stream()
				.filter(s -> s.getEarnedCreditPoints() >= 60)
				.mapToInt(s -> s.getEarnedCreditPoints()).sum();
		System.out.println("Üle 60 EAP saanud tudengite EAP-d kokku:");
		System.out.println("\tMapping: " + sEAP5);
		List<Person> sEAP6 = students.stream()
				.filter(s -> s.getEarnedCreditPoints() >= 60)
				.map(s -> new Person(s.getName(), s.getAge()))
				.collect(Collectors.toList());
		System.out.println("Loodud isikud: " + sEAP6.size());
	}
}