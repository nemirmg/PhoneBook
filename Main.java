package PhoneBook;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        
        pb.addPhone("Aidar", 111);
        pb.addPhone("Oleg", 2222);
        pb.addPhone("Aidar", 222);
        pb.addPhone("Oleg", 87987);
        pb.addPhone("Oleg", 54546);
        pb.addPhone("Alena", 777);
        pb.addPhone("Oleg", 548);
        pb.addPhone("Oleg", 6549);
        pb.addPhone("Alena", 6549);
        pb.printAll();

        pb.removePhone("Alena", 6549);
        pb.printAll();
    }
}
