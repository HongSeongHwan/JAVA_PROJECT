import java.awt.*;
import javax.swing.*;

public class FoodAteBar extends JPanel {		
			
	private double destiny;
	private double data,dataD;
	private EverageLine eLine;
	
	public FoodAteBar() {}
	public FoodAteBar(double a, double b)
	{
		setLayout(null);
		setBackground(Color.white);
		
		data = a;
		dataD = b;
		eLine=new EverageLine(5,10);
		
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		destiny = (data*74)/dataD;
		page.setColor(Color.blue);
		page.fillRect(0,5,(int)destiny,30);	
		
		page.setColor(Color.red);
		page.drawLine((int)eLine.getRecomanded(), 0, (int)eLine.getRecomanded(), 40);
		
	}	// paintComponent();	
}