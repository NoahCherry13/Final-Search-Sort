import BreezySwing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class EnterDialog extends GBDialog implements ItemListener{

	
	Database d;
	
	JComboBox options = addComboBox(1, 2, 1, 1);
	
	GBPanel employeePane= addPanel(1,1,2,4);
	JButton eEnter = employeePane.addButton("Enter",4,1,1,1);
	JLabel employeeLabel = employeePane.addLabel("", 1, 1, 1, 1);
	JLabel eNameLbl = employeePane.addLabel("Name:", 2, 1, 1, 1);
	JTextField employeeNameField = employeePane.addTextField("",2,2,1,1);
	JLabel salaryLbl = employeePane.addLabel("Salary:", 3, 1, 1, 1);
	DoubleField salaryField = employeePane.addDoubleField(0.0,3,2,1,1);
	
	GBPanel studentPane= addPanel(1,1,2,4);
	JButton sEnter = studentPane.addButton("Enter",4,1,1,1);
	JLabel StudentLabel = studentPane.addLabel("", 1, 1, 1, 1);
	JLabel sNameLbl = studentPane.addLabel("Name:", 2, 1, 1, 1);
	JTextField studentNameField = studentPane.addTextField("",2,2,1,1);
	JLabel gpaLbl = studentPane.addLabel("GPA:", 3, 1, 1, 1);
	DoubleField gpaField = studentPane.addDoubleField(0,3,2,1,1);
	
	GBPanel widgetPane= addPanel(1,1,2,4);
	JButton wEnter = widgetPane.addButton("Enter",4,1,1,1);
	JLabel WidgetLabel = widgetPane.addLabel("", 1, 1, 1, 1);
	JLabel serialLabel = widgetPane.addLabel("Serial Number:", 2, 1, 1, 1);
	IntegerField serialNumber = widgetPane.addIntegerField(0,2,2,1,1);
	JLabel soldLbl = widgetPane.addLabel("Number Sold:", 3, 1, 1, 1);
	IntegerField soldField = widgetPane.addIntegerField(0,3,2,1,1);
	
	public EnterDialog(JFrame parent, Database data) {
		super(parent);
		d = data;
		options.addItemListener(this);
		
		options.addItem("Employee");
		options.addItem("Student");
		options.addItem("Widget");
		
		studentPane.setVisible(false);
		widgetPane.setVisible(false);
		employeePane.setVisible(true);
		repaint();
		this.setSize(275, 200);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			
			if (options.getSelectedItem() == "Employee") {
				studentPane.setVisible(false);
				widgetPane.setVisible(false);
				employeePane.setVisible(true);
			}else if(options.getSelectedItem() == "Student") {
				studentPane.setVisible(true);
				widgetPane.setVisible(false);
				employeePane.setVisible(false);
			}else if(options.getSelectedItem() == "Widget") {
				studentPane.setVisible(false);
				widgetPane.setVisible(true);
				employeePane.setVisible(false);
			}
		}
		
	}
	
	public void buttonClicked(JButton b) {
		if (b == eEnter) {
			if (employeeNameField.getText().isBlank()) {
				messageBox("Please enter a Name");
				return;
			}else if (!salaryField.isValidNumber()) {
				messageBox("Please enter a valid Salary");
				return;
			}
			d.addEmployee(new Employee(salaryField.getNumber(),employeeNameField.getText()));
			messageBox("Added: \n"+ employeeNameField.getText()+", "+salaryField.getNumber());
		}else if(b == sEnter) {
			if (studentNameField.getText().isBlank()) {
				messageBox("Please enter a Name");
				return;
			}else if (!gpaField.isValidNumber()) {
				messageBox("Please enter a valid GPA");
				return;
			}
			d.addStudent(new Student(studentNameField.getText(),gpaField.getNumber()));
			messageBox("Added: \n"+ studentNameField.getText()+", "+gpaField.getNumber());
		}else if(b == wEnter) {
			if (!serialNumber.isValidNumber()) {
				messageBox("Please Enter a valid Serial Number");
				return;
			}else if(!soldField.isValidNumber()) {
				messageBox("Please Enter a Valid Quantity");
				return;
			}
			d.addWidget(new Widget(serialNumber.getNumber(), soldField.getNumber()));
			messageBox("Added: \n"+ serialNumber.getText()+", "+soldField.getNumber());
		}
	}

}
