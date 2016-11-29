import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
public class TimePanel extends JPanel 
{

	private int target;
	private int num;
	private ArrayList<TimeLinePanel> tlp;
	private SecondPanel second;
	public TimePanel(SecondPanel second){
		this.second = second;
		num = 0;
		tlp = new ArrayList<TimeLinePanel>();
		//listener =	ViewControl.getMoveFoodListener();
		//listener.setTime();
		this.setBackground(Color.BLACK);
	//	this.setBounds(1,1,190,400);
		setLayout(null);
		
		TimeLinePanel temp;
		GridLayout l = new GridLayout(10,1);
		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);
		
		temp = new TimeLinePanel();
		//temp.addMouseListener(second.getMoveFoodListener());
		addTimeLine(temp);
		
		temp = new TimeLinePanel();
		//temp.addMouseListener(second.getMoveFoodListener());
		addTimeLine(temp);
		
		temp = new TimeLinePanel();
		//temp.addMouseListener(second.getMoveFoodListener());
		addTimeLine(temp);
	}
	public void addTimeLine(TimeLinePanel x){
		tlp.add(x);
		x.addMouseListener(second.getMoveFoodListener());
		add(x);
		num++;
	}
	public void deleteT(TimeLinePanel t){
		t.setVisible(false);
		this.remove(t);
		tlp.remove(t);
	}
	public void listenerAdd(){
		for(TimeLinePanel temp : tlp){
			temp.addMouseListener(second.getMoveFoodListener());
			
		}
	}
	
}
