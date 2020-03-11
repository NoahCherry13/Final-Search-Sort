import BreezySwing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
public class SearchSortDialog extends GBDialog implements ItemListener{

	public SearchSortDialog(JFrame parent) {
		super(parent);
		
		options.addItemListener(this);
		classes.addItemListener(this);
		
		
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
	
	
	JComboBox options = addComboBox(1,1,1,1);
	GBPanel searchPane = addPanel(2,1,2,4);
	GBPanel sortPane = addPanel(2,1,2,4);
	JLabel nameLbl = searchPane.addLabel("Name: ", 2, 1, 1, 1);
	JLabel serialLbl = searchPane.addLabel("Serial Number: ", 2, 1, 1, 1);
	JTextField inputField = searchPane.addTextField("",2,2,1,1);
	IntegerField serialField = searchPane.addIntegerField(0, 2, 2, 1, 1);
	JComboBox sorts = sortPane.addComboBox(1,1,1,1);
	JComboBox searches = searchPane.addComboBox(1,2,1,1);
	JComboBox classes = addComboBox(1,2,1,1);
	JButton output = addButton ("Enter",3,2,1,1);

	public void buttonClicked(JButton b) {
		if (b == output) {
			if (sorts.getSelectedItem() == "Insertion") {
				
			}else if (sorts.getSelectedItem() == "Selection") {
				
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if(options.getSelectedItem() == "Sort") {
				sortPane.setVisible(true);
				searchPane.setVisible(false);
			}else if (options.getSelectedItem() == "Search") {
				searchPane.setVisible(true);
				sortPane.setVisible(false);
			}
			
			if(classes.getSelectedItem() == "Widget") {
				System.out.println("Widget");
				nameLbl.setVisible(false);
				serialLbl.setVisible(true);
				serialField.setVisible(true);
				inputField.setVisible(false);
				repaint();
			}else if (classes.getSelectedItem() == "Employee"||classes.getSelectedItem() == "Student"){
				System.out.println("Not Widget");
				nameLbl.setVisible(true);
				serialLbl.setVisible(false);
				serialField.setVisible(false);
				inputField.setVisible(true);
				repaint();
			
			}
		}
		
	}
}
