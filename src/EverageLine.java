import java.awt.*;
import javax.swing.*;


public class EverageLine extends JPanel{
	//��õ�Ǵ� ������ ������ ���� ������ ǥ��
	private double recomanded;
	
	public EverageLine(){}
	public EverageLine(double a)
	{
		setLayout(null);
		setBackground(Color.white);
		recomanded = a;
	}//EverageLine()
	public double getRecomanded()
	{
		return recomanded;
	}//getRecomanded()
	public void paintComponent(Graphics page2)
	{
		super.paintComponent(page2);		
		
	}	// paintComponent();	
}//EveageLine
