import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

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
		Color n=Constant.c3;
		
		num = 4;
		field = new JTextField[num];
		lbl = new JLabel[num];
		title = new JLabel();
		man=new ImageIcon("picture/first/man.png");
		woman=new ImageIcon("picture/first/woman.png");
		rb1=new JRadioButton("남성");
		rb1.addActionListener(listener);
		rb2=new JRadioButton("여성");
		rb2.addActionListener(listener);
		group=new ButtonGroup();
		
		
		
		title.setText("당신은 누구인가요?");
		title.setFont(new Font("HYGothic",Font.BOLD,40));
		title.setBounds(210, 100, 500, 100);
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(n);
		add(title);
		
		JLabel image1=new JLabel(man);
		image1.setBounds(175, 210, 200, 250);
		add(image1);
		
		JLabel image2=new JLabel(woman);
		image2.setBounds(425,210,200,250);
		add(image2);
		
		rb1.setFont(new Font("HYGothic",20,20));
		rb1.setBounds(235, 430, 80, 50);
		rb1.setBackground(n);
		add(rb1);
		
		rb2.setFont(new Font("HYGothic",20,20));
		rb2.setBounds(485, 430, 80, 50);
		rb2.setBackground(n);
		add(rb2);
		
		group.add(rb1);
		group.add(rb2);
		
		lbl[0] = new JLabel("Age :");
		lbl[0].setFont(new Font("Segoe Print",Font.BOLD,20));
		lbl[0].setBounds(235, 530, 100, 50);
		add(lbl[0]);
		
		field[0] = new JTextField();
		field[0].setBounds(360, 530, 200, 50);
		add(field[0]);
		
		lbl[1] = new JLabel("Weight :");
		lbl[1].setFont(new Font("Segoe Print",Font.BOLD,20));
		lbl[1].setBounds(235, 600, 150, 50);
		add(lbl[1]);
		
		field[1] = new JTextField();
		field[1].setBounds(360, 600, 200, 50);
		add(field[1]);
		
		lbl[2] = new JLabel("Height :");
		lbl[2].setFont(new Font("Segoe Print",Font.BOLD,20));
		lbl[2].setBounds(235, 670, 150, 50);
		add(lbl[2]);
		
		field[2] = new JTextField();
		field[2].setBounds(360, 670, 200, 50);
		add(field[2]);
		
		
		bbtn= new JButton(new ImageIcon("picture/first/back.png"));
		bbtn.addActionListener(listener);
		bbtn.setBounds(670, 900, 50, 50);
		bbtn.setBorder(new RoundedBorder(70));
		bbtn.setBackground(n);
		bbtn.setForeground(n);
		add(bbtn);
		bbtn.setEnabled(false);
		
		nbtn = new JButton(new ImageIcon("picture/first/next.png"));
		nbtn.addActionListener(listener);
		nbtn.setBounds(720, 900, 50, 50);
		nbtn.setBorder(new RoundedBorder(70));
		nbtn.setBackground(n);
		nbtn.setForeground(n);
		add(nbtn);
		
		
		
	}
	
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


	
	private class FirstPanelListener implements ActionListener
	{
		//private PrivateInfo informed;
		public void actionPerformed(ActionEvent e){

			if(e.getSource()==rb1)
			{				
				PrivateInfo.setSex(1);//1==남자						
			}
			else if(e.getSource()==rb2)
			{
				PrivateInfo.setSex(2);//2==여자				
			}
			else if(e.getSource()==nbtn)
			{
				if(PrivateInfo.getSex()==0)
					{JOptionPane.showMessageDialog(FirstPanel.this, "Error : Select Gender.","Error",JOptionPane.WARNING_MESSAGE);}

				else {
					try{
					
						Integer.parseInt(field[0].getText());
						Integer.parseInt(field[1].getText());
						Integer.parseInt(field[2].getText());
					
					}catch(IllegalArgumentException ectn){JOptionPane.showMessageDialog(FirstPanel.this, "Error : Input Natural Number.","Error",JOptionPane.WARNING_MESSAGE);}
				
					if(PrivateInfo.getSex()!=0&&Integer.parseInt(field[0].getText())>0&&Integer.parseInt(field[1].getText())>0&&Integer.parseInt(field[2].getText())>0)
					{
						PrivateInfo.setAge(Integer.parseInt(field[0].getText()));
						PrivateInfo.setWeight(Integer.parseInt(field[1].getText()));
						PrivateInfo.setHeight(Integer.parseInt(field[2].getText()));						
						PrivateInfo.recommend();
						
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
