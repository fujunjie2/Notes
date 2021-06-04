package com.knight.springboot.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

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
 * System.currentTimeMillis() 获取的是当前计算机时间(UTC) 距离 (1970-01-01 00:00:00 UTC时间) 之间的毫秒数差。
 * 而计算机的时间则与当前时区相关。中国虽然跨了5个时区，但是时间统一使用东八时区，即北京时间(CST = GMT + 8)。
 *
 * LocalDateTime.toEpochSeconds 返回的是距离 (1970-01-01 00:00:00 UTC时) 之间的 秒差
 */
public class DateTimeUtils {

    public static LocalDateTime toLocalDateTime(Long timeStamp) {
        return LocalDateTime.ofEpochSecond(timeStamp / 1000, 999_999_999, ZoneOffset.ofHours(8));
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.of(ZoneId.SHORT_IDS.get("CTT"));
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     *
     * @param time 某个日期
     * @return time 所在的月份的第一天， 时分秒为 00:00:00
     */
    public static LocalDateTime monthBeginDate(LocalDateTime time) {
        return LocalDateTime.of(LocalDate.from(time.with(TemporalAdjusters.firstDayOfMonth())), LocalTime.MIN);
    }

    /**
     *
     * @param timeStamp utc 时间戳
     * @return timeStamp 所在的月份的第一天， 时分秒为 00:00:00
     */
    public static LocalDateTime monthBeginDate(long timeStamp) {
        LocalDateTime mt = toLocalDateTime(timeStamp);
        return monthBeginDate(mt);
    }

    /**
     *
     * @param timeStamp utc 时间戳
     * @return timeStamp 所在的月份的最后一天日期， 时分秒为 00:00:00
     */
    public static LocalDateTime monthEndDate(long timeStamp) {
        LocalDateTime med = toLocalDateTime(timeStamp);
        return LocalDateTime.of(LocalDate.from(med.with(TemporalAdjusters.lastDayOfMonth())), LocalTime.MIN);
    }

    /**
     *
     * @param timeStamp utc 时间戳
     * @return timeStamp 所在的月份的最后一天日期， 时分秒为 23:59:59.999_999_999
     */
    public static LocalDateTime monthEndDateTime(long timeStamp) {
        LocalDateTime med = toLocalDateTime(timeStamp);
        return LocalDateTime.of(LocalDate.from(med.with(TemporalAdjusters.lastDayOfMonth())), LocalTime.MAX);
    }


    public static String format(LocalDateTime time, String format) {
        return DateTimeFormatter.ofPattern(format).format(time);
    }
    public static String format(Long timeStamp, String format) {
        LocalDateTime time = toLocalDateTime(timeStamp);
        return format(time, format);
    }

    public static String format(Date date, String format) {
        LocalDateTime time = toLocalDateTime(date);
        return format(time, format);
    }

    public static LocalDateTime parse(String dateStr, String format) {
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(format));
    }


}
