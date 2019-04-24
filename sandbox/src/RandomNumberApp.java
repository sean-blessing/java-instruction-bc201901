
public class RandomNumberApp {

	public static void main(String[] args) {
		// generate a random # between 1 and 100
		double d = Math.random();
		System.out.println(d);
		double d100 = d*100;
		System.out.println(d100);
		int d100i = (int)d100+1;
		System.out.println(d100i);

	}

}
