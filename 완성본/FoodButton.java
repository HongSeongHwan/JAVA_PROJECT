import java.awt.*;
import javax.swing.*;

public class FoodButton extends JButton {//Ǫ�� �гο� ���� ������
	//Ǫ�� ����� ������ �� ���� ��
	private double fat;
	private double calories;
	private double protein;
	private double tansoo;
	private String name;
	private ImageIcon imageIcon;
	private String imageIconPath;
	private Image image;
	
	//������
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

	FoodButton() {//������
		super();
	}

	FoodButton(ImageIcon x) {//������ - �̹���
		super(x);
		image = x.getImage();		
		this.setPreferredSize(new Dimension(185, 100));
	}
	public void paintComponent(Graphics g) {// ��ư �׸��� �̹��� �׸���
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this );
	}
}