import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;

public class FoodButtonList //���� ���� ����Ʈ�� ���� �صδ� Ŭ����
{
	private FoodPanel p;
	private ArrayList<FoodButton> list;// ���⿡ �� ����

	private static FoodButtonList me;// �ڱ� �ڽ� ����Ŵ ���߿� �ٸ� Ŭ���� �� ���� ����
	// get
	public FoodButton getB(int a)			{ return list.get(a);	}	//get
	public ArrayList<FoodButton> getList()	{ return list;			}//get
	public static FoodButtonList getFoodButtonList(){ return me;}//get
	public FoodButtonList(FoodPanel x)// ������
	{
		p = x; //Ǫ�� �г� ���� ����
		me = this; // �ڽ��� ����
		list = new ArrayList<FoodButton>();
	
	}	
	public void addB(FoodButton k)
	{
		p.add(k);//Ǫ�� �гο� ������ �߰�
		list.add(k);//����Ʈ�� �߰�
	
	}
	public void deleteF(FoodButton item){
		item.setVisible(false);///
		p.remove(item);//Ǫ�� �гο��� ������ ����
		list.remove(item);// ����Ʈ���� ������ ����
	
	}
}
