package laboratory_tasks;
import java.util.Random;

public class Lab2 {
	
	public static void sumCount() {
		for(int i = 0; i < 10; ){
			int sum = 0;
			int min = 100;
			int max = 200;
			int diff = max - min;
			Random random = new Random();
			int number = random.nextInt(diff + 1);
			number += min;
			int tmp = number;
			
			while(number != 0){
		        sum += (number % 10);
		        number/= 10;
		        if(number == 0) {
		        i++;
		        }
		}
		    System.out.println("×èñëî: " + tmp + ". Ñóììà öèôð: " + sum);
		}
	}
		
	public static void main(String[] args) {
		sumCount();
	
	}
}
