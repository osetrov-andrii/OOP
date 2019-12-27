package Lab_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuHelper {
static String str ;
	static MyIterator list = new MyIterator();
	static ArrayList<StringBuffer> listResult = new ArrayList<StringBuffer>();
	static double averValue;
	static boolean dataIsReady;
    static void menuPrint() {
        System.out.println("1  - enter data");
        System.out.println("2  - show data");
        System.out.println("3  - do calculations");
        System.out.println("4  - show the result");
        System.out.println("5  - add data");
        System.out.println("6  - remove all data");
        System.out.println("7  - remove exact string");
        System.out.println("8  - sort elements");
        System.out.println("9  - save data");
        System.out.println("10 - recover data");
        System.out.println("11 - exit");
    }
    static void menuChoice(int numMenu) throws IOException, ClassNotFoundException {
        switch (numMenu) {
            case 1 : 
            	MenuHelper.scanFunction();
            break;
            case 2 : 
            	if(dataIsReady) MenuHelper.printData();
            	else System.out.println("Enter data str");
            break;
            case 3 :
            	if(dataIsReady) MenuHelper.divide();
            	else System.out.println("Enter data str");
            break;
            case 4 : 
            	if(dataIsReady = true) MenuHelper.printResult();
            	else System.out.println("Enter data and do calculations");
            break;
            case 5 : 
            	if(dataIsReady) MenuHelper.addElement();
            	else System.out.println("Enter data str");
            break;
            case 6 : 
            	if(dataIsReady) { 
            		list.clear();
            		dataIsReady = false;
            	}
            	else System.out.println("Enter data str");
            break;
            case 7 :
            	if(dataIsReady && list.size() != 0) MenuHelper.removeElement();
            	else if(list.size() == 0) dataIsReady = false;
            	else System.out.println("Enter data str");
            break;
            case 8 : 
            	if(dataIsReady) list.sortArray();
            	else System.out.println("Enter data str");
            break;
            case 9 : 
            	if(dataIsReady) saveContainer();
            	else System.out.println("Enter data str");
            break;
            case 10 : 
            	recoverContainer();
            	dataIsReady = true;
            break;
            case 11:
            	System.out.println("Closing...");
            break;
            default:
                System.out.println("Try again");
        }
    }
	static void scanFunction(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    list.add(new String(current));
		    current = sc.nextLine();
		}
		dataIsReady = true;
	}
	public static void divide() {
		for(String str : list) {
			StringBuffer sb = new StringBuffer(str);
			StringBuffer result = new StringBuffer(str);
			int i,j;
			for (j = 0,i=0; j < sb.length(); j++,i++) 
	            if (str.charAt(j) == 'l') {
	                if (str.charAt(j+1) == (' ')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                } else if (str.charAt(j+1) == ('.')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                } else if (str.charAt(j+1) == (',')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                } else if (str.charAt(j+1) == ('!')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                }
	           }
	       }
		}
	
	public static void divideShow() {
		for(String str : list) {
			StringBuffer sb = new StringBuffer(str);
			StringBuffer result = new StringBuffer(str);
			int i,j;
			for (j = 0,i=0; j < sb.length(); j++,i++) 
	            if (str.charAt(j) == 'l') {
	                if (str.charAt(j+1) == (' ')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                } else if (str.charAt(j+1) == ('.')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                } else if (str.charAt(j+1) == (',')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                } else if (str.charAt(j+1) == ('!')) {
	                	result.insert(i+1,"123");
	                	i += 3;
	                }
	                System.out.println(result);
	                }
	       }
		}
		
	static void printData () {
		for(String str : list) {
			System.out.println("   " + str);
		}
	}
	
	static void printResult () {
		System.out.println("Result: ");
		divideShow();
		
		
	}
	static public String[] getElements() {
		return list.toArray();
	}
	static public void starter() throws ClassNotFoundException, IOException {
        Scanner userInput = new Scanner(System.in);
        int x = 0;
        String s ="";
        menuPrint();
        while (!"11".equals(s)) {
        	System.out.print("[" + list.size() + "]" + " User> ");
        	 s = userInput.next();
        	 try {
                 x = Integer.parseInt(s);
                 menuChoice(x);
             } catch (NumberFormatException e){
                 System.out.println("Try again");
             }
        }
	}
	static public void addElement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		list.add(current);
	}
	static public void removeElement() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		if(!list.remove(current)) System.out.println("Cannot find the string :(");;
	}
	static public void saveContainer() throws IOException {
		FileOutputStream outputStream = new FileOutputStream("C:\\Users\\������\\Desktop\\savedContainer.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    objectOutputStream.writeObject(list);
	    objectOutputStream.close();
	}
	static public void recoverContainer() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\������\\Desktop\\savedContainer.txt");
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    list = (MyIterator) objectInputStream.readObject();
	}
	
}