package com.knight.springboot.utils;


import com.alibaba.druid.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 正则校验工具类
*
* */
public class RegExUtil {
    /*
    * 校验：0-1之间，最多两位小数
    * */
    public static boolean checkTwoDecimalPlaces(String number) {
        boolean result = false;

        try {

            String regex = "\\b0(\\.\\d{1,2})\\b";
            result=Pattern.matches(regex,number);

        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static boolean checkOneDecimalPlaces(String number) {
        boolean result = false;

        try {

            String regex = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1})?$";
            result=Pattern.matches(regex,number);

        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    /*
    * 校验：正整数
    * */
    public static boolean checkPositiveInteger(String number) {

        boolean result = false;

        try {

            String regex = "^\\+?[1-9][0-9]*$";
            result=Pattern.matches(regex,number);

        } catch (Exception e) {
            result = false;
        }
        return result;

    }

    /**
     * 校验正整数或者1位小数
     * @param number
     * @return
     */
    public static boolean checkPositiveIntegerOrOneDecimalPlaces(String number) {

        boolean result = false;

        try {

            String regex = "^\\d*\\.{0,1}\\d{0,1}$";
            result=Pattern.matches(regex,number);

        } catch (Exception e) {
            result = false;
        }
        return result;

    }

    /**
     * 校验姓名, 只允许英文或者汉字,2-8和字符
     * @param name
     * @return
     */
    public static boolean checkName(String name) {
        boolean result = false;
        String regex = "[a-zA-Z\u4E00-\u9FA5]{2,8}";
        result = Pattern.matches(regex, name);
        return result;
    }

    public static boolean checkEmail(String email) {
        String regex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式 编译正则表达式
        Pattern p = Pattern.compile(regex);
        //正则表达式的匹配器
        Matcher m = p.matcher(email);
        //进行正则匹配\
        return m.matches();
    }

    public static boolean checkPhone(String phone) {
        String regex = "^1[3456789]{1}\\d{9}";
        return Pattern.matches(regex, phone);
    }

    public static String[] split(String pattern) {
        String[] result = pattern.split("\\,\\s*|，\\s*");
        List<String> a = Arrays.asList(result);
        return result;
    }

    public static String hidePhone(String phone) {
        if (StringUtils.isEmpty(phone) || phone.length() != 11) return phone;
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String splitIntDate(String date, String split) {
        if (StringUtils.isEmpty(date) || date.length() != 8) return date;
        StringBuilder sp = new StringBuilder();
        sp.append("$1").append(split).append("$2").append(split).append("$3");
        return date.replaceAll("(\\d{4})(\\d{2})(\\d{2})", sp.toString());
    }

    /**
     * 整数三位一断
     * @param  source  10000
     * @return 例      10,000
     */
    public static String splitNumber(Integer source) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return  decimalFormat.format(source);

    }

}
