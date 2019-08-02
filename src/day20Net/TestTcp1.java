package day20Net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cdx on 2019/8/2.
 * desc:客户端给服务端发信息，服务端将信息输出到控制台
 */
public class TestTcp1 {
    private static final String TAG = "TestTcp1";

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is=null;
        try {
            //创建发送端client对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            //创建输出流对象
            os = socket.getOutputStream();
            //输出流对象赋值
            os.write("我是客户端,请多关照".getBytes());
            socket.shutdownOutput();
            is=socket.getInputStream();
            int len;
            byte[] b=new byte[100];
            while ((len=is.read(b))!=-1){
                String str=new String(b,0,len);
                System.out.println(str);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if (os != null)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (socket != null) try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket s = null;
        InputStream is = null;
        OutputStream os=null;
        try {
            //    a)、创建ServerSocket对象绑定监听端口。
            ss = new ServerSocket(9090);
            //    b)、通过accept()方法监听客户端的请求。
            s = ss.accept();//获得客户端socket对象
            //2、调用accept()方法开始监听，等待客户端的连接
                          //使用accept()阻塞等待客户请求，有客户
                          //请求到来则产生一个Socket对象，并继续执行
            //    c)、建立连接后，通过输入输出流读取客户端发送的请求信息。
            is = s.getInputStream();
            //创建读取
            byte[] b=new byte[1024];
            int len;
            while ((len=is.read(b))!=-1){
                String str=new String(b,0,len);
                System.out.println("来自"+s.getInetAddress().getHostName()+"的消息：" + str);
            }
            os=s.getOutputStream();
            os.write("我已收到你的情谊".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null)
                if(os!=null)
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(s!=null)
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(ss!=null)
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


    }
}
