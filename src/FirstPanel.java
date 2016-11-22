import java.awt.*;
import javax.swing.*;


public class FirstPanel extends JPanel {
	public JLabel title;
	public JTextField [] field;
	public JLabel [] lbl; 
	private JRadioButton rb1, rb2;
	private ImageIcon man,woman;
	private ButtonGroup group;
	int num;
	
	FirstPanel(){
		num = 4;
		field = new JTextField[num];
		lbl = new JLabel[num];
		title = new JLabel();
		man=new ImageIcon("C:\\Users\\Jae\\Desktop\\2-2\\JAVA\\팀플\\project\\man.jpg");
		woman=new ImageIcon("C:\\Users\\Jae\\Desktop\\2-2\\JAVA\\팀플\\project\\woman.jpg");
		rb1=new JRadioButton("남성",man);
		rb2=new JRadioButton("여성",woman);
		group=new ButtonGroup();
		
		title.setText("당신은 누구 인가요?");
		title.setFont(new Font("Araial black",Font.BOLD,20));
		title.setBounds(300, 10, 500, 100);
		this.setBounds(1,1,100,100);
		this.setLayout(null);
		this.setBackground(Color.white);
		add(title);
		
		rb1.setFont(new Font("Araial black",20,20));
		rb1.setBounds(150, 100, 260, 260);
		add(rb1);
		
		rb2.setFont(new Font("Araial black",20,20));
		rb2.setBounds(420, 100, 260, 260);
		add(rb2);
		
		group.add(rb1);
		group.add(rb2);
		
		lbl[0] = new JLabel("Age :");
		lbl[0].setFont(new Font("Arial black",Font.BOLD,20));
		lbl[0].setBounds(200, 400, 100, 50);
		add(lbl[0]);
		
		field[0] = new JTextField();
		field[0].setBounds(300, 400, 200, 50);
		add(field[0]);
		
		lbl[1] = new JLabel("Weight :");
		lbl[1].setFont(new Font("Arial black",Font.BOLD,20));
		lbl[1].setBounds(200, 460, 150, 50);
		add(lbl[1]);
		
		field[1] = new JTextField();
		field[1].setBounds(300, 460, 200, 50);
		add(field[1]);
		
		lbl[2] = new JLabel("Height :");
		lbl[2].setFont(new Font("Arial black",Font.BOLD,20));
		lbl[2].setBounds(200, 520, 150, 50);
		add(lbl[2]);
		
		field[2] = new JTextField();
		field[2].setBounds(300, 520, 200, 50);
		add(field[2]);
		
		
		
		JButton nextBtn = new JButton("asd");
		nextBtn.addMouseListener(new FirstPanelListener());
		nextBtn.setBounds(1000,800,100,100);
		add(nextBtn);
		this.add(new JTextField(10));
	}
}
