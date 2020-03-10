import java.util.ArrayList;

public class SortSearch {

	private int count = 0;

	@SuppressWarnings("rawtypes")
	public ArrayList<Comparable> binarySearch(Comparable item, ArrayList<Comparable> arr) throws NullPointerException {
		
		ArrayList<Comparable> temp = new ArrayList<Comparable>(arr);
		count = 0;
		ArrayList<Comparable> output = new ArrayList<Comparable>();
		int f = 0;
		int end = temp.size() - 1;
		int n = temp.size() / 2;
		
		
		if (!temp.contains(item)) {
			throw new NullPointerException("Not In Array");
		}
		while (temp.contains(item)) {
			while (f <= end) {
				count++;
				if (temp.get(n).compareTo(item) < 0) {
					f = n + 1;
				} else if (temp.get(n).compareTo(item) > 0) {
					end = n - 1;
				} else {
					output.add(temp.get(n));
					temp.remove(temp.get(n));
				}
				n = ((f + end) / 2);
			}
			f = 0;
			end = temp.size()-1;
			n = temp.size()/2;
		}
		return output;
	}

}
