package day06.banking2;

public class Account {
    private double balance;
   public Account(double init_balance){
        balance=init_balance;
    }
    public  double getBalance(){
        return balance;
    }
    //cunqian
    public void deposit(double amt){
    balance+=amt;

    }
    public void withdraw(double amt){
       if (balance>=amt)
    balance-=amt;
       else
           System.out.println("余额不足");
    }
}
