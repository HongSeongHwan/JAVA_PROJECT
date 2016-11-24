import javax.swing.*;
import java.awt.*;

public class Dialog_PopUp extends JDialog{
	private JLabel jlb = new JLabel("");
	private String str;
	private JPanel x;
	
	public Dialog_PopUp(){
		 str = "123";		 
		 x = new JPanel();
		 x.setBounds(0,0,300,300);
		 x.setBackground(Color.YELLOW);
		 getContentPane().add(jlb);
         jlb.setText(str.toString());
         
         this.getContentPane().add(x);
         this.setSize(300,300);
         this.setModal(true);
         this.setVisible(true);
	}
}