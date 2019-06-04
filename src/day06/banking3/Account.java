package day06.banking3;

public class Account {
    private double balance;
   public Account(double init_balance){
        balance=init_balance;
    }
    public  double getBalance(){
        return balance;
    }
    //cunqian
    public boolean deposit(double amt){
    balance+=amt;
return true;
    }
    public boolean withdraw(double amt){
       if (balance>=amt){
    balance-=amt;
        return true;}
       else
       { //System.out.println("余额不足");
           return false;}

    }
}
