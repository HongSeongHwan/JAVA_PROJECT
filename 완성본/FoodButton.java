import java.awt.*;
import javax.swing.*;

public class FoodButton extends JButton {//푸드 패널에 들어가는 데이터
	//푸드 영양소 데이터 및 사진 들
	private double fat;
	private double calories;
	private double protein;
	private double tansoo;
	private String name;
	private ImageIcon imageIcon;
	private String imageIconPath;
	private Image image;
	
	//생성자
	public  FoodButton(FoodButton f) {
		fat = f.fat;
		calories = f.calories;
		protein = f.protein;
		tansoo = f.tansoo;
		name = f.name;
		imageIconPath = f.imageIconPath;
		imageIcon = new ImageIcon(imageIconPath);
		image = imageIcon.getImage();
	}
	
	// get
	public double getFat()			{ return fat;		}
	public double getCalories()		{ return calories;	}
	public double getProtein()		{ return protein;	}
	public double getTansoo()		{ return tansoo;	}
	public String getName()			{ return name;		}
	public String getImageIconPath() {return imageIconPath;}
	public ImageIcon getImageIcon(){
		return imageIcon;
	}
	// set
	public void setImageIconPath(String imageIconPath) {this.imageIconPath =  imageIconPath;}
	public void setImage() {image=new ImageIcon(imageIconPath).getImage();}
	public void setFat(double fat)				{ this.fat = fat;			}
	public void setCalories(double calories)	{ this.calories = calories; }
	public void setProtein(double protein)		{ this.protein = protein;	}
	public void setTansoo(double tansoo)		{ this.tansoo = tansoo;		}
	public void setName(String name)			{ this.name = name;			}

	FoodButton() {//생성자
		super();
	}

	FoodButton(ImageIcon x) {//생성자 - 이미지
		super(x);
		image = x.getImage();		
		this.setPreferredSize(new Dimension(185, 100));
	}
	public void paintComponent(Graphics g) {// 버튼 그림에 이미지 그리기
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this );
	}
}