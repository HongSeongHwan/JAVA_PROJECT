import java.awt.*;
import javax.swing.*;

public class FoodButton extends JButton {
	private double fat;
	private double calories;
	private double protein;
	private double tansoo;
	private String name;
	private ImageIcon imageIcon;
	private Image image;
	
	public  FoodButton(FoodButton f) {
		fat = f.fat;
		calories = f.calories;
		protein = f.protein;
		tansoo = f.tansoo;
		name = f.name;
	}
	
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

	FoodButton() {
		super();
		this.setPreferredSize(new Dimension(185, 50));
	}

	FoodButton(ImageIcon x) {
		image = x.getImage();		
		//super(x);
		//this.setPreferredSize(new Dimension(185, 50));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this );
		
	}
}