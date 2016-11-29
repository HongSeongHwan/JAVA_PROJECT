import java.awt.*;
import javax.swing.*;

public class GraphPanel extends JPanel {
	private FoodAteBar tot,dan,tan,ji;
	private DataSample a;
	
	GraphPanel(){
		setLayout(null);
		setBackground(Color.gray);
		setPreferredSize(new Dimension(760,230));
		
		a = new DataSample();			
		
		tot = new FoodAteBar(a.tot,a.totD);
		tot.setBounds(10,20,740,40);
		add(tot);
		
		dan = new FoodAteBar(a.dan,a.danD);
		dan.setBounds(10,70,740,40);
		add(dan);		
		
		tan = new FoodAteBar(a.tan,a.tanD);
		tan.setBounds(10,120,740,40);
		add(tan);
		
		ji = new FoodAteBar(a.ji,a.jiD);
		ji.setBounds(10,170,740,40);
		add(ji);
	}

}