package Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Bentao She
 * @Email: harrypotterandsbt@gmail.com
 * @Date: 2022/3/15 12:36
 * @Version: V1.0
 **/

public class Test {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(3000.1200);
        BigDecimal b = a.stripTrailingZeros();
        BigDecimal c = new BigDecimal(b.toPlainString());

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
}
