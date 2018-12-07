package com.mall.core.domain.utils;



import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class DateUtils {

    /**
     * 日期格式
     */
    public static final String YYYY_MM_DD_DATE_FORMAT = "yyyy-MM-dd";
    public static final String YYYYMMDD_DATE_FORMAT = "yyyyMMdd";
    public static final String YYYY_MM_DD_HH_mm_SS_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_HH_mm_DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String YYYY_MM_DATE_FORMAT = "yyyy-MM";
    public static final String YYYYMMDDHHmmSS_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String YYYYMDDHHMMSS_FORMAT="yyyyMMddHHmmss";
    public static final String MM_DD_FORMAT="MM-dd";
    public static final int LEAP_YEAR_DAYS = 366;
    public static final int NO_LEAP_YEAR_DAYS = 365;


    /**
     * 终止日期30年
     * @throws Exception
     * @Name: getZzrq
     * @Description: @param str
     * @Description: @return
     * @Author: zhangjun
     * @Create Date: 2015年4月14日下午4:57:53
     * @Parameters: DateUtil
     * @Return: int
     */
    public static String getZzrq(String str) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date dt=sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.YEAR,30);//日期减1年
        Date dt1=rightNow.getTime();
        SimpleDateFormat sdfs=new SimpleDateFormat("yyyyMMdd");
        String reStr = sdfs.format(dt1);

        return reStr;
    }


    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }



    /**
     * 按月结算，获取周期
     * @param date
     * @return
     */
    private static String[] getBalanceByMonth(Date date) {
        String[] dates = new String[2];
        dates[0] = getDay(date, 0, 0, Boolean.TRUE, YYYY_MM_DD_DATE_FORMAT);
        dates[1] = getDay(date, 0, 0, Boolean.FALSE, YYYY_MM_DD_DATE_FORMAT);
        return dates;
    }

    /**
     * 按照Date对象取得指定SimpleDateFormat格式的日期字符串。
     *
     * @param date Date对象
     * @param dateFormat  SimpleDateFormat格式
     *
     * @return 指定格式的时间字符串。
     */
    public static String dateToStr(Date date, String dateFormat) {
        if (date == null && dateFormat == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateStr = "";
        try {
            dateStr = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }



    /**
     * 获取一年天数
     *
     * @param year
     * @return
     */
    public static int getTotalDaysPerYear(int year) {
        return isLeapYear(year) ? LEAP_YEAR_DAYS : NO_LEAP_YEAR_DAYS;
    }

    /**
     * 获取月份总天数
     * @param year
     * @param month
     * @return
     */
    public static int getTotalDaysPerMonth(int year, int month) {
        boolean yearleap = isLeapYear(year);
        int day;
        if (yearleap && month == 2) {
            day = 29;
        } else if (!yearleap && month == 2) {
            day = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        } else {
            day = 31;
        }
        return day;
    }

    /**
     * 获取日期 例“2015-01-16, 1, 1, true, yyyy-MM-dd” 输出为2016-02-01
     * @param date
     * @param addYearValue
     * @param addMonthValue
     * @param isFirstDay 如果为true，则是当月第一天，如果为false，则是当月最后一天
     * @return
     */
    public static String getDay(Date date, int addYearValue, int addMonthValue, boolean isFirstDay, String dateFormat) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.YEAR, addYearValue);
        ca.add(Calendar.MONTH, addMonthValue);
        if (isFirstDay) {
            ca.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DATE));
        }
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        return sf.format(ca.getTime());
    }

    /**
     * 获取指定月份的时间， 例“2015-01-16, 4, true, yyyy-MM-dd” 输出为2016-04-01
     * @param date
     * @param month
     * @param isFirstDay 如果为true，则是当月第一天，如果为false，则是当月最后一天
     * @param dateFormat
     * @return
     */
    public static String getDesignatedDay(Date date, int month, boolean isFirstDay, String dateFormat) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.MONTH, month - 1);
        if (isFirstDay) {
            ca.set(Calendar.DAY_OF_MONTH, 1);
        } else {
            ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DATE));
        }
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        return sf.format(ca.getTime());
    }

    /**
     * 获取该date归属月份
     * @param date
     * @return
     */
    public static int getCurrentMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int month = ca.get(Calendar.MONTH);
        return month > 12 ? 1 : month + 1;
    }

    /**
     * 获取该date归属年份
     * @param date
     * @return
     */
    public static int getCurrentYear(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.YEAR);
    }

    /**
     * 格式化日期
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date, String dateFormat) {
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 以date为准，获取第几个月的第几天，如date为（2015-06-15，1,2） 则结果为2015-07-02
     * @param date
     * @param monthNum
     * @param dayNum
     * @return
     */
    public static String getPreOrfurDate(Date date, int monthNum, int dayNum, String dateFormat) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MONTH, monthNum);
        ca.add(Calendar.DAY_OF_MONTH, dayNum);
        return formatDate(ca.getTime(), dateFormat);
    }

    /**
     * 以date为准，操作事件+-days
     * @param date
     * @param dayNum
     */
    public static Date getPreOrfurDate(Date date, int dayNum) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH, dayNum);
        return ca.getTime();
    }

    /**
     * 能被4整除且又能不能被100整除 是闰年,能直接被400整除也是闰年
     *
     * @param year
     * @return
     */
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0);
    }

    public static String getFormatDateTime() {
        GregorianCalendar gca = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_mm_SS_DATE_FORMAT);
        return sdf.format(gca.getTime());
    }

    /*
     * 整数天运算 到秒单位
     */
    public static Long formatDateToLong(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.getTimeInMillis() / 1000;
    }

    /*
     * 秒运算 到date单位
     */
    public static Date formatLongToDate(Long para) {
        return new Date(para * 1000);
    }

    public static long getTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 下一个月1号
     * @param date
     * @return
     */
    public static Date nextMonthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 当月1号
     * @param date
     * @return
     */
    public static Date currentMonthFirstDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static void main(String[] args) throws Exception {
//		System.out.println(DateUtils.formatDate(new Date(), DATE_FORMAT_MD));
        System.out.println("==="+DateUtils.addDaysToDate(new Date(), 2));
    }

    /**
     * 获取现在时间
     *
     * @return返回长时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDateTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return返回长时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);// 设置日期格式
        try {
            return df.parse(df.format(new Date()));
        } catch (ParseException e) {
            log.error("getNowDate error", e);
            // TODO Auto-generated catch block
            // e.printStackTrace();
        } catch (Exception ex) {
            log.error("getNowDate error", ex);
        }
        return null;
    }

    /**
     * 比较beginDate与endDate之间相差的天数 与 days的大小 beginDate>endDate 1 beginDate=endDate 0
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int compare(String beginDate, String endDate) {
        try {
            Calendar end = Calendar.getInstance();
            end.setTime(parse("yyyyMMdd", endDate));
            Calendar begin = Calendar.getInstance();
            begin.setTime(parse("yyyyMMdd", beginDate));

            return begin.compareTo(end);

        } catch (Exception e) {
            log.error("compare error", e);
            return 99;
        }
    }

    public static long countCompareDays(String beginDate, String endDate) {
        try {

            SimpleDateFormat smdf = new SimpleDateFormat("yyyyMMdd");
            Date start = smdf.parse(beginDate);
            Date end = smdf.parse(endDate);
            long days = (end.getTime() - start.getTime()) / (3600 * 24 * 1000);
            return days;
        } catch (Exception e) {
            log.error("countCompareDays error", e);
            return -9999;
        }
    }


    /**
     * 解析27/Feb/2008:10:12:35 +0800类似时间字符串.
     *
     * @param pattern
     * @param strDateTime
     * @param locale
     * @return
     */
    public static Date parse(String pattern, String strDateTime, Locale locale) {
        if (strDateTime == null || pattern == null)
            return null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
            formatter.setLenient(false);
            return formatter.parse(strDateTime);
        } catch (Exception e) {
            log.error("parse error", e);
            return null;
        }
    }

    /**
     * 判断给定日期是否为月末的一天
     *
     * @param date
     * @return true:是|false:不是
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    public static final int getDaysOfCurrYear() {
        return Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    public static int getCurrentDay() {
        Date dates = getNowDate(YYYYMMDD_DATE_FORMAT);
        return dates.getDate();
    }

    /**
     * 判断是否月末
     * @param date
     * @return
     */
    public static boolean isMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            return true;
        else
            return false;
    }

    /**
     * 以分钟为准，操作事件+-分钟
     * @param date
     * @param minNum
     * @return
     */
    public static Date getPreOrfurDateByMin(Date date, int minNum) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.MINUTE, minNum);
        return ca.getTime();
    }

    public static String getNowDateString(String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);// 设置日期格式
        try {
            return df.format(new Date());
        } catch (Exception ex) {
            log.error("getNowDateString error", ex);
        }
        return null;
    }

    /**
     * 比较日期都小时
     */
    public static long compareDateToHour(Date begin, Date end) {
        try {
            long diff = begin.getTime() - end.getTime();
            long hour = diff / (1000 * 60 * 60);
            return hour;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static String getFormatDateTimeWithFormatType(String type) {
        GregorianCalendar gca = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(gca.getTime());
    }

    /***
     * 获取当前日期的秒
     * @return
     */
    public static int getTimeSeconds(Date date){
        Long times = date.getTime();
        Long result = (times / 1000);
        return result.intValue();
    }


    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 字符串日期
     * @param format   如：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String Date2TimeStamp(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



    public static final Map<Integer, String> MTH_MAP = new HashMap<Integer, String>();

    static {
        MTH_MAP.put(1, "Jan");
        MTH_MAP.put(2, "Feb");
        MTH_MAP.put(3, "Mar");
        MTH_MAP.put(4, "Apr");
        MTH_MAP.put(5, "May");
        MTH_MAP.put(6, "Jun");
        MTH_MAP.put(7, "Jul");
        MTH_MAP.put(8, "Aug");
        MTH_MAP.put(9, "Sep");
        MTH_MAP.put(10, "Oct");
        MTH_MAP.put(11, "Nov");
        MTH_MAP.put(12, "Dec");
    }

    public static final String DATE_FORMAT_MD = "M月d日";//常见的日期格式
    public static final String DATE_FORMAT_YM = "yyyy-MM";//常见的日期格式，推荐使用
    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";//常见的日期格式，推荐使用
    public static final String DATE_FORMAT_YMD2 = "yyyyMMdd";
    public static final String OAP_FORMAT_DATETIME = "yyyyMMddHHmmss";//调用一号通的时间格式
    public static final String DATE_FORMAT_JAVA_YMDH24 = "yyyyMMddHH";//常见的java日期时间格式，推荐使用
    public static final String DATE_FORMAT_JAVA_YMDHM24 = "yyyy-MM-dd HH:mm";//常见的java日期时间格式，推荐使用
    public static final String DATE_FORMAT_JAVA_YMDHMS24 = "yyyy-MM-dd HH:mm:ss";//常见的java日期时间格式，推荐使用
    public static final String DATE_FORMAT_JAVA_YMDHMssSSS24 = "yyyyMMddHHmmssSSS";//精确到毫秒的java日期格式
    public static final String DATE_FORMAT_JAVA_YMDHMssSSS24_SHORT = "yyMMddHHmmssSSS";//精确到毫秒的java日期格式
    public static final String DATE_FORMAT_JAVA_YMDHMssSSS = "yyyy-MM-dd HH:mm:ss.SSS";//精确到毫秒的java日期格式
    public static final String DATE_FORMAT_SQL_YMDHM24 = "yyyy-MM-dd HH24:mi";//精确到分钟的sql日期格式
    public static final String DATE_FORMAT_SQL_YMDHMS24 = "yyyy-MM-dd HH24:mi:ss";//精确到秒的sql日期格式
    public static final String DATE_FORMAT_SQL_YMDHMSF24 = "yyyy-mm-dd HH24:mi:ss.ff";//精确到毫秒的sql日期格式
    public static final String MILLISECOND_FORMAT = ".SSS";
    public static final String TIME_FORMAT_YYYYMMDD = "MM/dd/yy h:mm:ss a.SSS";
    public static final String CUSTOM_FORMAT_DATETIME = "YYYY年MM月dd日HH时mm分";//客户短信日期时间格式
    public static final String APP_FORMAT_DATETIME = "YYYY年MM月dd日 HH:mm:ss";//客户短信日期时间格式
    public static final String CUSTOM_FORMAT_DATE = "YYYY年MM月dd日";//客户短信日期格式
    public static final String HOUR_MINUTE_SECOND_FORMAT = "HHmmss";//获取时分秒
    public static final String HOUR_MINUTE_SECOND_JAVA_FORMAT = "HH:mm:ss";//获取时分秒
    public static final String DATE_FORMAT_YMD_SPOT = "yyyy.MM.dd";//常见的日期格式，推荐使用
    public static final String DATE_FORMAT_JAVA_YMDHMS = "yyyy.MM.dd HH:mm:ss";

    public static final String DATE_FORMAT_MD_DOT = "MM.dd";
    /** 西太平洋时间戳 用于SF中间的转换 **/
    public static final String DATE_FORMAT_TPY_YMDHMssSSS = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static final String DAY_COUNT_WORKING = "W";//工作天数
    public static final String DAY_COUNT_CALENDAR = "C";//日历天数
    public static final String DAY_COUNT_AVERAGEWORKING = "A";//平均工作天数
    public static final String DATE_FORMATYM = "YYYYMM";//常见的日期格式

    /**
     * 根据月份获取英文简写月份
     * @param month
     * @return
     */
    public static String getStrMth(int month) {
        if (MTH_MAP.containsKey(month)) {
            MTH_MAP.get(month);
        }
        return "";
    }

    /**
     * 根据英文简写月份获取月份
     * @param month
     * @return
     */
    public static int getIntMth(String month) {
        for (Integer ks : MTH_MAP.keySet()) {
            if (MTH_MAP.get(ks).equals(month)) {
                return ks;
            }
        }
        return 0;
    }

    /**
     * 获取年
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取月
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日
     * @param date
     * @return
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取小时
     * @param date
     * @return
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取分钟
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 获取秒
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.SECOND);
    }

    /**
     * 根据年月日构造Date(YYYY-MM-DD 00:00:00.000)
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当前系统时间戳
     * @return
     */
    public static Timestamp getSystemTimestamp() {
        return getSystemTimestamp(System.currentTimeMillis());
    }

    /**
     * 根据指定毫秒获取系统系统时间戳
     * @param milliseconds
     * @return
     */
    public static Timestamp getSystemTimestamp(long milliseconds) {
        return new Timestamp(milliseconds);
    }

    public static String getSystemTimeMillisecond() {
        return convertDateToString(new Date(), DATE_FORMAT_JAVA_YMDHMssSSS24);
    }

    public static String getSystemTimeMillisecondShort() {
        return convertDateToString(new Date(), DATE_FORMAT_JAVA_YMDHMssSSS24_SHORT);
    }

    /**
     * 日期年份加numYears
     * @param date
     * @param numYears
     * @return
     */
    public static Date addYearsToDate(Date date, int numYears) {
        return addDate(Calendar.YEAR, date, numYears);
    }

    public static Date addMonthsToDate(Date date, int numMonths) {
        return addDate(Calendar.MONTH, date, numMonths);
    }

    public static Date addDaysToDate(Date date, int numDays) {
        return addDate(Calendar.DATE, date, numDays);
    }

    public static Date addHoursToDate(Date date, int numHours) {
        return addDate(Calendar.HOUR_OF_DAY, date, numHours);
    }

    public static Date addMinutesToDate(Date date, int numMins) {
        return addDate(Calendar.MINUTE, date, numMins);
    }

    public static Date addDate(int type, Date date, int num) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, num);
        return cal.getTime();
    }

    public static Date getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        return new Date(cal.getTime().getTime());
    }

    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        return new Date(cal.getTime().getTime());
    }

    public static Date getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DATE, day);
        return new Date(cal.getTime().getTime());
    }

    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DATE, day);
        return new Date(cal.getTime().getTime());
    }

    public static Date getFirstDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return new Date(cal.getTime().getTime());
    }

    public static Date getFirstDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DATE, 1);
        return new Date(cal.getTime().getTime());
    }

    public static Date getLastDayOfYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return new Date(cal.getTime().getTime());
    }

    public static Date getLastDayOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DATE, 31);
        return new Date(cal.getTime().getTime());
    }

    /**
     * @author Aaron.Wu
     * @date 2013-1-25 下午12:28:27
     * @description 根据当前日期，天数，天数统计类型获取下一个工作日
     * @param date 日期，天数，天数统计类型
     */
    public static Date getNextWorkingDay(Date date, int numDays, String day_count_type) {
        if (DAY_COUNT_CALENDAR.equalsIgnoreCase(day_count_type)) {
            date = addDaysToDate(date, numDays);
        } else {
            for (int i = 0; i < numDays; i++) {
                date = addDaysToDate(date, 1);
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int day = c.get(Calendar.DAY_OF_WEEK);
                if (day == Calendar.SATURDAY) {
                    date = addDaysToDate(date, 2);
                } else if (day == Calendar.SUNDAY) {
                    date = addDaysToDate(date, 1);
                }
            }
        }
        return date;
    }

    public static boolean isStartOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE) == 1;
    }

    public static boolean isEndOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return cal.get(Calendar.DATE) == maxDay;
    }

    public static boolean isStartOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (cal.get(Calendar.MONTH) == 1) && (cal.get(Calendar.DATE) == 1);
    }

    public static boolean isEndOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return (cal.get(Calendar.MONTH) == 11) && (cal.get(Calendar.DATE) == 31);
    }

    public static Date resetTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date endTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 59);
        return cal.getTime();
    }

    /**
     * The method will compares 2 dates (excluding the HH MM SS)
     * 比较两个日期的大小
     * @param date1 1st date parameter
     * @param date2 2nd date parameter
     * @return returns -1 if 1st date parameter is earlier than 2nd date
     *         parameter return 0 if both dates parameter is the same day
     *         return 1 if 1st date parameter is later than 2nd date parameter
     */
    public static int compareDates(Date date1, Date date2) {
        if ((date1 == null) && (date2 == null)) {
            return 0;
        }
        if (date1 == null) {
            return 1;
        }
        if (date2 == null) {
            return -1;
        }
        date1 = resetTime(date1);
        date2 = resetTime(date2);
        return date1.compareTo(date2);
    }

    /**
     * @author Aaron.Wu
     * @date 2013-7-25 下午03:49:49
     * @description 获取两个日期间相隔的分钟数
     */
    public static int getMinutesCount(Date date_from, Date date_to) {
        int date_from_days = (int) (date_from.getTime() / 1000 / 60);
        int date_to_days = (int) (date_to.getTime() / 1000 / 60);
        int count = date_to_days - date_from_days;
        return count;
    }

    /**
     * @author Jason.Shi
     * @date Nov 8, 2012 11:14:59 AM
     * @description 返回2个日期的间隔天数，如果date_from大于date_to则返回-1
     */
    public static int getCalendarDaysCount(Date date_from, Date date_to) {
        int count = 0;
        //重置时分秒为0
        date_from = resetTime(date_from);
        date_to = resetTime(date_to);
        //计算从1970年1月1号到date_from和date_to的天数
        int date_from_days = (int) (date_from.getTime() / 1000 / 60 / 60 / 24);
        int date_to_days = (int) (date_to.getTime() / 1000 / 60 / 60 / 24);
        count = date_to_days - date_from_days + 1;
        //如果date_from大于date_to,返回结果为-1
        count = count <= 0 ? -1 : count;
        return count;
    }

    public static int getWorkingDaysCount(Date startDate, Date endDate) {
        int totalDays = getCalendarDaysCount(startDate, endDate);
        int weeks = totalDays / 7;
        int result = weeks * 5;
        int balance = totalDays % 7;
        //看看开始的时候是星期几
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        int day = c.get(Calendar.DAY_OF_WEEK);
        for (int i = 0; i < balance; i++) {
            if ((day + i) != Calendar.SATURDAY && ((day + i) % 7) != Calendar.SUNDAY) {
                result++;
            }
        }
        return result;
    }

    /**
     * @author Jason.Shi
     * @date Nov 8, 2012 11:14:59 AM
     * @description 根据类型决定计算working day count或者calendar day count
     */
    public static int getDaysCount(Date date_from, Date date_to, String day_count_type) {
        if (DAY_COUNT_CALENDAR.equalsIgnoreCase(day_count_type)) {
            return getCalendarDaysCount(date_from, date_to);
        } else {
            return getWorkingDaysCount(date_from, date_to);
        }
    }

    /**
     * @author Jason.Shi
     * @date Sep 20, 2012 8:27:04 PM
     * @description get the total date count value of current year
     */
    public static int getYearDaysCount(String day_count_type) {
        return getDaysCount(getFirstDayOfYear(), getLastDayOfYear(), day_count_type);
    }

    public static int getYearDaysCount(Date date, String day_count_type) {
        return getDaysCount(getFirstDayOfYear(date), getLastDayOfYear(date), day_count_type);
    }


    /**
     * Calculates the duration in years, months and days.
     *
     * @param startDate Start Date of a period.
     * @param endDate End date of a period.
     * @return int[0]=duration in years,[1]=duration in months,[2]=duration in days.
     */
    public static int[] calculateDuration(Date startDate, Date endDate) {
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(startDate);
        to.setTime(endDate);

        int birthYYYY = from.get(Calendar.YEAR);
        int birthMM = from.get(Calendar.MONTH);
        int birthDD = from.get(Calendar.DAY_OF_MONTH);
        int asofYYYY = to.get(Calendar.YEAR);
        int asofMM = to.get(Calendar.MONTH);
        int asofDD = to.get(Calendar.DAY_OF_MONTH);
        int ageInYears = asofYYYY - birthYYYY;
        int ageInMonths = asofMM - birthMM;
        int ageInDays = asofDD - birthDD + 1;

        if (ageInDays < 0) {
            /*
             * Guaranteed after this single treatment, ageInDays will be >= 0.
             * that is ageInDays = asofDD - birthDD + daysInBirthMM.
             */
            ageInDays += from.getActualMaximum(Calendar.DAY_OF_MONTH);
            ageInMonths--;
        }

        if (ageInDays == to.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            ageInDays = 0;
            ageInMonths++;
        }

        if (ageInMonths < 0) {
            ageInMonths += 12;
            ageInYears--;
        }

        if ((birthYYYY < 0) && (asofYYYY > 0)) {
            ageInYears--;
        }

        if (ageInYears < 0) {
            ageInYears = 0;
            ageInMonths = 0;
            ageInDays = 0;
        }

        int[] result = new int[3];
        result[0] = ageInYears;
        result[1] = ageInMonths;
        result[2] = ageInDays;

        return result;
    }

    public static java.sql.Date toSQLDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    /**
     * 按照parrtern格式将字符串转换成日期对象
     *
     * @param dateStr	日期字符串
     * @param parrtern	转换格式
     * @return	Date对象
     */
    public static Date parse(String dateStr, String parrtern) {
        SimpleDateFormat sdf = new SimpleDateFormat(parrtern);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取日期对象yyyy-MM-dd HH:mm:ss.SSS格式的字符串
     *
     * @return "yyyy-MM-dd HH:mm:ss.SSS"格式的日期字符串。
     */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return formatter.format(new Date());
    }

    /**
     * 返回当前日期yyyyMMdd格式字符串
     *
     * @return "yyyyMMdd"格式的当前日期字符串
     */
    public static String getCurrentDate() {
        String curDate;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        curDate = formatter.format(new Date());
        return curDate;
    }

    /**
     * 返回当前日期MMdd格式字符串
     *
     * @return "MMdd"格式的当前日期字符串
     */
    public static String getCurrentConcretDate() {
        String curDate;
        SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
        curDate = formatter.format(new Date());
        return curDate;
    }

    /**
     * 返回当前日期HHmmss格式字符串
     *
     * @return "HHmmss"格式的当前日期字符串
     */
    public static String getCurrentTime() {

        String curTime;
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss");
        curTime = formatter.format(new Date());
        return curTime;
    }

    /**
     * 返回当前日期yyyyMMddHHmmss格式字符串
     *
     * @return "yyyyMMddHHmmss"格式的当前日期字符串
     */
    public static String getDateTime() {
        String dateTime;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        dateTime = formatter.format(new Date());
        return dateTime;
    }

    /**
     * 返回当前日期MMddHHmmss格式字符串
     *
     * @return "MMddHHmmss"格式的当前日期字符串
     */
    public static String getDateAndTime() {
        String dateTime;
        SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmss");
        dateTime = formatter.format(new Date());
        return dateTime;
    }

    /**
     * 获取当前时间interval秒后的yyyyMMddHHmmss格式的日期字符串
     *
     * @param interval	秒数
     * @return	当前时间interval秒后的日期字符串
     */
    public static String getAssignTime(int interval) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, interval);
        Date assignTime = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(assignTime);
    }

    /**
     * 获取指定时间的interval秒后的yyyyMMddHHmmss格式的日期字符串
     *
     * @param dateTime 指定时间
     * @param interval	秒数
     * @return	当前时间interval秒后的日期字符串
     */
    public static String getAssignTime(String dateTime, int interval) {
        Calendar c = Calendar.getInstance();
        c.setTime(parse(dateTime, "yyyyMMddHHmmss"));
        c.add(Calendar.SECOND, interval);
        Date assignTime = c.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(assignTime);
    }

    /**
     * 获取指定时间的interval秒后的yyyyMMddHHmmss格式的日期字符串
     *
     * @param dateTime 指定时间
     * @param interval	秒数
     * @return	当前时间interval秒后的日期字符串
     */
    public static Date getAssignTime(Date dateTime, int interval) {
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.add(Calendar.SECOND, interval);
        Date assignTime = c.getTime();
        return assignTime;
    }

    /**
     * 判断是否是本周
     *
     * @author caiy
     * @throws Exception
     */
    public static boolean whetherThisWeek(String date) {
        boolean right = false;
        // 获取当前系统日期
        Calendar cal = Calendar.getInstance();
        // 获取本周一日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int count = compare_date(date, format.format(cal.getTime()));
        if (count >= 0) {
            right = true;
        }
        return right;
    }

    /**
     * 日期比较
     *
     * @author caiy
     * @return
     * @throws Exception
     */
    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    /**
     * Adds or subtracts the specified amount of time to the given calendar
     * field, based on the calendar's rules. For example, to after 5 days
     * from the current time of the calendar, you can achieve it by calling:
     * <p>
     * <code>
     * 		getAfterDate(Calendar.DAY_OF_MONTH, 5)
     * 	</code>
     *
     *
     * @param field
     *            the calendar field.
     * @param amount
     *            the amount of date or time to be added to the field.
     * @return the date
     */
    public static Date getAfterDate(int field, int amount) {
        Calendar c = Calendar.getInstance();
        c.add(field, amount);
        return c.getTime();
    }

    /**
     * 获取指定时间的时间戳
     * @param timeStamp 指定时间,格式为 yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    public static long getTimeMillis(String timeStamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = formatter.parse(timeStamp, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取指定时间的交易耗时
     * @param timeStamp 指定时间,格式为 yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    @Deprecated
    public static String getTimeDuration(String timeStamp) {
        long timeDuration = System.currentTimeMillis() - getTimeMillis(timeStamp);
        return String.valueOf(timeDuration);
    }

    /**
     * 获取指定时间的交易耗时
     * @param timeStamp 指定时间
     * @return
     */
    public static String getTimeDuration(Date timeStamp) {
        long timeDuration = System.currentTimeMillis() - timeStamp.getTime();
        return String.valueOf(timeDuration);
    }

    /**
     * 判断时间是否超时
     * @param start
     * @param timeout
     * @return
     */
    public static boolean timeout(long start, long timeout) {
        long gap = System.currentTimeMillis() - start;
        if (gap < 0) {
            return true;
        }
        return gap >= timeout;
    }



    public static String toYearString(Date date, int year) {
        Calendar g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.YEAR, year);
        Date time = g.getTime();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD2);
        return format.format(time);
    }

    public static String toString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD2);
        return format.format(date);
    }

    public static String toStringYmd(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD);
        return format.format(date);
    }

    public static String toString2(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(APP_FORMAT_DATETIME);
        return format.format(date);
    }

    public static Date toDate(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD2);
        return format.parse(str);
    }

    public static Date toDate2(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_JAVA_YMDHMS);
        return format.parse(str);
    }

    public static Date toDateYm(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMATYM);
        return format.parse(str);
    }

    public static Date toDateYmdhms(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_JAVA_YMDHMS24);
        return format.parse(str);
    }

    public static Date toDateYmd(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD);
        return format.parse(str);
    }

    public static String toStringSpot(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD_SPOT);
        return format.format(date);
    }

    public static Date toDateStot(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YMD_SPOT);
        return format.parse(str);
    }

    /**
     * 比较2个字符串日期时间的大小
     * @param dateStr1 日期1，格式为yyyyMMddHHmmss
     * @param dateStr2 日期2，格式为yyyyMMddHHmmss
     * @return 1:dateStr1>dateStr2,0:dateStr1=dateStr2,-1:dateStr1<dateStr2
     */
    public static int compareDateTime(String dateStr1, String dateStr2) {
        if (StringUtils.isEmpty(dateStr1) && StringUtils.isEmpty(dateStr2)) {
            return 0;
        } else if (StringUtils.isEmpty(dateStr1)) {
            return 1;
        } else if (StringUtils.isEmpty(dateStr2)) {
            return -1;
        }

        Date date1 = parse(dateStr1, OAP_FORMAT_DATETIME);
        Date date2 = parse(dateStr2, OAP_FORMAT_DATETIME);
        return compareDateTime(date1, date2);
    }

    /**
     * 比较2个字符串日期的大小
     * @param dateStr1 日期1，格式为yyyyMMdd
     * @param dateStr2 日期2，格式为yyyyMMdd
     * @return 1:dateStr1>dateStr2,0:dateStr1=dateStr2,-1:dateStr1<dateStr2
     */
    public static int compareDate(String dateStr1, String dateStr2) {
        if (StringUtils.isEmpty(dateStr1) && StringUtils.isEmpty(dateStr2)) {
            return 0;
        } else if (StringUtils.isEmpty(dateStr1)) {
            return 1;
        } else if (StringUtils.isEmpty(dateStr2)) {
            return -1;
        }

        Date date1 = parse(dateStr1, DATE_FORMAT_YMD2);
        Date date2 = parse(dateStr2, DATE_FORMAT_YMD2);
        return compareDateTime(date1, date2);
    }

    /**
     * 比较2个日期时间的大小
     * @param date1
     * @param date2
     * @return 1:date1>date2,0:date1=date2,-1:date1<date2
     */
    public static int compareDateTime(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime())
            return 1;
        else if (date1.getTime() < date2.getTime())
            return -1;
        else
            return 0;
    }

    /**
     * 	截取yyyyMMddHHmmss为yyyyMMdd
     * @param dateStr
     */
    public static String getStrYearMthDay(String dateStr) {
        if (dateStr == null || dateStr.length() <= 8) {
            return dateStr;
        }
        return dateStr.substring(0, 8);
    }

    /**
     * 获取当天开始时间
     *  @Title:getTimesmorning
     *  @Description: TODO
     *  @return
     *  Date
     *
     */
    public static Date getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date today = cal.getTime();
        return today;
    }

    public static String convertDateToString(Date date, String formatStr) {
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        if (date == null) {
            return null;
        } else {
            return df.format(date);
        }
    }

    public static String toStringMdDot(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_MD_DOT);
        return format.format(date);
    }

    public static Date toDateMdDot(String str) throws ParseException {
        if (str == null || str.equals("")) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_MD_DOT);
        return format.parse(str);
    }

    public static int getIntervalDay(Date startDate, Date endDate) {
        String startStandardDate = formatToStandardDate(startDate, "");
        String endStandardDate = formatToStandardDate(endDate, "");
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        int year = Integer.parseInt(startStandardDate.substring(0, 4));
        int month = Integer.parseInt(startStandardDate.substring(4, 6));
        int day = Integer.parseInt(startStandardDate.substring(6));
        startCalendar.set(year, month - 1, day, 0, 0, 0);
        year = Integer.parseInt(endStandardDate.substring(0, 4));
        month = Integer.parseInt(endStandardDate.substring(4, 6));
        day = Integer.parseInt(endStandardDate.substring(6));
        endCalendar.set(year, month - 1, day, 0, 0, 0);

        return new Long((endCalendar.getTimeInMillis() - startCalendar.getTimeInMillis()) / (24 * 3600 * 1000)).intValue();
    }

    public static String formatToStandardDate(Date date, String seperator) {
        String pattern = "yyyy" + seperator + "MM" + seperator + "dd";
        String formattedDate = new SimpleDateFormat(pattern).format(date);
        return formattedDate;
    }

    public static Date convertStringToDate(String strDateTime, String dateTimeFormat) {
        if ((strDateTime == null) || (strDateTime.length() == 0) || (dateTimeFormat == null)
                || (dateTimeFormat.length() == 0)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
        Date date = dateFormat.parse(strDateTime, new ParsePosition(0));

        if (date == null) {
            return null;
        }
        String dateStr = convertDateToString(date, dateTimeFormat);

        if (!strDateTime.equals(dateStr)) {
            return null;
        }
        return date;
    }

    public static Date stringToDate(String strDateTime, String dateTimeFormat) {
        if ((strDateTime == null) || (strDateTime.length() == 0) || (dateTimeFormat == null)
                || (dateTimeFormat.length() == 0)) {
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateTimeFormat);
        Date date = null;
        try {
            date = dateFormat.parse(strDateTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (date == null) {
            return null;
        }
        String dateStr = convertDateToString(date, dateTimeFormat);

        if (!strDateTime.equals(dateStr)) {
            return null;
        }
        return date;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate2(Date dt) {
        String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取格式化后的日期或时间
     * <p>
     * 将日期时间从beforDateFormat格式转换成afterDateFormat格式
     * @param dateTime 日期字符串
     * @param beforDateFormat 转换前日期时间格式
     * @param afterDateFormat 转换前日期时间格式
     * @return
     */
    public static String getFormatDateTime(String dateTime, String beforDateFormat, String afterDateFormat) {
        if (StringUtils.isEmpty(dateTime) || StringUtils.isEmpty(beforDateFormat) ||StringUtils.isEmpty(afterDateFormat)) {
            return "";
        }

        return convertDateToString(parse(dateTime, beforDateFormat), afterDateFormat);
    }

    public static Timestamp convertStringToTimestamp(String dateTimeStr) {
        return convertDateToTimestamp(convertStringToDate(dateTimeStr));
    }

    public static Date convertStringToDate(String strDateTime) {
        return convertStringToDate(strDateTime, DATE_FORMAT_YMD);
    }
    public static Timestamp convertDateToTimestamp(Date date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 将时间格式yyyyMMdd转换yyyy-MM-dd
     * @Name: convertDate
     * @Description: @param formatStr
     * @Description: @return
     * @Description: @throws Exception
     * @Author: zhangjun
     * @Create Date: 2015-4-24下午12:51:28
     * @Parameters: DateUtil
     * @Return: String
     */
    public static String convertDate(String formatStr) throws ParseException {
        if(StringUtils.isEmpty(formatStr)){
            return "";
        }
        SimpleDateFormat sdfs=new SimpleDateFormat("yyyyMMdd");
        Date dt=sdfs.parse(formatStr);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dt);
    }


    //获取前几月的时间
    public static String monthDateTime(int monthNum){
        DateFormat df = new SimpleDateFormat(DATE_FORMAT_YMD2);
        Date date = new Date();
        Calendar  g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.MONTH,monthNum);
        Date retdate = g.getTime();
        return df.format(retdate);
    }

    //获取几年之前的时间
    public static String yearDateTime(int yearNum){
        DateFormat df = new SimpleDateFormat(DATE_FORMAT_YMD2);
        Date date = new Date();
        Calendar  g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.YEAR,yearNum);
        Date retdate = g.getTime();
        return df.format(retdate);
    }

    /**
     * 按月份获取获取开始和结束日期
     *-1 前一个月
     * @throws ParseException
     */
    public static Map<String, Object> getDateString(String month) {
        Map<String, Object> returnMap = new HashMap<>();
        Date date = new Date();
        String endDate = DateUtils.toStringYmd(date);// 结束日期
        Calendar g = Calendar.getInstance();
        g.setTime(date);
        g.add(Calendar.MONTH, Integer.parseInt(month));
        Date d2 = g.getTime();
        g = Calendar.getInstance();
        g.setTime(d2);
        g.add(Calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        d2 = g.getTime();
        String startDate = DateUtils.toStringYmd(d2);// 开始日期
        returnMap.put("endDate", endDate);
        returnMap.put("startDate", startDate);// 开始日期
        return returnMap;
    }

    /**
     * 判断一个日期是否是周末
     * @param date
     * @return true 周末
     * @throws ParseException
     */
    public static Boolean isWeekend(Date date) {
//		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
//		Date bdate = format1.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
            return true;
        }
        else return false;
    }
    /**
     * 判断某天是否是周末
     * 日期支持的格式：yy-MM-dd
     */
    public static Boolean isWeeKend(String date){
        Date formatDate = DateUtils.parse(date,DateUtils.YYYY_MM_DD_DATE_FORMAT);
        Calendar cal = Calendar.getInstance();
        cal.setTime(formatDate);
        if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
            return true;
        }
        else return false;
    }
}
