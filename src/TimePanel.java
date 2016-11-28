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
		
		listener = new MoveFoodListener();
		listener.setTimePanel(this);
		
		this.setBackground(Color.BLACK);
		this.setBounds(1,1,190,400);
		setLayout(null);
		
		TimeLinePanel temp;
		GridLayout l = new GridLayout(5,1);
		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);
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
		num++;
	}
	public void deleteT(TimeLinePanel t){
		t.setVisible(false);
		this.remove(t);
		tlp.remove(t);

	}
	
}
