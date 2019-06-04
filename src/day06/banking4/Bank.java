package day06.banking4;

public class Bank {

    private Customer[] customers;
    private int numberOfCustomer;

    public Bank() {
         customers=new Customer[5];
    }

    public void addCustomer(String f, String l) {
        customers[numberOfCustomer] = new Customer(f, l);
        numberOfCustomer++;
    }

    public int getNumOfCustomers() {
        return numberOfCustomer;
    }

    public Customer getCustomer(int index) {
        return customers[index];
    }
}
