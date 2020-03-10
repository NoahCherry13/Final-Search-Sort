import BreezySwing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class EnterDialog extends GBDialog implements ItemListener{

	JComboBox options = addComboBox(1, 2, 1, 1);
	
	GBPanel employeePane= addPanel(1,1,2,4);
	JLabel employeeLabel = employeePane.addLabel("", 1, 1, 1, 1);
	JTextField employeeNameField = employeePane.addTextField("",2,2,1,1);
	DoubleField salaryField = employeePane.addDoubleField(0.0,3,2,1,1);
	
	GBPanel studentPane= addPanel(1,1,2,4);
	JTextField studentNameField = studentPane.addTextField("",2,2,1,1);
	DoubleField gpaField = studentPane.addDoubleField(0,3,2,1,1);
	
	GBPanel widgetPane= addPanel(1,1,2,4);
	IntegerField serialNumber = widgetPane.addIntegerField(0,2,2,1,1);
	IntegerField soldField = widgetPane.addIntegerField(0,3,2,1,1);
	
	public EnterDialog(JFrame parent) {
		super(parent);

		options.addItemListener(this);
		
		options.addItem("Employee");
		options.addItem("Student");
		options.addItem("Widget");
		
		widgetPane.add(soldField);
		
		studentPane.setVisible(false);
		widgetPane.setVisible(false);
		employeePane.setVisible(true);
		repaint();
		this.setSize(500, 400);
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
