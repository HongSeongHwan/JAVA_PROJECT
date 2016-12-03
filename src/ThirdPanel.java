import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.border.Border;

public class ThirdPanel extends JPanel{
	//private JPanel upPanel, downPanel;
	private JButton bbtn,nbtn,btnThx;
	private JPanel img,recom;
	private JLabel adv,lblImg;
	private int check;
	private ImageIcon iconQurio;
	private Recommend rec;
	
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
		btnThx = new JButton("ReStart");
		listener = new ThirdPanelListener();		
		btnThx.addActionListener(listener);
		
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
	}	// ThirdPanel()
	
	public void recommend() {
		// background panel
		rec = new Recommend();
		recom = new JPanel();
		recom.setBounds(35,735,715,150);
		recom.setBackground(Color.gray);
		recom.setLayout(null);
		add(recom);
		
		Font fnt = new Font("Segoe Print",Font.BOLD,20);
		
		JLabel title = new JLabel("Advice!");
		title.setFont(fnt);
		title.setBounds(20,5,200,30);
		recom.add(title);		
		
		rec.setBounds(20,40,420,100);
		recom.add(rec);
		
		ImageIcon thxImg = new ImageIcon("picture/third/thx.png");
		JLabel lblThx = new JLabel(thxImg);
		lblThx.setBounds(450, 5, 250, 115);
		recom.add(lblThx);
		
		btnThx.setBounds(550,120,150,25);
		btnThx.setFont(fnt);
		recom.add(btnThx);
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
	}	// RoundedBorder()
	
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
	}	// Analysis()
	
	private class ThirdPanelListener implements ActionListener {		
		public void actionPerformed(ActionEvent e){
			Object obj = e.getSource();
			if(obj == bbtn) {
				ViewControl.viewPanel(3, 2);
				remove(tot);
				remove(tan);
				remove(ji);
				remove(dan);
				remove(recom);
			} else if (obj == btnThx) {
				ViewControl.viewPanel(3, 4);
			}	// if.. else..
		}		// actionPerformed()
	}	// ThirdPanelListner class
}	// ThirdPanel class
