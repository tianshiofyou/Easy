package com.easy.utils;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MoneyUtils {

    /**
     * 保留两位小数 四舍五入
     *
     * @param money
     * @return BigDecimal
     */
    public static BigDecimal DecimalFormat(String money) {
        if (StringUtils.isEmpty(money)) {
            return new BigDecimal("0.00");
        }
        BigDecimal bigDecimal = new BigDecimal(money);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 保留两位小数 四舍五入
     *
     * @param money
     * @return BigDecimal
     */

    public static BigDecimal DecimalFormat(BigDecimal money) {
        //todo 负数全部转换成了0.00
        if (null == money || money.compareTo(new BigDecimal("0.00")) <= 0) {
            return new BigDecimal("0.00");
        }


        return money.setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    public static BigDecimal multiply(BigDecimal fee, BigDecimal rate) {

        if (null == rate || rate.doubleValue() == 0) {
            return fee;
        }

        if (null == fee || fee.doubleValue() == 0) {
            return fee;
        }

        return fee.multiply(rate).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {


        System.out.println(new BigDecimal("11.5").divide(new BigDecimal("100")));

        MathContext context = new MathContext(6, RoundingMode.HALF_UP);
        BigDecimal xysFee = MoneyUtils.multiply(new BigDecimal("600.00"),
                new BigDecimal("11.5").divide(new BigDecimal("100"), context));
        System.out.println(xysFee);

    }
}
