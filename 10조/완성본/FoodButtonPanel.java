import java.awt.*;
import javax.swing.*;

public class FoodButtonPanel extends JPanel{// 타임 라인 패널에 추가 되어짐
	//음식 영양 정보 및 이미지 정보
	private double fat;
	private double calories;
	private double protein;
	private double tansoo;
	private String name;
	private ImageIcon imageIcon;
	private String imageIconPath;
	private Image image;
	// get
	public double getFat()			{ return fat;		}
	public double getCalories()	{ return calories;	}
	public double getProtein()		{ return protein;	}
	public double getTansoo()		{ return tansoo;	}
	public String getName()		{ return name;		}
	
	// set
	public void setFat(double fat)				{ this.fat = fat;			}
	public void setCalories(double calories)	{ this.calories = calories; }
	public void setProtein(double protein)		{ this.protein = protein;	}
	public void setTansoo(double tansoo)		{ this.tansoo = tansoo;		}
	public void setName(String name)		{ this.name = name;			}
	public FoodButtonPanel (FoodButton f) {		
		fat = f.getFat();
		calories = f.getCalories();
		protein = f.getProtein();
		tansoo = f.getTansoo();
		name = f.getName();
		imageIconPath = f.getImageIconPath();
		imageIcon = new ImageIcon(imageIconPath);
		image = imageIcon.getImage();
		
	}
	public void paintComponent(Graphics g) { // 음식을 크기에 맞게 그려줌
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this );
		
	}
}