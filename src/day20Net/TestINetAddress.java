package day20Net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by cdx on 2019/8/2.
 * desc:
 */
public class TestINetAddress {
    private static final String TAG = "TestINetAddress";

    @Test
    public void test() throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
        InetAddress inetAddress1=InetAddress.getLocalHost();
        System.out.println(inetAddress1.getHostName());
    }
}

