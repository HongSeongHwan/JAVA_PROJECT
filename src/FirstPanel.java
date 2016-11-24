import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class FirstPanel extends JPanel {
	public JLabel title;
	public JTextField [] field;
	public JLabel [] lbl; 
	private JRadioButton rb1, rb2;
	private ImageIcon man,woman;
	private ButtonGroup group;
	int num;
	private FirstPanelListener listener=new FirstPanelListener();
	private JButton bbtn, nbtn;

	
	FirstPanel(){
		num = 4;
		field = new JTextField[num];
		lbl = new JLabel[num];
		title = new JLabel();
		man=new ImageIcon("man.jpg");
		woman=new ImageIcon("woman.jpg");
		rb1=new JRadioButton("남성",man);
		rb1.addMouseListener(listener);
		rb2=new JRadioButton("여성",woman);
		rb2.addMouseListener(listener);
		group=new ButtonGroup();
		
		
		title.setText("당신은 누구 인가요?");
		title.setFont(new Font("Araial black",Font.BOLD,20));
		title.setBounds(300, 10, 500, 100);
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(Color.white);
		add(title);
		
		rb1.setFont(new Font("Araial black",20,20));
		rb1.setBounds(150, 100, 260, 260);
		add(rb1);
		
		rb2.setFont(new Font("Araial black",20,20));
		rb2.setBounds(420, 100, 260, 260);
		add(rb2);
		
		group.add(rb1);
		group.add(rb2);
		
		lbl[0] = new JLabel("Age :");
		lbl[0].setFont(new Font("Arial black",Font.BOLD,20));
		lbl[0].setBounds(200, 400, 100, 50);
		add(lbl[0]);
		
		field[0] = new JTextField();
		field[0].setBounds(300, 400, 200, 50);
		add(field[0]);
		
		lbl[1] = new JLabel("Weight :");
		lbl[1].setFont(new Font("Arial black",Font.BOLD,20));
		lbl[1].setBounds(200, 460, 150, 50);
		add(lbl[1]);
		
		field[1] = new JTextField();
		field[1].setBounds(300, 460, 200, 50);
		add(field[1]);
		
		lbl[2] = new JLabel("Height :");
		lbl[2].setFont(new Font("Arial black",Font.BOLD,20));
		lbl[2].setBounds(200, 520, 150, 50);
		add(lbl[2]);
		
		field[2] = new JTextField();
		field[2].setBounds(300, 520, 200, 50);
		add(field[2]);
		
		
		bbtn= new JButton("◀");
		bbtn.addMouseListener(listener);
		bbtn.setBounds(670, 900, 50, 50);
		add(bbtn);
		bbtn.setEnabled(false);
		
		nbtn = new JButton("▶");
		nbtn.addMouseListener(listener);
		nbtn.setBounds(720, 900, 50, 50);
		add(nbtn);
		
		
		
	}
	
	public class FirstPanelListener implements MouseListener {
		private PrivateInfo informed;
		
		public void mousePressed(MouseEvent e){}
		public void mouseReleased(MouseEvent e){}
		public void mouseClicked(MouseEvent e){
			if(e.getSource()==rb1)
			{				
				informed.setSex(false);//false==남자				
				System.out.println(informed.isSex());			
			}
			else if(e.getSource()==rb2)
			{
				informed.setSex(true);//true==여자
				
				System.out.println(informed.isSex());
			}
			else if(e.getSource()==nbtn)
			{
				informed.setAge(Integer.parseInt(field[0].getText()));
				informed.setWeight(Integer.parseInt(field[1].getText()));
				informed.setHeight(Integer.parseInt(field[2].getText()));
				
				System.out.println(informed.getAge());
				System.out.println(informed.getHeight());
				System.out.println(informed.getWeight());
				//다음장으로 넘기기
				ViewControl.viewPanel(1, 2);
			}
		}
		public void mouseEntered(MouseEvent e){}
		public void mouseExited(MouseEvent e){}
	}
}
