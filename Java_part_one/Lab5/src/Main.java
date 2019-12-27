package Test_Lab5;

public class Main {

	public static void main(String[] args) {
		
		String[] string = new String[]{"Daewoo","Audi"};
//		String[] string2 = new String[]{"Daewoo","Audi","Mercedes"};
		MyIterator test = new MyIterator(string);
//		MyIterator test2 = new MyIterator(string2);
		test.remove("Daewoo");
		test.add("Mazeratti");
//		test.clear();
		String[] test2 = test.toArray();
		for(String str : test2) {
			System.out.println(str);
		}
//		System.out.println(test2.toString());
//		System.out.println(test.contains("April"));
//		System.out.println(test.toString());
	}

}