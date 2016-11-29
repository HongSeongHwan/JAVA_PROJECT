import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
public class ThirdPanel extends JPanel{
	//private JPanel upPanel, downPanel;
	private JButton bbtn,nbtn;
	private ThirdPanelListener listener;
	private AdviceLabel lblTot,lblDan,lblTan,lblJi;
	private JPanel img,tot,dan,tan,ji,recom;
	private JLabel adv,lblImg;
	private int check;
	private ImageIcon iconQurio;
	
	public ThirdPanel(){
		this.setBounds(0,0,800,1000);
	//	this.setPreferredSize(new Dimension(800,1000));
		this.setLayout(null);
		this.setBackground(Color.white);
		
		// page change button
		bbtn = new JButton("¢¸");
		nbtn = new JButton("¢º");
		listener = new ThirdPanelListener();		
		
		bbtn.setBounds(670, 900, 50, 50);
		bbtn.addActionListener(listener);
		add(bbtn);
		
		nbtn.setBounds(720, 900, 50, 50);
		nbtn.addActionListener(listener);
		nbtn.setEnabled(false);
		add(nbtn);	
		
		// advice title .. Top
		adv = new JLabel("Result! Check please!");
		adv.setFont(new Font("Verdana",Font.BOLD,30));
		adv.setBounds(10,10,780,50);
		adv.setHorizontalAlignment(SwingConstants.CENTER);
		adv.setVerticalAlignment(SwingConstants.CENTER);
		add(adv);
		
		// img panel .. Mid left
		iconQurio = new ImageIcon("picture/third/quriosity.jpg");
		lblImg = new JLabel(iconQurio);
		img = new JPanel();
		img.setBounds(20,90,300,630);
		img.setBackground(Color.white);
		img.add(lblImg);
		add(img);
		
		
		// result .. Mid right
		tot = new JPanel();
		tot.setBounds(340,90,400,150);
		// making color
		check = 1; // tmp		
		if(check == 1)			tot.setBackground(Color.blue);
		else if(check == -1)	tot.setBackground(Color.red);
		else 					tot.setBackground(Color.green);
		// etc..
		tot.setLayout(null);		
		lblTot = new AdviceLabel(1,check);
		tot.add(lblTot);
		add(tot);
		
		
		dan = new JPanel();
		dan.setBounds(340,250,400,150);
		
		check = 0; // tmp		
		if(check == 1)			dan.setBackground(Color.blue);
		else if(check == -1)	dan.setBackground(Color.red);
		else 					dan.setBackground(Color.green);
		
		dan.setLayout(null);		
		lblDan = new AdviceLabel(2,check);
		dan.add(lblDan);
		add(dan);
		
		
		tan = new JPanel();
		tan.setBounds(340,410,400,150);
		
		check = -1; // tmp		
		if(check == 1)			tan.setBackground(Color.blue);
		else if(check == -1)	tan.setBackground(Color.red);
		else 					tan.setBackground(Color.green);
		
		tan.setLayout(null);		
		lblTan = new AdviceLabel(2,check);
		tan.add(lblTan);
		add(tan);
			
			
		ji = new JPanel();
		ji.setBounds(340,570,400,150);
		
		check = 1; // tmp		
		if(check == 1)			ji.setBackground(Color.blue);
		else if(check == -1)	ji.setBackground(Color.red);
		else 					ji.setBackground(Color.green);
		
		ji.setLayout(null);		
		lblJi = new AdviceLabel(2,check);
		ji.add(lblJi);		
		add(ji);
		
		
		// Recomand - Bottom
		recom = new JPanel();
		recom.setBounds(20,730,720,150);
		recom.setBackground(Color.yellow);
		add(recom);
	}
	
	
	
	private class ThirdPanelListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			ViewControl.viewPanel(3, 2);
		}		
	}
}
