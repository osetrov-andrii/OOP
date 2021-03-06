package lab13;

import ua.khpi.oop.osetrov11_12.*;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Calendar;

public class DataGenerator {

    public static NewLinkedList<Prisoner> generator(int size) {
        char b, c;
        NewLinkedList<Prisoner> list = new NewLinkedList<>();
        String[] namesOfDays = new String[]{
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < size; i++) {
        	final Random random = new Random();
        	int sits, num, sits_a;
        	Prisoner test = new Prisoner();
        	    
            StringBuilder numberGenerator = new StringBuilder("Test");
            int randomNum = (int) (Math.random() * 55 + 10);
            numberGenerator.append(randomNum);
            
            int randomDob = (int) (Math.random() * 55 + 11);
            Calendar newDob = new GregorianCalendar(randomDob, randomDob, randomDob);
            int randomImp = (int) (Math.random() * 55 + 12);
            Calendar newImp = new GregorianCalendar(randomImp, randomImp, randomImp);
            int randomRelease = (int) (Math.random() * 55 + 13);
            Calendar newRelease = new GregorianCalendar(randomRelease, randomRelease, randomRelease);
                
            test.setFirstName(numberGenerator.toString());
            test.setLastName(numberGenerator.toString());
            test.setPatronymic(numberGenerator.toString());
            test.setDob(newDob);
            test.setEyeColor(numberGenerator.toString());
            test.setImprisonmentDate(newImp);
            test.setReleaseDate(newRelease);
            test.setTattooDescription(numberGenerator.toString());
            
            list.add(test);
        }
        return list;
    }
}
