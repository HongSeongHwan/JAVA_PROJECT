import java.awt.*;
import javax.swing.*;
public class FirstPanel extends JPanel {
	public JTextField [] field;
	public JLabel [] lbl; 
	int num;
	FirstPanel(){

		num = 4;
		field = new JTextField[num];
		lbl = new JLabel[num];
		this.setBounds(1,1,100,100);
		this.setBackground(Color.BLUE);
		for(int i=0 ; i<num; i++){
			field[i] = new JTextField(20);
			lbl[i] = new JLabel("asd2");
			add(field[i]);
			add(lbl[i]);
		}	
		JButton nextBtn = new JButton("asd");
		nextBtn.addMouseListener(new FirstPanelListener());
		add(nextBtn);
		this.add(new JTextField(10));
	}
}
