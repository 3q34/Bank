package day20Net;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by cdx on 2019/8/2.
 * desc:
 */
public class TestUDP {
    private static final String TAG = "TestUDP";

    @Test
    public void client() {
        DatagramSocket ds = null;//绑定本机任意可用端口
        FileInputStream fis = null;
        DatagramSocket ds1 = null;
        DatagramPacket pack = null;
        DatagramPacket packet = null;
        try {
            fis = new FileInputStream(new File("D://1.txt"));
            ds = new DatagramSocket();
            int len;
            byte[] b = new byte[1024];
            while ((len = fis.read(b)) != -1) {
                pack = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);//目标主机，目标端口
                ds.send(pack);
            }

            byte[] c = new byte[1024];
            ds1 = new DatagramSocket(8090);
            packet = new DatagramPacket(c, 0, c.length);
            ds1.receive(packet);
            String str = new String(packet.getData(), 0, packet.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (ds1 != null)
                try {
                    ds1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (ds != null)
                try {
                    ds.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

    }

    @Test
    public void server() {
        DatagramSocket ds = null;
        DatagramSocket ds1 = null;
        FileOutputStream fos = null;
        DatagramPacket pack = null;
        try {
            ds = new DatagramSocket(9090);
            fos = new FileOutputStream(new File("D://2.txt"));
            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b, 0, b.length);
            ds.receive(packet);
            fos.write(packet.getData(), 0, packet.getLength());
            String str = new String(packet.getData(), 0, packet.getLength());
            byte[] c = str.toUpperCase().getBytes();
            System.out.println(str);
            pack = new DatagramPacket(c, 0, c.length, InetAddress.getByName("127.0.0.1"), 8090);
            ds1 = new DatagramSocket();
            ds1.send(pack);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (ds1 != null)
                try {
                    ds1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            if (ds != null)
                try {
                    ds.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

    }
}
