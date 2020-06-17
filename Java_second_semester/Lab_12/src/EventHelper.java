package lab12;


import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EventHelper {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Integer> resultOfSearch = new ArrayList<Integer>();

	public static ArrayList<String> enterparticipants(){
		ArrayList<String> participants = new ArrayList<String>();
		System.out.println("Enter Participant`s names (click double Enter to stop adding): ");
		String current = sc.nextLine();
		while(!current.equals("")) {
			if(checkParticipant(current)) {
				participants.add(new String(current));
				current = sc.nextLine();
			}
			else {
				System.out.print("WARNING: Invalid participant name. Try again: ");
				current = sc.nextLine();
			}
		}
		return participants;
	}

	public static boolean checkParticipant(String name) {
		return name.matches("[A-Z][a-z]*");
	}

	public static boolean checkDate(String date) {
		return date.matches("\\d{2}/\\d{2}/\\d{4}");
	}
	
	public static boolean check_participant(ArrayList<String> participants) {
		for(String str : participants) {
			if(Pattern.matches("Jack", str) || Pattern.matches("Kurt", str)) 
				return true;
		}
		return false;
	}

	public static String enterDescription() {
		System.out.print("Enter description: ");
		String description = sc.nextLine();
		return description;
	}
	public static String enterDuration() {
		System.out.print("Enter duration in hours: ");
		String duration = sc.nextLine();
		return duration;
	}
	public static Date enterDate() {
		System.out.print("Enter date (in DD/MM/YYYY format): ");
		Date theDate = null;
		try {
			String date = sc.nextLine();
			while(!checkDate(date)) {
				System.out.print("WARNING: Invalid date. Try again: ");
				date = sc.nextLine();
			}
			theDate = new SimpleDateFormat("ddMMyyyy").parse(date.replaceAll("/", ""));
		} catch (ParseException e) {
			System.out.println(e);
		}
		return theDate;
	}
	public static String enterAddress() {
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		return address;
	}
	public static String enterCity() {
		System.out.print("Enter city: ");
		String city = sc.nextLine();
		return city;
	}

	public static Event newEventAdded() {
		Event Event = new Event();
		Event.setDescription(enterDescription());
		Event.setDuration(enterDuration());
		Event.setDate(enterDate());
		Event.setCity(enterCity());
		Event.setAddress(enterAddress());
		Event.setParticipants(enterparticipants());
		return Event;
	}
	public static Event newEventFromFile(BufferedReader reader) throws IOException {
		Event Event = new Event();
		Event.setDescription(reader.readLine());
		Event.setDuration(reader.readLine());
		try {
			Date theDate = new SimpleDateFormat("ddMMyyyy").parse(reader.readLine().replaceAll("/", ""));
			Event.setDate(theDate);
		} catch (ParseException e) {
			System.out.println(e);
		}

		Event.setAddress(reader.readLine());
		ArrayList<String> participants = new ArrayList<String>();
		String current = reader.readLine();
		while(!current.equals("----")) {
			participants.add(new String(current));
			current = reader.readLine();
		}
		Event.setParticipants(participants);
		return Event;
	}
	public static void removeEvent() {
		attributePrint();
		int choice = MenuHelper.numberEnterer(5);
		while(choice != 0) {
			if(attributeChoice(choice)) {
				System.out.println("Enter number of Event to delete");
				int removeIndex = resultOfSearch.get(MenuHelper.numberEnterer(resultOfSearch.size()));
				MenuHelper.Events.remove(removeIndex);
			}
			attributePrint();
			choice = MenuHelper.numberEnterer(5);
		}
	}
	public static void scanEvent() {
		attributePrint();
		int choice = MenuHelper.numberEnterer(5);
		while(choice != 0) {
			attributeChoice(choice);
			attributePrint();
			choice = MenuHelper.numberEnterer(5);
		}
	}

	public static void sortEvent() {
		int choice;
		sortPrint();
		while((choice = MenuHelper.numberEnterer(5)) != 0) {
			sortChoice(choice);
			sortPrint();
		}
		System.out.println("Canceled");
	}
	public static void attributePrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Description");
		System.out.println("2  - Duration");
		System.out.println("3  - Date");
		System.out.println("4  - Address");
	}
	public static void sortPrint() {
		System.out.println("0  - Cancel");
		System.out.println("1  - Description");
		System.out.println("2  - Duration");
		System.out.println("3  - Participants");
		System.out.println("4  - Date");
	}

	public  void taskSearch() {
		resultOfSearch.clear();
		String searchCity = "Kharkov"; 
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 01, 01, 00, 00, 00);
		Date searchDate = calendar.getTime();
		int index = 0;
		for(Event Event : MenuHelper.Events) {
			if(Event.getCity().indexOf(searchCity) >= 0) {
				if(Event.getDate().after(searchDate)) {
					resultOfSearch.add(MenuHelper.Events.indexOf(Event));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(Event.toString());
				}
			}
		}
	}
	public static boolean attributeChoice(int numMenu) {
		resultOfSearch.clear();
		String search;
		int index = 0;
		switch (numMenu) {
		case 0 :
			System.out.println("Canceled");
			break;
		case 1 : 
			String searchCity = "Kharkov"; 
			Calendar calendar = Calendar.getInstance();
			calendar.set(2017, 01, 01, 00, 00, 00);
			Date searchDate = calendar.getTime();

			for(Event Event : MenuHelper.Events) {
				if(Event.getCity().indexOf(searchCity) >= 0) {
					if(Event.getDate().after(searchDate)) {
						resultOfSearch.add(MenuHelper.Events.indexOf(Event));
						System.out.println(index++ + ") " + "-------------------------------------------------------");
						System.out.println(Event.toString());
					}
				}
			}
			break;
		case 2 :
			search = enterDuration();
			for(Event Event : MenuHelper.Events) {
				if(Event.getDuration().indexOf(search) >= 0) {
					resultOfSearch.add(MenuHelper.Events.indexOf(Event));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(Event.toString());
				}
			}
			break;
		case 3 :
			Date dateSearch = enterDate();
			for(Event Event : MenuHelper.Events) {
				if(Event.getDate().compareTo(dateSearch) == 0) {
					resultOfSearch.add(MenuHelper.Events.indexOf(Event));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(Event.toString());
				}
			}
			break;
		case 4 :
			search = enterAddress();
			for(Event Event : MenuHelper.Events) {
				if(Event.getAddress().indexOf(search) >= 0) {
					resultOfSearch.add(MenuHelper.Events.indexOf(Event));
					System.out.println(index++ + ") " + "-------------------------------------------------------");
					System.out.println(Event.toString());
				}
			}

			break;


		}
		if(resultOfSearch.size() == 0) {
			System.out.println("Oops... Nothing was found.");
			return false;
		}
		return true;
	}

	public static void sortChoice(int numMenu) {
		boolean isSorted = false;
		Event[] o = MenuHelper.Events.getArray(Event.class, MenuHelper.Events.getSize());
		Event temp;
		while(!isSorted) {
			isSorted = true;
			for (int i = 0; i < o.length-1; i++) {
				if(sortStatement(numMenu,o[i],o[i+1])) {
					isSorted = false;

					temp = o[i];
					o[i] = o[i+1];
					o[i+1] = temp;
				}
			}
		}
		for(Event a : o) {
			System.out.println(a.toString());
		}
	}
	private static boolean sortStatement(int numMenu, Event o1, Event o2) {
		switch(numMenu) {
		case 1:
			if(o1.getDescription().compareToIgnoreCase(o2.getDescription()) >= 0) return true;
			else return false;
		case 2:
			if(o1.getDuration().compareToIgnoreCase(o2.getDuration()) >= 0) return true;
			else return false;
		case 3:
			if(o1.getDate().after(o2.getDate())) return true;
			else return false;
		case 4:
			if(o1.getAddress().compareToIgnoreCase(o2.getAddress()) >= 0) return true;
			else return false;
		}
		return false;
	}

}