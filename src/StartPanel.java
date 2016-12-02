import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class StartPanel extends JPanel{
	private JButton 	btnWonder, btnNoWonder;	// 궁금하다 , 궁금하지 않다
	private JPanel		titlePanel, mainPanel, bottomPanel;
	private JLabel		lblTitle, lblQuestion , lblCopyright;	// 제목, 사진, 저작권
	private ImageIcon	iconQuestion;	// 메인화면 - 사진, 말풍선
	private ButtonListener btnL;
	
	public StartPanel(){		
		Color n=new Color(255, 207, 181);
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(n);
		

		btnL = new ButtonListener();	
		titlePanel = new JPanel();
		titlePanel.setBounds(0,85,800,80);
		titlePanel.setLayout(null);
		add(titlePanel);
		
		lblTitle = new JLabel("Eating is important");
		lblTitle.setBounds(0,0,800,72);
		lblTitle.setFont(new Font("Segoe Print",Font.BOLD,40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblTitle);				
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0,110,800,650);
		mainPanel.setBackground(n);
		mainPanel.setLayout(null);
		add(mainPanel);				
		
		iconQuestion = new ImageIcon("picture/start/question.png");		

		lblQuestion = new JLabel(iconQuestion);
		lblQuestion.setBounds(0,50,670,580);
		mainPanel.add(lblQuestion);	
		
		Font fntButton = new Font("Segoe Print",Font.PLAIN,15);	
		
	//	btnWonder = new JButton(new ImageIcon("picture/start/wNw.png"));
		btnWonder = new JButton("Wonder");
		btnWonder.setFont(fntButton);
		btnWonder.setBackground(n);
		btnWonder.setBounds(610,420,120,50);
		btnWonder.addActionListener(btnL);
		btnWonder.setBorder(new RoundedBorder(20));
		mainPanel.add(btnWonder);		
		
//		btnNoWonder = new JButton(new ImageIcon("picture/start/wNw.png"));
		btnNoWonder = new JButton("No Wonder");
		btnNoWonder.setFont(fntButton);
		btnNoWonder.setBackground(n);
		btnNoWonder.setBounds(610,500,140,50);
		btnNoWonder.addActionListener(btnL);
		btnNoWonder.setBorder(new RoundedBorder(20));
		mainPanel.add(btnNoWonder);	
		
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,780,800,50);
		bottomPanel.setLayout(null);
		add(bottomPanel);
		
		lblCopyright = new JLabel("COPYRIGHTS TEAM-10 Wellbeing.  ALL RIGHTS RESERVED");
		lblCopyright.setFont(new Font("Verdana",Font.BOLD,20));
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setVerticalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(0,0,800,50);
		bottomPanel.add(lblCopyright);		
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
	
	public void wannaOut() {
		int question = JOptionPane.showConfirmDialog(null,"Do you want to go out?");
		if(question == JOptionPane.YES_OPTION) {
			System.exit(1);	
		}
		else if(question == JOptionPane.NO_OPTION) {
			ViewControl.viewPanel(4,1);	
		}
		else {
			// do nothing
			// stay this page	
		}
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object obj = event.getSource();
			
			if(obj == btnWonder) {
				ViewControl.viewPanel(4,1);
			}
			else if(obj == btnNoWonder) {
				wannaOut();
			}
		}
	}
}
