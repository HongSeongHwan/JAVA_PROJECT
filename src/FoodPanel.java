import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {
	
	private FoodButtonList	list;
	private int 			target;
	
	FoodPanel(){
		setBackground(Color.BLUE);
		setLayout(null);
		
		
		list = new FoodButtonList();
		foodAdd();
		foodAdd();
		foodAdd();
		foodAdd();
		foodAdd();
		foodAdd();
		foodAdd();
	}
	
	void foodAdd(){
		list.addB(new FoodButton());
		add(list.getB(list.getNum()));
	}
}
