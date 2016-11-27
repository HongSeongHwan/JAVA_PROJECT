import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class SecondPanel extends JPanel{
	private FoodPanel foodPanel;
	private TimePanel timePanel;
	private GraphPanel graphPanel;
	private JButton bbtn,nbtn;
	private SecondPanelListener listener;
	
	public SecondPanel(){
		foodPanel = new FoodPanel();
		timePanel = new TimePanel();
		graphPanel = new GraphPanel();
		bbtn = new JButton("¢¸");
		nbtn = new JButton("¢º");
		listener=new SecondPanelListener();		
		
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(Color.white);
		
		foodPanel.setBounds(395, 10, 375, 650);
		foodPanel.setBackground(Color.cyan);
		add(foodPanel);
		
		timePanel.setBounds(10, 10, 375, 650);
		timePanel.setBackground(Color.orange);
		add(timePanel);
		
		graphPanel.setBounds(10, 670, 760, 230);
		graphPanel.setBackground(Color.gray);
		add(graphPanel);

		bbtn.setBounds(670, 900, 50, 50);
		bbtn.addActionListener(listener);
		add(bbtn);
		
		nbtn.setBounds(720, 900, 50, 50);
		nbtn.addActionListener(listener);
		add(nbtn);		
	}
	private class SecondPanelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			if(e.getSource()==bbtn)
			{
				ViewControl.viewPanel(2, 1);
			}
			else if(e.getSource()==nbtn)
			{
				ViewControl.viewPanel(2, 3);
			}
			
		}
	}
}

