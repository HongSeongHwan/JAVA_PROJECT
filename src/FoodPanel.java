import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {
	
	private FoodButtonList	list;
	private JButton			addButton;	
	private int 			target;
	
	FoodPanel(){
		setBackground(Color.BLUE);
		setLayout(null);
		
		addButton = new JButton("add");
		addButton.setBounds(5, 5, 50, 50);
		addButton.addActionListener(new AddListener());
		add(addButton);
		
		list = new FoodButtonList();
		foodAdd();
	}
	
	void foodAdd(){
		list.addB(new FoodButton());
		add(list.getB(list.num));
	}
}
