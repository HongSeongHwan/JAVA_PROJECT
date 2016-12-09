import java.awt.*;
import javax.swing.*;

//화면 전환을 제어하는 클래스
public class ViewControl
{
	private static Component [] x;
	private static Container contentPane;
	private static FirstPanel first;
	private static SecondPanel second;
	private static ThirdPanel third;
	private static Main main;
	private static StartPanel start;
	
	public static Component getPanel(int i){
		return x[i];
	}	//	getPanel()
	
	public ViewControl(Main main)
	{	
		x = new Component[4];
		start = new StartPanel();
		first = new FirstPanel();
		second = new SecondPanel();
		third = new ThirdPanel();
		
		// linking page with list x
		x[0]=first;
		x[1]=second;
		x[2]=third;
		x[3]=start;
		this.main = main;
		init();
	}	//	ViewControl()
	
	public void init()
	{
		contentPane = main.getContentPane();
		contentPane.add(start);		// startPanel - initiate
		// to apply change data, real time 
		main.setVisible(false);
		main.setVisible(true);
	}	//	init()
	
	//화면전환을 실행하는 함수
	public static void viewPanel(int prev, int next)
	{
		contentPane.remove(x[prev-1]);	// prev page
		contentPane.add(x[next-1]);		// next page
		// to apply change data, real time 
		main.setVisible(false);
		main.setVisible(true);	
	}//viewPanel()

}	// ViewControl class
