import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.*;
import javax.swing.*;
import javax.swing.border.Border;


public class SecondPanel extends JPanel{
	//private final Semaphore sem;
	private static final int VERTICAL = 0;
	private static final int HORIZONTAL = 0;
	private static SecondPanel out;
	private FoodPanel foodPanel;
	private TimePanel timePanel;
	private GraphPanel graphPanel;
	private JButton bbtn,nbtn;
	private SecondPanelListener listener;
	private MoveFoodListener move_listener;
	private JScrollPane scroll1, scroll2;
	private final int loction_pane_x = 55;
	private final int height_pane = 600;
	private JButton option_time ,option_food;
	static public SecondPanel getSecondPanel(){
		return out;
	}
	public SecondPanel(){
		Color n=new Color(255, 207, 181);
	//	sem = new Semaphore(4);
		
		out = this;
		foodPanel = new FoodPanel(this);
		timePanel = new TimePanel(this);
		
		move_listener = new MoveFoodListener(this);
		
		
		graphPanel = new GraphPanel();
		bbtn= new JButton(new ImageIcon("picture/first/back.png"));
		nbtn = new JButton(new ImageIcon("picture/first/next.png"));
		option_time = new JButton(new ImageIcon("picture/second/plus2.jpg"));
		option_food = new JButton(new ImageIcon("picture/second/plus2.jpg"));
		
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
		this.setBackground(n);
		
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
		
		bbtn.addActionListener(listener);
		bbtn.setBounds(670, 900, 50, 50);
		bbtn.setBorder(new RoundedBorder(70));
		bbtn.setBackground(n);
		bbtn.setForeground(n);
		add(bbtn);
		
		
		nbtn.addActionListener(listener);
		nbtn.setBounds(720, 900, 50, 50);
		nbtn.setBorder(new RoundedBorder(70));
		nbtn.setBackground(n);
		nbtn.setForeground(n);
		add(nbtn);	
		
		
		
		option_time.setBounds(10, 5, 50, 50);
		option_time.addMouseListener(move_listener);
		add(option_time);	
		
		option_food.setBounds(720, 5, 50, 50);
		option_food.addMouseListener(move_listener);
		add(option_food);
		
	}
	public JButton getOption_time()					{ return option_time;	}
	public MoveFoodListener getMoveFoodListener()	{ return move_listener;	}
	public FoodPanel getFoodPanel()					{ return foodPanel;	}
	public TimePanel getTimePanel()					{ return timePanel;	}
	public GraphPanel getGraphPanel()				{ return graphPanel; }
	
	class RoundedBorder implements Border { 
		int radius;
		RoundedBorder(int radius) { 
			this.radius = radius; 
		} 
		public Insets getBorderInsets(Component c) { 
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius); 
		} 
		public boolean isBorderOpaque() { 
			return true; 
		} 
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) { 
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); 
		} 
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
				((ThirdPanel)ViewControl.getPanel(2) ).Analysis();
			}
			
		}
	}
	
}

