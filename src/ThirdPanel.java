import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
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
		this.setBounds(0,0,800,1000);
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
		adv.setFont(new Font("Segoe Print",Font.BOLD,40));
		adv.setBounds(10,20,780,50);
		adv.setHorizontalAlignment(SwingConstants.CENTER);
		adv.setVerticalAlignment(SwingConstants.CENTER);
		add(adv);
		
		// img panel .. Mid left
		iconQurio = new ImageIcon("picture/third/quriosity.jpg");
		lblImg = new JLabel(iconQurio);
		img = new JPanel();
		img.setBounds(40,90,300,630);
		img.setBackground(Color.white);
		img.add(lblImg);
		add(img);
				
		// Recomand - Bottom
		recom = new JPanel();
		recom.setBounds(20,730,720,150);
		recom.setBackground(Color.yellow);
		add(recom);
	}	// ThirdPanel()
	
	public void Analysis() {
		// main	.. Mid right
		// 1. Total
		tot = new AdvicePanel("Total",TotalAted.gettCal(),PrivateInfo.getRecomCal());
		tot.setBounds(350,90,400,150);
		add(tot);
		
		// 2. Protein
		dan = new AdvicePanel("Protein",TotalAted.gettProt(),PrivateInfo.getRecomProt());
		dan.setBounds(330,250,400,150);
		add(dan);
		
		// 3. Carbohydrate
		tan = new AdvicePanel("Carbo",TotalAted.gettCarbo(),PrivateInfo.getRecomCarbo());
		tan.setBounds(330,410,400,150);
		add(tan);
		
		// 4. Fat
		ji = new AdvicePanel("Fat",TotalAted.gettFat(),PrivateInfo.getRecomFat());
		ji.setBounds(330,570,400,150);
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
