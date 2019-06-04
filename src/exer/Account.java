package exer;

public class Account {
    private int Id;
    private double balance;
    private double annualInterestRate;

    public Account(int Id, double balance, double annualInterestRate) {
        this.Id = Id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }
    public int getId(){
        return this.Id;
    }
    public double getBalance(){
        return this.balance;
    }
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    public void setId(int Id){
        this.Id=Id;
    }
    public  void setBalance(double balance){
        this.balance=balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public void  withdraw(double amount){
        if(this.balance>amount)
        {this.balance-=amount;
            System.out.println("取出[" + amount + "]");}
        else
            System.out.println("账户余额不足！");
    }
    public void deposite(double amount){
        this.balance+=amount;
        System.out.println("存入 [" + amount + "]");
    }
}
