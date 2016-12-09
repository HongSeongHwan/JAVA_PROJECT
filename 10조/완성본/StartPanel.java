import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class StartPanel extends JPanel{
	private JButton 	btnWonder, btnNoWonder;					//	�ñ��ϴ� , �ñ����� �ʴ�
	private JPanel		titlePanel, mainPanel, bottomPanel;		//	���� �г�
	private JLabel		lblTitle, lblPhoto, lblQuestion , lblCopyright;	// ����, ����, ����, ���۱�
	private ImageIcon	iconPhoto, iconQuestion;				// �̹��� ���Կ�
	private ButtonListener btnL;
	
	public StartPanel(){		
		// basic set
		Color n= Constant.backColor;
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(n);		
		
		// button
		btnL = new ButtonListener();	
		
		// Title Panel - Top Side
		titlePanel = new JPanel();
		titlePanel.setBounds(0,85,800,120);
		titlePanel.setBackground(Constant.c5);
		titlePanel.setLayout(null);
		add(titlePanel);
		
		// lblTitle at titlePanel
		lblTitle = new JLabel("Eating is important");
		lblTitle.setBounds(0,0,800,120);
		lblTitle.setFont(new Font("Segoe Print",Font.BOLD,60));
		lblTitle.setForeground(Constant.backColor);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setVerticalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblTitle);	
		
		// Main Panel - Middle Side
		mainPanel = new JPanel();
		mainPanel.setBounds(0,110,800,700);
		mainPanel.setBackground(n);
		mainPanel.setLayout(null);
		add(mainPanel);				
		
		// main image - photo, question at mainPanel
		iconPhoto = new ImageIcon("picture/start/donguri.jpg");
		lblPhoto = new JLabel(iconPhoto);
		lblPhoto.setBounds(-154,88,750,780);
		mainPanel.add(lblPhoto);	
		
		iconQuestion = new ImageIcon("picture/start/q.png");
		lblQuestion = new JLabel(iconQuestion);
		lblQuestion.setBounds(390,80,400,400);
		mainPanel.add(lblQuestion);
		
		// font
		Font fntButton = new Font("Segoe Print",Font.PLAIN,20);	
		
		// two buttons at mainPanel	- wonder : go to next page / no wonder : JOptionPane
		//							- border
		btnWonder = new JButton("Wonder");
		btnWonder.setFont(fntButton);
		btnWonder.setForeground(Constant.c2);
		btnWonder.setBackground(n);
		btnWonder.setBounds(530,495,170,60);
		btnWonder.addActionListener(btnL);
		btnWonder.setBorder(new RoundedBorder(25));
		mainPanel.add(btnWonder);		
		
		btnNoWonder = new JButton("No Wonder");
		btnNoWonder.setFont(fntButton);
		btnNoWonder.setBackground(n);
		btnNoWonder.setBounds(530,585,170,60);
		btnNoWonder.addActionListener(btnL);
		btnNoWonder.setBorder(new RoundedBorder(25));
		mainPanel.add(btnNoWonder);	
		
		
		// Bottom Panel - Bottom Side
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0,880,800,50);
		bottomPanel.setBackground(Constant.c5);
		bottomPanel.setLayout(null);
		add(bottomPanel);
		
		// copyright label at BottomPanel
		lblCopyright = new JLabel("COPYRIGHTS TEAM-10 Wellbeing.  ALL RIGHTS RESERVED");
		lblCopyright.setFont(new Font("Verdana",Font.BOLD,15));
		lblCopyright.setForeground(Constant.backColor);
		lblCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyright.setVerticalAlignment(SwingConstants.CENTER);
		lblCopyright.setBounds(0,0,800,50);
		bottomPanel.add(lblCopyright);		
	}	// StartPanel()
	
	public void wannaOut() {
		int question = JOptionPane.showConfirmDialog(null,"Do you want to go out?");
		if(question == JOptionPane.YES_OPTION) {	// Exit
			System.exit(1);	
		} else if(question == JOptionPane.NO_OPTION) {	// go to next page
			ViewControl.viewPanel(4,1);	
		} else {
			// do nothing
			// stay this page	
		}	// if.. else..
	}	// wannaOut()	
	
	class RoundedBorder implements Border { 
		int radius;
		RoundedBorder(int radius) { 
			this.radius = radius; 
		} // RoundedBorder()
		
		public Insets getBorderInsets(Component c) { 
			return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius); 
		} // getBorderInsets()
		
		public boolean isBorderOpaque() { 
			return true; 
		} 	// isBorderOpaque()
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) { 
			g.drawRoundRect(x, y, width - 1, height - 1, radius, radius); 
		} // paintBorder()
	}	// RoundedBorder class

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Object obj = event.getSource();
			
			if(obj == btnWonder) {				// go to next page
				ViewControl.viewPanel(4,1);
			} else if(obj == btnNoWonder) {		// go to JOptionPane dialog
				wannaOut();
			} // if..else..
		}	// actionPerformed()
	}	// ButtonListener class
	
}	// StartPanel class
