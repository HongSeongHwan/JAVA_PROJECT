import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {	
	ViewControl controller;
	public Main(String title){
		super(title);
        this.setLocation(new Point(100,0));//ȭ��󿡼� �ߴ� ��ġ�� ����ش�
        this.setVisible(true);//�������� ���̰� ����
        this.setPreferredSize(new Dimension(800,1000));//������ ������ ����
        this.setResizable(false);//������ ũ�⸦ ����ڰ� �� �ٲٰ� ����
        this.pack();// ������ �°� pack
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���� ��ư���� ������ ����
        controller = new ViewControl(this);// ���� �Լ��ڽ��� Viewcontroller�� �ѱ�鼭 ViewCotroller ����
	}
	public static void main(String[] args) {
		new Main("Diet");//���� �Լ� ȣ��
	}
}