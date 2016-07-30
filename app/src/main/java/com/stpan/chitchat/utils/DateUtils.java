package com.stpan.chitchat.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * <p>Title: DateUtils</p>
 * <p>Description: 日期工具类</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: pubinfo</p>
 * <p>Usage: </p>
 *
 * @author trundle
 * @version 1.0
 */

public class DateUtils {
    private static Calendar calendar = Calendar.getInstance();

    /**
     * 将Date根据指定格式(yyyy-MM-dd HH:mm:ss)转化成字符串
     *
     * @param date   Date
     * @param format String
     * @return String
     */
    public static String baseFormatDateTime(Date date, String format) {
        SimpleDateFormat mydate = new SimpleDateFormat(format,Locale.getDefault());
        return mydate.format(date);
    }

    /**
     * 将long类型时间根据指定格式(yyyy-MM-dd HH:mm:ss)转化成字符串
     *
     * @param millis long
     * @param format String
     * @return String
     */
    public static String baseFormatDateTime(long millis, String format) {
        return baseFormatDateTime(new Date(millis), format);
    }

    /**
     * 获得当天零点的时间 long类型
     */
    public static long getTodayZero() {
        Date date = new Date();
        long l = 24 * 60 * 60 * 1000;
        return (date.getTime() - (date.getTime() % l) - 8 * 60 * 60 * 1000);
    }
    /**
     * 取得格式化日期时间的函数 2004-10-25 05:34:23
     *
     * @param date Date
     * @return String
     */
    public static String getFormatDateTime(Date date) {
        return baseFormatDateTime(date, "yyyy-MM-dd HH:mm:ss");

    }

    /**
     * 取得格式化日期时间的函数 2004-10-25 05:34:23
     *
     * @param millis long
     * @return String
     */
    public static String getFormatDateTime(long millis) {
        return getFormatDateTime(new Date(millis));
    }

    /**
     * 取得格式化日期的函数 2004-10-25
     *
     * @param date Date
     * @return String
     */
    public static String getFormatDate(Date date) {
        return baseFormatDateTime(date, "yyyy-MM-dd");
    }

    /**
     * 取得格式化日期的函数 2004-10-25
     *
     * @param millis long
     * @return String
     */
    public static String getFormatDate(long millis) {
        return getFormatDate(new Date(millis));
    }


    /**
     * 根据日期得到年份字符串
     *
     * @param date Date
     * @return String
     */
    public static String getYear(Date date) {
        String tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy",Locale.getDefault());
        tempstr = "";
        mydate.applyPattern("yyyy");
        i = Integer.parseInt(mydate.format(date));
        tempstr = tempstr + String.valueOf(i);
        return tempstr;
    }

    /**
     * 根据日期得到月份字符串
     *
     * @param date Date
     * @return String
     */
    public static String getMonth(Date date) {
        String tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MM dd H mm ss,yyyy",Locale.getDefault());
        tempstr = "";
        mydate.applyPattern("MM");
        i = Integer.parseInt(mydate.format(date));
        tempstr += String.valueOf(i);
        return tempstr;
    }

    /**
     * 根据日期得到日期字符串
     *
     * @param date Date
     * @return String
     */
    public static String getDay(Date date) {
        String Tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MM dd H mm ss,yyyy",Locale.getDefault());
        Tempstr = "";
        mydate.applyPattern("dd");
        i = Integer.parseInt(mydate.format(date));
        Tempstr = Tempstr + String.valueOf(i);
        return Tempstr;
    }

    /**
     * 根据日期得到小时字符串
     *
     * @param date Date
     * @return String
     */
    public static String getHour(Date date) {
        String Tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MM dd H mm ss,yyyy",Locale.getDefault());
        Tempstr = "";
        mydate.applyPattern("H");
        i = Integer.parseInt(mydate.format(date));
        Tempstr = Tempstr + String.valueOf(i);
        return Tempstr;
    }

