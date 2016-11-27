import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;

public class FoodButtonList 
{
	private ArrayList<FoodButton> list;
	private int num;
	private MoveFoodListener listener;
	public int getNum()
	{
		return num;
	}
	public FoodButtonList()
	{
		list = new ArrayList<FoodButton>();
		num = -1;		
		listener = new MoveFoodListener();
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

}
