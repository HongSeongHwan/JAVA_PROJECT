import java.awt.*;
import javax.swing.*;

public class FoodAteBar extends JPanel {		
			
	private int destiny,delay;
	private double data,dataD;
	private EverageLine eLine;
	private int rectX;
	private static GraphThread t;
	
	public FoodAteBar(double a, double b)
	{
		setBackground(Color.white);	

		eLine = new EverageLine(740/1.2);
		delay = 30;
	}
	public void renew(int x, double a, double b){
		rectX = x;
		data = a;
		dataD = b;		
		destiny = (int)((data*740)/(dataD*1.2));
		
		new GraphThread(this).start();	
	}
	
//	public double getData()		{ return data; }
//	public double getDataD()	{ return dataD; }	
	
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
 			while(destiny > rectX){
  				rectX += 1;
				graph.repaint();
				   
   				try{
   					 Thread.sleep(delay);
   				}catch(Exception e){}
  			}
 			/*
 			while(destiny < rectX){
  				rectX -= 1;
				graph.repaint();
				   
   				try{
   					 Thread.sleep(delay);
   				}catch(Exception e){}
  			} 	
  			*/		
 		} 		
	}
	
}