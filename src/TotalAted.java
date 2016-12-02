public class TotalAted {
	private static double tCal = 0;
	private static double tCarbo = 0;
	private static double tProt = 0;
	private static double tFat = 0;

	public static double gettCal() {
		return tCal;
	}

	public static void settCal(double tCal) {
		TotalAted.tCal = tCal;
	}

	public static double gettCarbo() {
		return tCarbo;
	}

	public static void settCarbo(double tCarbo) {
		TotalAted.tCarbo = tCarbo;
	}

	public static double gettProt() {
		return tProt;
	}

	public static void settProt(double tProt) {
		TotalAted.tProt = tProt;
	}

	public static double gettFat() {
		return tFat;
	}

	public static void addCarbo(double tCarbo) {
		TotalAted.tCarbo += tCarbo;
	}

	public static void addtFat(double tFat) {
		TotalAted.tFat += tFat;
	}

	public static void addProt(double tProt) {
		TotalAted.tProt += tProt;
	}

	public static void add(FoodButton x) {
		tCarbo += x.getTansoo();
		tFat += x.getFat();
		tProt += x.getProtein();
		tCal += x.getCalories();
	}

	public static void minus(FoodButton x) {
		tCarbo -= x.getTansoo();
		tFat -= x.getFat();
		tProt -= x.getProtein();
		tCal -= x.getCalories();
	}
}
