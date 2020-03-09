import BreezySwing.*;
import javax.swing.*;

public class EnterDialog extends GBDialog {

	JComboBox options = addComboBox(1, 2, 1, 1);
	GBPanel employeePane= addPanel(1,1,1,1);
	GBPanel studentPane= addPanel(1,1,1,1);
	GBPanel widgetPane= addPanel(1,1,1,1);

	public EnterDialog(JFrame parent) {
		super(parent);
	}

}