    public static String getFormatDateTime(Long lngObj) {
        return getFormatDateTime(lngObj.longValue());
    }

    /**
     * 根据日期得到格式化小时、分 例如  02:32
     *
     * @param date Date
     * @return String
     */
    public static String getFormatTime(Date date) {
        String Tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy",Locale.getDefault());
        Tempstr = "";

        mydate.applyPattern("H");
        i = Integer.parseInt(mydate.format(date));
        if (i < 10) {
            Tempstr = Tempstr + "0" + String.valueOf(i) + ":";
        } else {
            Tempstr = Tempstr + String.valueOf(i) + ":";
        }

        mydate.applyPattern("mm");
        i = Integer.parseInt(mydate.format(date));
        if (i < 10) {
            Tempstr = Tempstr + "0" + String.valueOf(i);
        } else {
            Tempstr = Tempstr + String.valueOf(i);
        }
        return Tempstr;
    }

    /**
     * 根据日期得到小时 格式例如  02
     *
     * @param date Date
     * @return String
     */
    public static String getFormatHour(Date date) {
        String Tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy",Locale.getDefault());
        Tempstr = "";

        mydate.applyPattern("H");
        i = Integer.parseInt(mydate.format(date));
        Tempstr = Tempstr + String.valueOf(i);
        return Tempstr;
    }

    /**
     * 根据日期得到分钟的格式例如  28
     *
     * @param date Date
     * @return String
     */
    public static String getFormatMinute(Date date) {
        String Tempstr;
        int i;
        SimpleDateFormat mydate = new SimpleDateFormat(" MMM dd H mm ss,yyyy",Locale.getDefault());
        Tempstr = "";

        mydate.applyPattern("mm");
        i = Integer.parseInt(mydate.format(date));
        Tempstr = Tempstr + String.valueOf(i);
        return Tempstr;
    }

