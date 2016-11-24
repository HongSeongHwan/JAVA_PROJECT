
public class PrivateInfo {
	private static int age;
	private static boolean sex;
	private static int weight;
	private static int height;
	
	public PrivateInfo(){};
	public PrivateInfo(int age, boolean sex, int weight, int height) {
		PrivateInfo.age = age;
		PrivateInfo.sex = sex;
		PrivateInfo.weight = weight;
		PrivateInfo.height = height;
	}
	
	public static int getAge() {
		return age;
	}
	public static void setAge(int age) {
		PrivateInfo.age = age;
	}
	public static boolean isSex() {
		return sex;
	}
	public static void setSex(boolean sex) {
		PrivateInfo.sex = sex;
	}
	public static int getWeight() {
		return weight;
	}
	public static void setWeight(int weight) {
		PrivateInfo.weight = weight;
	}
	public static int getHeight() {
		return height;
	}
	public static void setHeight(int height) {
		PrivateInfo.height = height;
	}
}
