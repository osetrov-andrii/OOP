package laboratory_tasks;

public class Lab1 {
	public static int evenCount (long number){
		int even = 0;
				 
		while (number > 0) {
				    if (number % 2 == 0) {
				        even += 1;
				    }
				    number = number / 10;
		}
		return even;
	}
	
	public static int oddCount (long number){
		int odd = 0;
				 
		while (number > 0) {
				    if (number % 2 != 0) {
				        odd += 1;
				    }
				    number = number / 10;
		}
		return odd;	
	}
	
	
	public static int oneCount(long n)
	{
	    String s = "";
	    while (n > 0)
	    {
	        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
	        n = n / 2;
	    }
	    int countOnes = 0;
	    for (char element : s.toCharArray()) {
	        if (element == '1') countOnes++;
	    }
	    return countOnes;
	}  
   
		
	public static void main(String[] args) {
		int accountNumber = 0x467C;
		long telephoneNumber = 380956109120l;
		int last2TelephoneNumbers = 0b1100;
		int last4TelephoneNumbers = 03570;
	    char studentLetter = '\14'; 
	    
	    int accountNumberEven = evenCount(accountNumber);
	    int accountNumberOdd = oddCount(accountNumber);
		
	    int telephoneNumberEven = evenCount(telephoneNumber);
	    int telephoneNumberOdd = oddCount(telephoneNumber);

	    int last2TelephoneNumbersEven = evenCount(last2TelephoneNumbers);
	    int last2TelephoneNumbersOdd = oddCount(last2TelephoneNumbers);
	    
	    int last4TelephoneNumbersEven = evenCount(last4TelephoneNumbers);
	    int last4TelephoneNumbersOdd = oddCount(last4TelephoneNumbers);
	    
	    int studentLetterEven = evenCount(studentLetter);
	    int studentLetterOdd = oddCount(studentLetter);
	    
	    
	    int oneCountAccountNumber = oneCount(accountNumber);
	    int oneCountLast2TelephoneNumbers = oneCount(last2TelephoneNumbers);
	    int oneCountLast4TelephoneNumbers = oneCount(last4TelephoneNumbers);
	    int oneCountStudentLetter = oneCount(studentLetter);
	}

}
