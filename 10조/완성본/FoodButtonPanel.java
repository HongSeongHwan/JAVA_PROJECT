import java.awt.*;
import javax.swing.*;

public class FoodButtonPanel extends JPanel{// Ÿ�� ���� �гο� �߰� �Ǿ���
	//���� ���� ���� �� �̹��� ����
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
	public void paintComponent(Graphics g) { // ������ ũ�⿡ �°� �׷���
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this );
		
	}
}