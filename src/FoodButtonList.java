import java.awt.*;
import javax.swing.*;
import java.util.*;

public class FoodButtonList {
	private ArrayList<FoodButton> list;
	private int num;
	
	FoodButtonList(){
		list = new ArrayList<FoodButton>();
		num = -1;		
	}
	
	public void addB(FoodButton k){
		list.add(k);
		num++;
		list.get(num).setLocation(2, (num)*110 );
	}
	
	FoodButton getB(int a){
		return list.get(a);
	}
}
