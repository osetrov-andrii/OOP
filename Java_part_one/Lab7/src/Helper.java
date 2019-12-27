package lab_7;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper {
    public static void starter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of events:");
		int arraySize = sc.nextInt();
    	Event[] events = new Event[arraySize];
    	for(int i = 0; i < events.length; i++) {
    		System.out.println(".............." + (i+1) + "..............");
    		events[i] = new Event(enterDate(), enterAddress(), enterDescription(), enterParticipants(), enterTimeOfStart());
    	}
    	showevents(events);
    }
	public static void showevents(Event[] events) {
		for(int i = 0; i < events.length; i++) {
			System.out.println("Event #" + (i+1));
			System.out.printf("%30s%s\n", "Date:  ", events[i].getDate());
			System.out.printf("%30s%s\n", "Starting time:  ", events[i].getTimeOfStart());
			System.out.printf("%30s%s\n", "Addres:  ", events[i].getAddress());		
			System.out.printf("%30s%s\n", "Description:  ", events[i].getDescription());
			System.out.printf("%30s%s\n", "Participant(S):  ", events[i].getParticipants());
			System.out.printf("%30s%s\n", "Time Of start and time of spending:  ", events[i].getTimeOfStart());
		}
	}
	public static ArrayList<String> enterParticipants(){
		ArrayList<String> mobileNumbers = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter participants (double Enter to stop adding): ");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    mobileNumbers.add(new String(current));
		    current = sc.nextLine();
		}
		return mobileNumbers;
	}
	public static String enterDate() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date of event: ");
		String fullName = sc.nextLine();
		return fullName;
	}
	public static String enterAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter address of event: ");
		String birthday = sc.nextLine();
		return birthday;
	}
	public static String enterDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter description of event: ");
		String address = sc.nextLine();
		return address;
	}
	public static String enterTimeOfStart() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter description of event: ");
		String timeOfStart = sc.nextLine();
		return timeOfStart;
	}
}