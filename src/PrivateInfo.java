
public class PrivateInfo {
	private static int age;
	private static int sex=0;
	private static int weight;
	private static int height;
	private static double recomCal;
	private static double recomCarbo;
	private static double recomProt;
	private static double recomFat;
		
	// private information
	public PrivateInfo(){};
	public PrivateInfo(int age, int sex, int weight, int height) {
		PrivateInfo.age = age;
		PrivateInfo.sex = sex;
		PrivateInfo.weight = weight;
		PrivateInfo.height = height;
	}	// PrivateInfo()
	
	// privateinfo get/set
	public static int getAge()			{ return age; }	
	public static int getSex()			{ return sex; }
	public static int getWeight()		{ return weight;}	
	public static int getHeight() 		{ return height; }	
	

	public static void setAge(int age)			{ PrivateInfo.age = age;	}
	public static void setSex(int sex)			{ PrivateInfo.sex = sex;	}
	public static void setWeight(int weight)	{ PrivateInfo.weight = weight; }
	public static void setHeight(int height)	{ PrivateInfo.height = height; }
		
	// recom
	public static void recommend() {
		//Åº¼öÈ­¹°
		recomCarbo = 4 * weight;
		
		//Áö¹æ
		if(sex == 1)	//	man
			recomFat = 58.9;
		else			// woman
			recomFat = 43.0;
		
		//Ä®·Î¸®, ´Ü¹éÁú
		if (sex == 1) {	// man
			if (age>=1 && age<=3) {
				recomCal = 1200;
				recomProt = 25;
			}
			else if (age>=4 && age<=6){
				recomCal = 1600;
				recomProt = 30;
			}
			else if (age>=7 && age<=9){
				recomCal = 1800;
				recomProt = 40;
			}
			else if (age>=10 && age<=12){
				recomCal = 2200;
				recomProt = 55;
			}
			else if (age>=13 && age<=19){
				recomCal = 2700;
				recomProt = 75;
			}
			else if (age>=20 && age<=49){
				recomCal = 2500;
				recomProt = 70;
			}
			else if (age>=50 && age<=64){
				recomCal = 2300;
				recomProt = 70;
			}
			else {
				recomCal = 1900;
				recomProt = 60;
			}			
		}
		else {	// woman
			if (age>=1 && age<=3) {
				recomCal = 1200;
				recomProt = 25;
			}
			else if (age>=4 && age<=6) {
				recomCal = 1600;
				recomProt = 30;
			}
			else if (age>=7 && age<=9){
				recomCal = 1800;
				recomProt = 40;
			}
			else if ((age>=10 && age<=12)||(age>=20 && age<=49)){
				recomCal = 2000;
				recomProt = 55;
			}
			else if (age>=13 && age<=19){
				recomCal = 2100;
				recomProt = 65;
			}
			else if (age>=50 && age<=64){
				recomCal = 1900;
				recomProt = 55;
			}
			else {
				recomCal = 1800;
				recomProt = 55;
			}
		}		
	}	// recommend()
	
	// Recom get/set
	public static double getRecomCal()		{ return recomCal;}	
	public static double getRecomCarbo()	{ return recomCarbo; }	
	public static double getRecomProt()		{ return recomProt; }	
	public static double getRecomFat()		{ return recomFat; }
	
	public static void setRecomCal(double recomCal)			{ PrivateInfo.recomCal = recomCal; }
	public static void setRecomCarbo(double recomCarbo) 	{ PrivateInfo.recomCarbo = recomCarbo; }
	public static void setRecomProt(double recomProt)		{ PrivateInfo.recomProt = recomProt; }
	public static void setRecomFat(double recomFat)			{ PrivateInfo.recomFat = recomFat; }	
}
