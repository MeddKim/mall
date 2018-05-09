package com.mall.core.domain.utils;

import com.google.common.collect.Range;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeUtils {


    public static LocalDateTime parseDate(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        try {
            return LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE).atStartOfDay();
        } catch (DateTimeParseException e) {
            final String[] dateArr = text.split(Constants.DASH);
            if (dateArr.length != 3) {
                return null;
            }
            try {
                return (LocalDate.of(Integer.valueOf(dateArr[0]), Integer.valueOf(dateArr[1]), Integer.valueOf(dateArr[2]))).atStartOfDay();
            } catch (DateTimeParseException ex) {
                return null;
            }
        }
    }

    public static LocalDateTime parseDateTime(String text) {
        if (StringUtils.isEmpty(text)) {
            return null;
        }
        try {
            return LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private TimeUtils() {
        throw new UnsupportedOperationException();
    }

    public static Timestamp now() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

    /**
     * @param timestamp resource
     * @return 2000-01-01 09:00:00
     */
    public static String format(Timestamp timestamp) {
        return null == timestamp ? null : timestamp.toString().substring(0, 19);
    }

    /**
     * @param timestamp resource
     * @return 2000-01-01
     */
    public static String formatDate(Timestamp timestamp) {
        return null == timestamp ? null : timestamp.toString().substring(0, 10);
    }

    /**
     * @param timestamp resource
     * @return 2000-01-01 16:10
     */
    public static String formatDateTimeHour(Timestamp timestamp) {
        return null == timestamp ? null : timestamp.toString().substring(0, 16);
    }

    /**
     * parse unix timestamp to standard timestamp
     *
     * @param unixTimestamp unix timestamp -> 12819380
     * @return 2000-01-03 09:05:12.302
     */
    public static Timestamp parseTime(Long unixTimestamp) {
        if (unixTimestamp == null) {
            return null;
        }
        return new Timestamp(unixTimestamp * 1000);
    }

    /**
     * convert timestamp to unix timestamp
     *
     * @param timestamp timestamp -> 2000-01-03 09:05:12.302
     * @return unix timestamp -> 1501843136
     */
    public static Long formatUnixTimestamp(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timestamp.toInstant().getEpochSecond();
    }


    /**
     * add day from timestamp
     *
     * @param oldTime resource datetime {@link Timestamp}
     * @param days    add days
     * @return new Timestamp {@link Timestamp}
     */
    public static Timestamp addDays(Timestamp oldTime, Integer days) {
        return null != oldTime && null != days ? addDays(oldTime, Long.valueOf(days)) : null;
    }

    /**
     * add day from timestamp
     *
     * @param oldTime resource datetime {@link Timestamp}
     * @param days    add days
     * @return new Timestamp {@link Timestamp}
     */
    public static Timestamp addDays(Timestamp oldTime, Long days) {
        return oldTime != null && days != null
                ? Timestamp.valueOf(oldTime.toLocalDateTime().plusDays(days))
                : null;
    }


    public static Timestamp minusMonth(Timestamp oldTime, Long months) {
        return oldTime != null && months != null
                ? Timestamp.valueOf(oldTime.toLocalDateTime().minusMonths(months))
                : null;

    }

    public static Timestamp addMonth(Timestamp oldTime, Long months) {
        return oldTime != null && months != null
                ? Timestamp.valueOf(oldTime.toLocalDateTime().plusMonths(months))
                : null;
    }

    /**
     * add minutes for timestamp
     *
     * @param oldTime resource datetime {@link Timestamp}
     * @param minutes add minutes
     * @return new Timestamp {@link Timestamp}
     */
    public static Timestamp addMinutes(Timestamp oldTime, Long minutes) {
        return oldTime == null || minutes == null
                ? null
                : Timestamp.valueOf(oldTime.toLocalDateTime().plusMinutes(minutes));
    }


    public static Timestamp parsePeriod(String period) {
        if (StringUtils.isEmpty(period)) {
            period = "0";
        }
        LocalDateTime compareTime;
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfToday = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0);
        switch (period) {
            //in seven days
            case "1": {
                compareTime = startOfToday.with(DayOfWeek.MONDAY);
            }
            break;
            //in month
            case "2": {
                compareTime = startOfToday.withDayOfMonth(1);
            }
            break;
            //all
            case "3": {
                compareTime = startOfToday.withDayOfMonth(1).minusMonths(3);
            }
            break;
            default://today
                compareTime = startOfToday;
        }
        return Timestamp.valueOf(compareTime);
    }

    public static Timestamp getDateStartTime(Timestamp timestamp) {
        return Timestamp.valueOf(timestamp.toLocalDateTime().toLocalDate().atStartOfDay());
    }

    public static Timestamp getDateEndTime(Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        return Timestamp.valueOf(LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 23, 59, 59));
    }

    /**
     * 当前是否是业务繁忙时段
     * [09:00 - 11:59/14:00-16:59]
     *
     * @return true|false
     */
    public static boolean isTransactionBusyTime() {

        final int currentHour = LocalDateTime.now().getHour();

        return Range.closed(9, 11).contains(currentHour) || Range.closed(14, 16).contains(currentHour);
    }

    /**
     * 当前是否是营业时间
     * [07:00 - 22:00]
     *
     * @return true|false
     */
    public static boolean isTransactionTime() {
        //temporary solution without MQ middle machine service
        LocalDateTime localDateTime = LocalDateTime.now();
        // hour: 0-23     6-> '7:00'  21-> '22:00'
        return 6 <= localDateTime.getHour() && localDateTime.getHour() <= 21;
    }
}

