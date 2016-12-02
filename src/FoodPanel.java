import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {

	public static final String[] FOODA = { "ssalbab", "±è¹ä", "¶ó¸é", "Â¥Àå¸é", "Â«»Í", "¹Ì¿ª±¹", "»ï°èÅÁ", "±èÄ¡Âî°³", "µÈÀåÂî°³", "°íµî¾î±¸ÀÌ", "°è¶õ¸»ÀÌ",
			"µ·°¡½º", "¶±ººÀÌ", "¾ç»óÃß»ø·¯µå", "Äá³ª¹°¹«Ä§" };

	public static final double[][] foodData = { { 322, 70.6, 5.7, 0.4 }, { 273.0, 50.6, 8.0, 3.6 },
			{ 388.0, 60.7, 8.3, 11.9 }, { 640.0, 100.9, 22.1, 13.8 }, { 306.0, 49.6, 12.1, 5.5 },
			{ 23.0, 2.7, 2.0, 1.4 }, { 302.0, 25.2, 22.7, 11.4 }, { 59.0, 4.2, 6.4, 1.7 }, { 40.0, 3.7, 3.0, 1.5 },
			{ 98.0, 0.0, 8.9, 6.4 }, { 69.0, 1.8, 4.3, 4.7 }, { 144.0, 11.5, 9.6, 6.2 }, { 128.0, 24.1, 2.8, 2.0 },
			{ 146.0, 7.0, 2.2, 12.3 }, { 21.0, 1.8, 1.5, 0.9 } 
	};

	private FoodButtonList list;
	private FoodButton[] button;
	private int target;
	private int i;
	private SecondPanel second;

	FoodPanel(SecondPanel second) {
		button = new FoodButton[FOODA.length];
		this.second = second;
		setBackground(Color.BLUE);
		setLayout(null);
		list = new FoodButtonList(this);
		GridLayout l = new GridLayout(5, 2);

		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);		
		
		for(i=0; i<FOODA.length; i++) {
			button[i] = new FoodButton();
		//	button[i].setName(foodData[i][]);
		}
		
		FoodButton button1 = new FoodButton(new ImageIcon("picture/food/ssalbab.jpg"));
		button1.setCalories(11);
		
		// button1.setBorderPainted(false);
		// button1.setFocusPainted(false);
		// button1.setContentAreaFilled(false);
		foodAdd(button1);

		FoodButton button2 = new FoodButton(new ImageIcon("picture/food/kimbab.jpg"));
		// button2.setBorderPainted(false);
		// button2.setFocusPainted(false);
		// button2.setContentAreaFilled(false);
		foodAdd(button2);

		FoodButton button3 = new FoodButton(new ImageIcon("picture/food/rameon.jpg"));
		// button3.setBorderPainted(false);
		// button3.setFocusPainted(false);
		// button3.setContentAreaFilled(false);
		foodAdd(button3);

		FoodButton button4 = new FoodButton(new ImageIcon("picture/food/jajang.jpg"));
		button4.setName("Â¥Àå¸é");
		// button4.setBorderPainted(false);
		// button4.setFocusPainted(false);
		// button4.setContentAreaFilled(false);
		foodAdd(button4);

		FoodButton button5 = new FoodButton(new ImageIcon("picture/food/jjam.jpg"));
		// button5.setBorderPainted(false);
		// button5.setFocusPainted(false);
		// button5.setContentAreaFilled(false);
		foodAdd(button5);

		FoodButton button6 = new FoodButton(new ImageIcon("picture/food/miyeok.jpg"));
		// button6.setBorderPainted(false);
		// button6.setFocusPainted(false);
		// button6.setContentAreaFilled(false);
		foodAdd(button6);
		foodAdd(button6);
		foodAdd(button6);
	}

	public void listenerAdd() {
		for (FoodButton btn : list.getList()) {
			btn.addMouseListener(second.getMoveFoodListener());
		}
	}

	public void foodAdd(FoodButton x) {
		list.addB(x);
		x.addMouseListener(second.getMoveFoodListener());
		// add(list.getB(list.getNum()));
	}
	public void foodDelete(FoodButton x) {
		list.deleteF(x);
		// add(list.getB(list.getNum()));
	}
	public FoodButtonList getFoodButtonList() {
		return list;
	}
}