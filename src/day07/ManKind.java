package day07;

public class ManKind
{
    private int sex;
    private  int salary;
    public void manOrWomen(int sex){

        if(sex==0)
            System.out.println("sex = [女 ]");
        else
            System.out.println("sex = [男]");
    }
    public void employeed(int salary){
        if(salary==0)
            System.out.println("no job");
        else System.out.println("job");
    }
}
