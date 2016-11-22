import java.awt.*;
import javax.swing.*;
public class Main extends JFrame {
	ViewControl controller;
	public Main(String title){
		super(title);
	        //��������� â�� ��ġ�� ����ش�.
        this.setLocation(new Point(600,250));
        //�������� �����ش�. default = false
        this.setVisible(true);
        //�������� âũ�⸦ �����Ѵ�.
        this.setPreferredSize(new Dimension(800,1000));
        //������Ʈ ũ�⸸ŭ â�� ũ�⸦ ����ش�.
        this.pack();
        //������â�� ���� ��� ���μ����� �����ϱ� ���� ����ؾ��Ѵ�. 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //����Ʈ�ѷ� ���
        controller = new ViewControl(this);
	}
	public static void main(String[] args) {
		new Main("Diet");
	}
}