    /**
     * 用于只输入年月日生成long型的时间格式
     *
     * @param yy int
     * @param mm int
     * @param dd int
     * @return long
     */
    public static long getTimeLong(int yy, int mm, int dd) {
        calendar.clear();
        calendar.set(yy, mm - 1, dd, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 用于输入年月日小时分生成long型的时间格式
     *
     * @param yy int
     * @param mm int
     * @param dd int
     * @param h  int
     * @param m  int
     * @return long
     */
    public static long getTimeLong(int yy, int mm, int dd, int h, int m) {
        calendar.clear();
        calendar.set(yy, mm - 1, dd, h, m, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 用于只输入年，月生成long型的时间格式
     *
     * @param yy int
     * @param mm int
     * @return long
     */
    public static long getTimeLong(int yy, int mm) {
        calendar.clear();
        calendar.set(yy, mm - 1, 0, 0, 0, 0);
        return calendar.getTimeInMillis();
    }

    /**
     * 根据输入的初始日期和新增的月份到新增月份后的总时间
     *
     * @param startTime Date
     * @param month     long
     * @return long
     */
    public static long getTotalTime(Date startTime, long month) {
        calendar.setTime(startTime);
        calendar.add(calendar.MONTH, (int) month);
        return calendar.getTimeInMillis();
    }

    /**
     * 用于输入年月日小时分秒生成long型的时间格式
     *
     * @param yy  int
     * @param mm  int
     * @param dd  int
     * @param h   int
     * @param m   int
     * @param sec int
     * @return long
     */
    public static long getTimeLong(int yy, int mm, int dd, int h, int m,
                                         int sec) {
        calendar.clear();
        calendar.set(yy, mm - 1, dd, h, m, sec);
        return calendar.getTimeInMillis();
    }

    /**
     * 从日期时间字符串中取得时间的long型
     *
     * @param datetime String 格式: 2006-12-31 00:00:00
     * @return long
     */
    public static long getLongTimefromString(String datetime) {
        String args[] = datetime.split(" ");
        String date = args[0];
        String time = args[1];

        String dateArgs[] = date.split("-");
        String timeArgs[] = time.split(":");

        return getTimeLong(Integer.parseInt(dateArgs[0])
                , Integer.parseInt(dateArgs[1])
                , Integer.parseInt(dateArgs[2])
                , Integer.parseInt(timeArgs[0])
                , Integer.parseInt(timeArgs[1])
                , Integer.parseInt(timeArgs[2]));

    }

    /**
     * 将2005-10-19类型转换成long型
     *
     * @param date String
     * @return long
     */
    public static long getLongDateFromString(String date) {
        String[] args = date.split("-");
        return getTimeLong(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    /**
     * 返回相应格式的时间字符串，iFlag == 0，返回年月日时分秒
     * iFlag == 1，返回年－月－日 时：分：秒
     * iFlag == 2，返回年月日
     * iFlag == 3，返回年－月－日
     * iFlag == 4，返回年－月
     *
     * @param lngDate long  要转化的时间
     * @param iFlag   int  要转化的时间格式
     * @return String    相应格式的时间字符串
     */
    public static String getFormatDate(long lngDate, int iFlag) {
        return getFormatDate(new Date(lngDate), iFlag);
    }

    /**
     * 返回相应格式的时间字符串，iFlag == 0，返回年月日时分秒
     * iFlag == 1，返回年－月－日 时：分：秒
     * iFlag == 2，返回年月日
     * iFlag == 3，返回年－月－日
     * iFlag == 4，返回年－月
     *
     * @param date  Date  要转化的时间
     * @param iFlag int  要转化的时间格式
     * @return String    相应格式的时间字符串
     */
    public static String getFormatDate(Date date, int iFlag) {
        SimpleDateFormat simpleDateFormat;
        if (iFlag == 0) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.getDefault());
        } else if (iFlag == 1) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.getDefault());
        } else if (iFlag == 2) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
        } else if (iFlag == 3) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        } else if (iFlag == 4) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM",Locale.getDefault());
        } else if (iFlag == 5) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM HH",Locale.getDefault());
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM HH:mm",Locale.getDefault());
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 转化当前的时间，返回相应格式的时间字符串，iFlag == 0，返回年月日时分秒
     *
     * @param iFlag int
     * @return String
     */
    public static String getFormatDate(int iFlag) {
        return getFormatDate(new Date(), iFlag);
    }

    /**
     * 根据输入一个时间得到和现在的时间差
     *
     * @param tagTime long
     * @return String
     */
    public static String getLeaveTime(long tagTime) {
        long nowTime = System.currentTimeMillis();
        long leaveTime;
        if (nowTime > tagTime)
            leaveTime = (nowTime - tagTime) / 1000;
        else
            leaveTime = -1;
        long date ;
        long hour ;
        long minute ;
        long dateTime;
        long hourTime ;
        String strDate = "";
        String strHour = "";
        String strMinute = "";
        date = leaveTime / 86400;
        dateTime = date * 86400;
        hour = (leaveTime - dateTime) / 3600;
        hourTime = hour * 3600;
        minute = (leaveTime - dateTime - hourTime) / 60;
        if (date > 0)
            strDate = date + "天";
        if (hour > 0 || (minute > 0 && date > 0))
            strHour = hour + "小时";
        if (minute > 0)
            strMinute = minute + "分";
        return strDate + strHour + strMinute;
    }

    /**
     * 查询公元某年某月某日为星期几,0代表星期天
     *
     * @param year  int
     * @param month int
     * @param day   int
     * @return int
     */
    public static int getWeekDay(int year, int month, int day) {
        if (month < 3) {
            month += 13;
            year--;
        } else month++;
        return (day + 26 * month / 10 + year + year / 4 - year / 100 + year / 400 +
                6) % 7;
    }

