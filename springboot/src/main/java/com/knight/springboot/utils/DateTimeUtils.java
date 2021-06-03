package com.knight.springboot.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 地球分24个时区，相邻的时区时间差一小时
 * GMT 即是格林威治时间，是旧时间标准。它是0时区，即本初子午线的时间.
 *      GMT根据地球的公转自转来计时，由于地球的自传速度越来越慢，且速度不均匀，导致每年都会比上一年多几毫秒,
 * UTC 即 世界协调时，是新的时间标准。
 *     UTC 根据原子钟计时，50亿年才会有1秒的误差。
 * GMT = UTC + 0
 * 如果不涉及到秒以下的计算，GMT 可以等同于 UTC
 *
 * 润秒：当“世界时”与“原子时” 之间时刻相差超过0.9秒时，就在“协调世界时”上加上或减去1秒，以尽量接近“世界时”，这就是闰秒
 *
 * System.currentTimeMillis() 获取的是当前计算机时间 距离 (1970-01-01 00:00:00) 之间的毫秒数差。
 * 而计算机的时间则与当前时区相关。中国虽然跨了多个时区，但是时间统一使用东八时区，即北京时间(CST = GMT + 8)。
 *
 * LocalDateTime.toEpochSeconds 返回的是距离 (1970-01-01 00:00:00) 之间的 秒差
 */
public class DateTimeUtils {


    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(8)));
        System.out.println(System.currentTimeMillis());
    }
}
