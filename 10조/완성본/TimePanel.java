import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
public class TimePanel extends JPanel 
{
	private ArrayList<TimeLinePanel> tlp;				// each time line panels
	private Color backColor = new Color(120,170,175);	// background color
	
	// constructor
	public TimePanel(SecondPanel second) {		
		// basic set
		tlp = new ArrayList<TimeLinePanel>();
		this.setBackground(backColor);
		setLayout(null);		
		TimeLinePanel temp;
		
		// GridLayout set - 여백설정
		GridLayout l = new GridLayout(10,1);
		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);
		
		// basic TimeLinePanel
		temp = new TimeLinePanel();
		temp.setBackground(backColor);
		addTimeLine(temp);
		
	}	// TimePanel()
	
	// TimeLine Add
	public void addTimeLine(TimeLinePanel x){
		tlp.add(x);
		x.addMouseListener(MoveFoodListener.getMoveFoodListener());
		x.setBackground(backColor);
		add(x);	
	}	// addTimeLine()
	
	// TimeLine delete
	public void deleteT(TimeLinePanel t){
		t.setVisible(false);	// real time change apply
		this.remove(t);
		tlp.remove(t);
	}	// deleteT()
	
	// TimelinePanels - connect with - MoveFoodListener
	public void listenerAdd(){
		for(TimeLinePanel temp : tlp)	{
			temp.addMouseListener(MoveFoodListener.getMoveFoodListener());
		}	// for
	}	// listenerAdd()
	
}	// TimePanel class
