package com.ctrl.education.core.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * ClassName: AlohaDateUtil <br/>
 * Function: 日期工具帮助类
 * date: 2016年1月26日 上午10:38:41 <br/>
 *
 * @author bian
 * @since JDK 1.7
 */
public class AlohaDateUtils {
    private static final String FormatDate = "yyyy-MM-dd";

    private static final String FormatDateTime = "yyyyMMddHHmmss";

    private static final String FormatTimestamp = "yyyy-MM-dd HH:mm:ss";

    /**
     * 到毫秒级数据转换
     */
    private static final String FormatTimestampMil = "yyyy-MM-dd HH:mm:ss.S";

    private static final String SpecificFormat = "yyyyMMdd";

    private static final String SPECIFIC_FORMAT = "yyMMdd";

    private static final SimpleDateFormat sdf = new SimpleDateFormat(
            FormatTimestamp);
    private static SimpleDateFormat sdfm = new SimpleDateFormat(
            FormatTimestampMil);
    private static SimpleDateFormat dffd = new SimpleDateFormat(FormatTimestamp);
    private static SimpleDateFormat dffdL = new SimpleDateFormat(FormatDate);
    private final static SimpleDateFormat sdfDays = new SimpleDateFormat(SpecificFormat);
    private final static SimpleDateFormat sdfTimes = new SimpleDateFormat(FormatDateTime);

    /**
     * 获取当前月第一天
     *
     * @return
     */
    public static String getMonthFirstDay() {
        SimpleDateFormat format = new SimpleDateFormat(FormatDate);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        String first = format.format(c.getTime());
        return first;
    }

    /**
     * 获取当月最后一天
     */
    public static String getMonthLastDay(){
        SimpleDateFormat format =  new SimpleDateFormat(FormatDate);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        int lastD = c.getActualMaximum(c.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, lastD);
        String last = format.format(c.getTime());
        return last;
    }
    static {
        dffd.setTimeZone(new GregorianCalendar().getTimeZone());
        dffd.setLenient(false);
        dffdL.setTimeZone(new GregorianCalendar().getTimeZone());
        dffdL.setLenient(false);
    }

    public static String rturnWeek(Date date) {
        String returnStr = null;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        switch (weekNumber) {
            case 1:
                returnStr = "星期一";
                break;
            case 2:
                returnStr = "星期二";
                break;
            case 3:
                returnStr = "星期三";
                break;
            case 4:
                returnStr = "星期四";
                break;
            case 5:
                returnStr = "星期五";
                break;
            case 6:
                returnStr = "星期六";
                break;
            case 0:
                returnStr = "星期七";
                break;
            default:
                returnStr = "";
                break;

        }

        return returnStr;
    }


    /**
     * 获取YYYY-MM-DD格式
     *
     * @return
     */
    public static String getDay() {
        return dffdL.format(new Date());
    }

    /**
     * 获取YYYYMMDD格式
     *
     * @return
     */
    public static String getDays() {
        return sdfDays.format(new Date());
    }

    /**
     * 获取YYYY-MM-DD HH:mm:ss格式
     *
     * @return
     */
    public static String getTime() {
        return dffd.format(new Date());
    }

    /**
     * 获取yyyyMMddHHmmss格式
     *
     * @return
     */
    public static String getTimes() {
        return sdfTimes.format(new Date());
    }

    /**
     * 根据传入日期增加i天
     *
     * @param date 日期
     * @param i    增加的天数
     * @return 格式为"yyyy-MM-dd"的字符串
     * @throws Exception
     * @throws IllegalArgumentException
     * @roseuid 44D6EB790190
     */
    public static String AddDate(String date, int i)
            throws IllegalArgumentException {
        Date d = null;

        d = AlohaDateUtils.dateFormat(date);
        long ldate = d.getTime();
        ldate += i * 24 * 60 * 60 * 1000;
        return new SimpleDateFormat(AlohaDateUtils.FormatDate).format(new Date(
                ldate));
    }

