package Lab_8;

import java.util.ArrayList;
import java.util.Scanner;

public class Helper_Event {
    public static Event[] starter() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array:");
		int arraySize = sc.nextInt();
    	Event[] events = new Event[arraySize];
    	for(int i = 0; i < events.length; i++) {
    		System.out.println("............." + (i+1) + "..............");
    		events[i] = new Event();
    		events[i].setDate(enterDate());
    		events[i].setAddress(enterAddress());
    		events[i].setDescription(enterDescription());
    		events[i].setParticipants(enterMobileNumbers());
    		events[i].setTimeOfStart(enterTimeOfStart());
    	}
    	return events;
    }
	public static void showEvents(Event[] events) {
		for(int i = 0; i < events.length; i++) {
			System.out.println("Event #" + (i+1));
			System.out.printf("%30s%s\n", "Date:  ", events[i].getDate());
			System.out.printf("%30s%s\n", "Addres:  ", events[i].getAddress());
			System.out.printf("%30s%s\n", "Description:  ", events[i].getDescription());
			System.out.printf("%30s%s\n", "Participant(S):  ", events[i].getParticipants());
			System.out.printf("%30s%s\n", "Time of start:  ", events[i].getTimeOfStart());
		}
	}
	private static ArrayList<String> enterMobileNumbers(){
		ArrayList<String> mobileNumbers = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter participants (click double Enter to stop adding): ");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    mobileNumbers.add(new String(current));
		    current = sc.nextLine();
		}
		return mobileNumbers;
	}
	private static String enterDate() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date: ");
		String date = sc.nextLine();
		return date;
	}
	private static String enterAddress() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		return address;
	}
	private static String enterDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter description: ");
		String description = sc.nextLine();
		return description;
	}
	private static String enterTimeOfStart() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter time of start and time of spending: ");
		String timeOfStart = sc.nextLine();
		return timeOfStart;
	}
	
}