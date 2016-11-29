import java.awt.*;
import javax.swing.*;


public class EverageLine extends JPanel{

	private double recomanded;
	
	public EverageLine(){}
	public EverageLine(double a)
	{
		setLayout(null);
		setBackground(Color.white);
		recomanded = a;
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
