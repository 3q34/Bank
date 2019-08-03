package day20Net;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by cdx on 2019/8/2.
 * desc:同一资源定位符
 */
public class TestURL {
    private static final String TAG = "TestURL";

    @Test
    public void test() throws Exception {
        URL url = new URL("http://127.0.0.1:8080/Example/2.txt");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
        //将资源读取进来
        InputStream is = url.openStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            String str = new String(b, 0, len);
            System.out.println(str);
        }
        is.close();

        //如果需要读写，URLConnection
        URLConnection urlCon = url.openConnection();
        InputStream is1 = urlCon.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("D://1.txt"));
        byte[] b1 = new byte[1024];
        int len1;
        while ((len1 = is1.read(b1)) != -1) {
            fos.write(b1, 0, len1);
            String st=new String(b1,0,len1);
            System.out.println(st);
        }
        System.out.println("输出完成");
        fos.close();
    }
}
