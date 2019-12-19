
public class Lab_2 {
    public static void main(String[] args){
    	final int max = 10000;
    	System.out.println("Number |Max digit|");
    	System.out.println("------------------");
    	for(int i = 0; i < 10; i++) {
	        int number = rnd(max);
	        int saver = number;
	        byte maxDigit;
	        maxDigit = (byte)(number % 10);
	        while (number > 0) {
	            byte curDigit = (byte)(number % 10);
	            if (curDigit > maxDigit)
	                maxDigit = curDigit;
	            number /= 10;
	        }
	        System.out.printf(" %-6d|    %-5d|\n",saver,maxDigit);
    	}
    }
    static int rnd(int max) {
    	return (int) (Math.random() * ++max);
    }
}