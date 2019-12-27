package laboratory_tasks;

public class Lab3 {
	
	    public static void divide(String first, String second) {
	    	StringBuffer sb = new StringBuffer(first);
	    	StringBuffer result = new StringBuffer(first);
	    	int i,j;
	        for (j = 0,i=0; j < sb.length(); j++,i++) 
	            if (first.charAt(j) == 'l') {
	                if (first.charAt(j+1) == (' ')) {
	                	result.insert(i+1,second);
	                	i += second.length();
	                } else if (first.charAt(j+1) == ('.')) {
	                	result.insert(i+1,second);
	                	i += second.length();
	                } else if (first.charAt(j+1) == (',')) {
	                	result.insert(i+1,second);
	                	i += second.length();
	                } else if (first.charAt(j+1) == ('!')) {
	                	result.insert(i+1,second);
	                	i += second.length();
	                }
	                    System.out.println(result);
	                }
	            }
	        
	    public static void main (String[] args)
	    {
	        String first = "original textl   ";
	        String second = "123";
	        divide(first, second);
	    }
	}
	

