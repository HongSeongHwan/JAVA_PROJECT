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
		GridLayout l = new GridLayout(10, 2);//���Ĺ�ư �迭�� ���� �׸��� ���̾ƿ� ����

		l.setHgap(2);
		l.setVgap(2);
		this.setLayout(l);		
		
		for(i=0; i<Constant.FOODA.length; i++) {
			//��ư���� ������ ������ ������� �ݺ���
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

	public void foodAdd(FoodButton x) {//�߰��� ������ ���ϰ� ���� �뵵
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