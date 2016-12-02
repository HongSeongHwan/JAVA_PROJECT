import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class DialogPan extends JPanel
{	
	private JLabel lname, ltan, lfat, lprotein, lcal;
	private JTextField name = new JTextField();
	private JTextField tan = new JTextField();
	private JTextField fat = new JTextField();
	private JTextField protein = new JTextField();
	private JTextField cal = new JTextField();
	private JButton sbtn, delButton, applyButton, cbtn;	
	private JPanel photoPanel;
	private DialogActionListener listener;
	private DialogPan me;
	private JDialog parent;
	private FoodButton f;
	private boolean isAdd;
	public FoodButton getFoodButton(){
		return f;
	}
	public boolean getOption(){
		return isAdd;
	}
	public DialogPan(JDialog dialog, FoodButton f) {
		parent = dialog;
		me = this;
		f = this.f;
		if(f==null){
			f = new FoodButton();
			isAdd = true;
		}else {
			isAdd = false;
		}
		listener = new DialogActionListener();
		setPreferredSize(new Dimension(500,650));
		setLayout(null);
		setBackground(Color.white);		

		lname = new JLabel(" Food Name : ");
		lname.setFont(new Font("Segoe Print",Font.PLAIN,20));
		lname.setBounds(40,50,170,30);
		add(lname);

		name.setBounds(220, 50, 120, 35);
		add(name);

		lcal = new JLabel(" Calorie : ");
		lcal.setFont(new Font("Segoe Print",Font.PLAIN,20));
		lcal.setBounds(40,110,170,30);
		add(lcal);

		cal.setBounds(220, 110, 120, 35);
		add(cal);

		ltan = new JLabel(" Carbohydrate : ");
		ltan.setFont(new Font("Segoe Print",Font.PLAIN,20));
		ltan.setBounds(40,150,170,30);
		add(ltan);		
		tan.setBounds(220, 150, 120, 35);
		tan.setText(Double.toString(f.getTansoo()));
		add(tan);
		

		lprotein = new JLabel(" Protein : ");
		lprotein.setFont(new Font("Segoe Print",Font.PLAIN,20));
		lprotein.setBounds(40,190,170,30);
		add(lprotein);
		protein.setText(Double.toString(f.getProtein()));
		protein.setBounds(220, 190, 120, 35);
		add(protein);
		

		lfat = new JLabel(" Fat : ");
		lfat.setFont(new Font("Segoe Print",Font.PLAIN,20));
		lfat.setBounds(40,230,170,30);
		add(lfat);
		fat.setText(Double.toString(f.getFat()));
		fat.setBounds(220, 230, 120, 35);
		add(fat);
		
		
		photoPanel = new JPanel();
		photoPanel.setBounds(40, 300, 250, 250);
		photoPanel.setBackground(Color.cyan);
		add(photoPanel);
		
		
		
		
		//button
		sbtn = new JButton("<html>SELECT<br>\tFILE</html>");
		sbtn.setBounds(350, 300, 100, 80);
		sbtn.setBackground(new Color(192,192,192));
		add(sbtn);
		String apply =(isAdd)?"add":"apply";
		applyButton = new JButton(" APPLY");
		applyButton.setBounds(135, 580, 100, 40);
		applyButton.setBackground(Color.white);
		applyButton.addActionListener(listener);
		add(applyButton);
		
		delButton = new JButton(" DELETE ");
		delButton.setBounds(255, 580, 100, 40);
		delButton.setBackground(Color.white);
		if(isAdd){
			delButton.setEnabled(false);
		}
		
		add(delButton);
		
		cbtn = new JButton(" EXIT ");
		cbtn.setBounds(370, 580, 100, 40);
		cbtn.setBackground(Color.white);
		add(cbtn);
	
	}

	private class DialogActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == applyButton){
				if(((JButton)e.getSource()).getText()=="add"){
					FoodButton newButton = new FoodButton();
					newButton.setName(name.getText() );
					newButton.setCalories( Integer.parseInt( cal.getText()) );
					newButton.setProtein( Integer.parseInt( protein.getText()) );
					newButton.setFat( Integer.parseInt( fat.getText()) );
					newButton.setTansoo( Integer.parseInt( tan.getText()) );
					SecondPanel.getSecondPanel().getFoodPanel().foodAdd(newButton);
					System.out.println("button add!");
					SecondPanel.getSecondPanel().setVisible(false);
					SecondPanel.getSecondPanel().setVisible(true);
				//	me.getRootPane().setVisible(false);;
					parent.setVisible(false);
				}else{
					
					
				}
			}else if(e.getSource() == delButton){
			//	SecondPanel.getSecondPanel().getFoodPanel().foodDelete(F;
				
				
			}else{
				
				
			}
		}
	}

}
