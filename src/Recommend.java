import javax.swing.*;
import java.awt.*;

public class Recommend extends JPanel
{
	private int num,max;
	private int t,p,c,f;
	private boolean check = true;
	private JLabel lbl,comment;
	
	public Recommend() {
		this.setPreferredSize(new Dimension(420,100));
		this.setLayout(null);
		
		t =	(int)	( 100-(TotalAted.gettCal()/PrivateInfo.getRecomCal()*100) );
		p = (int)	( 100-(TotalAted.gettProt()/PrivateInfo.getRecomProt()*100) );
		c = (int)	( 100-(TotalAted.gettCarbo()/PrivateInfo.getRecomCarbo()*100) );
		f = (int)	( 100-(TotalAted.gettFat()/PrivateInfo.getRecomFat()*100) );
		
		// to find big problem
		if(Math.abs(t)>Math.abs(p)) { max = Math.abs(t); if(t<0) check=false;	}
		else 						{ max = Math.abs(p); if(p<0) check=false;	}
		if(max<Math.abs(c))			{ max = Math.abs(c); if(c<0) check=false;	}
		if(max<Math.abs(f)) 		{ max = Math.abs(f); if(f<0) check=false;	}
	
		lbl = new JLabel();
		lbl.setBounds(0,0,400,30);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVerticalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Segoe Print",Font.BOLD,20));
		add(lbl);
		
		comment = new JLabel();
		comment.setBounds(0,35,400,60);
		comment.setHorizontalAlignment(SwingConstants.CENTER);
		comment.setVerticalAlignment(SwingConstants.CENTER);
		comment.setFont(new Font("Segoe Print",Font.BOLD,28));
		comment.setForeground(Color.black);
		add(comment);
		
		setText();
		if(check = false)		setCommentS();
		else if(check = true)	setCommentA();		
	}	// Recommend()	
	
	public void setText() {
		if(max==t)		lbl.setText("Problem of Calories");
		else if(max==p)	lbl.setText("Problem of Protein");
		else if(max==c)	lbl.setText("Problem of Carbohydrate");
		else			lbl.setText("Problem of Fat");
	}	// setText()
	
	public void setCommentS() {
		if(max==t)			comment.setText("Shortage of Calories " + max+ " kcal");
		else if(max==p)		comment.setText("Shortage of Protein " + max+ " kcal");
		else if(max==c)		comment.setText("Shortage of Carbohydrate " + max+ " kcal");
		else				comment.setText("Shortage of Fat " + max+ " kcal");
	}	// setCommenetS()
	
	public void setCommentA() {
		if(max==t)			comment.setText("Abundance of Calories " + max + "kcal");
		else if(max==p)		comment.setText("Abundance of Protein " + max+ "kcal");
		else if(max==c)		comment.setText("Abundance of Carbohydrate " + max+ "kcal");
		else				comment.setText("Abundance of Fat " + max+ "kcal");
	}	// setCommenetA()
}	// Recommend class
