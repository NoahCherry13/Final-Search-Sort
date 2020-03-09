import BreezySwing.*;
import javax.swing.*;
public class FinalSearchGUI extends GBFrame{

	JButton enter = addButton("Enter",1,1,1,1);
	JButton exit = addButton("Exit",3,1,1,1);
	JButton output = addButton("Output",2,1,1,1);
	
	public static void main(String[] args) {
		JFrame frm = new FinalSearchGUI();
		frm.setTitle("Ace Program");
		frm.setSize(700, 500);
		frm.setVisible(true);

	}
	
	public void buttonClicked(JButton b) {
		if (b == enter) {
			EnterDialog ed = new EnterDialog(this);
		}else if (b == output) {
			
		}else if (b == exit) {
			System.exit(0);
		}
	}

}