    public static String getTimeSplitStr(Date date) {
        String result;
        long timeMills = date.getTime();
        if (isSameDay(timeMills)) {
            Calendar calendar1 = GregorianCalendar.getInstance();
            calendar1.setTime(date);
            int hour = calendar1.get(Calendar.HOUR_OF_DAY);
            if (hour > 17) {
                result = "晚上 hh:mm";
            } else if (hour >= 0 && hour <= 6) {
                result = "凌晨 hh:mm";
            } else if (hour > 11 && hour <= 17) {
                result = "下午 hh:mm";
            } else {
                result = "上午 hh:mm";
            }
        } else if (isYesterday(timeMills)) {
            result = "昨天 HH:mm";
        } else {
            result = "M月d日 HH:mm";
        }
        return (new SimpleDateFormat(result, Locale.CHINA)).format(date);
    }

    public static boolean isCloseEnough(long timeMills1, long timeMills2) {
        return Math.abs(timeMills1 - timeMills2) < 1000 * 60 * 2;
    }

    private static boolean isSameDay(long timeMills) {
        TimeInfo timeInfo = getTodayStartAndEndTime();
        return timeMills > timeInfo.getStartTime() && timeMills < timeInfo.getEndTime();
    }

    private static boolean isYesterday(long timeMills) {
        TimeInfo timeInfo = getYesterdayStartAndEndTime();
        return timeMills > timeInfo.getStartTime() && timeMills < timeInfo.getEndTime();
    }


    public static TimeInfo getTodayStartAndEndTime() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.HOUR, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date date1 = calendar1.getTime();
        long timeMills1 = date1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.HOUR, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        Date date2 = calendar2.getTime();
        long timeMills2 = date2.getTime();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setStartTime(timeMills1);
        timeInfo.setEndTime(timeMills2);
        return timeInfo;
    }

    public static TimeInfo getYesterdayStartAndEndTime() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, -1);
        calendar1.set(Calendar.HOUR, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date date1 = calendar1.getTime();
        long timeMills1 = date1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, -1);
        calendar2.set(Calendar.HOUR, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        Date date2 = calendar2.getTime();
        long timeMills2 = date2.getTime();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setStartTime(timeMills1);
        timeInfo.setEndTime(timeMills2);
        return timeInfo;
    }

    public static TimeInfo getBeforeYesterdayStartAndEndTime() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, -2);
        calendar1.set(Calendar.HOUR, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date date1 = calendar1.getTime();
        long timeMills1 = date1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, -2);
        calendar2.set(Calendar.HOUR, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        Date date2 = calendar2.getTime();
        long timeMills2 = date2.getTime();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setStartTime(timeMills1);
        timeInfo.setEndTime(timeMills2);
        return timeInfo;
    }

    public static TimeInfo getCurrentMonthStartAndEndTime() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.set(Calendar.HOUR, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date date1 = calendar1.getTime();
        long timeMills1 = date1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        Date date2 = calendar2.getTime();
        long timeMills2 = date2.getTime();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setStartTime(timeMills1);
        timeInfo.setEndTime(timeMills2);
        return timeInfo;
    }

    public static TimeInfo getLastMonthStartAndEndTime() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.set(Calendar.HOUR, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        Date date1 = calendar1.getTime();
        long timeMills1 = date1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.MONTH, -1);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.set(Calendar.HOUR, 23);
        calendar2.set(Calendar.MINUTE, 59);
        calendar2.set(Calendar.SECOND, 59);
        calendar2.set(Calendar.MILLISECOND, 999);
        calendar2.roll(Calendar.DAY_OF_MONTH, -1);
        Date date2 = calendar2.getTime();
        long timeMills2 = date2.getTime();
        TimeInfo timeInfo = new TimeInfo();
        timeInfo.setStartTime(timeMills1);
        timeInfo.setEndTime(timeMills2);
        return timeInfo;
    }

    private static class TimeInfo {
        private long startTime;
        private long endTime;

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }
    }
}
