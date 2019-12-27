package Lab4;

import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		String current;
		current = scanFunction();
		StringBuffer result;
    	result = divide(current);
    	if(args.length != 0) {
	    	if(args[0].equals("-d")) {
	    		debug(current);
	    	}
	    	else if(args[0].equals("-h")) {
	    		infoPrint();
	    	}
    	}
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s ="";
 
        while (!"5".equals(s)){
            System.out.println("1. ����� ������ ������ ������� 1");
            System.out.println("2. ����� �������� ������� ������� ������� 2");
            System.out.println("3. ����� �������� ��������� ������� 3");
            System.out.println("4. ����� �������� ��������� ������� 4");
            System.out.println("5. ����� ����� �� ���������� ������� 5");
            s = scan.next();
                        
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("�������� ����");
            }
            
            switch (x){
                case 1:
                    // ����� ������ 1
                	scanFunction();
                    break;
                case 2:
                    // ����� ������ 2
                	printData(current);
                    break;
                case 3:
                    // ����� ������ 3
                	divide(current);
                	break;
                case 4:
                	//method 4
                	printResult(result);
                	break;
                case 5:
                	System.out.println("Closing...");
                break;
                
            }
        }
        System.out.println("�� ��������!");
    }
    
    private static void debug(String current) {
    	System.out.println("�������� ������: " + current  + "\n");
    	System.out.println("������ �������� �����: " + current.length()  + "\n");
	}

	static String scanFunction(){
		Scanner sc = new Scanner(System.in);
		System.out.println("������� �����:");
		String current = sc.nextLine();
		return current;
		}
    
    
    static void printData (String current) {
			System.out.println(current);
		}
	
    
    public static StringBuffer divide(String first) {
    	StringBuffer sb = new StringBuffer(first);
    	StringBuffer result = new StringBuffer(first);
    	int i,j;
        for (j = 0,i=0; j < sb.length(); j++,i++) 
            if (first.charAt(j) == 'l') {
                if (first.charAt(j+1) == (' ')) {
                	result.insert(i+1,"123");
                	i += 3;
                } else if (first.charAt(j+1) == ('.')) {
                	result.insert(i+1,"123");
                	i += 3;
                } else if (first.charAt(j+1) == (',')) {
                	result.insert(i+1,"123");
                	i += 3;
                } else if (first.charAt(j+1) == ('!')) {
                	result.insert(i+1,"123");
                	i += 3;
                }
                   
                }
             return result;
            }
    
    static void infoPrint() {
    	System.out.println("�����: ������� ������., 1.KIT102.8a");
    	System.out.println("��������� ��������� ����� � �������� ������, ���� ��������� ������ - ����� �����");
    }
    
    static void printResult (StringBuffer result) {
		System.out.println(result);
	}

}