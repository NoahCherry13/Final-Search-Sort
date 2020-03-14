import java.util.ArrayList;
public class Database {
	ArrayList<Comparable> arr;
	ArrayList<Comparable> employeeList;
	ArrayList<Comparable> studentList;
	ArrayList<Comparable> widgetList;
	
	
	public Database() {
		arr = new ArrayList<Comparable>();
		widgetList = new ArrayList<Comparable>();
		studentList = new ArrayList<Comparable>();
		employeeList = new ArrayList<Comparable>();
	}
	
	public ArrayList<Comparable> getWidgets(){
		for(Comparable c: arr) {
			if (c instanceof Widget&& !widgetList.contains(c)) {
				widgetList.add((Widget)c);
			}
		}
		return widgetList;
	}
	public ArrayList<Comparable> getStudents(){
		for(Comparable c: arr) {
			if (c instanceof Student&& !studentList.contains(c)) {
				studentList.add((Student)c);
			}
		}
		return studentList;
	}
	public ArrayList<Comparable> getEmployee(){
		for(Comparable c: arr) {
			if (c instanceof Employee&& !employeeList.contains(c)) {
				employeeList.add((Employee)c);
			}
		}
		return employeeList;
	}
	
	public void addEmployee(Employee e) {
		arr.add(e);
	}
	
	public void addWidget(Widget e) {
		arr.add(e);
	}
	
	public void addStudent(Student e) {
		arr.add(e);
	}
}
