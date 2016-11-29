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
		man=new ImageIcon("picture/first/man.jpg");
		woman=new ImageIcon("picture/first/woman.jpg");
		rb1=new JRadioButton("남성");
		rb1.addActionListener(listener);
		rb2=new JRadioButton("여성");
		rb2.addActionListener(listener);
		group=new ButtonGroup();
		
		title.setText("당신은 누구 인가요?");
		title.setFont(new Font("Araial black",Font.BOLD,20));
		title.setBounds(300, 10, 500, 100);
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(Color.white);
		add(title);
		
		JLabel image1=new JLabel(man);
		image1.setBounds(150, 80, 200, 250);
		add(image1);
		
		JLabel image2=new JLabel(woman);
		image2.setBounds(400,80,200,250);
		add(image2);
		
		rb1.setFont(new Font("Araial black",20,20));
		rb1.setBounds(200, 330, 80, 50);
		rb1.setBackground(Color.white);
		add(rb1);
		
		rb2.setFont(new Font("Araial black",20,20));
		rb2.setBounds(460, 330, 80, 50);
		rb2.setBackground(Color.white);
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
		bbtn.addActionListener(listener);
		bbtn.setBounds(670, 900, 50, 50);
		add(bbtn);
		bbtn.setEnabled(false);
		
		nbtn = new JButton("▶");
		nbtn.addActionListener(listener);
		nbtn.setBounds(720, 900, 50, 50);
		add(nbtn);
		
		
		
	}
	
	private class FirstPanelListener implements ActionListener
	{
		private PrivateInfo informed;
		public void actionPerformed(ActionEvent e){

			if(e.getSource()==rb1)
			{				
				informed.setSex(1);//1==남자				
				System.out.println(informed.getSex());			
			}
			else if(e.getSource()==rb2)
			{
				informed.setSex(2);//2==여자
				
				System.out.println(informed.getSex());
			}
			else if(e.getSource()==nbtn)
			{
				if(informed.getSex()==0)
					{JOptionPane.showMessageDialog(FirstPanel.this, "Error : Select Gender.","Error",JOptionPane.WARNING_MESSAGE);}

				else {
					try{
					
						Integer.parseInt(field[0].getText());
						Integer.parseInt(field[1].getText());
						Integer.parseInt(field[2].getText());
					
					}catch(IllegalArgumentException ectn){JOptionPane.showMessageDialog(FirstPanel.this, "Error : Input Natural Number.","Error",JOptionPane.WARNING_MESSAGE);}
				
					if(informed.getSex()!=0&&Integer.parseInt(field[0].getText())>0&&Integer.parseInt(field[1].getText())>0&&Integer.parseInt(field[2].getText())>0)
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
					else
						JOptionPane.showMessageDialog(FirstPanel.this, "Error : Input Natural Number.","Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
}
