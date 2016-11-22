import java.awt.*;
import javax.swing.*;
public class ViewControl
{
	public static Component [] x;
	public static Container contentPane;
	public static FirstPanel first;
	public static SecondPanel second;
	public static ThirdPanel third;
	public static Main main;
	public static StartPanel start;
	public ViewControl(Main main){
		x = new Component[4];
		start = new StartPanel();
		first = new FirstPanel();
		second = new SecondPanel();
		third = new ThirdPanel();
		x[0]=first;
		x[1]=second;
		x[2]=third;
		x[3]=start;
		this.main = main;
		init();
		//this.viewSecondPanel();
	}
	public void init(){
		contentPane = main.getContentPane();
		contentPane.add(start);
		main.setVisible(false);
		main.setVisible(true);
	}
	public static void viewPanel(int prev, int next){
		contentPane.remove(x[prev-1]);
		contentPane.add(x[next-1]);
		main.setVisible(false);
		main.setVisible(true);	
	}
}
