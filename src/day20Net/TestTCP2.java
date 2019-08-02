package day20Net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cdx on 2019/8/2.
 * desc:client发送文件到server，保存到本地，并返回“发送成功”gei client，并关闭相应的连接
 */
public class TestTCP2 {
    private static final String TAG = "TestTCP2";

    @Test
    public void client() {
        Socket client=null;
        InputStream is = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            client = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            is = client.getInputStream();
            os = client.getOutputStream();
            fis = new FileInputStream(new File("D://1.txt"));
            byte[] b = new byte[30];
            int len;
            while ((len = fis.read(b)) != -1) {

                os.write(b, 0, len);
            }
            client.shutdownOutput();
            int len1;
            byte[] b1 = new byte[100];
            while ((len1 = is.read(b1)) != -1) {
                String str = new String(b1, 0, len1);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fis!=null)

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(os!=null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(client!=null)
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }



    }

    @Test
    public void server() {
        ServerSocket server = null;
        Socket client = null;
        OutputStream os = null;
        OutputStream os1 = null;
        InputStream is=null;
        try {
            server = new ServerSocket(9090);
            client = server.accept();
            os = client.getOutputStream();
            is = client.getInputStream();
            os1 = new FileOutputStream(new File("D://2.txt"));
            byte[] b = new byte[30];
            int len;
            while ((len = is.read(b)) != -1) {
                os1.write(b, 0, len);
            }
            System.out.println("接收完成");
            os.write("发送成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(os1!=null)
                try {
                    os1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(is!=null)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(client!=null)
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(server!=null)
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
