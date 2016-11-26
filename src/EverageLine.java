import java.awt.*;
import javax.swing.*;


public class EverageLine extends JPanel{
	private double datae, dataE;
	private double recomanded;
	
	public EverageLine(){}
	public EverageLine(double a, double b)
	{
		setLayout(null);
		setBackground(Color.white);
		datae = a;
		dataE = b;
		recomanded = (datae*74)/dataE;
	}
	public double getRecomanded()
	{
		return recomanded;
	}
	public void paintComponent(Graphics page2)
	{
		super.paintComponent(page2);
		 
		
		
		
	}	// paintComponent();	
}
