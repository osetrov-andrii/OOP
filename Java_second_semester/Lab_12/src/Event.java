package lab12;

import java.util.*;

public class Event {
    private Date date;
    private String duration;
    private String city;
    private String address;
    private String description;
    private ArrayList<String> participants = new ArrayList<String>();

    public Event() {
        this.date = date;
        this.address = address;
        this.city = city;
        this.description = description;
        this.participants = participants;
    }

    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getDescription() {
        return description;
    }

    public ArrayList<String> getParticipants() {
        return participants;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
   
    public String getDuration() {
        return duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setCity(String City) {
        this.city = city;
    }
    
    public String toString() {
    	String result = "";
		result += String.format("%30s%s\n", "Description: ", description);
		result += String.format("%30s%s\n", "Date:  ", date);
		result += String.format("%30s%s\n", "Participants(S):  ", participants);
		result += String.format("%30s%s\n", "ADDRESS:  ", address);		
		result += String.format("%30s%s\n", "Duration:  ", duration);
		return result;
    }


    
    
}