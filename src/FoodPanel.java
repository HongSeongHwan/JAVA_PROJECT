import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {
	
	private FoodButtonList	list;
	private int	target;
	
	FoodPanel(){
		setBackground(Color.BLUE);
		setLayout(null);
		
		list = new FoodButtonList();
		
		FoodButton button1 = new FoodButton(new ImageIcon("ssalbab.jpg"));
		//button1.setBorderPainted(false);
		//button1.setFocusPainted(false);
	//	button1.setContentAreaFilled(false);
		foodAdd(button1);
		
		FoodButton button2 = new FoodButton(new ImageIcon("kimbab.jpg"));
		//button2.setBorderPainted(false);
		//button2.setFocusPainted(false);
	//	button2.setContentAreaFilled(false);
		foodAdd(button2);
		
		FoodButton button3 = new FoodButton(new ImageIcon("rameon.jpg"));
		//button3.setBorderPainted(false);
		//button3.setFocusPainted(false);
	//	button3.setContentAreaFilled(false);
		foodAdd(button3);
		
		FoodButton button4 = new FoodButton(new ImageIcon("jajang.jpg"));
		//button4.setBorderPainted(false);
		//button4.setFocusPainted(false);
		//button4.setContentAreaFilled(false);
		foodAdd(button4);
		
		FoodButton button5 = new FoodButton(new ImageIcon("jjam.jpg"));
		//button5.setBorderPainted(false);
		//button5.setFocusPainted(false);
		//button5.setContentAreaFilled(false);
		foodAdd(button5);
		
		FoodButton button6 = new FoodButton(new ImageIcon("miyeok.jpg"));
		//button6.setBorderPainted(false);
		//button6.setFocusPainted(false);
		//button6.setContentAreaFilled(false);
		foodAdd(button6);

	}
	void foodAdd(FoodButton x){
		list.addB(x);
		add(list.getB(list.getNum()));
	}
}