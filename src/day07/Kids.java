package day07;

public class Kids extends ManKind {
    private int yearsOld;
    public void printAge()
    {
        System.out.println(this.yearsOld);
    }
    public void employeed(int salary){
        if(salary==0)
            System.out.println("no job");
        else System.out.println("job");
    }
    public static void main(String[] args) {
        Kids kids=new Kids();
        kids.manOrWomen(0);
        kids.employeed(2);
    }
}
