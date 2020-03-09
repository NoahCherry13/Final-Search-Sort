import java.util.ArrayList;

public class SortSearch {

	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private ArrayList<Widget> widgetList = new ArrayList<Widget>();
	private int count = 0;

	public ArrayList<Comparable> binarySearch(Comparable item, ArrayList<Comparable> arr) throws NullPointerException {
		count = 0;
		ArrayList<Comparable> output = new ArrayList<Comparable>();
		int f = 0;
		int end = arr.size() - 1;
		int n = arr.size() / 2;
		if (!arr.contains(item)) {
			throw new NullPointerException("Not In Array");
		}
		while (arr.contains(item)) {
			while (f <= end) {
				count++;
				if (arr.get(n).compareTo(item) < 0) {
					f = n + 1;
				} else if (arr.get(n).compareTo(item) > 0) {
					end = n - 1;
				} else {
					output.add(arr.get(n));
				}
				n = ((f + end) / 2);
			}
		}
		return output;
	}

}
