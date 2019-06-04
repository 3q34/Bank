package day08;

public class Account {
    public Account() {

    }

    private int id;
    private double banlance;
    private double annualInterestRate;

    public Account(int id, double banlance, double annualInterestRate) {
        this.id = id;
        this.banlance = banlance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBanlance() {
        return banlance;
    }

    public void setBanlance(double banlance) {
        this.banlance = banlance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate(double annualInterestRate) {
        return annualInterestRate / 12;
    }

    public void withdraw(double amount) {
        if (banlance >= amount) {
            banlance -= amount;
            System.out.println("取款 = [" + amount + "]");
        } else
            System.out.println("余额不足");
    }

    public void deposite(double amount) {
        banlance += amount;
        System.out.println("存款= [" + amount + "]");
    }
}

class CheckAcount extends Account {


    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    private double overdraft;

    public CheckAcount(int id,double banlance, double annualInterestRate,double overdraft) {
        super(id, banlance, annualInterestRate);
        this.overdraft = overdraft;
    }
    public double getOverdraft() {
        return overdraft;
    }
    public void withdraw(double amount) {
        if (this.getBanlance() >= amount)
            super.withdraw(amount);
        else {
            if (overdraft >= (amount - this.getBanlance())) {

                overdraft -= (amount - this.getBanlance());
                this.setBanlance(0);
            } else
                System.out.println("超过可透支限额");
        }
    }
}
