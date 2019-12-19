public class Lab_1 {
	public static void main(String[] argc) {
		int count_of_odd = 0;
		int num_of_values = 5;
		int count_one = 0;
		int total_count_one = 0;
		long mobile_num = 380992705267L;
		int student_num = 0x3;
		int eight_num = 012223;
		int binary_num = 0b1000011;
		char letter = '\23';
		
		if((mobile_num%2) == 1) count_of_odd++;
		if((student_num%2) == 1) count_of_odd++;
		if((eight_num%2) == 1) count_of_odd++;
		if((binary_num%2) == 1) count_of_odd++;
		if((letter%2) == 1) count_of_odd++;
		for(char cc : Long.toBinaryString(mobile_num).toCharArray()) {
			System.out.print(cc);
			if(cc == '1') {
				total_count_one++;
				count_one++;
			}
		}
		System.out.println(": (" + mobile_num + ") "+ count_one);
		count_one = 0;
		for(char cc : Integer.toBinaryString(student_num).toCharArray()) {
			System.out.print(cc);
			if(cc == '1') {
				total_count_one++;
				count_one++;
			}
		}
		System.out.println(": (" + student_num + ") "+ count_one);
		count_one = 0;
		for(char cc : Integer.toBinaryString(eight_num).toCharArray()) {
		  	System.out.print(cc);
			if(cc == '1') {
				total_count_one++;
				count_one++;
			}
		}
		System.out.println(": (" + eight_num + ") "+ count_one);
		count_one = 0;
		for(char cc : Integer.toBinaryString(binary_num).toCharArray()) {
			System.out.print(cc);
			if(cc == '1') {
				total_count_one++;
				count_one++;
			}
		}		
		System.out.println(": (" + binary_num + ") "+ count_one);
		count_one = 0;
		for(char cc : Integer.toBinaryString((int)letter).toCharArray()) {
			System.out.print(cc);
			if(cc == '1') {
				total_count_one++;
				count_one++;
			}
		}
		System.out.println(": (" + (int)letter + ") " + count_one);
		System.out.println("Кол-во единиц = " + total_count_one);
		System.out.println("Кол-во четных = " + (num_of_values - count_of_odd));
		System.out.println("Кол-во нечетных = " + count_of_odd);
		System.out.println("Збільшене на одиницю значення залишку від"
				+ " ділення на 26 зменшеного на одиницю номера студента в журналі групи = " + ((((3-1)%26) + 1)));
	}
}
