package Lab_8;

import java.util.*;

public class Event {
    private String date;
    private String timeOfStart;
    private String address;
    private String description;
    private ArrayList<String> participants = new ArrayList<String>();

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
    
    public void setDate(String date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }
    
    public void setTimeOfStart(String timeOfStart) {
        this.timeOfStart = timeOfStart;
    }


    
    
}