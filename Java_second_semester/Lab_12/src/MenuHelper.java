package lab12;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class MenuHelper {
	static UserLinkedList<Event> Events = new UserLinkedList<Event>();
    static Scanner userInput = new Scanner(System.in);
    static boolean isAuto;
    static public void starter(String[] arg)  {
    	if(arg.length == 0) {
    		isAuto = false;
    		consoleMode();
    	} else if("-auto".equals(arg[0])) {
    		isAuto = true;
    		autoMode();
    	}
    }
    static public void autoMode() {
		try {
			FileReader filereader = new FileReader(directory());
			BufferedReader reader = new BufferedReader(filereader);
			String line = reader.readLine();
			int size = Integer.parseInt(line);
			int index = 0;
			while (index++ < size) {
				Events.add(EventHelper.newEventFromFile(reader));
            }
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		consoleMode();
    }
	static public void consoleMode() {
        menuPrint();
        int choice =numberEnterer(11);
        while(choice != 0) {
        	menuChoice(choice);
			choice = numberEnterer(11);
        }
        System.out.println("Closing...");
	}
	static void menuChoice(int numMenu) {
		switch (numMenu) {
		case 1 : 
			if(isAuto)	
				System.out.println("Sorry, in auto mode this function is not available");
			else
				Events.add(EventHelper.newEventAdded());
			break;
		case 2 :
			if(Events.getSize() == 0) System.out.println("Enter data first.");
			else System.out.println(Events.toString());
			break;
		case 3 :
			if(Events.getSize() == 0) System.out.println("Enter data first.");
			else EventHelper.removeEvent();
			break;
		case 4 :
			if(Events.getSize() == 0) System.out.println("Enter data first.");
			else Events.clear();
			break;
		case 5 :
			if(Events.getSize() == 0) System.out.println("Enter data first.");
			else EventHelper.scanEvent();
			break;
		case 6 :
			if(Events.getSize() == 0) System.out.println("Enter data first.");
			else Events.xmlSaver(directory());
			break;
		case 7 :
			Events.xmlLoader(directory());
			break;
		case 8 :
			if(Events.getSize() == 0) System.out.println("Enter data first.");
			else
				try {
					Events.saveContainer(directory());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			break;
		case 9 :
			try {
				Events.recoverContainer(directory());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 10 :
			EventHelper.sortEvent();
			break;
		default:
			System.out.println("Try again");
		}
	}
	static void menuPrint() {
		System.out.println("0  - Exit");
		System.out.println("1  - Enter Event");
		System.out.println("2  - Show all Events");
		System.out.println("3  - Remove Event");
		System.out.println("4  - Remove all Events");
		System.out.println("5  - Scan Event");
		System.out.println("6  - Use XML encoder");
		System.out.println("7  - Use XML decoder");
		System.out.println("8  - Serialize data");
		System.out.println("9  - Deserialize data");
		System.out.println("10 - Sort data");
	}
	static String directory() {
		Scanner dirsc = new Scanner(System.in);
		int index_const = 3, index2, index3, choice;
		String fileName = writeFileName();
		File file = new File(fileName);
		File file2 = new File(file.getAbsolutePath());
		String currPos = file2.getParent();
		while(true) {
			index2 = 0;
			index3 = 0;
			File currFolder = new File(currPos);
			File[] folders = currFolder.listFiles();
			int[] indexes = new int[folders.length];

			System.out.printf("%-30s","1) .");
			System.out.printf("%-30s","2) ..");
			for(int i = 0; i < folders.length; i++) {
				if(folders[i].isDirectory() && !folders[i].isHidden())   {
					indexes[index2] = i;
					if(index2%4 == 3) System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					else if(index2%4 == 2) System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					else if(index2%4 == 1) System.out.printf("%-30s\n", (index_const + index3++) + ") " + folders[i].getName());
					else System.out.printf("%-30s", (index_const + index3++) + ") " + folders[i].getName());
					index2++;
				}
			}
			System.out.print("\n" + currPos + "> ");
			choice = dirsc.nextInt();
			if(choice == 1) 
				break;
			else if(choice == 2 && currFolder.getParent() != null) {
				currPos = currFolder.getParent();
			}
			else if((choice-index_const) < index2 && (choice-index_const) >= 0) {
				currPos = folders[indexes[choice-index_const]].getAbsolutePath();
			}
			else {
				System.out.println("Try again.");
			}
		}
		return currPos + "\\" + fileName;
	}
	private static String writeFileName() {
		System.out.print("Enter file name: ");
		String fileName = userInput.nextLine();
		return fileName;
	}
	public static int numberEnterer(int size) {
		String input = "";
		int userChoice;
		while (true) {
			System.out.print("[" + Events.getSize() + "]" + " User> ");
			input = userInput.nextLine();
			try {
				userChoice = Integer.parseInt(input);
				if(userChoice >= 0 && userChoice < size) 
					break;
			} catch (Exception e){
				
			}
		}
		return userChoice;
	}
}