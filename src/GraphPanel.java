import java.awt.*;
import javax.swing.*;

public class GraphPanel extends JPanel {
	private FoodAteBar tot,dan,tan,ji;	// 단백질 , 탄수화물 , 지방
	private JPanel drawing;
	private double destin;
	
	// private 권장량 클래스 
	// private 먹은 종합 량 

	
	GraphPanel(){
		setLayout(null);
		setBackground(Color.gray);
		setPreferredSize(new Dimension(760,230));			
		
		tot = new FoodAteBar(10,10);
		tot.setBounds(10,20,740,40);
		add(tot);
		
		dan = new FoodAteBar(10,10);
		dan.setBounds(10,70,740,40);
		add(dan);
		
		tan = new FoodAteBar(10,10);
		tan.setBounds(10,120,740,40);
		add(tan);
		
		ji = new FoodAteBar(10,10);
		ji.setBounds(10,170,740,40);
		add(ji);
	}

}