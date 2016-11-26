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
	private TimeLineListener listener;
	public TimePanel(){
		num = 0;
		//btn  = new JButton[4];
		tlp = new ArrayList<TimeLinePanel>();
		setLayout(null);
		listener = new TimeLineListener();
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
	private class TimeLineListener implements MouseListener 
	{	
		TimeLinePanel prev;
		TimeLinePanel cur;
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e)
		{
			cur = (TimeLinePanel)e.getSource();
			if(prev==null)
			{
				cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
			}
			else if(cur==prev){
				
			}
			else
			{
				cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
				prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));
			}
			prev = cur;
			
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
	}
	
}
