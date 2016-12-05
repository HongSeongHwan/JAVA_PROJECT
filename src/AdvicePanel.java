import javax.swing.*;
import java.awt.*;

public class AdvicePanel extends JPanel
{
	private JPanel	anaP,resultP;
	private JLabel	lblAna,lblResult,lblName;
	private int		check, std;
	private ImageIcon vs, lbs, ok;
	
	public AdvicePanel(){}
	public AdvicePanel(String str,double data,double dataD)
	{
		anaP		= new JPanel();
		resultP		= new JPanel();
		lblAna		= new JLabel();
		lblResult	= new JLabel();
		lblName		= new JLabel();
		
		// image about result
		vs= new ImageIcon("picture/third/very serious.png");
		lbs=new ImageIcon("picture/third/little bit serious.png");
		ok=new ImageIcon("picture/third/ok.png");
		
		this.setPreferredSize(new Dimension(400,150));
		this.setLayout(null);
		
		check	= Math.abs((int)(data - dataD));
		std		= (int) dataD;
		
		// anaP	-- left
		anaP.setLayout(null);
		anaP.setBounds(0,0,200,150);
		this.add(anaP);		
		// lblName	-- left top
		lblName.setText(str);
		lblName.setFont(new Font("Verdana",Font.BOLD,30));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setVerticalAlignment(SwingConstants.CENTER);
		lblName.setBounds(0,0,200,100);	
		anaP.add(lblName);
		// lblAna	-- left bottom
		lblAna.setText("(" + Math.round(data*100d)/100d + "/" +Math.round(dataD*100d)/100d + ")");
		lblAna.setFont(new Font("Verdana",Font.BOLD,15));
		lblAna.setHorizontalAlignment(SwingConstants.CENTER);
		lblAna.setVerticalAlignment(SwingConstants.CENTER);
		lblAna.setBounds(0,100,200,50);
		anaP.add(lblAna);
		
		// resultP	-- right
		resultP.setLayout(null);
		resultP.setBounds(210,0,190,150);
		// Color
		if(check>0)			resultP.setBackground(Color. yellow);
		else if(check<0)	resultP.setBackground(Color.yellow);
		else				resultP.setBackground(Color.white);
		
		this.add(resultP);
		// lblResult
		AdviceLabel(lblResult,check);
		lblResult.setBounds(0,0,190,150);
		resultP.add(lblResult);					
	}	// AdvicePanel()
	
	public void AdviceLabel(JLabel lbl, int check)
	{
		lbl.setFont(new Font("Verdana",Font.BOLD,40));
		lbl.setForeground(Color.white);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setVerticalAlignment(SwingConstants.CENTER);
		lbl.setPreferredSize(new Dimension(190,150));
		
		if(check > (std*0.2))		lbl.setIcon(vs);	//	많이 위험
		else if(check > (std*0.1))	lbl.setIcon(lbs);	//	조금 위험
		else 						lbl.setIcon(ok);	//	적당	
	}	// AdviceLabel()
	
}	// AdvicePanel class