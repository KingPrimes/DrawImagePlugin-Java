package io.github.kingprimes.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;
@SuppressWarnings("unused")
public class TimeZoneUtil {

    // 获取系统默认时区
    public static String getSystemTimeZone() {
        return ZoneId.systemDefault().toString();
    }

    // 获取所有可用的时区ID
    public static Set<String> getAllTimeZones() {
        return ZoneId.getAvailableZoneIds();
    }

    // 格式化时间戳为指定时区的时间字符串
    public static String formatTimestamp(Long timestampMillis, String timeZone) {
        if (timestampMillis == null) {
            return null;
        }

        try {
            if (!isValidTimeZone(timeZone)) {
                timeZone = "UTC"; // 默认使用UTC
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.of(timeZone));

            return formatter.format(Instant.ofEpochMilli(timestampMillis));
        } catch (Exception e) {
            return "Invalid timestamp";
        }
    }

    public static String formatTimestamp(Long timestampMillis) {
        return formatTimestamp(timestampMillis, getEffectiveTimeZone());
    }

    // 验证时区ID是否有效
    public static boolean isValidTimeZone(String timeZone) {
        return timeZone != null && getAllTimeZones().contains(timeZone);
    }

    // 获取最终使用的时区
    public static String getEffectiveTimeZone() {
        String startupTimeZone = System.getProperty("user.timezone");

        if (isValidTimeZone(startupTimeZone)) {
            return startupTimeZone;
        }


        String systemTZ = getSystemTimeZone();
        if (isValidTimeZone(systemTZ)) {
            return systemTZ;
        }


        return "UTC";
    }

    /**
     * 获取当前时间戳
     */
    public static Long getTimeStampMillis() {
        return System.currentTimeMillis();
    }





}
