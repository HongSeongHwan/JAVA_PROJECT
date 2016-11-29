import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class MoveFoodListener implements MouseListener 
{	

	private  TimePanel time;
	private  FoodButtonList food;

	private  TimeLinePanel t_prev;
	private  TimeLinePanel t_cur;
	private  FoodButton prev;
	private  FoodButton cur;

	private MyListener listener;
	
	private JTextField name = new JTextField();
	private JTextField tan = new JTextField();
	private JTextField fat = new JTextField();
	private JTextField protein = new JTextField();
	private JTextField cal = new JTextField();
	
	private JLabel lname;
	private JLabel ltan;
	private JLabel lfat;
	private JLabel lprotein;
	private JLabel lcal;

	private SecondPanel second;
	public  MoveFoodListener(SecondPanel s){
		listener = new MyListener();
		second = s;
		setTime();
		setFood();
	}
	public void setTime(){
		time = second.getTimePanel();
	}
	public void setFood(){
		food = second.getFoodPanel().getFoodButtonList();
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{

		if(e.getSource().getClass()==(new TimeLinePanel()).getClass())
		{
			System.out.println("aaa");
			t_cur = (TimeLinePanel)e.getSource();
			if(t_prev==null)
			{
				t_cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
			}
			else if(t_cur==t_prev){
				time.deleteT(t_prev);
				t_prev=null;
				//	t_prev =null;
				//	t_prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));

			}
			else
			{
				for(JPanel temp : t_prev.getList()){
					temp.removeMouseListener(listener);
				}
				for(JPanel temp : t_cur.getList()){
					temp.addMouseListener(listener);
				}
				t_cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
				t_prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));

			}
			t_prev = t_cur;
		}
		else if(e.getSource().getClass()==(new FoodButton()).getClass())
		{
			System.out.println("aaa");
			cur = (FoodButton)e.getSource();
			if(t_prev!=null && cur!=prev){//타임에 음식추가
				System.out.println("aaa");

				JPanel temp = new JPanel();
				temp.add(new JLabel(cur.getIcon()));
				temp.addMouseListener(listener);
				//temp.removeMouseListener(this);
				t_prev.addF(temp);
				
			}
			if(prev==null)
			{
				System.out.println("aaa");
				cur.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
				prev = cur;
			}
			else if(cur==prev){//타임에서 음식지우기
				System.out.println("aaa");
				food.deleteF(prev);
				prev=null;
				//	prev=null;
				//	prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));
				//	time.delete(prev);

			}
			else
			{
				System.out.println("aaa");
				cur.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.red));
				prev.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.white));
				prev = cur;

			}		
		}else if(e.getSource() == second.getOption_time()){
			System.out.println("a22aa");
			time.addTimeLine(new TimeLinePanel());
			time.setVisible(false);
			time.setVisible(true);
		}else{
			JDialog popup = new JDialog();
			popup.setTitle("food setup");

			if(prev==null){
				FoodButton temp = new FoodButton();
				JPanel pan = new JPanel();
				pan.setSize(400,500);
				pan.setLayout(null);
				
				
				
				lname = new JLabel(" Name : ");
				lname.setFont(new Font("Arial black",Font.PLAIN,20));
				lname.setBounds(20,20,20,20);
				pan.add(lname);
				 
				
				
				/*
		
		field[0] = new JTextField();
		field[0].setBounds(300, 400, 200, 50);
		add(field[0]);
				 */
				
				cal.setBounds(30,30,30,100);
				popup.setSize(new Dimension(400,500));
				pan.add(name);
				pan.add(tan);
				pan.add(fat);
				pan.add(protein);
				pan.add(cal);
				popup.add(pan);
				second.getFoodPanel().foodAdd(temp);
				second.getFoodPanel().setVisible(false);
				second.getFoodPanel().setVisible(true);
				popup.show();
			}else {
				
				JPanel pan = new JPanel();
				pan.setSize(400,500);
				pan.setLayout(null);
				//popup.setLayout(null);
				JTextField name = new JTextField(prev.getName());
				JTextField tan= new JTextField(prev.getTansoo());
				JTextField fat= new JTextField(prev.getFat());
				JTextField protein= new JTextField(prev.getProtein());
				JTextField cal= new JTextField(prev.getCalories());
				name.setBounds(1, 1, 100, 30);
				tan.setBounds(1, 200, 100, 30);
				popup.setSize(new Dimension(400,500));
				pan.add(name);
				pan.add(tan);
				pan.add(fat);
				pan.add(protein);
				pan.add(cal);
				popup.add(pan);
				second.getFoodPanel().setVisible(false);
				second.getFoodPanel().setVisible(true);
				popup.show();
			}

		}


	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	//
	private class MyListener implements MouseListener{
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e)
		{
			if(t_prev!=null)
			{	
				t_prev.deleteF((JPanel)e.getSource());
				t_prev.setVisible(false);
				t_prev.setVisible(true);
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}

	}
}