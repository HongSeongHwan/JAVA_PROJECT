import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;

public class FoodButtonList 
{
	private FoodPanel p;
	private ArrayList<FoodButton> list;
	private int num;
	private MoveFoodListener listener;
	public int getNum()
	{
		return num;
	}
	public FoodButtonList(FoodPanel x)
	{
		p = x;
		list = new ArrayList<FoodButton>();
		num = -1;		
		listener = new MoveFoodListener();
		listener.setFoodButtonList(this);
	}
	
	public void addB(FoodButton k)
	{
		p.add(k);
		k.addMouseListener(listener);
		list.add(k);
		num++;
		list.get(num).setLocation(2+(num%2)*160, (num/2)*110 );
	}
	
	public FoodButton getB(int a)
	{
		return list.get(a);
	}
	public void deleteF(FoodButton item){
		p.remove(item);
		list.remove(item);		
		//System.out.println(k);
		num--;
		for(int i=0 ; i<num+1;i++){
			list.get(i).setLocation(2+(i%2)*160, (i/2)*110 );
			//p.add(list.get(i));
		}
	}
}
