package lab9;

import java.util.*;

public class Event {
    private Date date;
    private String timeOfStart;
    private String address;
    private String description;
    private ArrayList<String> participants = new ArrayList<String>();

    public Event(Date date, String address, String description, ArrayList<String> participants, String timeOfStart) {
        this.date = date;
        this.timeOfStart = timeOfStart;
        this.address = address;
        this.description = description;
        this.participants = participants;
    }

    public Date getDate() {
        return date;
    }

    public String getTimeOfStart() {
        return timeOfStart;
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
    
    public String getFullName() {
        return description;
    }
    public void timeOfStart(String address) {
        this.address = address;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setTimeOfStart(String timeOfStart) {
        this.timeOfStart = timeOfStart;
    }


    
    
}