package lab9_10;


public class MainClass {

	 public static void main(String[] args) {
	        try {
	            Helper.starter(args);
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.err.println("Woops........Error");
	            System.err.println(e.getMessage());
	        }
	    }

}

