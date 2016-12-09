import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Recommend extends JPanel {
	private int loc;								// Recommended food location
	private boolean check;							// to know abundance or shortage
	private JLabel lbl;
	private double prot, carbo, fat, min, least;
	private ArrayList<FoodButton> list;
	private Imgpnl imgpnl;

	public Recommend() {
		this.setPreferredSize(new Dimension(650, 150));
		this.setBackground(Constant.backColor);
		check = true;	// true - abundance , false - shortage

		// stack Label over Recommend Panel
		// to add text, image
		lbl = new JLabel();
		lbl.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 25));
		lbl.setHorizontalAlignment(SwingConstants.RIGHT);	// text - right side
		lbl.setVerticalAlignment(SwingConstants.CENTER);
		lbl.setBounds(0, 0, 650, 150);
		this.add(lbl);

		/*  			decision process				 */
		// 음식 데이터 리스트
		list = FoodButtonList.getFoodButtonList().getList();
		// standard
		prot = TotalAted.gettProt() - PrivateInfo.getRecomProt();
		carbo = TotalAted.gettCarbo() - PrivateInfo.getRecomCarbo();
		fat = TotalAted.gettFat() - PrivateInfo.getRecomFat();
		
		// minimum data initiate
		min =  (	(list.get(0).getProtein() - prot) * (list.get(0).getProtein() - prot) / PrivateInfo.getRecomProt()	/ PrivateInfo.getRecomProt()
				+ 	(list.get(0).getTansoo() - carbo) * (list.get(0).getTansoo() - carbo)	/ PrivateInfo.getRecomCarbo() / PrivateInfo.getRecomCarbo()
				+	(list.get(0).getFat() - fat) * (list.get(0).getFat() - fat) / PrivateInfo.getRecomFat()/ PrivateInfo.getRecomFat()	);

		// to find minimum value
		// abundance formula
		for (int i = 1; i < list.size(); i++) {
			least = (	(list.get(i).getProtein() - prot) * (list.get(i).getProtein() - prot) / PrivateInfo.getRecomProt()	/ PrivateInfo.getRecomProt()
					+ 	(list.get(i).getTansoo() - carbo) * (list.get(i).getTansoo() - carbo)	/ PrivateInfo.getRecomCarbo() / PrivateInfo.getRecomCarbo()
					+	(list.get(i).getFat() - fat) * (list.get(i).getFat() - fat) / PrivateInfo.getRecomFat()/ PrivateInfo.getRecomFat()	);
			if (min > least) {
				loc = i;
				min = least;
			}	// if
		}	// for
		// shortage formula
		for (int i = 1; i < list.size(); i++) {
			least = (	(list.get(i).getProtein() + prot) * (list.get(i).getProtein() + prot) / PrivateInfo.getRecomProt()	/ PrivateInfo.getRecomProt()
					+ 	(list.get(i).getTansoo() + carbo) * (list.get(i).getTansoo() + carbo)	/ PrivateInfo.getRecomCarbo() / PrivateInfo.getRecomCarbo()
					+	(list.get(i).getFat() + fat) * (list.get(i).getFat() + fat) / PrivateInfo.getRecomFat()/ PrivateInfo.getRecomFat()	);
			if (min > least) {
				loc = i;
				min = least;
				check = false;
			}	// if
		}	// for
		// finish decision process
		
		// adding image and label
		imgpnl=new Imgpnl();
		lbl.add(imgpnl);
		this.printImg();
	} // Recommend()

	public void printImg() {
		if (check == true) { 			// abundance.
			lbl.setText("같은 음식은 피하는게 좋아요~");

		} else { 						// shortage
			lbl.setText("같은 음식을 찾아봐요~");
		} // if.. else
	}	// printImg()

	class Imgpnl extends JPanel {
		private ImageIcon imageIcon;
		private Image image;

		private Imgpnl() {
			setPreferredSize(new Dimension(300, 150));
			setBounds(0, 0, 300, 150);
			imageIcon = new ImageIcon(list.get(loc).getImageIconPath());//imageIcon에 getImageIconPath을 통하여 이미지 불러오기
			image = imageIcon.getImage();//getImage를 통하여 이미지 추출
		}	// Imgpnl()

		// to make a image size suitably
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);//drawImage를 통하여 image를 Imgpnl에 그린다.
		}	// paintComponent()
	}	// Imgpnl class
	
} // Recommend class
