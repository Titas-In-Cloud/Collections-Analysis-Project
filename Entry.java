
public class Entry {

    private String surname;
    private String initials;
    private String number;

    public String getSurname() {
        return surname;
    }

    public String getInitials() {
        return initials;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEntry(String newSurname, String newInitials, String newNumber){
        this.surname = newSurname;
        this.initials = newInitials;
        this.number = newNumber;
    }

}


