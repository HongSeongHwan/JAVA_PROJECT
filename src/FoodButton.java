import java.awt.*;
import javax.swing.*;

public class FoodButton extends JButton implements Cloneable {
	private int key;
	private int fat;
	private int calories;
	private int protein;
	private int tansoo;
	private String name;
	
	public FoodButton clone() throws CloneNotSupportedException {
	      return (FoodButton)super.clone();
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

	FoodButton(){
		super();
		this.setPreferredSize(new Dimension(185, 50));
	}
	FoodButton(ImageIcon x){
		super(x);
		this.setPreferredSize(new Dimension(185, 50));
	}
}