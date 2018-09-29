package com.easy.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * 实现描述：时间操作工具类
 *
 * @author zuochi
 * @version v1.0.0
 * @see
 * @since 2016-07-27
 */
public class DateUtils {

    public final static String DATE_CHINESE_PATTERN = "yyyy年MM月dd日";

    public final static String DATE_MONTH_DAY_CHINESE_PATTERN = "MM月dd日";

    /**
     * 标准的中文小时分钟格式
     */
    public final static String HOUR_MINUTE_CHINESE_PATTERN = "HH点mm分";

    /**
     * 标准日期格式
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    public final static String DATE_YYYY_MM = "yyyy-MM";

    public final static String DATE_SHORT_PATTERN = "yyyyMMdd";

    public final static String DATE_SLASH_PATTERN = "yyyy/MM/dd";


    public final static String DATE_FORMAT_PATTER = "yyyyMMddHHmmss";

    /**
     * 标准日期时分秒毫秒格式
     */
    public final static String DATETIME_MILL_SECOND = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 标准时间格式
     */
    public final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准时间格式，不含秒
     */
    public final static String DATETIME_PATTERN_SHORT = "yyyy-MM-dd HH:mm";

    /**
     * 特殊的格式 针对创建订单，拼凑的最晚支付时间
     */
    public final static String DATETIME_PATTERN_CREAT_ORDER = "yyyy-MM-ddHH:mm";

    public final static String DATETIME_SHORT_PATTERN = "yyyyMMddHHmmss";

    public final static String DATETIME_MILLi_PATTERN = "yyyyMMddHHmmssSSS";

    /**
     * 标准年小时分钟格式
     */
    public final static String HOUR_MINUTE = "HH:mm";

    /**
     * 标准年小时格式
     */
    public final static String HOUR = "HH";

    public final static String HOUR_MIN = "H";

    /**
     * 标准年小时分钟秒格式
     */
    public final static String HOUR_MINUTE_SECOND = "HH:mm:ss";

    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    /**
     * Number of milliseconds in a standard day.
     */
    public static final long MILLIS_PER_DAY = 24 * DateUtils.MILLIS_PER_HOUR;

    /**
     * Number of milliseconds in a standard hour.
     */
    public static final long MILLIS_PER_HOUR = 60 * DateUtils.MILLIS_PER_MINUTE;

    /**
     * Number of milliseconds in a standard minute.
     */
    public static final long MILLIS_PER_MINUTE = 60 * DateUtils.MILLIS_PER_SECOND;

    /**
     * Number of milliseconds in a standard second.
     */
    public static final long MILLIS_PER_SECOND = 1000;

    /**
     * Number of day in a year
     */
    public static final int DAYS_PER_YEAR = 365;

    /**
     * 标准年月格式
     */
    public final static String MONTH_PATTERN = "yyyy-MM";

    private final static String[] WEEK_NAMES = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"};

    private static SimpleDateFormat hmSdf = new SimpleDateFormat(HOUR_MINUTE);

    /**
     * 在指定日期增加指定月数
     *
     * @param date   指定日期
     * @param months 指定月数
     * @return
     */
    public static Date addMonth(Date date, int months) {
        if (months == 0) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    /**
     * 在指定日期增加指定秒
     *
     * @param date
     * @param seconds
     * @return
     */
    public static Date addSeconds(Date date, int seconds) {
        if (seconds == 0) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, seconds);
        return c.getTime();
    }

    /**
     * 在指定日期增加指定天数
     *
     * @param date 指定日期
     * @param days 指定天数
     * @return
     */
    public static Date addDay(Date date, int days) {
        if (days == 0) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }

    /**
     * 获取当天的开始时间
     *
     * @return
     */
    public static Date getStartTime(Date date) {
        Calendar start = Calendar.getInstance();
        start.setTime(date);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        return convertDate(start.getTime(), DATETIME_PATTERN);
    }

