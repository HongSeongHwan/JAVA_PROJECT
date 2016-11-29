import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {
	
	private FoodButtonList	list;
	private int	target;
	private SecondPanel second;
	FoodPanel(SecondPanel second){
		this.second = second;
		setBackground(Color.BLUE);
		setLayout(null);
		list = new FoodButtonList(this);
		GridLayout l = new GridLayout(10,3);
		
		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);
		FoodButton button1 = new FoodButton(new ImageIcon("picture/food/ssalbab.jpg"));
		//button1.setBorderPainted(false);
		//button1.setFocusPainted(false);
	//	button1.setContentAreaFilled(false);
		foodAdd(button1);
		
		FoodButton button2 = new FoodButton(new ImageIcon("picture/food/kimbab.jpg"));
		//button2.setBorderPainted(false);
		//button2.setFocusPainted(false);
	//	button2.setContentAreaFilled(false);
		foodAdd(button2);
		
		FoodButton button3 = new FoodButton(new ImageIcon("picture/food/rameon.jpg"));
		//button3.setBorderPainted(false);
		//button3.setFocusPainted(false);
	//	button3.setContentAreaFilled(false);
		foodAdd(button3);
		
		FoodButton button4 = new FoodButton(new ImageIcon("picture/food/jajang.jpg"));
		button4.setName("Â¥Àå¸é");
		//button4.setBorderPainted(false);
		//button4.setFocusPainted(false);
		//button4.setContentAreaFilled(false);
		foodAdd(button4);
		
		FoodButton button5 = new FoodButton(new ImageIcon("picture/food/jjam.jpg"));
		//button5.setBorderPainted(false);
		//button5.setFocusPainted(false);
		//button5.setContentAreaFilled(false);
		foodAdd(button5);
		
		FoodButton button6 = new FoodButton(new ImageIcon("picture/food/miyeok.jpg"));
		//button6.setBorderPainted(false);
		//button6.setFocusPainted(false);
		//button6.setContentAreaFilled(false);
		foodAdd(button6);
	}
	public void listenerAdd(){
		for(FoodButton btn : list.getList()){
			btn.addMouseListener(second.getMoveFoodListener());
		}
	}
	public void foodAdd(FoodButton x){
		list.addB(x);
		x.addMouseListener(second.getMoveFoodListener());
	//	add(list.getB(list.getNum()));
	}
	public FoodButtonList getFoodButtonList(){
		return list;
	}
}