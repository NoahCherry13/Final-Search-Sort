
public class Student implements Comparable<Student>{

	private String name;
	private double gpa;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Student(String name, double gpa) {
		super();
		this.name = name;
		this.gpa = gpa;
	}
	@Override
	public int compareTo(Student o) {
		return getName().compareTo(o.getName());
	}
	
	public String toString() {
		return ("Name: "+ name +", GPA: " + gpa);
	}
	
}
