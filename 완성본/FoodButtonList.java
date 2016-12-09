import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;

public class FoodButtonList //음식 정보 리스트로 저장 해두는 클래스
{
	private FoodPanel p;
	private ArrayList<FoodButton> list;// 여기에 다 저장

	private static FoodButtonList me;// 자기 자신 가르킴 나중에 다른 클래스 얻어서 쓸수 있음
	// get
	public FoodButton getB(int a)			{ return list.get(a);	}	//get
	public ArrayList<FoodButton> getList()	{ return list;			}//get
	public static FoodButtonList getFoodButtonList(){ return me;}//get
	public FoodButtonList(FoodPanel x)// 생성자
	{
		p = x; //푸드 패널 정보 가짐
		me = this; // 자신을 대입
		list = new ArrayList<FoodButton>();
	
	}	
	public void addB(FoodButton k)
	{
		p.add(k);//푸드 패널에 데이터 추가
		list.add(k);//리스트에 추가
	
	}
	public void deleteF(FoodButton item){
		item.setVisible(false);///
		p.remove(item);//푸드 패널에서 데이터 삭제
		list.remove(item);// 리스트에서 데이터 삭제
	
	}
}
