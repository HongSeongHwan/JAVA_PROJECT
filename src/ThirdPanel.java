import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.border.Border;

public class ThirdPanel extends JPanel{
	//private JPanel upPanel, downPanel;
	private JButton bbtn,nbtn;
	private JPanel img,recom;
	private JLabel adv,lblImg;
	private int check;
	private ImageIcon iconQurio;
	
	private ThirdPanelListener listener;
	private AdvicePanel tot,dan,tan,ji;
	
	public ThirdPanel(){
		Color n=new Color(255, 207, 181);
		this.setBounds(0,0,800,1000);
		this.setLayout(null);
		this.setBackground(n);
		
		// page change button
		bbtn= new JButton(new ImageIcon("picture/first/back.png"));
		nbtn = new JButton(new ImageIcon("picture/first/next.png"));
		listener = new ThirdPanelListener();		
		
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
		nbtn.setEnabled(false);
		add(nbtn);	
		
		// advice title .. Top
		adv = new JLabel("Result! Check Please!");
		adv.setFont(new Font("Segoe Print",Font.BOLD,50));
		adv.setBounds(10,20,780,50);
		adv.setHorizontalAlignment(SwingConstants.CENTER);
		adv.setVerticalAlignment(SwingConstants.CENTER);
		add(adv);
		
		// img panel .. Mid left
		iconQurio = new ImageIcon("picture/third/quriosity.jpg");
		lblImg = new JLabel(iconQurio);
		img = new JPanel();
		img.setBounds(35,85,300,635);
		img.setBackground(Color.white);
		img.add(lblImg);
		add(img);
				
		// Recomand - Bottom
		recom = new JPanel();
		recom.setBounds(35,735,715,150);
		recom.setBackground(Color.yellow);
		add(recom);
	}	// ThirdPanel()
	
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
	
	public void Analysis() {
		// main	.. Mid right
		// 1. Total
		tot = new AdvicePanel("Total",TotalAted.gettCal(),PrivateInfo.getRecomCal());
		tot.setBounds(350,90,400,150);
		add(tot);
		
		// 2. Protein
		dan = new AdvicePanel("Protein",TotalAted.gettProt(),PrivateInfo.getRecomProt());
		dan.setBounds(350,250,400,150);
		add(dan);
		
		// 3. Carbohydrate
		tan = new AdvicePanel("Carbo",TotalAted.gettCarbo(),PrivateInfo.getRecomCarbo());
		tan.setBounds(350,410,400,150);
		add(tan);
		
		// 4. Fat
		ji = new AdvicePanel("Fat",TotalAted.gettFat(),PrivateInfo.getRecomFat());
		ji.setBounds(350,570,400,150);
		add(ji);
	}
	
	public ThirdPanel getThird()	{ return this;}
	
	
	private class ThirdPanelListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			ViewControl.viewPanel(3, 2);
			remove(tot);
			remove(tan);
			remove(ji);
			remove(dan);			
		}		
	}
}
