import java.util.*;

public class Account {
    private String FullName;
    private String birthday;
    private ArrayList<String> mobileNumbers = new ArrayList<String>();
    private String address;
    private Date editingTime;

    public Account(String fullName, String birthday, ArrayList<String> mobileNumbers, String address) {
        this.FullName = fullName;
        this.birthday = birthday;
        this.mobileNumbers = mobileNumbers;
        this.address = address;
        this.editingTime = new Date();
    }

    public String getFullName() {
        return FullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public ArrayList<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public String getAddress() {
        return address;
    }

    public Date getEditingTime() {
        return editingTime;
    }
}
