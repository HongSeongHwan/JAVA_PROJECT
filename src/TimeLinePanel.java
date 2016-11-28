import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.util.*;

public class TimeLinePanel extends JPanel {
	private ArrayList<FoodButton> list;
	
	public TimeLinePanel(){
		list = new ArrayList<FoodButton>();
		this.setSize(360, 130);
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(1,3));
		
	}
	void addF(FoodButton b){
		list.add(b);
		this.add(b);
	}
	void deleteF(FoodButton b){
		this.remove(b);
		list.remove(b);
		
	}
}
