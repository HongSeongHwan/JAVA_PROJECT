import java.awt.*;
import javax.swing.*;
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
		lblTitle.setBounds(0,0,800,70);
		lblTitle.setFont(new Font("Verdana",Font.BOLD,40));
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
		Font fntButton = new Font("Verdana",Font.PLAIN,15);	
		
		btnWonder = new JButton("wonder");
		btnWonder.setFont(fntButton);
		btnWonder.setBounds(630,300,120,50);
		btnWonder.addActionListener(btnL);
		mainPanel.add(btnWonder);		
		
		btnNoWonder = new JButton("no wonder");
		btnNoWonder.setFont(fntButton);
		btnNoWonder.setBounds(630,390,120,50);
		btnNoWonder.addActionListener(btnL);
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
