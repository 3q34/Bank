package exer;

import java.util.*;

public class TestCustomer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        List list = new ArrayList();
        Date date =new Date();
        Customer customer = new Customer("Jane", "Smith");
        customer.setAccount(new Account(1000, 2000, 0.0123));
        customer.getAccount().deposite(100);
        customer.getAccount().withdraw(960);
        customer.getAccount().withdraw(2000);
        System.out.println(customer.getFirstname() + customer.getLastname() + customer.getAccount().getBalance());
    }


}
