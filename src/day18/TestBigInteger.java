package day18;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by cdx on 2019/7/10.
 * desc:
 */
public class TestBigInteger {
    private static final String TAG = "TestBigInteger";
    @Test
    public void test1(){
        BigInteger bi=new BigInteger("12345678");//比intger更大
        BigDecimal bd=new BigDecimal("123423.234");//比float更大
        BigDecimal bd2=new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));//bd除以bd2，四舍五入
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));//四舍五入，保留15位小数点以后
    }
}
