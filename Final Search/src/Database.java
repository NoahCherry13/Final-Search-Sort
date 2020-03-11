import java.util.ArrayList;
public class Database {
	
	ArrayList<Employee> employeeList;
	ArrayList<Student> studentList;
	ArrayList<Widget> widgetList;
	
	
	public Database() {
		widgetList = new ArrayList<Widget>();
		studentList = new ArrayList<Student>();
		employeeList = new ArrayList<Employee>();
	}
	
	public ArrayList<Widget> getWidgets(){
		return widgetList;
	}
	
	public ArrayList<Student> getStudents(){
		return studentList;
	}
	
	public ArrayList<Employee> getEmployee(){
		return employeeList;
	}
	
	public void addEmployee(Employee e) {
		employeeList.add(e);
	}
	
	public void addWidget(Widget e) {
		widgetList.add(e);
	}
	
	public void addStudent(Student e) {
		studentList.add(e);
	}
}
