package PhoneBook;

public class Contact {
    protected int id;
    protected String name;
    
    public Contact(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Contact user = (Contact) obj;
        return name == user.name;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
