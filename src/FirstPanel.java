import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;


public class FirstPanel extends JPanel {
	public JPanel titlePanel;
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
		Color n = Constant.backColor;
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(n);
		//패널속성 설정
		
		num = 4;
		field = new JTextField[num];
		lbl = new JLabel[num];
		titlePanel = new JPanel();
		title = new JLabel();
		man=new ImageIcon("picture/first/man.png");
		woman=new ImageIcon("picture/first/woman.png");
		rb1=new JRadioButton("남성");
		rb1.addActionListener(listener);
		rb2=new JRadioButton("여성");
		rb2.addActionListener(listener);
		group=new ButtonGroup();//버튼을 그룹화하여 그룹화된 버튼중 하나만 선택가능하도록 설정
		
		//titlePanel
		titlePanel.setBounds(0,85,800,120);
		titlePanel.setBackground(Constant.c5);
		titlePanel.setLayout(null);
		add(titlePanel);
		
		//title
		title.setText("당신은 누구인가요?");
		title.setFont(new Font("한컴 윤고딕 230",Font.BOLD,60));
		title.setBounds(110, 0, 590, 120);
		title.setForeground(Constant.backColor);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		titlePanel.add(title);
		
		//insert image 'man'
		JLabel image1=new JLabel(man);
		image1.setBounds(175, 260, 200, 250);
		add(image1);
		
		//insert image 'woman'
		JLabel image2=new JLabel(woman);
		image2.setBounds(425,260,200,250);
		add(image2);
		
		//rb1=남성 버튼
		rb1.setFont(new Font("한컴 윤고딕 230",20,20));
		rb1.setBounds(235, 480, 80, 50);
		rb1.setBackground(n);
		add(rb1);
		
		//rb2=여성 버튼
		rb2.setFont(new Font("한컴 윤고딕 230",20,20));
		rb2.setBounds(485, 480, 80, 50);
		rb2.setBackground(n);
		add(rb2);
		
		//rb1, rb2 group
		group.add(rb1);
		group.add(rb2);
		
		//lbl[0] 나이
		lbl[0] = new JLabel("Age :");
		lbl[0].setFont(new Font("Segoe Print",Font.BOLD,25));
		lbl[0].setBounds(230, 590, 100, 50);
		add(lbl[0]);
		
		//field[0] 나이입력
		field[0] = new JTextField();
		field[0].setBounds(365, 590, 200, 50);
		field[0].setFont(new Font("한컴 윤고딕 230",Font.PLAIN,20));
		add(field[0]);
		
		//lbl[1] 몸무게
		lbl[1] = new JLabel("Weight :");
		lbl[1].setFont(new Font("Segoe Print",Font.BOLD,25));
		lbl[1].setBounds(230, 660, 150, 50);
		add(lbl[1]);
		
		//field[1] 몸무게입력
		field[1] = new JTextField();
		field[1].setBounds(365, 660, 200, 50);
		field[1].setFont(new Font("한컴 윤고딕 230",Font.PLAIN,20));
		add(field[1]);
		
		//lbl[2] 키
		lbl[2] = new JLabel("Height :");
		lbl[2].setFont(new Font("Segoe Print",Font.BOLD,25));
		lbl[2].setBounds(230, 730, 150, 50);
		add(lbl[2]);
		
		//field[2] 키입력
		field[2] = new JTextField();
		field[2].setBounds(365, 730, 200, 50);
		field[2].setFont(new Font("한컴 윤고딕 230",Font.PLAIN,20));
		add(field[2]);
		
		//bbtn 전 페이지로 돌아가는 버튼
		bbtn= new JButton(new ImageIcon("picture/first/back.png"));
		bbtn.addActionListener(listener);
		bbtn.setBounds(670, 900, 50, 50);
		bbtn.setBorder(new RoundedBorder(70));
		bbtn.setBackground(n);
		bbtn.setForeground(n);
		add(bbtn);
		bbtn.setEnabled(false);//첫 화면이므로 전 화면으로 돌아갈 수 없도록 비활성화
		
