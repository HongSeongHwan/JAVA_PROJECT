import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;

public class FoodButtonList 
{
	private ArrayList<FoodButton> list;
	private int num;
	private FirstPanelListener listener;
	public int getNum()
	{
		return num;
	}
	public FoodButtonList()
	{
		list = new ArrayList<FoodButton>();
		num = -1;		
		listener = new FirstPanelListener();
	}
	
	public void addB(FoodButton k)
	{
		k.addMouseListener(listener);
		list.add(k);
		num++;
		list.get(num).setLocation(2+(num%2)*160, (num/2)*110 );
	}
	
	public FoodButton getB(int a)
	{
		return list.get(a);
	}
	private class FirstPanelListener implements MouseListener 
	{	
		FoodButton prev;
		FoodButton cur;
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e)
		{
			cur = (FoodButton)e.getSource();
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
