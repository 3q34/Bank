package exer.innerClass;

/**
 * Created by cdx on 2019/5/30.
 * desc:
 */
public class TestProduct {
    private static final String TAG = "TestProduct";

    public static void main(String[] args) {
        TestProduct tp=new TestProduct();
        NoteBook nb=new NoteBook();
        tp.show(nb);
        tp.show(new Product(){
            @Override
            public void getName() {
                System.out.println("HP电脑");
            }

            @Override
            public void getPrice() {
                System.out.println("5000元");
            }
        });
        Product p=new Product() {
            @Override
            public void getName() {
                System.out.println("HP电脑");
            }

            @Override
            public void getPrice() {
                System.out.println("5000元");
            }
        };
        tp.show(p);
    }
    public void show(Product p){
        p.getName();
        p.getPrice();
    }
}
interface Product{
    void getName();
    void getPrice();

}
class NoteBook implements Product{
    @Override
    public void getName() {
        System.out.println("HP电脑");
    }

    @Override
    public void getPrice() {
        System.out.println("5000元");
    }
}