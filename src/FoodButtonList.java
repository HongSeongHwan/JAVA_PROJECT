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
//	private MoveFoodListener listener;
	
	// get
	public int getNum()						{ return num;			}
	public FoodButton getB(int a)			{ return list.get(a);	}	
	public ArrayList<FoodButton> getList()	{ return list;			}

	public FoodButtonList(FoodPanel x)
	{
		p = x;
		list = new ArrayList<FoodButton>();
		num = -1;		
	//	listener = new MoveFoodListener();
	//	listener.setFoodButtonList(this);
	}	
	public void addB(FoodButton k)
	{
		p.add(k);
	//	k.addMouseListener(listener);
		list.add(k);
		num++;
		//list.get(num).setLocation(2+(num%2)*160, (num/2)*110 );
	}
	public void deleteF(FoodButton item){
		item.setVisible(false);
		p.remove(item);
		list.remove(item);		
		//System.out.println(k);
		num--;
	}
}
