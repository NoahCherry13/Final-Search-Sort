import BreezySwing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class EnterDialog extends GBDialog implements ItemListener{

	JComboBox options = addComboBox(1, 2, 1, 1);
	
	GBPanel employeePane= addPanel(1,1,1,1);
	JTextField employeeNameField = addTextField("",1,2,1,1);
	DoubleField salaryField = addDoubleField(0.0,2,2,1,1);
	
	GBPanel studentPane= addPanel(1,2,1,1);
	JTextField studentNameField = addTextField("",1,2,1,1);
	DoubleField gpaField = addDoubleField(0,2,2,1,1);
	
	GBPanel widgetPane= addPanel(1,3,1,1);
	IntegerField serialNumber = addIntegerField(0,1,2,1,1);
	IntegerField soldField = addIntegerField(0,2,2,1,1);
	
	public EnterDialog(JFrame parent) {
		super(parent);

		options.addItemListener(this);
		
		options.addItem("Employee");
		options.addItem("Student");
		options.addItem("Widget");
		
		employeePane.add(employeeNameField);
		employeePane.add(salaryField);
		
		studentPane.add(studentNameField);
		studentPane.add(gpaField);
		
		widgetPane.add(serialNumber);
		widgetPane.add(soldField);
		
		studentPane.setVisible(false);
		widgetPane.setVisible(false);
		employeePane.setVisible(true);
		
		this.setSize(500, 400);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
