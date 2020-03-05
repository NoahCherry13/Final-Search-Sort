
public class Employee implements Comparable <Employee>{

	private double Salary;
	private String name;
	
	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee(double salary, String name) {
		Salary = salary;
		this.name = name;
	}

	@Override
	public int compareTo(Employee o) {
		if (getSalary()<o.getSalary()) {
			return -1;
		}else if (getSalary()>o.getSalary()) {
			return 1;
		}else return 0;
	}
	
	
}
