package lab_7;

import java.util.*;

public class Event {
    private String date;
    private String timeOfStart;
    private String address;
    private String description;
    private ArrayList<String> participants = new ArrayList<String>();

    public Event(String date, String address, String description, ArrayList<String> participants, String timeOfStart) {
        this.date = date;
        this.timeOfStart = timeOfStart;
        this.address = address;
        this.description = description;
        this.participants = participants;
    }

    public String getDate() {
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

    
    
}