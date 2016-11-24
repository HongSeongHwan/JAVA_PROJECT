import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {
	
	private FoodButtonList	list;
	private int	target;
	
	FoodPanel(){
		setBackground(Color.BLUE);
		setLayout(null);
		
		list = new FoodButtonList();
		
		FoodButton button = new FoodButton(new ImageIcon("man.jpg"));
		foodAdd(button);
		
		foodAdd(new FoodButton());

	}
	void foodAdd(FoodButton x){
		list.addB(x);
		add(list.getB(list.getNum()));
	}
}