import java.awt.*;
import javax.swing.*;

public class FoodAteBar extends JPanel {		
			
	private int destiny,delay,rectX;
	private double data,dataD;
	private EverageLine eLine;
	private GraphThread t;
	
	public FoodAteBar() {}
	public FoodAteBar(double a, double b)
	{
		setLayout(null);
		setBackground(Color.white);
		
		delay = 30;
		data = a;
		dataD = b;
		rectX=0;
		destiny = (int)((data/(dataD*1.2))*740);
		eLine=new EverageLine(dataD/3);		
		
		t = new GraphThread(this);
		t.start();
	}

	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		page.setColor(Color.blue);
		page.fillRect(0,5,rectX,30);	
		
		page.setColor(Color.red);
		page.drawLine((int)eLine.getRecomanded(), 0, (int)eLine.getRecomanded(), 40);
		
	}	// paintComponent();
	

		// thread
	class  GraphThread extends Thread
	{
 		FoodAteBar graph;
 	 	
 		public GraphThread(FoodAteBar p){
			graph = p;
 		}
 
 		public void run(){
  			
 			while(destiny >= rectX){
  				rectX += 1;
				graph.repaint();
				   
   				try{
   					 Thread.sleep(delay);
   				}catch(Exception e){}
  			}
 		}
	}
	
}