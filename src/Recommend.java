import javax.swing.*;
import java.awt.*;

public class Recommend extends JPanel
{
	private int num,max;
	private int t,p,c,f;
	private JLabel lbl;
	
	public Recommend() {
		this.setPreferredSize(new Dimension(420,100));
		this.setLayout(null);
		
		t =	(int)Math.abs( 100-(TotalAted.gettCal()/PrivateInfo.getRecomCal()*100) );
		p = (int)Math.abs( 100-(TotalAted.gettProt()/PrivateInfo.getRecomProt()*100) );
		c = (int)Math.abs( 100-(TotalAted.gettCarbo()/PrivateInfo.getRecomCarbo()*100) );
		f = (int)Math.abs( 100-(TotalAted.gettFat()/PrivateInfo.getRecomFat()*100) );
		
		// to find big problem
		if(t>p) max = t;
		else max = p;
		if(max<c) max = c;
		if(max<f) max = f;
	
		lbl = new JLabel();
		lbl.setBounds(80,0,200,30);
		lbl.setFont(new Font("Segoe Print",Font.BOLD,15));
		add(lbl);
		
		setText(max);
	}	// Recommend()	
	public void setText(int a) {
		if(a==t)		lbl.setText("Problem of Calories");
		else if(a==p)	lbl.setText("Problem of Protein");
		else if(a==c)	lbl.setText("Problem of Carbohydrate");
		else			lbl.setText("Problem of Fat");
	}	// setText()
}	// Recommend class
