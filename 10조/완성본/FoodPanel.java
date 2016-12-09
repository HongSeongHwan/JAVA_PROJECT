import java.awt.*;
import javax.swing.*;

public class FoodPanel extends JPanel {

	private FoodButtonList list;
	private FoodButton[] button;
	private int target;
	private int i;
	private SecondPanel second;

	FoodPanel(SecondPanel second) {
		button = new FoodButton[Constant.FOODA.length];
		this.second = second;
		setBackground(Color.BLUE);
		setLayout(null);
		list = new FoodButtonList(this);
		GridLayout l = new GridLayout(10, 2);//음식버튼 배열을 위한 그리드 레이아웃 설정

		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);		
		
		for(i=0; i<Constant.FOODA.length; i++) {
			//버튼마다 음식의 정보를 담기위한 반복문
			button[i] = new FoodButton(new ImageIcon(Constant.FOODIMAGE[i]));
			button[i].setImageIconPath(Constant.FOODIMAGE[i]);
			button[i].setName(Constant.FOODA[i]);
			button[i].setCalories(Constant.foodData[i][0]);
			button[i].setTansoo(Constant.foodData[i][1]);
			button[i].setProtein(Constant.foodData[i][2]);
			button[i].setFat(Constant.foodData[i][3]);
			foodAdd(button[i]);
		}//for
	}//FoodPanel()

	public void listenerAdd() {
		for (FoodButton btn : list.getList()) {
			btn.addMouseListener(second.getMoveFoodListener());
		}//for
	}//listenerAdd()

	public void foodAdd(FoodButton x) {//추가된 음식을 더하고 빼는 용도
		list.addB(x);
		x.addMouseListener(second.getMoveFoodListener());
	}//foodAdd()
	public void foodDelete(FoodButton x) {
		list.deleteF(x);
	}//foodDelete()
	public FoodButtonList getFoodButtonList() {
		return list;
	}//getFoodButtonList()
}