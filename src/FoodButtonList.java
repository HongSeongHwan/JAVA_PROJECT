import java.awt.*;
import javax.swing.*;
import java.util.*;
public class FoodButtonList {
	public ArrayList<FoodButton> list;
	int num;
	FoodButtonList(){
		list = new ArrayList<FoodButton>();
		num=0;
		
	}
	void addB(FoodButton k){
		k.setSize(40,40);
		list.add(k);
		num++;
	}
	FoodButton getB(int a){
		return list.get(a);
	}
}
