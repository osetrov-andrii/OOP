package lab_5;

public class Main_v2 {

	public static void main(String[] args) {
		
		String[] string = new String[]{"February","March"};
		//String[] string2 = new String[]{"January","February","March"};
		MyIterator_v2 test = new MyIterator_v2(string);
		//MyIterator_v2 test2 = new MyIterator_v2(string2);
		//test.remove("February");
		//test.add("April");
		//test.clear();
		String[] test2 = test.toArray();
		for(String str : test2) {
			System.out.println(str);
		}
//		System.out.println(test2.toString());
//		System.out.println(test.contains("April"));
//		System.out.println(test.toString());
	}

}
