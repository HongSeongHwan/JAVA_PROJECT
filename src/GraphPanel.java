import java.awt.*;
import javax.swing.*;

public class GraphPanel extends JPanel {
	private FoodAteBar 	tot,dan,tan,ji;
	private DataSample 	a;
	//private PrivateInfo	recom;
	
	GraphPanel(){
		setLayout(null);
		setBackground(Color.gray);
		setPreferredSize(new Dimension(760,230));
		
		a = new DataSample();
		PrivateInfo.recommend();
		
		// test 
		tot = new FoodAteBar(TotalAted.gettCal(),PrivateInfo.getRecomCal());
		tot.setBounds(10,20,740,40);
		add(tot);
		
		dan = new FoodAteBar(TotalAted.gettCarbo(),PrivateInfo.getRecomProt());
		dan.setBounds(10,70,740,40);
		add(dan);		
		
		tan = new FoodAteBar(TotalAted.gettProt(),PrivateInfo.getRecomCarbo());
		tan.setBounds(10,120,740,40);
		add(tan);
		
		ji = new FoodAteBar(TotalAted.gettFat(),PrivateInfo.getRecomFat());
		ji.setBounds(10,170,740,40);
		add(ji);
	}

}