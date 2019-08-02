package day20Net;

import org.junit.Test;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by cdx on 2019/8/2.
 * desc:同一资源定位符
 */
public class TestURL {
    private static final String TAG = "TestURL";

    @Test
    public void test() throws  Exception {
        URL url = new URL("http://127.0.0.1:8080/cyx");
        System.out.println( url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getQuery());
        InputStream is=url.openStream();
        byte[] b=new byte[1024];
        int len;
        while ((len=is.read(b))!=-1){
            String str=new String(b,0,len);
            System.out.println(str);
        }
        is.close();
    }
}
