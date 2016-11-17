import java.awt.*;
import javax.swing.*;
public class FoodPanel extends JPanel {
	FoodButtonList list;
	JButton addButton;
	int target;
	FoodPanel(){
		setLayout(null);
		addButton = new JButton("add");
		addButton.setBounds(1, 1, 70, 100);
		addButton.addActionListener(new AddListener());
		add(addButton);
		list = new FoodButtonList();
		setBounds(200,1,200,400);
		setBackground(Color.BLUE);
	}
	void foodAdd(){
		list.addB(new FoodButton());
		add(list.getB(list.num-1));
	}
}
