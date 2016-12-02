import java.awt.*;
import javax.swing.*;
import java.util.concurrent.*;
public class GraphPanel extends JPanel {
	private FoodAteBar 	tot,dan,tan,ji;
	private static int totX,danX,tanX,jiX;
	
	GraphPanel(){
		setLayout(null);
		setBackground(Color.gray);
		setPreferredSize(new Dimension(760,230));
		
		// main
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
	
	public void startThread() {		
		tot.renew(totX, TotalAted.gettCal(),PrivateInfo.getRecomCal());
		dan.renew(danX, TotalAted.gettCarbo(),PrivateInfo.getRecomProt());
		tan.renew(tanX, TotalAted.gettProt(),PrivateInfo.getRecomCarbo());
		ji.renew(jiX, TotalAted.gettFat(),PrivateInfo.getRecomFat());		
	}
}