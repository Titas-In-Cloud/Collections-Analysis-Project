
public class Entry {

    private String surname;
    private String initials;
    private int number;

    public String getSurname() {
        return surname;
    }

    public String getInitials() {
        return initials;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setEntry(String newSurname, String newInitials, int newNumber){
        this.surname = newSurname;
        this.initials = newInitials;
        this.number = newNumber;

    }

}


