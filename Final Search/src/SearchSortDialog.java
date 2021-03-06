import BreezySwing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

public class SearchSortDialog extends GBDialog implements ItemListener {

	public SearchSortDialog(JFrame parent, Database data) {
		super(parent);

		classes.addItemListener(this);
		options.addItemListener(this);

		d = data;

		options.addItem("Search");
		options.addItem("Sort");

		sorts.addItem("Insertion");
		sorts.addItem("Selection");

		searches.addItem("Binary");
		searches.addItem("Linear");

		classes.addItem("Students");
		classes.addItem("Employees");
		classes.addItem("Widgets");

		sortPane.setVisible(false);
		searchPane.setVisible(false);

		this.setSize(300, 225);
		this.setVisible(true);
	}

	Database d;
	SortSearch ss = new SortSearch();

	JComboBox options = addComboBox(1, 1, 1, 1);
	GBPanel searchPane = addPanel(2, 1, 2, 4);
	GBPanel sortPane = addPanel(2, 1, 2, 4);
	JLabel salaryLbl = searchPane.addLabel("Salary", 2, 1, 1, 1);
	DoubleField salaryFld = searchPane.addDoubleField(0.0, 2, 2, 1, 1);
	JLabel nameLbl = searchPane.addLabel("Name: ", 2, 1, 1, 1);
	JLabel serialLbl = searchPane.addLabel("Serial Number: ", 2, 1, 1, 1);
	JTextField inputField = searchPane.addTextField("", 2, 2, 1, 1);
	IntegerField serialField = searchPane.addIntegerField(0, 2, 2, 1, 1);
	JComboBox sorts = sortPane.addComboBox(1, 1, 1, 1);
	JComboBox searches = searchPane.addComboBox(1, 1, 1, 1);
	JComboBox classes = addComboBox(1, 2, 1, 1);
	JButton output = addButton("Enter", 6, 1, 1, 1);

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (options.getSelectedItem() == "Sort") {
				sortPane.setVisible(true);
				searchPane.setVisible(false);
			} else if (options.getSelectedItem() == "Search") {
				searchPane.setVisible(true);
				sortPane.setVisible(false);
			}

			if (classes.getSelectedItem() == "Widgets") {
				nameLbl.setVisible(false);
				serialLbl.setVisible(true);
				serialField.setVisible(true);
				inputField.setVisible(false);
				salaryFld.setVisible(false);
				salaryLbl.setVisible(false);
				repaint();
			} else if (classes.getSelectedItem() == "Students") {
				nameLbl.setVisible(true);
				serialLbl.setVisible(false);
				serialField.setVisible(false);
				inputField.setVisible(true);
				salaryFld.setVisible(false);
				salaryLbl.setVisible(false);
				repaint();

			} else if (classes.getSelectedItem() == "Employees") {
				nameLbl.setVisible(false);
				salaryFld.setVisible(true);
				salaryLbl.setVisible(true);
				serialLbl.setVisible(false);
				serialField.setVisible(false);
				inputField.setVisible(false);
				repaint();
			}
		}

	}

	public void buttonClicked(JButton b) {

		if (b == output) {
			if (classes.getSelectedItem() == "Students") {
				String str = "";
				if (options.getSelectedItem() == "Sort") {
					if (sorts.getSelectedItem() == "Selection") {
						str = "Selection Sort: \n";
						ArrayList<Comparable> sorted = ss.selectionSort(d.getStudents());

						for (Comparable c : sorted) {
							str += ((Student) c).getName() + ", ";
						}
						messageBox(str);
					} else if (sorts.getSelectedItem() == "Insertion") {
						str = "Insertion Sort: \n";
						ArrayList<Comparable> sorted = ss.insertionSort(d.getStudents());

						for (Comparable c : sorted) {
							str += ((Student) c).getName() + ", ";
						}
						messageBox(str);
					}
				} else if (options.getSelectedItem() == "Search") {
					ArrayList<Comparable> arr = null;
					ArrayList sorted = ss.selectionSort(d.getStudents());
					try {
						arr = ss.binarySearch(new Student(inputField.getText(), 0), sorted);
					} catch (Exception e) {
						messageBox(e.getMessage());
					}

					for (int i = 0; i < arr.size(); i++) {
						str += ((Student) arr.get(i)).getName() + ", " + ((Student) arr.get(i)).getGpa() + "\n";
					}
					messageBox(str);
				}
			}else 			if (classes.getSelectedItem() == "Employees") {
				String str = "";
				if (options.getSelectedItem() == "Sort") {
					if (sorts.getSelectedItem() == "Selection") {
						str = "Selection Sort: \n";
						ArrayList<Comparable> sorted = ss.selectionSort(d.getEmployee());

						for (Comparable c : sorted) {
							str += ((Employee) c).getName() + ", ";
						}
						messageBox(str);
					} else if (sorts.getSelectedItem() == "Insertion") {
						str = "Insertion Sort: \n";
						ArrayList<Comparable> sorted = ss.insertionSort(d.getEmployee());

						for (Comparable c : sorted) {
							str += ((Employee) c).getName() + ", ";
						}
						messageBox(str);
					}
				} else if (options.getSelectedItem() == "Search") {
					ArrayList<Comparable> arr = null;
					ArrayList sorted = ss.selectionSort(d.getEmployee());
					try {
						arr = ss.binarySearch(new Employee(salaryFld.getNumber(), null), sorted);
					} catch (Exception e) {
						messageBox(e.getMessage());
					}

					for (int i = 0; i < arr.size(); i++) {
						str += ((Employee) arr.get(i)).getName() + ", " + ((Employee) arr.get(i)).getSalary() + "\n";
					}
					messageBox(str);
				}
			}else 			if (classes.getSelectedItem() == "Widgets") {
				String str = "";
				if (options.getSelectedItem() == "Sort") {
					if (sorts.getSelectedItem() == "Selection") {
						str = "Selection Sort: \n";
						ArrayList<Comparable> sorted = ss.selectionSort(d.getWidgets());

						for (Comparable c : sorted) {
							str += ((Widget) c).getCode() + ", ";
						}
						messageBox(str);
					} else if (sorts.getSelectedItem() == "Insertion") {
						str = "Insertion Sort: \n";
						ArrayList<Comparable> sorted = ss.insertionSort(d.getWidgets());

						for (Comparable c : sorted) {
							str += ((Widget) c).getCode() + ", ";
						}
						messageBox(str);
					}
				} else if (options.getSelectedItem() == "Search") {
					ArrayList<Comparable> arr = null;
					ArrayList sorted = ss.selectionSort(d.getWidgets());
					try {
						arr = ss.binarySearch(new Widget(serialField.getNumber(), 0), sorted);
					} catch (Exception e) {
						messageBox(e.getMessage());
					}

					for (int i = 0; i < arr.size(); i++) {

						str += ((Widget) arr.get(i)).getCode() + ", " + ((Widget) arr.get(i)).getSold() + "\n";
					}
					messageBox(str);
				}
			}
		}
	}
}
