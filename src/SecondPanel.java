import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class SecondPanel extends JPanel{
	private static final int VERTICAL = 0;
	private static final int HORIZONTAL = 0;
	private FoodPanel foodPanel;
	private TimePanel timePanel;
	private GraphPanel graphPanel;
	private JButton bbtn,nbtn;
	private SecondPanelListener listener;
	private MoveFoodListener move_listener;
	private JScrollPane scroll1, scroll2;
	private final int loction_pane_x = 50;
	private final int height_pane = 600;
	
	private JButton option_time ,option_food;
	public SecondPanel(){
		
		foodPanel = new FoodPanel(this);
		timePanel = new TimePanel(this);
		
		move_listener = new MoveFoodListener(this);
		
		
		graphPanel = new GraphPanel();
		bbtn = new JButton("¢¸");
		nbtn = new JButton("¢º");
		option_time = new JButton("+");
		option_food = new JButton("+");
		
		listener=new SecondPanelListener();	
		timePanel.listenerAdd();
		foodPanel.listenerAdd();
		
		scroll1=new JScrollPane(timePanel);
		scroll1.setBounds(10,loction_pane_x, 380, height_pane);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scroll2=new JScrollPane(foodPanel);
		scroll2.setBounds(395, loction_pane_x, 390, height_pane);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(Color.white);
		
		timePanel.setBounds(10, loction_pane_x, 370, height_pane);
		timePanel.setBackground(Color.orange);
		//add(timePanel);
		add(scroll1);
		
		foodPanel.setBounds(395, loction_pane_x, 375, height_pane);
		foodPanel.setBackground(Color.cyan);
		//add(foodPanel);
		add(scroll2);			
		
		graphPanel.setBounds(10, 670, 760, 230);
		graphPanel.setBackground(Color.gray);
		add(graphPanel);
		
		bbtn.setBounds(670, 900, 50, 50);
		bbtn.addActionListener(listener);
		add(bbtn);
		
		nbtn.setBounds(720, 900, 50, 50);
		nbtn.addActionListener(listener);
		add(nbtn);	
		
		
		
		option_time.setBounds(10, 10, 50, 50);
		//option_time.addActionListener(listener);
		add(option_time);	
		
		option_food.setBounds(670, 10, 50, 50);
		//option_food.addActionListener(option_food);
		add(option_food);
		
	}
	public MoveFoodListener getMoveFoodListener(){
		return move_listener;
	}
	public FoodPanel getFoodPanel(){
		return foodPanel;
	}
	public TimePanel getTimePanel(){
		return timePanel;
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

