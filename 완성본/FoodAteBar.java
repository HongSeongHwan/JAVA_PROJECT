import java.awt.*;
import javax.swing.*;

public class FoodAteBar extends JPanel {		
			
	private int destiny,delay,i;
	private double data,dataD;	
	private int rectX,percent,prePer;
	
	private EverageLine eLine;		// draw a recommended line
	private GraphPanel primary;		// canvas
	
	public FoodAteBar(double a, double b)
	{
		setBackground(Color.white);	

		i=0;
		eLine = new EverageLine(630/1.5);	// 권장량 눈금선
		delay = 10;		// thread speed
	}	// FoodAteBar()
	
	public void renew(int x, int y, double a, double b){
		rectX = x;			// 지난 그래프 - 스레드 시작점
		prePer = y;			// 지난 퍼센트 - 스레드 시작점
		data = a;
		dataD = b;		
		destiny = (int)((data*630)/(dataD*1.5));	// 그래프의 목표점
		percent = (int)	((data/dataD)*100);			// 퍼센트의 목표점
		
		new GraphThread(this).start();		// thread start
	}	// renew()
	
	
	// get / set
	public int getDestiny(double a, double b)	{ 
		destiny = (int)((a*630)/(b*1.5));
		return destiny; 
	}	// getDestiny()
	
	public int getPercent() {
		if (i<0) i = 0;
		return i;
	}	// getPercent()
	
	public void setThis(GraphPanel p)
	{
		primary = p;	
	}	// setThis()
	
	// Painting
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		// drawing graph
		page.setColor(new Color(120,170,175));
		page.fillRect(0,5,rectX,30);	
		
		// drawing recommended line
		page.setColor(Constant.c2);
		page.drawLine((int)eLine.getRecomanded(), 0, (int)eLine.getRecomanded(), 40);		
	}	// paintComponent();
	

	// Thread
	class  GraphThread extends Thread
	{
 		FoodAteBar graph;
 	 	
 		public GraphThread(FoodAteBar p){
			graph = p;
 		} 	// GraphThread()
 		
 		public void run(){
 			// Percent counting
 			if(percent > prePer) {						// 입력 시 
 				for (i = prePer; i<=percent ; i++){
 					primary.countD();
 					try{
 	   					 Thread.sleep(delay*2);
 	   				}catch(Exception e){}
 				}	// for	
 			} else if(percent < prePer){				// 삭제 시
				for (i = prePer; i>=percent ; i--){
 					primary.countD();
 					try{
	   					 Thread.sleep(delay*2);
	   				}catch(Exception e){}
				}	// for  	
 			}	// if.. else - Percent counting
 			
 			// Graph drawing
 			while(destiny > rectX){						// 입력할 때
  				rectX += 1;
				graph.repaint();				  		  
   				try{
   					 Thread.sleep(delay);
   				}catch(Exception e){}
  			} 	// while
 			while(destiny < rectX){						// 삭제할 때
  				rectX -= 1;
				graph.repaint();	
   				try{
   					 Thread.sleep(delay);
   				}catch(Exception e){}
  			} 	// while
 		} 	// run() 		
	}	// GraphThread()
	
}	// FoodAteBar class