    /**
     * 根据传入日期增加i分钟
     *
     * @param datetime 时间
     * @param i        增加的分钟数
     * @return java.lang.String 格式为"yyyy-MM-dd HH:mm:ss"的字符串
     * @throws IllegalArgumentException
     * @roseuid 44D6EB79026C
     */
    public static String AddMinute(String datetime, int i)
            throws IllegalArgumentException {
        String date = datetime.substring(0, 10);
        String time = datetime.substring(11);
        Date d = AlohaDateUtils.dateFormat(date, time);
        long ldate = d.getTime();
        ldate += i * 60 * 1000;
        return new SimpleDateFormat(AlohaDateUtils.FormatTimestamp)
                .format(new Date(ldate));
    }

    /**
     * 根据传入日期增加i秒
     *
     * @param datetime 时间
     * @param i        要增加的秒数
     * @return java.lang.String 格式为"yyyy-MM-dd HH:mm:ss"的字符串
     * @throws IllegalArgumentException
     * @roseuid 44D6EB79026C
     */
    public static String AddSecond(String datetime, int i)
            throws IllegalArgumentException {
        String date = datetime.substring(0, 10);
        String time = datetime.substring(11);
        Date d = AlohaDateUtils.dateFormat(date, time);
        long ldate = d.getTime();
        ldate += i * 1000;
        return new SimpleDateFormat(AlohaDateUtils.FormatTimestamp)
                .format(new Date(ldate));
    }

    /**
     * 根据传入日期增加i天
     *
     * @param date 要增加的日期(Date类型)
     * @param i    要增加的天数
     * @return 增加后的日期
     * @roseuid 44D6EB790257
     */
    public static Date dateAdd(Date date, long i) {
        long ldate = date.getTime();
        ldate += i * 24 * 60 * 60 * 1000;
        return new Date(ldate);
    }

    /**
     * 根据传入参数两个时间差单位:天 减数放前 被减数放后，判断大小
     *
     * @param EndDate 减数
     * @param BegDate 被减数
     * @return int 返回int类型的数据
     * @throws IllegalArgumentException
     * @throws Exception
     * @roseuid 44D6EB780197
     */
    public static int dateDiff(String EndDate, String BegDate)
            throws IllegalArgumentException {
        Date firDate = dateFormat(BegDate);
        Date secDate = dateFormat(EndDate);
        long r = secDate.getTime() - firDate.getTime();
        return (int) (r / 60000 / 60 / 24);
    }

    /**
     * 根据传入参数两个时间差单位:分钟 减数放前 被减数放后
     *
     * @param EndDate 减数年月日
     * @param EndTime 减数时分秒
     * @param BegDate 被减数年月日
     * @param BegTime 被减数时分秒
     * @return int 返回int类型数值
     * @throws IllegalArgumentException
     * @roseuid 44D6EB7800D9
     */
    public static int dateDiff(String EndDate, String EndTime, String BegDate,
                               String BegTime) throws IllegalArgumentException {
        Date firDate = dateFormat(BegDate, BegTime);
        Date secDate = dateFormat(EndDate, EndTime);
        long r = secDate.getTime() - firDate.getTime();
        return (int) (r / 60000);
    }

