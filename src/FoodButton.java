import java.awt.*;
import javax.swing.*;

public class FoodButton extends JButton {
	private int key;
	private int fat;
	private int calories;
	private int protein;
	private int tansoo;
	private String name;
	private ImageIcon imageIcon;
	private Image image;
	public  FoodButton(FoodButton f) {
		key = f.key;
		fat = f.fat;
		calories = f.calories;
		protein = f.protein;
		tansoo = f.tansoo;
		name = f.name;
	}

	public int getKey() {
		return key;

	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getTansoo() {
		return tansoo;
	}

	public void setTansoo(int tansoo) {
		this.tansoo = tansoo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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