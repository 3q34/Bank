package exer.Exception;

import java.io.*;
import  java.io.FileInputStream;
import java.rmi.server.ExportException;

/**
 * Created by cdx on 2019/6/2.
 * desc:
 */
public class TestException {
    private static final String TAG = "TestException";

    public static void main(String[] args) {
        try{
        method2();}
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            throw new MyException("hah");
        }catch (IOException e){
            System.out.println(e.getStackTrace());
        }
        finally {

        }

    }
    public static void method2() throws FileNotFoundException, IOException {
        method1();
    }
    //throws  IOException或者Exception
    public static void method1() throws FileNotFoundException, IOException {
        FileInputStream fis=new FileInputStream(new File("hello.txt"));
        int b;
        while ((b=fis.read())!=-1){
            System.out.print((char)b);

        }
        fis.close();

    }
}
