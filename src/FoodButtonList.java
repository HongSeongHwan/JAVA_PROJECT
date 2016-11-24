import java.awt.*;
import javax.swing.*;
import java.util.*;
public class FoodButtonList {
	public ArrayList<FoodButton> list;
	int num;
	FoodButtonList(){
		list = new ArrayList<FoodButton>();
		num=-1;		
	}
	void addB(FoodButton k){
		list.add(k);
		num++;
		list.get(num).setLocation(2 + (num%2)*160, (num/2)*110 );
	}
	FoodButton getB(int a){
		return list.get(a);
	}
}
