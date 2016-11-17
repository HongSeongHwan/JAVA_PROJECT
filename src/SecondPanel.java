import java.awt.*;
import javax.swing.*;
public class SecondPanel extends JPanel{
	FoodPanel foodPanel;
	TimePanel timePanel;
	JButton nextPage;
	public SecondPanel(){
		foodPanel = new FoodPanel();
		timePanel = new TimePanel();
		nextPage = new JButton("qwe");
		this.setLayout(null);
		this.setBounds(1,1,400,400);
		this.setBackground(Color.white);
		this.add(new JLabel("tesat"));
		nextPage.setBounds(400,410,50,50);
		nextPage.addMouseListener(new SecondPanelListener());
		add(nextPage);
		add(foodPanel);
		add(timePanel);
	}
}
