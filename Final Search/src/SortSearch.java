import java.util.ArrayList;

public class SortSearch {

	private int count = 0;

	@SuppressWarnings("rawtypes")
	public ArrayList<Comparable> binarySearch(Comparable item, ArrayList<Comparable> arr) throws NullPointerException {
		
		ArrayList<Comparable> temp = new ArrayList<Comparable>(arr);
		count = 0;
		ArrayList<Comparable> output = new ArrayList<Comparable>();
		int f = 0;
		boolean found;
		int end = temp.size() - 1;
		int n = temp.size() / 2;
		
		do {
			found = false;
			while (f <= end) {
				count++;
				if (temp.get(n).compareTo(item) < 0) {
					f = n + 1;
				} else if (temp.get(n).compareTo(item) > 0) {
					end = n - 1;
				} else {
					output.add(temp.get(n));
					temp.remove(temp.get(n));
					found = true; 
				}
				n = ((f + end) / 2);
			}
			
			f = 0;
			end = temp.size()-1;
			n = temp.size()/2;
		}while(found);
		
		if (output.size() == 0) {
			throw new NullPointerException("Not In List");
		}
		
		return output;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList<Comparable> sequentialSearch(Comparable item, ArrayList<Comparable> arr){
		ArrayList<Comparable> output = new ArrayList();
		count = 0;
		for (int i = 0;i<arr.size();i++) {
			count++;
			if (arr.get(i).compareTo(item) == 0) {
				output.add(arr.get(i));
			}
		}
		throw new NullPointerException("Item Not Found");
	}

	public int getCount() {
		return count;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Comparable> selectionSort(ArrayList<Comparable> arr){

		int n = arr.size();

		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr.get(j).compareTo(arr.get(min_idx))<0) 
					min_idx = j;
			}

			Comparable temp = arr.get(min_idx);
			arr.set(min_idx, arr.get(i));
			arr.set(i, temp);
		}
		return arr;
	}
	
	public ArrayList<Comparable> insertionSort(ArrayList<Comparable> arr){
		
		for(int i = 1; i < arr.size(); i++) {
			Comparable t = arr.get(i);
			int pos = i;
			
			while (pos > 0 && arr.get(pos-1).compareTo(t)>0) {
				arr.set(pos, arr.get(pos-1));
				pos--;
			}
			arr.set(pos, t);
		}
		return arr;
	}
	
}
