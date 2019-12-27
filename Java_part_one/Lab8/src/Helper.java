package Lab_8;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class Helper {
	static Event[] events;
	static int size;
	static public void starter() throws ClassNotFoundException, IOException {
        Scanner userInput = new Scanner(System.in);
        int x = 0;
        String s ="";
        menuPrint();
        while (!"6".equals(s)) {
        	System.out.print("[" + size + "]" + " User> ");
        	 s = userInput.next();
        	 try {
                 x = Integer.parseInt(s);
                 menuChoice(x);
             } catch (NumberFormatException e){
                 System.out.println("Try again");
             }
        }
	}
	static void menuChoice(int numMenu) throws IOException, ClassNotFoundException {
		switch (numMenu) {
		case 1 : 
			events = Helper_Event.starter();
			size = events.length;
			break;
		case 2 : 
			if(size == 0) System.out.println("Enter data first.");
			else Helper_Event.showEvents(events);
			break;
		case 3 :
			if(size == 0) System.out.println("Enter data first.");
			else clearEvents();
			break;
		case 4 :
			if(size == 0) System.out.println("Enter data first.");
			else encoder(events);
			break;
		case 5 :
			events = decoder();
			size = events.length;
			break;
		case 6 :
			System.out.println("Closing...");
			break;
		default:
			System.out.println("Try again");
		}
	}
	static void menuPrint() {
		System.out.println("1  - Enter data");
		System.out.println("2  - Show data");
		System.out.println("3  - Remove all data");
		System.out.println("4  - Encode data");
		System.out.println("5  - Decode data");
		System.out.println("6  - Exit");
	}
	static void encoder(Event[] event) throws FileNotFoundException {
		XMLEncoder encoder = new XMLEncoder(
				new BufferedOutputStream(
						new FileOutputStream(directory())));
		encoder.writeObject(event);
		encoder.close(); 
	}
	static Event[] decoder() throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(
				new BufferedInputStream(
						new FileInputStream(directory())));
		Event[] event =  (Event[]) decoder.readObject();
		decoder.close();
		return event; 
	}
	static String directory() {
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
			Scanner sc = new Scanner(System.in);
			System.out.print("\n" + currPos + "> ");
			choice = sc.nextInt();
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
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = sc.nextLine();
		return fileName;
	}
	private static void clearEvents() {
		for(Event acc : events) {
			acc = null;
		}
		size = 0;
	}
}