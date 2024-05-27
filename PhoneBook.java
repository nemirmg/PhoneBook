package PhoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<Contact, ArrayList<Integer>> phonebook = new HashMap<>();
    int id = 0;

    public void addPhone(String name, int phone) {
        if (phonebook.isEmpty() || findContactId(name) == -1) {
            Contact contact = new Contact(id, name);
            ArrayList<Integer> phones = new ArrayList<>();
            phones.add(phone);
            phonebook.put(contact, phones);
            id++;
        } else {
            phonebook.get(findContact(findContactId(name))).add(phone);
        }
    }

    public void removePhone(String name, int phone) {
        phonebook.get(findContact(findContactId(name)))
        .removeAll(Arrays.asList(phone));
    }

    private int findContactId(String contactName) {
        for (Contact c : phonebook.keySet()) {
            if (c.name.equals(contactName))
                return c.id;
        }
        return -1;
    }

    private Contact findContact(int id) {
        for (Contact c : phonebook.keySet())
            if (c.id == id) return c;
        return null;
    }
 
    private String arrayToString(ArrayList<Integer> array) {
        String str = array.toString();
        str = str.substring(1, str.length() - 1);
        return str;
    }
   
    public void printAll() {
        Comparator<ArrayList<Integer>> lengthComparator = new Comparator<>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				return a.size() - b.size();
			}
		};

        phonebook.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(lengthComparator.reversed()))
        .forEach((item)->System.out.println(item.getKey() + " - " + 
        arrayToString(item.getValue())));
    }
}