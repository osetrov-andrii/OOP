import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
    public static void starter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array:");
		int arraySize = sc.nextInt();
    	Account[] accounts = new Account[arraySize];
    	for(int i = 0; i < accounts.length; i++) {
    		System.out.println("//////////////" + (i+1) + "\\\\\\\\\\\\\\\\\\\\\\\\\\");
    		accounts[i] = new Account(enterFullName(), enterBirthday(), enterMobileNumbers(), enterAddress());
    	}
    	showAccounts(accounts);
    }
	public static void showAccounts(Account[] accounts) {
		for(int i = 0; i < accounts.length; i++) {
			System.out.println("PERSON #" + (i+1));
			System.out.printf("%30s%s\n", "NAME:  ", accounts[i].getFullName());
			System.out.printf("%30s%s\n", "BIRTHDAY:  ", accounts[i].getBirthday());
			System.out.printf("%30s%s\n", "MOBILE NUMBER(S):  ", accounts[i].getMobileNumbers());
			System.out.printf("%30s%s\n", "ADDRESS:  ", accounts[i].getAddress());		
			System.out.printf("%30s%s\n", "EDITING TIME:  ", accounts[i].getEditingTime());
		}
	}
	public static ArrayList<String> enterMobileNumbers(){
		ArrayList<String> mobileNumbers = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter mobile numbers (click double Enter to stop adding): ");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    mobileNumbers.add(new String(current));
		    current = sc.nextLine();
		}
		return mobileNumbers;
	}
	public static String enterFullName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter full name: ");
		String fullName = sc.nextLine();
		return fullName;
	}
	public static String enterBirthday() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter birthday: ");
		String birthday = sc.nextLine();
		return birthday;
	}
	public static String enterAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		return address;
	}
}
