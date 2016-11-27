import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
public class TimePanel extends JPanel 
{
	//JButton [] btn;
	private int target;
	private int num;
	private ArrayList<TimeLinePanel> tlp;
	private MoveFoodListener listener;
	public TimePanel(){
		num = 0;
		//btn  = new JButton[4];
		tlp = new ArrayList<TimeLinePanel>();
		setLayout(null);
		listener = new MoveFoodListener();
		this.setBackground(Color.BLACK);
		this.setBounds(1,1,190,400);
		TimeLinePanel temp;
		
		temp = new TimeLinePanel();
		temp.addMouseListener(listener);
		addTimeLine(temp);
		
		temp = new TimeLinePanel();
		temp.addMouseListener(listener);
		addTimeLine(temp);
		
		temp = new TimeLinePanel();
		temp.addMouseListener(listener);
		addTimeLine(temp);
	}
	public void addTimeLine(TimeLinePanel x){
		tlp.add(x);
		add(x);
		x.setLocation(10,10+(num)*140);
		num++;
	}
	
	
}
