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
    private JButton sbtn, applyButton, cbtn; 
    private JPanel photoPanel;
    private DialogActionListener listener;
    private DialogPan me;
    private JDialog parent;
	public DialogPan(JDialog dialog) {
		//
		Color c = new Color(255,184,171);
		parent = dialog;
        me = this;
        listener = new DialogActionListener();
        me.setPreferredSize(new Dimension(500,650));
        setLayout(null);
        setBackground(c);     
        
        // Add title 추가
        ltitle = new JLabel(" < ADD FOOD > ");
        ltitle.setFont(new Font("Segoe Print",Font.BOLD,30));
        ltitle.setForeground(Color.black);
        ltitle.setBounds(100,45,280,45);
        ltitle.setHorizontalAlignment(SwingConstants.CENTER);
		ltitle.setVerticalAlignment(SwingConstants.CENTER);
        add(ltitle);        
         
        //음식 텍스트 필드 옆 라벨 및 텍스트 필드 추가
        lname = new JLabel("* Food Name : ");
        lname.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lname.setBounds(40,120,180,30);
        add(lname);
        name.setBounds(230, 120, 150, 35);
        add(name);
 
        //칼로리 텍스트 필드 옆 라벨 및 텍스트 필드 추가
        lcal = new JLabel("* Calorie : ");
        lcal.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lcal.setBounds(40,160,180,30);
        add(lcal);
        cal.setBounds(230, 160, 150, 35);
        add(cal);
 
        //탄수회물 텍스트 필드 옆 라벨 및 텓스트 필드 추가
        ltan = new JLabel("* Carbohydrate : ");
        ltan.setFont(new Font("Segoe Print",Font.PLAIN,20));
        ltan.setBounds(40,200,180,30);
        add(ltan);      
        tan.setBounds(230, 200, 150, 35);
        add(tan);
         
        //단백질 텍스트 필드 및 라벨 추가
        lprotein = new JLabel("* Protein : ");
        lprotein.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lprotein.setBounds(40,240,180,30);
        add(lprotein);
        protein.setBounds(230, 240, 150, 35);
        add(protein);
         
        //지방 텍스트 필드 및 라벨 추가
        lfat = new JLabel("* Fat : ");
        lfat.setFont(new Font("Segoe Print",Font.PLAIN,20));
        lfat.setBounds(40,280,180,30);
        add(lfat);
        //fat.setText(Double.toString(f.getFat()));
        fat.setBounds(230, 280, 150, 35);
        add(fat);
         
        //음식 사진 라벨 추가
        lphoto = new JLabel("* Food Photo ");
        lphoto.setFont(new Font("Segoe Print", Font.PLAIN,20));
        lphoto.setBounds(40,340,180,30);
        add(lphoto);
         
        //음식 사진 패널 추가
        photoPanel = new JPanel();
        photoPanel.setBounds(45, 380, 250, 250);
        photoPanel.setBackground(Color.white);
        add(photoPanel);
         
         
        //파일 추저 버튼 추가
        sbtn = new JButton("<html>SELECT<br>\tFILE</html>");// \n 기능 구현
        sbtn.setBounds(345, 380, 100, 80);
        sbtn.setBackground(c);
        sbtn.setBorder(new RoundedBorder(25));
        sbtn.addActionListener(listener);
        add(sbtn);
        
        //음식 추가 버튼 추가 
        applyButton = new JButton(" APPLY"); // 
        applyButton.setBounds(250, 650, 100, 40);
        applyButton.setBackground(c);
        applyButton.setBorder(new RoundedBorder(25));
        applyButton.addActionListener(listener);
        add(applyButton);
         
        //종료 버튼 추가
        cbtn = new JButton(" EXIT ");
        cbtn.setBounds(360, 650, 100, 40);
        cbtn.setBackground(c);
        cbtn.setBorder(new RoundedBorder(25));
        cbtn.addActionListener(listener);
        add(cbtn);

		//사진 패널에 이미지 들어갈 라벨 추가
		iconlbl=new JLabel();
		iconlbl.setBounds(0,0,250,250);
		iconlbl.setBackground(Color.white);
		photoPanel.add(iconlbl);
		
	}
	//버튼 모양 동그랗게 바꾸기
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
	private class DialogActionListener implements ActionListener {
		FoodButton newButton = new FoodButton();// 추가할 음식 버튼
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == applyButton) {//음식 새로 추가
				//텍스트 필드에 있는 음식들을 받아와서 새로 만든 푸드 버튼에 set 해줌
				newButton.setName(name.getText());
				newButton.setCalories(Integer.parseInt(cal.getText()));
				newButton.setProtein(Integer.parseInt(protein.getText()));
				newButton.setFat(Integer.parseInt(fat.getText()));
				newButton.setTansoo(Integer.parseInt(tan.getText()));
				newButton.repaint();//사진 그리기
				
				SecondPanel.getSecondPanel().getFoodPanel().foodAdd(newButton);//만든 푸드버튼 푸드 패널에 추가
				SecondPanel.getSecondPanel().setVisible(false);// 추가 된거 딜레이 되서 안 보이게 해줌
				SecondPanel.getSecondPanel().setVisible(true);// 마찬가지로 추가 된거 딜레이되서 안보이게 해줌
				parent.setVisible(false);// 다이얼로그창 끄기
				

			} else if (e.getSource() == sbtn) { // 만약 이미지 파일 추가 버튼을 누르면
				//파일 추저를 만들어서 이미지 패스를 받아와서 이미지를 그린다.
				JFileChooser f = new JFileChooser();
				if (f.showOpenDialog(me) == JFileChooser.APPROVE_OPTION) {
		            iconlbl.setIcon(new ImageIcon(f.getSelectedFile().getPath()));
		            newButton.setImageIconPath(f.getSelectedFile().getPath());
		            newButton.setImage();
		            iconlbl.repaint();
				}

			}else { //Exit 버튼 눌리면
				parent.setVisible(false);// 다이얼로그창 끄기
			}
		}
	}
}
