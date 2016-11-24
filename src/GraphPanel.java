import java.awt.*;
import javax.swing.*;

public class GraphPanel extends JPanel {
	private JPanel dan,tan,ji;	// 단백질 , 탄수화물 , 지방
	
	GraphPanel(){
		setLayout(null);
		setBackground(Color.gray);		
		
		dan = new JPanel();
		dan.setBounds(10,5,740,70);
		add(dan);
		
		tan = new JPanel();
		tan.setBounds(10,80,740,70);
		add(tan);
		
		ji = new JPanel();
		ji.setBounds(10,155,740,70);
		add(ji);
	}	
}
