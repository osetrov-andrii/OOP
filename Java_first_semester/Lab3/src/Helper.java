package ua.khpi.zozulya;
import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
	private static ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
	private static double averageValue;
	static ArrayList<StringBuilder> scanFunction(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    list.add(new StringBuilder(current));
		    current = sc.nextLine();
		}
		return list;
	}
	static void calculateAverageValue () {
		int sum = 0;
		for(StringBuilder str : list) {
			sum += str.length();
		}
		averageValue = (double)sum/list.size();
		System.out.println("Average length = " + averageValue);
	}
	static void printResult () {
		if(arrayIsEmpty()) return;
		System.out.println("Less than average length:");
		for(StringBuilder str : list) {
			if(str.length() < averageValue) {
				System.out.println("   " + str);
			}
		}
		System.out.println("More or equel:");
		for(StringBuilder str : list) {
			if(str.length() >= averageValue) {
				System.out.println("   " + str);
			}
		}
	}
	private static boolean arrayIsEmpty(){
		if(list.size() == 0) System.out.println("Enter the text first");
		return (list.size() == 0);
	}
}
