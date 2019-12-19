import java.util.Scanner;

public class Lab_4 {
    public static void main(String[] args) {
    	if(args.length != 0) {
	    	if(args[0].equals("-d")) {
	    		Helper.debug = true;
	    	}
	    	else if(args[0].equals("-h")) {
	    		infoPrint();
	    	}
    	}
        Scanner userInput = new Scanner(System.in);
        int x = 0;
        String s ="";
        while (!"5".equals(s)) {
        	 Helper.menuPrint();
        	 s = userInput.next();
        	 try {
                 x = Integer.parseInt(s);
                 Helper.menuChoice(x);
             } catch (NumberFormatException e){
                 System.out.println("Try again");
             }
        }
    }
    static void infoPrint() {
    	System.out.println("Author: Zozulya V., 1.KIT102.8a");
    	System.out.println("Program divides entered string into two groups: those which are shorter than average length");
    	System.out.println("and those which are longer than average length. Then it displays them.");
    }
}