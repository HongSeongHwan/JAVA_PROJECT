import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {	
	ViewControl controller;
	public Main(String title){
		super(title);
        this.setLocation(new Point(100,0));//화면상에서 뜨는 위치를 잡아준다
        this.setVisible(true);//프레임이 보이게 설정
        this.setPreferredSize(new Dimension(800,1000));//프레임 사이즈 설정
        this.setResizable(false);//프레임 크기를 사용자가 못 바꾸게 설정
        this.pack();// 사이즈 맞게 pack
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 종료 버튼으로 닫히게 설정
        controller = new ViewControl(this);// 메인 함수자신을 Viewcontroller로 넘기면서 ViewCotroller 생성
	}
	public static void main(String[] args) {
		new Main("Diet");//메인 함수 호출
	}
}