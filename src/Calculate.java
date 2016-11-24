public class Calculate {
	private static int age;
	private static boolean sex;
	private static int weight;
	private static int height;
	private static double recomCal;
	private static double recomCarbo;
	private static double recomProt;
	private static double recomFat;
	public Calculate () {

		//Åº¼öÈ­¹°
		recomCarbo = 4 * weight;
		
		//Áö¹æ
		if(sex == false)
			recomFat = 58.9;
		else
			recomFat = 43.0;
		
		//Ä®·Î¸®, ´Ü¹éÁú
		if (sex == false) {
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
		else {
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
	}
}
	