    public static Date getEndTime(Date date) {
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.MILLISECOND, 999);
        return convertDate(end.getTime(), DATETIME_PATTERN);
    }

    public static Date getEndTimeMinute(Date date) {
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        return convertDate(end.getTime(), DATETIME_PATTERN);
    }

    /**
     * 在指定日期增加指定天数
     *
     * @param date 指定日期
     * @param days 指定天数
     * @return
     */
    public static Date addDay(String date, int days) {
        return DateUtils.addDay(DateUtils.convertDate(date), days);
    }

    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }

    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hour);
        return c.getTime();
    }

    /**
     * 当前日期之后
     *
     * @param date
     * @return
     */
    public static boolean afterToday(Object date) {
        Date currentDate = new Date();
        return DateUtils.compareDate(date, currentDate) == 1;
    }

    /**
     * 当前时间之后
     *
     * @param date
     * @return
     */
    public static boolean afterTodayDate(Date date) {
        Date currentDate = new Date();
        return currentDate.compareTo(date) == -1;
    }

    /**
     * 当前日期之前
     *
     * @param date
     * @return
     */
    public static boolean beforeToday(Date date) {
        Date currentDate = DateUtils.convertDate(new Date(), DateUtils.DATE_PATTERN);
        return DateUtils.compareDate(date, currentDate) == -1;
    }

    /**
     * 当前时间之前
     *
     * @param date
     * @return
     */
    public static boolean beforeTodayDate(Date date) {
        Date currentDate = new Date();
        return currentDate.compareTo(date) == 1;
    }

    /**
     * 昨天 之前
     *
     * @param date
     * @return
     */
    public static boolean beforeYesterday(Date date) {
        Date yesterday = DateUtils.yesterday();

        return yesterday.compareTo(date) == 1;
    }

    /**
     * 昨天 之后
     *
     * @param date
     * @return
     */
    public static boolean afterYesterday(Date date) {
        Date yesterday = DateUtils.yesterday();

        return yesterday.compareTo(date) == -1;
    }

    /**
     * 比较两个日期date1大于date2 返回1 等于返回0 小于返回-1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Object date1, Object date2) {
        if (date1 == null || date2 == null) {
            String msg = "illegal arguments,date1 and date2 must be not null.";
            throw new IllegalArgumentException(msg);
        }
        Date d1 = (Date) (date1 instanceof String ? DateUtils.convertDate((String) date1) : date1);
        Date d2 = (Date) (date2 instanceof String ? DateUtils.convertDate((String) date2) : date2);
        return DateUtils.round(d1, Calendar.DATE).compareTo(DateUtils.round(d2, Calendar.DATE));
    }

    public static Date convertDate(Date date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            String msg = "the date or pattern is empty.";
            throw new IllegalArgumentException(msg);
        }
        String dateForPattern = DateUtils.formatDate(date, pattern);
        return DateUtils.convertDate(dateForPattern, pattern);
    }

    /**
     * 将long型整数转化为时间。
     *
     * @param date 时间对应的long值
     * @return 时间对象
     */
    public static Date convertDate(Long date) {
        return new Date(date);
    }

    /**
     * 将日期或者时间戳转化为日期对象
     *
     * @param date yyyy-MM-dd or yyyy-MM-dd HH:mm:ss or yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    public static Date convertDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        if (StringUtils.isNumeric(date)) {
            long timestamp = Long.parseLong(date);
            if (timestamp > 0 && timestamp < Long.MAX_VALUE) {
                return new Date(timestamp);
            } else {
                return null;
            }
        }
        if (date.indexOf(':') > 0) {
            return DateUtils.convertDate(date, DateUtils.DATETIME_PATTERN);
        } else if (date.indexOf('.') > 0) {
            return DateUtils.convertDate(date, DateUtils.DATETIME_MILL_SECOND);
        } else {
            return DateUtils.convertDate(date, DateUtils.DATE_PATTERN);
        }
    }

    /**
     * 将日期或者时间字符串转化为日期对象
     *
     * @param date    日期字符串
     * @param pattern 格式字符串</br> yyyy-MM-DD, yyyy/MM/DD, yyyyMMdd</br> yyyy-MM-dd-HH:mm:ss, yyyy-MM-dd HH:mm:ss
     *                格式字符串可选字符："GyMdkHmsSEDFwWahKzZ"
     * @return Date
     */
    public static Date convertDate(String date, String pattern) {
        try {
            if (StringUtils.isEmpty(pattern) || StringUtils.isEmpty(date)) {
                String msg = "the date or pattern is empty.";
                throw new IllegalArgumentException(msg);
            }
            SimpleDateFormat df = new SimpleDateFormat(pattern.trim());
            return df.parse(date.trim());
        } catch (Exception e) {
            DateUtils.logger.error("Method===DateUtils.convertDate error!", e);
            return null;
        }
    }

    /**
     * 将时间字符串转化为时间对象Time
     *
     * @param time    时间字符串
     * @param pattern 格式字符串 yyyy-MM-dd HH:mm:ss or yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    public static Time convertTime(String time, String pattern) {
        if ("24:00:00".equals(time)) {
            time = "23:59:59";
        }
        Date d = DateUtils.convertDate(time, pattern);
        return new Time(d.getTime());
    }

    /**
     * 获得日期相差天数
     *
     * @param date1 日期
     * @param date2 日期
     * @return
     */
    public static int diffDate(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / DateUtils.MILLIS_PER_DAY);
    }

    /**
     * 获取两个日期相差的分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int diffMinute(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / DateUtils.MILLIS_PER_MINUTE);
    }

    /**
     * 格式为时间字符串
     *
     * @param date 日期
     * @return yyyy-MM-dd Date
     */
    public static String formatDate(Date date) {
        try {
            return DateUtils.formatDate(date, DateUtils.DATE_PATTERN);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 按指定格式字符串格式时间
     *
     * @param date    日期或者时间
     * @param pattern 格式化字符串 yyyy-MM-dd， yyyy-MM-dd HH:mm:ss, yyyy年MM月dd日 etc.</br>
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern.trim());
        return format.format(date);
    }

    /**
     * 格式为时间戳字符串
     *
     * @param date 时间
     * @return yyyy-MM-dd HH:mm:ss Date
     */
    public static String formatDateTime(Date date) {
        try {
            return DateUtils.formatDate(date, DateUtils.DATETIME_PATTERN);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将制定时间格式为字符串'yyyyMMddHHmmss'.
     *
     * @return
     */
    public static String formatDateToYMDHMS(Date date) {
        return DateUtils.formatDate(date, DateUtils.DATETIME_SHORT_PATTERN);
    }

    public static String formatMonth(Date date) {
        return DateUtils.formatDate(date, DateUtils.MONTH_PATTERN);
    }

    /**
     * 将当前时间格式为字符串'yyyyMMddHHmmss'.
     *
     * @return
     */
    public static String formatNowToYMDHMS() {
        return DateUtils.formatDateToYMDHMS(new Date());
    }

    /**
     * 将当前时间格式为字符串'yyyyMMddHHmmss'.
     *
     * @return
     */
    public static Date convert2YMDHMS(String time) {
        SimpleDateFormat simpleDF = new SimpleDateFormat(DATETIME_SHORT_PATTERN);

        try {
            return simpleDF.parse(time);
        } catch (Exception e) {
            DateUtils.logger.warn("parse date error", e);
        }

        return null;
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static Date getDateFromShortString(String str) {
        SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDF.parse(str);
        } catch (ParseException e) {
            DateUtils.logger.warn("parse date error", e);
        }
        return null;
    }

    /**
     * 获得本周第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfThisWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获得小时
     *
     * @param date
     * @return
     */
    public static int getHourOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static Date getLastMonth() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month - 1);
        return c.getTime();
    }

    /**
     * 获得分钟数
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获得秒数
     *
     * @param date
     * @return
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 获取后续第n天日期
     *
     * @param date
     * @param n    第n天
     * @return
     */
    public static Date getNextNDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 获得星期数
     *
     * @param date 日期
     * @return
     */
    public static int getWeekNumber(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int number = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (number == 0) {
            number = 7;
        }
        return number;
    }

    /**
     * 获得星期名称
     *
     * @param date
     * @return
     */
    public static String getWeekNumberString(Date date) {
        int dayNum = DateUtils.getWeekNumber(date);
        return DateUtils.WEEK_NAMES[dayNum - 1];
    }

    /**
     * 是否同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Object date1, Object date2) {
        return DateUtils.compareDate(date1, date2) == 0;
    }

    /**
     * 检查时间或者字符串是否合法
     *
     * @param date    时间
     * @param pattern 格式串
     * @return
     */
    public static boolean isValidDate(String date, String pattern) {
        try {
            DateUtils.convertDate(pattern, date);
            return true;
        } catch (Exception e) {
            DateUtils.logger.debug("Method===DateUtils.isValidDate error!", e);
            return false;
        }
    }

    /**
     * 获得当前时间戳
     *
     * @return Timestamp
     */
    public static Timestamp now() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 获得当前时间字符串,格式为：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String nowDateTime() {
        return DateUtils.formatDate(new Date(), DateUtils.DATETIME_PATTERN);
    }

    /**
     * 按指定roundType格式化日期。
     *
     * @param date      日期
     * @param roundType
     * @return Date
     */
    public static Date round(Date date, int roundType) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        switch (roundType) {
            case Calendar.MONTH:
                c.set(Calendar.DAY_OF_MONTH, 1);
            case Calendar.DATE:
                c.set(Calendar.HOUR_OF_DAY, 0);
            case Calendar.HOUR:
                c.set(Calendar.MINUTE, 0);
            case Calendar.MINUTE:
                c.set(Calendar.SECOND, 0);
            case Calendar.SECOND:
                c.set(Calendar.MILLISECOND, 0);
                return c.getTime();
            default:
                throw new IllegalArgumentException("invalid round roundType.");
        }
    }

    /**
     * 获得当前日期对象
     *
     * @return
     */
    public static Date today() {
        return DateUtils.convertDate(DateUtils.formatDate(new Date()), DateUtils.DATE_PATTERN);
    }

    /**
     * 获得 昨天
     * yyyy-MM-dd
     *
     * @return
     */
    public static Date yesterday() {
        return DateUtils.convertDate(DateUtils.formatDate(addDay(new Date(), -1)), DateUtils.DATE_PATTERN);
    }

    /**
     * 获得 昨天
     * yyyy-MM-dd
     *
     * @return
     */
    public static Date dayBeforeYesterday() {
        return DateUtils.convertDate(DateUtils.formatDate(addDay(new Date(), -2)), DateUtils.DATE_PATTERN);
    }

    /**
     * 获得 明天
     * yyyy-MM-dd
     *
     * @return
     */
    public static Date tomorrow() {
        return DateUtils.convertDate(DateUtils.formatDate(addDay(new Date(), 1)), DateUtils.DATE_PATTERN);
    }

    /**
     * 获得当前日期字符串,格式为：yyyy-MM-dd
     *
     * @return
     */
    public static String todayDate() {
        return DateUtils.formatDate(new Date());
    }

    /**
     * 将日期或者时间字符串转化为Timestamp对象
     *
     * @param date    日期字符串
     * @param pattern 格式字符串</br> yyyy-MM-DD, yyyy/MM/DD, yyyyMMdd</br> yyyy-MM-dd-HH:mm:ss, yyyy-MM-dd HH:mm:ss
     * @return Timestamp
     * @author reeboo
     */
    public static Timestamp toTimestamp(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern.trim());
        try {
            return new Timestamp(format.parse(date).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getFirstDateOfCurrentMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getLastDateOfCurrentMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


    public static Date getFirstDateFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 判断当前时间是否在某个区间内
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean todayInClose(Date startDate, Date endDate) {
        Date currentDate = convertDate(new Date(), DATE_PATTERN);
        return currentDate.getTime() >= startDate.getTime() && currentDate.getTime() <= endDate.getTime();
//        Range<Date> range=Ranges.closed(startDate,endDate);
//        return range.contains(currentDate);
    }

    // 时间转换成毫秒,空返回-1
    public static Long getTime(Date date) {
        if (null == date) {
            return null;
        }
        return date.getTime();
    }

    /**
     * 判断两个时间区间是否有交集
     *
     * @param closeOneStartDate
     * @param closeOneEndDate
     * @param closeTwoStartDate
     * @param closeTwoEndDate
     * @return
     */
    public static boolean timeIntersection(Date closeOneStartDate, Date closeOneEndDate, Date closeTwoStartDate,
                                           Date closeTwoEndDate) {
        long start = Math.max(closeOneStartDate.getTime(), closeTwoStartDate.getTime());
        long end = Math.min(closeOneEndDate.getTime(), closeTwoEndDate.getTime());
        return start <= end;
    }

    public static Date convert2Date(Long time, String pattern) {
        if (time != null && time > 0L) {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            Date date = new Date(time);
            return date;
        }

        return new Date();
    }


    public static String convert2String(Long time, String pattern) {
        if (time != null && time > 0L) {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            Date date = new Date(time);
            return sf.format(date);
        }

        return "";
    }


    public static Date getStartOfMonth() {
        Calendar cal_1 = Calendar.getInstance();
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        return cal_1.getTime();
    }

    public static boolean isInZone(long tStart, long tEnd, long t) throws ParseException {
        return tStart <= t && t <= tEnd;
    }

    public static long getLong(String timeStr) throws ParseException {
        return hmSdf.parse(timeStr).getTime();
    }

    public static long getCurrentTime() throws ParseException {
        return getLong(hmSdf.format(new Date()));
    }


    public static long getNowToTomorrowMidnigthSeconds() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        return TimeUnit.NANOSECONDS.toSeconds(Duration.between(LocalDateTime.now(), tomorrowMidnight).toNanos());
    }

    public static Date getMysqlMaxDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2035);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 01);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(format.format(DateUtils.getMysqlMaxDate()));
    }
}
