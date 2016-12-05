import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;

public class DialogPan extends JPanel {
	private JLabel ltitle, lname, ltan, lfat, lprotein, lcal, lphoto, iconlbl;
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

	public DialogPan(JDialog dialog) {
		parent = dialog;
        me = this;
        listener = new DialogActionListener();
        me.setPreferredSize(new Dimension(500,650));
        setLayout(null);
        setBackground(Constant.c1);     
 
        ltitle = new JLabel(" ADD FOOD ! ");
        ltitle.setFont(new Font("Segoe Print",Font.BOLD,30));
        ltitle.setBounds(30,30,220,40);
        add(ltitle);        
         
        lname = new JLabel("* Food Name : ");
        lname.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lname.setBounds(40,100,180,30);
        add(lname);
        name.setBounds(230, 100, 150, 35);
        add(name);
 
        lcal = new JLabel("* Calorie : ");
        lcal.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lcal.setBounds(40,160,180,30);
        add(lcal);
        cal.setBounds(230, 160, 150, 35);
        add(cal);
 
        ltan = new JLabel("* Carbohydrate : ");
        ltan.setFont(new Font("Segoe Print",Font.PLAIN,20));
        ltan.setBounds(40,200,180,30);
        add(ltan);      
        tan.setBounds(230, 200, 150, 35);
        add(tan);
         
 
        lprotein = new JLabel("* Protein : ");
        lprotein.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lprotein.setBounds(40,240,180,30);
        add(lprotein);
        protein.setBounds(230, 240, 150, 35);
        add(protein);
         
 
        lfat = new JLabel("* Fat : ");
        lfat.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lfat.setBounds(40,280,180,30);
        add(lfat);
        fat.setBounds(230, 280, 150, 35);
        add(fat);
         
        lphoto = new JLabel("* Food Photo ");
        lphoto.setFont(new Font("Segoe Print", Font.PLAIN,20));
        lphoto.setBounds(40,340,180,30);
        add(lphoto);
         
        photoPanel = new JPanel();
        photoPanel.setBounds(45, 380, 250, 250);
        photoPanel.setBackground(Color.white);
        add(photoPanel);         
         
        //button
        sbtn = new JButton("<html>SELECT<br>\tFILE</html>");
        sbtn.setBounds(345, 380, 100, 80);
        sbtn.setBackground(Constant.c1);
        sbtn.setBorder(new RoundedBorder(25));
        sbtn.addActionListener(listener);
        add(sbtn);
         
        applyButton = new JButton(" APPLY");
        applyButton.setBounds(250, 650, 100, 40);
        applyButton.setBackground(Constant.c1);
        applyButton.setBorder(new RoundedBorder(25));
        applyButton.addActionListener(listener);
        add(applyButton);
         
        cbtn = new JButton(" EXIT ");
        cbtn.setBounds(360, 650, 100, 40);
        cbtn.setBackground(Constant.c1);
        cbtn.setBorder(new RoundedBorder(25));
        add(cbtn);

		//iconlbl
		iconlbl=new JLabel();
		iconlbl.setBounds(0,0,250,250);
		iconlbl.setBackground(Color.white);
		photoPanel.add(iconlbl);		
	}	// DialogPan()
	
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
    }	// RoundedBorder class


	private class DialogActionListener implements ActionListener {
		FoodButton newButton = new FoodButton();
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == applyButton) {//음식 새로 추가
				newButton.setName(name.getText());
				newButton.setCalories(Integer.parseInt(cal.getText()));
				newButton.setProtein(Integer.parseInt(protein.getText()));
				newButton.setFat(Integer.parseInt(fat.getText()));
				newButton.setTansoo(Integer.parseInt(tan.getText()));
				newButton.repaint();
				SecondPanel.getSecondPanel().getFoodPanel().foodAdd(newButton);
				System.out.println("button add!");
				SecondPanel.getSecondPanel().setVisible(false);
				SecondPanel.getSecondPanel().setVisible(true);
				parent.setVisible(false);

			} else if (e.getSource() == delButton) {

			} else if (e.getSource() == sbtn) {
				System.out.println("button ss!");
				JFileChooser f = new JFileChooser();
				if (f.showOpenDialog(me) == JFileChooser.APPROVE_OPTION) {
		            iconlbl.setIcon(new ImageIcon(f.getSelectedFile().getPath()));
		            newButton.setImageIconPath(f.getSelectedFile().getPath());
		            newButton.setImage();
		            iconlbl.repaint();
				}	// if
			}	// if.. else
		}	// actionPerformed()
	}	// DialogActionListenr class
}	// DialogPan class
