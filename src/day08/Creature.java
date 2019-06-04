package day08;

public class Creature {

    public Creature(){
        System.out.println("空参");
    }
}
class Anaimal extends Creature{
    public Anaimal(){

        System.out.println("Animal一个参数");
    }

    public Anaimal(String name){

        System.out.println("一个参数");
    }
    public static void main(String[] args) {

//        Account account=new Account(1122,2000,0.045);
//        account.withdraw(30000);
//        System.out.println("余额 = [" + account.getBanlance() + "]");
//        account.deposite(3000);
//        System.out.println("余额 = [" + account.getBanlance() + "]"+"月利率=["+account.getMonthlyInterestRate(account.getAnnualInterestRate())+"]");
    CheckAcount checkAcount=new CheckAcount(1122,2000,0.045,5000);
    checkAcount.withdraw(5000);
        System.out.println("余额 = [" + checkAcount.getBanlance()+ "]"+"可透支额 = [" + checkAcount.getOverdraft() + "]");
        checkAcount.withdraw(18000);
        System.out.println("余额 = [" + checkAcount.getBanlance()+ "]"+"可透支额 = [" + checkAcount.getOverdraft() + "]");
        checkAcount.withdraw(3000);
        System.out.println("余额 = [" + checkAcount.getBanlance()+ "]"+"可透支额 = [" + checkAcount.getOverdraft() + "]");

    }
}
