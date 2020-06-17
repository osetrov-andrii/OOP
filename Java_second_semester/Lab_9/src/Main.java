package lab9;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main {
	//saving in eclipse-workspace directory
	private final static String filename = "..\\savedContainer.xml";
	private final static String filename2 = "..\\savedContainer.txt";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String[] params = {"one","two","three"};
		UserLinkedList<String> list = new UserLinkedList<>(params);
		
		
		
	    System.out.println(list.toString());
	    saveSystem(list);
	    list.clear();
	    System.out.println(list.toString());
	    list = loadSystem();
	    System.out.println(list.toString());
	    list.add("fourth");
	    System.out.println(list.toString());
	    System.out.println(list.remove("five"));
	    System.out.println(list.toString());

	    System.out.println("---------------------------------------------------");
	    
	    saveContainer(list);
	    list.clear();
	    System.out.println(list.toString());
	    list = recoverContainer();
	    System.out.println(list.toString());
	    list.add("fifth");
	    System.out.println(list.toString());
	    System.out.println(list.remove("one"));
	    System.out.println(list.toString());
	    
	    System.out.println("---------------------------------------------------");
	    
		for(Object s : list) {
			System.out.println(s.toString());
		}
	}
	
	
	
	static public void saveContainer(UserLinkedList list) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(filename2);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	    objectOutputStream.writeObject(list);
	    objectOutputStream.close();
	}
	static public UserLinkedList recoverContainer() throws IOException, ClassNotFoundException {
		UserLinkedList list = new UserLinkedList<>();
		FileInputStream fileInputStream = new FileInputStream(filename2);
	    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
	    list = (UserLinkedList) objectInputStream.readObject();
	    objectInputStream.close();
	    return list;
	}
	
	static void saveSystem(UserLinkedList list) {
		try{
  			XMLEncoder encoder = new XMLEncoder(new FileOutputStream(filename));
  			encoder.writeObject(list);
  			encoder.close();
  		} catch (Exception e){
  			System.out.println(e);
  		}
	}
	static UserLinkedList loadSystem() {
		UserLinkedList<Event> list = new UserLinkedList<>();
		try{
			XMLDecoder decoder = new XMLDecoder(new FileInputStream(filename));
			list = (UserLinkedList) decoder.readObject();
			decoder.close();		
		} catch (Exception e){
			System.out.println(e);
		}
		return list;
	}
}