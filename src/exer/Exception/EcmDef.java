package exer.Exception;

import java.util.Scanner;

/**
 * Created by cdx on 2019/6/3.
 * desc:
 */
public class EcmDef {
    private static final String TAG = "EcmDef";

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        args[0] = sc.next();
//        args[1] = sc.next();
//        sc.close();
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        try {
            ecm(i, j);
        } catch (NumberFormatException e) {
            System.out.println("输入的类型不一致");
        }
        catch (ArithmeticException e) {
            System.out.println("分母为0");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        }
        catch (EcDef e) {
            System.out.println("输入的类型不一致");
        }
    }


    public static void ecm(int i, int j) throws EcDef {
        if (i < 0 || j < 0)
            throw new EcDef("请输入正数");
        if (j == 0)
            throw new EcDef("分母不能为0");
        double h = i / j;
        System.out.println(h);
    }
}

class EcDef extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public EcDef(String msg) {

        super(msg);
    }

}
