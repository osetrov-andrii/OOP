import java.util.*;

class Helper {
	static ArrayList<StringBuilder> list;
	static double averValue;
	static boolean dataIsReady;
	static boolean debug;
    static void menuPrint() {
        System.out.println("1 - enter data");
        System.out.println("2 - show data;");
        System.out.println("3 - do calculations");
        System.out.println("4 - show the result;");
        System.out.println("5 - exit");
        if(debug) System.out.printf("DEBUGGING: Average value = %.2f\n", averValue);
    }
   static void menuChoice(int numMenu) {
        switch (numMenu) {
            case 1 : 
            	Helper.scanFunction();
            break;
            case 2 : 
            	if(dataIsReady) 
            		Helper.printData(list);
            	else
            		System.out.println("Enter data first");
            break;
            case 3 :
            	if(dataIsReady) 
            		Helper.averageValue(list);
            	else
            		System.out.println("Enter data first");
            break;
            case 4 : 
            	if(dataIsReady && averValue != 0)
            		Helper.printResult(list, averValue);
            	else
            		System.out.println("Enter data and do calculations");
            break;
            case 5:
            	System.out.println("Closing...");
            break;
            default:
                System.out.println("Try again");
        }
    }
	static void scanFunction(){
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<StringBuilder>();
		System.out.println("Enter the text:");
		String current = sc.nextLine();
		while(!current.equals("")) {
		    list.add(new StringBuilder(current));
		    current = sc.nextLine();
		}
		if(debug) System.out.println("DEBUGGING: entered strings = " + list.size());
		dataIsReady = true;
	}
	static void averageValue (ArrayList<StringBuilder> list) {
		int sum = 0;
		for(StringBuilder str : list) {
			sum += str.length();
		}
		averValue = (double)sum/list.size();
		System.out.println("Average length = " + averValue);
	}
	static void printResult (ArrayList<StringBuilder> list, double aver) {
		System.out.println("Less than average length:");
		for(StringBuilder str : list) {
			if(str.length() < aver) {
				System.out.println("   " + str);
			}
		}
		System.out.println("More or equel:");
		for(StringBuilder str : list) {
			if(str.length() >= aver) {
				System.out.println("   " + str);
			}
		}
	}
	static void printData (ArrayList<StringBuilder> list) {
		for(StringBuilder str : list) {
			System.out.println("   " + str);
		}
	}
}