import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class TimePanel extends JPanel {
	//JButton [] btn;
	private int target;
	private ArrayList<TimeLinePanel> tlp;
	public TimePanel(){
		//btn  = new JButton[4];
		tlp = new ArrayList<TimeLinePanel>();
		setLayout(null);
		this.setBackground(Color.BLACK);
		this.setBounds(1,1,190,400);
		
		//for(int i=0 ; i< 4 ; i++){
		//	btn[i]= new JButton("asd");
		//	add(btn[i]);
	//	}
		
	}
	public void addTimeLine(TimeLinePanel x){
		tlp.add(x);
		
	}
	
}