		//nbtn 다음 페이지로 넘어가는 버튼
		nbtn = new JButton(new ImageIcon("picture/first/next.png"));
		nbtn.addActionListener(listener);
		nbtn.setBounds(720, 900, 50, 50);
		nbtn.setBorder(new RoundedBorder(70));
		nbtn.setBackground(n);
		nbtn.setForeground(n);
		add(nbtn);
		
		
	}//FirstPanel()
	
	class RoundedBorder implements Border { //버튼의 바운더리를 동그랗게 만들기 위한 클래스
		int radius;
		RoundedBorder(int radius) { 
			this.radius = radius; 
		}//RoundedBorder()
		public Insets getBorderInsets(Component c) { 
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius); 
		}//getBorderInsets()
		public boolean isBorderOpaque() { 
			return true; 
		}//isBorderOpaque()
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) { 
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); 
		}//paintBorder()
	}//RoundedBorder


	
	private class FirstPanelListener implements ActionListener
	{//첫 페이지 전용 리스너
		public void actionPerformed(ActionEvent e){

			if(e.getSource()==rb1)
			{				
				PrivateInfo.setSex(1);//1==남자						
			}//if
			else if(e.getSource()==rb2)
			{
				PrivateInfo.setSex(2);//2==여자				
			}//else if
			else if(e.getSource()==nbtn)//다음 버튼으로 넘어가는 버튼이 클릭된 상황설정
			{
				if(PrivateInfo.getSex()==0)//성별 미선택시 예외처리
					{JOptionPane.showMessageDialog(FirstPanel.this, "Error : Select Gender.","Error",JOptionPane.WARNING_MESSAGE);}
					//if
				
				else {
					try{//텍스트 필드에 값이 미입력되었을 시에 예외처리
					
						Integer.parseInt(field[0].getText());
						Integer.parseInt(field[1].getText());
						Integer.parseInt(field[2].getText());
					
					}catch(IllegalArgumentException ectn){JOptionPane.showMessageDialog(FirstPanel.this, "Error : Fill All Blanks.","Error",JOptionPane.WARNING_MESSAGE);}
					//try catch
					
					if(PrivateInfo.getSex()!=0&&(Integer.parseInt(field[0].getText())>0)&&(Integer.parseInt(field[1].getText())>0)&&(Integer.parseInt(field[2].getText())>0))
					{//입력된 값의 범위 설정을 통하여 예외처리
						if(Integer.parseInt(field[0].getText())>=10&&Integer.parseInt(field[0].getText())<=100)
						{	
							PrivateInfo.setAge(Integer.parseInt(field[0].getText()));
							if(Integer.parseInt(field[1].getText())>=20&&Integer.parseInt(field[1].getText())<=110)
							{
								PrivateInfo.setWeight(Integer.parseInt(field[1].getText()));
								if(Integer.parseInt(field[2].getText())>=60&&Integer.parseInt(field[2].getText())<=220)
								{
									PrivateInfo.setHeight(Integer.parseInt(field[2].getText()));
									
									PrivateInfo.recommend();
									
									//다음장으로 넘기기
									ViewControl.viewPanel(1, 2);
								}//if
								
								else
									JOptionPane.showMessageDialog(FirstPanel.this, "HEIGHT : 60 ~ 220.","Error",JOptionPane.WARNING_MESSAGE);
								//else
							}//if
							else
								JOptionPane.showMessageDialog(FirstPanel.this, "WEIGHT : 20 ~ 110","Error",JOptionPane.WARNING_MESSAGE);
							//else
						}//if
						else
							JOptionPane.showMessageDialog(FirstPanel.this, "AGE : 10 ~ 100","Error",JOptionPane.WARNING_MESSAGE);
						//else
					}//if
					else
						JOptionPane.showMessageDialog(FirstPanel.this, "Error : Wrong Number. (Need Proper Number) ","Error",JOptionPane.WARNING_MESSAGE);
					//else
				}//else
			}//else if
		}//actionPerformed()
	}//FirstPanelListener
}//FirstPanel