    /**
     * 格式化日期
     *
     * @param date 输入的日期String
     * @return java.utils.Date 返回日期yyyy-MM-dd
     * @roseuid 44D6EB7903A1
     */
    public static Date dateFormat(String date) {
        try {
            return fromDateString(date, FormatDate);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 格式化日期
     *
     * @param date 输入的日期String
     * @param lt   是否长日期
     * @return java.utils.Date lt为true返回日期yyyy-MM-dd hh:mm:ss，否则返回yyyy-MM-dd
     * @roseuid 44D6EB7903A1
     */
    public static Date dateFormat(String date, boolean lt) {
        try {
            return lt ? fromDateStringFixed(date) : fromDateStringFixedL(date);
            // return lt ? fromDateString(date, FormatTimestamp) :
            // fromDateString(
            // date, FormatDate);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 根据传入日期和时间返回Date对象
     *
     * @param date 日期
     * @param time 时间
     * @return java.utils.Date 返回时间，格式为yyyy-MM-dd hh:mm:ss
     * @throws IllegalArgumentException
     * @roseuid 44D6EB790333
     */
    public static Date dateFormat(String date, String time) {
        try {
            return fromDateString(date + " " + time, FormatTimestamp);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 根据传入日期和时间返回Date对象
     *
     * @param dateTime 格式为yyyy-MM-dd hh:mm:ss
     * @return java.utils.Date 返回时间，格式为yyyy-MM-dd hh:mm:ss
     * @throws IllegalArgumentException
     * @roseuid 44D6EB790333
     */
    public static Date dateFormat4DataTime(String dateTime) {
        try {
            return fromDateString(dateTime, FormatTimestamp);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 转换日期类型为字符串YYYY-MM-DD格式
     *
     * @param dt 要转换的时间
     * @return 转换后的字符串
     * @roseuid 44D6EB7A00E6
     */
    public static String formatDate(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(FormatDate);
        if (dt == null) {
            return "";
        }
        return sdf.format(dt);
    }

    /**
     * 转换日期类型为字符串YYYY-MM-DD格式
     *
     * @param dt 要转换的时间
     * @return 转换后的字符串
     * @roseuid 44D6EB7A00E6
     */
    public static String formatDateNo(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        if (dt == null) {
            return "";
        }
        return sdf.format(dt);
    }

    /**
     * 转换日期类型为字符串yyyy-MM-dd hh:MM:ss格式
     *
     * @param dt 要转换的时间
     * @return 转换后的字符串
     * @roseuid 44D6EB7A00E6
     */
    public static String formatLongDate(Date dt) {
        if (dt == null) {
            return null;
        }
        String dateStr = null;
        synchronized (sdf) {
            dateStr = sdf.format(dt);
        }
        return dateStr;
    }

    /**
     * 转换日期类型为字符串yyyy-MM-dd hh:MM:ss.S格式
     *
     * @param dt 要转换的时间
     * @return 转换后的字符串
     * @roseuid 44D6EB7A00E6
     */
    public static String formatLongDateMil(Date dt) {
        if (dt == null) {
            return null;
        }
        String dateStr = null;
        synchronized (sdfm) {
            dateStr = sdfm.format(dt);
        }
        return dateStr;
    }

    /**
     * 判断参数是否大于10,小于10时默认前补0
     *
     * @param temp
     * @return java.lang.String
     * @roseuid 44D6EB7800CF
     */
    private static String formatNum(int temp) {
        String reStr;
        if (temp < 10) {
            reStr = "0" + temp;
        } else {
            reStr = "" + temp;
        }
        return reStr;
    }

    /**
     * 转化为date的默认格式：如：2015-08-03 格式化为 Mon Aug 03 00:00:00 CST 2015
     *
     * @param dateString 日期字符串
     * @param fromFormat 转化格式
     * @return java.utils.Date
     * @roseuid 44D6EB7A0027
     */
    public static Date fromDateString(String dateString, String fromFormat) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat df = new SimpleDateFormat(fromFormat);
        df.setTimeZone(gc.getTimeZone());
        df.setLenient(false);
        Date date = df.parse(dateString, new ParsePosition(0));
        return date;
    }

    /**
     * 转化为date的默认格式，只能转化yyyy-MM-dd HH:mm:ss"格式日期
     *
     * @param dateString
     * @return java.utils.Date
     * @roseuid 44D6EB7A0027
     */
    public static Date fromDateStringFixed(String dateString)
            throws ParseException {
        Date date = null;
        synchronized (dffd) {
            date = dffd.parse(dateString);
        }
        return date;
    }

    /**
     * 转化为date的默认格式
     *
     * @param dateString date类型数据
     * @return String 返回"yyyy-MM-dd HH:mm:ss"格式日期
     * @roseuid 44D6EB7A0027
     */
    public static String fromDateStringFixed(Date dateString) {
        if (dateString == null) {
            return null;
        }
        String date = null;
        synchronized (dffd) {
            date = dffd.format(dateString);
        }
        return date;
    }

    /**
     * 格式化为yyyy-MM-dd类型日期
     *
     * @param dateString 日期型字符串
     * @param dateString
     * @return java.utils.Date
     * @roseuid 44D6EB7A0027
     */
    public static Date fromDateStringFixedL(String dateString)
            throws ParseException {
        Date date = null;
        synchronized (dffdL) {
            date = dffdL.parse(dateString);
        }
        return date;
    }


    /**
     * 获取当年的第一天
     * @param
     * @return
     */
    public static String getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }
    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static String getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return formatDate(currYearFirst);
    }

    /**
     * 格式化为yyyy-MM-dd类型日期
     *
     * @return String 返回"yyyy-MM-dd"格式日期
     * @roseuid 44D6EB7A0027
     */
    public static String fromDateStringFixedL(Date date) {
        String dateString = null;
        synchronized (dffdL) {
            dateString = dffdL.format(date);
        }
        return dateString;
    }

    /**
     * 取日期的小时,24小时模式
     *
     * @param dt
     * @return
     */
    public static int getHours(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取日期的分钟
     *
     * @param dt
     * @return
     */
    public static int getMinutes(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 返回当月最大时间
     *
     * @param dtime
     * @return java.lang.String
     * @throws IllegalArgumentException
     * @roseuid 44D6EB780008
     */
    public static String getMonthMaxDay(String dtime)
            throws IllegalArgumentException {
        Calendar date = Calendar.getInstance();
        String month = "";
        String day = "";
        date.setTime(AlohaDateUtils.dateFormat(dtime));
        month = AlohaDateUtils.formatNum(date.get(Calendar.MONTH) + 1);
        day = AlohaDateUtils.formatNum(date
                .getActualMaximum(Calendar.DAY_OF_MONTH));
        return date.get(Calendar.YEAR) + "-" + month + "-" + day;
    }

    /**
     * 取日期的秒
     *
     * @param dt
     * @return
     */
    public static int getSeconds(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        return cal.get(Calendar.SECOND);
    }

    /**
     * 判断strDate是否在strComBDate和strComEDate之间
     *
     * @param strDate     要判断是日期
     * @param strTime     要判断是时间
     * @param strComBDate 被比较的开始日期
     * @param strComBTime 被比较的开始时间
     * @param strComEDate 被比较的结束日期
     * @param strComETime 被比较的结束时间
     * @return true, 在范围之内；否则， false，不在范围之内
     * @throws IllegalArgumentException
     */
    public static boolean inBound(String strDate, String strTime,
                                  String strComBDate, String strComBTime, String strComEDate,
                                  String strComETime) throws IllegalArgumentException {
        boolean flag = false;
        Date date = dateFormat(strDate, strTime);

        Date comBDate = dateFormat(strComBDate, strComBTime);
        Date comEDate = dateFormat(strComEDate, strComETime);

        if (date.after(comBDate) && date.before(comEDate)) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断时间时间段strBDate~strEDate是否在strComBDate~strComEDate中
     *
     * @param strBDate    要判断的开始日期
     * @param strBTime    要判断的开始时间
     * @param strEDate    要判断的结束日期
     * @param strETime    要判断的结束时间
     * @param strComBDate 被比较的开始日期
     * @param strComBTime 被比较的开始时间
     * @param strComEDate 被比较的结束日期
     * @param strComETime 被比较的结束时间
     * @return boolean true -- 在范围之内 false -- 不在范围之内
     * @throws IllegalArgumentException
     * @roseuid 44D6EB780315
     */
    public static boolean inBound(String strBDate, String strBTime,
                                  String strEDate, String strETime, String strComBDate,
                                  String strComBTime, String strComEDate, String strComETime)
            throws IllegalArgumentException {
        boolean flag = true;
        Date bDate = dateFormat(strBDate, strBTime);
        Date eDate = dateFormat(strEDate, strETime);

        Date comBDate = dateFormat(strComBDate, strComBTime);
        Date comEDate = dateFormat(strComEDate, strComETime);

        if (inBoundBeg(bDate, eDate, comBDate)) {
            // 判断结束时间
            if (!inBoundEnd(bDate, eDate, comEDate)) {
                flag = false;
            }
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * inBound的下属方法，用作判断
     *
     * @param bDate
     * @param eDate
     * @param comBDate
     * @return boolean true -- 在范围之内 false -- 不在范围之内
     * @roseuid 44D6EB7803E9
     */
    private static boolean inBoundBeg(Date bDate, Date eDate, Date comBDate) {
        boolean flag = true;
        if ((bDate.before(comBDate) || bDate.equals(comBDate))
                && eDate.after(comBDate)) {
            flag = false;
        }
        return flag;
    }

    /**
     * inBound的下属方法，用作判断
     *
     * @param bDate
     * @param eDate
     * @param comEDate
     * @return boolean true -- 在范围之内 false -- 不在范围之内
     * @roseuid 44D6EB7900C7
     */
    private static boolean inBoundEnd(Date bDate, Date eDate, Date comEDate) {
        boolean flag = true;
        if (bDate.before(comEDate)
                && (eDate.after(comEDate) || eDate.equals(comEDate))) {
            flag = false;
        }
        return flag;
    }

    /**
     * 取大时间
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 返回大的时间
     * @throws IllegalArgumentException
     */
    public static String maxDate(String date1, String date2)
            throws IllegalArgumentException {
        if (AlohaDateUtils.dateFormat(date1, false).after(
                AlohaDateUtils.dateFormat(date2, false))) {
            return date1;
        } else {
            return date2;
        }
    }

    /**
     * 转换日期类型为字符串YYYYMMDD格式
     *
     * @param dt 要转换的时间
     * @return 转换后的字符串
     * @roseuid 44D6EB7A00E6
     */
    public static String specificFormatDate(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(SpecificFormat);
        if (dt == null) {
            return "";
        }
        return sdf.format(dt);
    }

    /**
     * 转换日期类型为字符串YYMMDD格式
     *
     * @param dt 要转换的时间
     * @return 转换后的字符串
     * @roseuid 44D6EB7A00E6
     */
    public static String specificFormatDateYYMMDD(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(SPECIFIC_FORMAT);
        if (dt == null) {
            return "";
        }
        return sdf.format(dt);
    }

    /**
     * 转换日期类型为字符串yyyyMMddHHmmss
     *
     * @param dt Date对象
     * @return 字符串
     */
    public static String formatDateTime(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat(FormatDateTime);
        if (dt == null) {
            return "";
        }
        return sdf.format(dt);
    }

    /**
     * 转换日期类型为字符串 可以自定义格式yyyyMMddHHmmss
     *
     * @param dt Date对象
     * @return 字符串
     */
    public static String formatDateTime(Date dt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (dt == null) {
            return "";
        }
        return sdf.format(dt);
    }

    /**
     * @roseuid 44C5A3840067
     * @since 1.0
     */
    public AlohaDateUtils() {

    }

    /**
     * 时间表示格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Get the current date string representation.
     *
     * @param dateFormat the input dateFormat. See the
     *                   <code>java.text.SimpleDateFormat</code> API for date format
     *                   string examples 示例： String currDateStr =
     *                   DateUtil.getCurrentDateString("yyyy-MM-dd HH:mm:ss");
     */
    public static String getCurrentDateString(String dateFormat) {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setTimeZone(TimeZone.getDefault());

        return sdf.format(cal.getTime());
    }

    /**
     * 得到系统当前时间。格式："yyyy-MM-dd HH:mm:ss"
     *
     * @return 系统当前时间。格式："yyyy-MM-dd HH:mm:ss"
     */
    public static String getCurrentDateString() {
        return getCurrentDateString(DEFAULT_FORMAT);
    }

    /**
     * 得到当前系统时间的毫秒数
     *
     * @return long 毫秒数
     */
    public static long getCurrentDateLong() {

        Calendar cal = Calendar.getInstance();

        return cal.getTime().getTime();
    }

    /**
     * 得到当前系统时间
     *
     * @return long 毫秒数
     */
    public static Date getCurrentDate() {

        Date currDate = new Date();

        return currDate;
    }

    /**
     * 比较系统当前时间是否在传入的开始与结束时间范围内
     *
     * @param startDate String yyyy-MM-dd HH:mm:ss 开始时间
     * @param endDate   String yyyy-MM-dd HH:mm:ss 结束时间
     * @param compareTs
     * @return true在范围内, false不在范围内
     */
    public static boolean compare(String startDate, String endDate,
                                  long compareTs) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(fromDateStringFixed(startDate));
            long startMi = cal.getTimeInMillis();
            cal.setTime(fromDateStringFixed(endDate));
            long endMi = cal.getTimeInMillis();
            if (compareTs >= startMi && compareTs < endMi) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * aTime大于等于bTime则返回True
     *
     * @param aTime String yyyy-MM-dd HH:mm:ss 时间
     * @param bTime String yyyy-MM-dd HH:mm:ss 时间
     * @return aTime大于等于bTime则返回True
     */
    public static boolean compareTimeInMillis(String aTime, String bTime) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(fromDateStringFixed(aTime));
            long startMi = cal.getTimeInMillis();
            cal.setTime(fromDateStringFixed(bTime));
            long endMi = cal.getTimeInMillis();
            //System.out.println(startMi+"   "+endMi);
            if (startMi >= endMi) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * addMonths 将月份进行增加，如果是减去，将value赋值为负数即可
     *
     * @param value int
     * @return Date
     */
    public static Date addMonths(int value) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, value);

        return cal.getTime();
    }


    /**
     * addMonths 将月份进行增加，如果是减去，将value赋值为负数即可
     *
     * @param dt    需要调整的日期
     * @param value
     * @return Date
     */
    public static Date addMonths(Date dt, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.MONTH, value);

        return cal.getTime();
    }


    /**
     * addDays 将天数进行增加，如果是减去，将value赋值为负数即可
     *
     * @param date Dat 需要增加的日期
     * @param i    int 天数
     * @return Date
     */
    public static Date addDays(Date date, int i) {
        return dateAdd(date, i);
    }

    /**
     * 获得上个月时间返回（yyyy-MM-dd）
     *
     * @param date
     */
    public static String getPreMonth(Date date) {

        GregorianCalendar calender = new GregorianCalendar();

        calender.setTime(date);

        calender.add(Calendar.MONTH, -1);

        return DateFormatUtils.format(calender.getTimeInMillis(), "yyyy-MM-dd");
    }

    /**
     * 得到两个时间的相差天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDifferDay(Date startDate, Date endDate) {
        int differDay = 1;
        Long n = endDate.getTime() - startDate.getTime();
        differDay += (int) (n / (1000 * 60 * 60 * 24));
        return differDay;
    }

    public static String formatTimestampDate(Timestamp stamp) {

        return sdf.format(stamp);
    }

    public static String getMonthForLastDay(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int last = cal.getActualMaximum(cal.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return new SimpleDateFormat(FormatTimestampMil).format(cal.getTime());

    }

    public static String getMonthForFirstDay(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        int firstDay = cal.getActualMaximum(cal.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat(FormatTimestampMil).format(cal.getTime());
    }

    public static String getYearFirstDay(int year) {
        Calendar cal = Calendar.getInstance();

        cal.clear();
        cal.set(Calendar.YEAR, year);
        return new SimpleDateFormat(FormatTimestampMil).format(cal.getTime());
    }
    public static String getYearLastDay (int year){
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR,year);
        cal.roll(Calendar.DAY_OF_YEAR,-1);
        return new SimpleDateFormat(FormatTimestampMil).format(cal.getTime());
    }
    public static void main(String[] args) {
        String str = getYearFirstDay(2016);
        System.out.println(str);
        String d = getMonthForFirstDay(2016,9);
        System.out.println(d);
        String s= getMonthForLastDay(2016,9);
        System.out.println(s);
    }
}