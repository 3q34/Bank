package day06.banking3;

public class Customer {
    private String  firstname;
    private  String lastname;
    private Account account;
    public Customer(String f, String  l){
        firstname=f;
        lastname=l;
    }
    public  String getFirstName(){
        return firstname;
    }
    public String getLastName(){
        return lastname;
    }
    public Account getAccount(){
        return account;
    }
    public void setAccount(Account acct){
        account=acct;
    }
}
