import java.awt.*;
import javax.swing.*;
public class ThirdPanel extends JPanel{
	JButton nextPage;
	ThirdPanel(){
		nextPage = new JButton("qwe");
		setBackground(Color.CYAN);
		this.setBounds(1, 1, 50, 50);
		nextPage.setBounds(400,410,50,50);
		nextPage.addMouseListener(new ThirdPanelListener());
		add(nextPage);
	}
}
