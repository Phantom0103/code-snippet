package com.wenxia.snippet.birthinfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-01-21
 */
public class BirthInfoGuess {

    private static final String PATTERN = "yyyy-MM-dd HH:mm";
    private static DateFormat format = new SimpleDateFormat(PATTERN);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);

    private static final LocalDateTime MIN_DATE_TIME = LocalDateTime.of(1900, 1, 30, 8, 0);
    private static final LocalDateTime MAX_DATE_TIME = LocalDateTime.of(2049, 12, 31, 20, 0);

    public static final String[] NUMBERS = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    public static final String[] WEEKDAYS = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    public static final String[] CONSTELLATIONS = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座",
            "天蝎座", "射手座", "摩羯座"};

    public static final String[] MONTH_ALIAS = {"正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};
    public static final String[] DAY_ALIAS = {"初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三",
            "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"};

    public static final String[] GAN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    public static final String[] ZHI = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    public static final String[] ZODIACS = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    public static final String[] PERIODS = {"子时", "丑时", "寅时", "卯时", "辰时", "巳时", "午时", "未时", "申时", "酉时", "戌时", "亥时"};

    public static final String[][] NIAN_SHANG_QI_YUE = {{"丙寅", "戊寅", "庚寅", "壬寅", "甲寅"},
            {"丁卯", "己卯", "辛卯", "癸卯", "乙卯"}, {"戊辰", "庚辰", "壬辰", "甲辰", "丙辰"}, {"己巳", "辛巳", "癸巳", "乙巳", "丁巳"},
            {"庚午", "壬午", "甲午", "丙午", "戊午"}, {"辛未", "癸未", "乙未", "丁未", "己未"}, {"壬申", "甲申", "丙申", "戊申", "庚申"},
            {"癸酉", "乙酉", "丁酉", "己酉", "辛酉"}, {"甲戌", "丙戌", "戊戌", "庚戌", "壬戌"}, {"乙亥", "丁亥", "己亥", "辛亥", "癸亥"},
            {"丙子", "戊子", "庚子", "壬子", "甲子"}, {"丁丑", "己丑", "辛丑", "癸丑", "乙丑"}};

    public static final String[][] RI_SHANG_QI_SHI = {{"甲子", "丙子", "戊子", "庚子", "壬子"}, {"乙丑", "丁丑", "己丑", "辛丑", "癸丑"},
            {"丙寅", "戊寅", "庚寅", "壬寅", "甲寅"}, {"丁卯", "己卯", "辛卯", "癸卯", "乙卯"}, {"戊辰", "庚辰", "壬辰", "甲辰", "丙辰"},
            {"己巳", "辛巳", "癸巳", "乙巳", "丁巳"}, {"庚午", "壬午", "甲午", "丙午", "戊午"}, {"辛未", "癸未", "乙未", "丁未", "己未"},
            {"壬申", "甲申", "丙申", "戊申", "庚申"}, {"癸酉", "乙酉", "丁酉", "己酉", "辛酉"}, {"甲戌", "丙戌", "戊戌", "庚戌", "壬戌"},
            {"乙亥", "丁亥", "己亥", "辛亥", "癸亥"}};

    private static int minYear = 1900;
    private static int maxYear = 2049;

    // 150年内的阴历数据，1900年到2049年
    private static final long[] LUNAR_INFO = new long[]{
            0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2, 0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250,
            0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977, 0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570,
            0x052f2, 0x04970, 0x06566, 0x0d4a0, 0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950, 0x0d4a0, 0x1d8a6,
            0x0b550, 0x056a0, 0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573,
            0x052d0, 0x0a9a8, 0x0e950, 0x06aa0, 0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950, 0x05b57, 0x056a0,
            0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6, 0x095b0, 0x049b0, 0x0a974, 0x0a4b0,
            0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570, 0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60,
            0x096d5, 0x092e0, 0x0c960, 0x0d954, 0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5, 0x0a950, 0x0b4a0,
            0x0baa4, 0x0ad50, 0x055d9, 0x04ba0, 0x0a5b0, 0x15176, 0x052b0, 0x0a930, 0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6,
            0x0a4e0, 0x0d260, 0x0ea65, 0x0d530, 0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
            0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0};

    /**
     * 通过阳历日期计算阴历日期
     *
     * @param date 1990-12-12 12:12
     * @return
     */
    public static BirthInfo guess(String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        if (dateTime.isBefore(MIN_DATE_TIME) || dateTime.isAfter(MAX_DATE_TIME)) {
            throw new IllegalArgumentException("超出我能计算的时间范围（1900-01-30 08:00 - 2049-12-31 20:00）");
        }

        BirthInfo birthInfo = new BirthInfo();

        // 阳历年月日
        String solarDay = date.substring(0, 10);
        String time = date.substring(11);
        int weekday = dateTime.getDayOfWeek().getValue();
        birthInfo.setSolarDay(solarDay);
        birthInfo.setTime(time);
        birthInfo.setWeekday(WEEKDAYS[weekday - 1]);

        // 计算星座
        String constellation = getConstellation(dateTime.getMonthValue(), dateTime.getDayOfMonth());
        birthInfo.setConstellation(constellation);

        int i = 0;
        int temp = 0;
        int lunarYear;
        int lunarMonth;
        int lunarDayOfMonth;
        boolean isLeapYear = false;
        int offset = (int) MIN_DATE_TIME.until(dateTime, ChronoUnit.DAYS);

        for (i = minYear; i <= maxYear; i++) {
            temp = daysOfLunarYear(i);
            if (offset - temp < 1) {
                break;
            } else {
                offset -= temp;
            }
        }

        lunarYear = i;
        int leapMonth = getLeapMonth(lunarYear);
        isLeapYear = leapMonth > 0;

        // 计算每个月的天数，以此递减
        for (i = 1; i < 13; i++) {
            if (i == leapMonth + 1 && isLeapYear) {
                temp = daysOfLeapMonth(lunarYear);
                isLeapYear = false;
                i--;
            } else {
                temp = daysOfMonth(lunarYear, i);
            }

            offset -= temp;

            if (offset <= 0) {
                break;
            }
        }

        offset += temp;
        lunarMonth = i;
        lunarDayOfMonth = offset;

        // 阴历年月日
        int qian = lunarYear / 1000;
        int bai = (lunarYear - 1000 * qian) / 100;
        int shi = (lunarYear - 1000 * qian - 100 * bai) / 10;
        int ge = lunarYear % 10;
        String year = NUMBERS[qian] + NUMBERS[bai] + NUMBERS[shi] + NUMBERS[ge];
        String ganzhiYear = getGanzhi(lunarYear);
        String lunarDay = MONTH_ALIAS[lunarMonth - 1] + DAY_ALIAS[lunarDayOfMonth - 1];
        birthInfo.setLunarYear(year + ganzhiYear + "年");
        birthInfo.setLunarDay(lunarDay);

        // 时辰
        int hour = dateTime.getHour();
        String period = getPeriod(hour);
        birthInfo.setPeriod(period);

        // 生肖
        String zodiac = getZodiac(lunarYear);
        birthInfo.setZodiac(zodiac);

        // 年上起月
        String ganzhiMonth = getGanzhiMonth(ganzhiYear, lunarMonth);
        // 纪日
        String ganzhiDay = getGanzhiDay(solarDay);
        // 日上起时
        String ganzhiTime = getGanzhiTime(ganzhiDay, hour);
        birthInfo.setBazi(ganzhiYear + " " + ganzhiMonth + " " + ganzhiDay + " " + ganzhiTime);

        // 五行，五行属性是以日干为准
        String[] wuxing = getWuxing(ganzhiYear, ganzhiMonth, ganzhiDay, ganzhiTime);
        String wuxingDesc = generateWuxingDesc(wuxing);
        birthInfo.setWuxing(wuxing[4]);
        birthInfo.setWuxingDesc(wuxingDesc);

        return birthInfo;
    }

    /**
     * 计算星座
     *
     * @param month
     * @param day
     * @return
     */
    private static String getConstellation(int month, int day) {
        switch (month) {
            case 1:
                return day < 20 ? "摩羯座" : "水瓶座";
            case 2:
                return day < 19 ? "水瓶座" : "双鱼座";
            case 3:
                return day < 21 ? "双鱼座" : "白羊座";
            case 4:
                return day < 21 ? "白羊座" : "金牛座";
            case 5:
                return day < 21 ? "金牛座" : "双子座";
            case 6:
                return day < 22 ? "双子座" : "巨蟹座";
            case 7:
                return day < 23 ? "巨蟹座" : "狮子座";
            case 8:
                return day < 23 ? "狮子座" : "处女座";
            case 9:
                return day < 23 ? "处女座" : "天秤座";
            case 10:
                return day < 24 ? "天秤座" : "天蝎座";
            case 11:
                return day < 22 ? "天蝎座" : "射手座";
            case 12:
                return day < 22 ? "射手座" : "摩羯座";
            default:
                return "神秘星座";
        }
    }

    /**
     * 根据小时计算时辰
     *
     * @param hour
     * @return
     */
    private static String getPeriod(int hour) {
        switch (hour) {
            case 23:
            case 0:
                return PERIODS[0];
            case 1:
            case 2:
                return PERIODS[1];
            case 3:
            case 4:
                return PERIODS[2];
            case 5:
            case 6:
                return PERIODS[3];
            case 7:
            case 8:
                return PERIODS[4];
            case 9:
            case 10:
                return PERIODS[5];
            case 11:
            case 12:
                return PERIODS[6];
            case 13:
            case 14:
                return PERIODS[7];
            case 15:
            case 16:
                return PERIODS[8];
            case 17:
            case 18:
                return PERIODS[9];
            case 19:
            case 20:
                return PERIODS[10];
            case 21:
            case 22:
                return PERIODS[11];
            default:
                return PERIODS[0];
        }
    }

    /**
     * 计算阴历年的总天数
     *
     * @param year
     * @return
     */
    private static int daysOfLunarYear(int year) {
        int sum = 29 * 12;
        for (int i = 0x8000; i >= 0x8; i >>= 1) {
            if ((LUNAR_INFO[year - 1900] & 0xfff0 & i) != 0) {
                sum++;
            }
        }

        return sum + daysOfLeapMonth(year);
    }

    /**
     * 计算阴历年闰月天数
     *
     * @param year
     * @return
     */
    private static int daysOfLeapMonth(int year) {
        if (getLeapMonth(year) == 0) {
            return 0;
        } else {
            if ((LUNAR_INFO[year - 1900] & 0xf0000) == 0) {
                return 29;
            } else {
                return 30;
            }
        }
    }

    /**
     * 计算阴历阴历年某月的天数
     *
     * @param year
     * @param month
     * @return
     */
    private static int daysOfMonth(int year, int month) {
        if ((month > 12) || (month < 0)) {
            // 月份有错
            return 0;
        }

        int bit = 1 << (16 - month);
        if (((LUNAR_INFO[year - 1900] & 0x0FFFF) & bit) == 0) {
            return 29;
        } else {
            return 30;
        }
    }

    /**
     * 计算阴历年润哪个月，没有则返回0
     *
     * @param year
     * @return
     */
    private static int getLeapMonth(int year) {
        return (int) (LUNAR_INFO[year - 1900] & 0xf);
    }

    /**
     * 根据阴历年计算干支
     *
     * @param year
     * @return
     */
    private static String getGanzhi(int year) {
        int ganN = year % 10;
        if (ganN <= 3) {
            ganN = ganN + 10 - 3 - 1;
        } else {
            ganN = ganN - 3 - 1;
        }

        int zhiN = year % 12;
        if (zhiN <= 3) {
            zhiN = zhiN + 12 - 3 - 1;
        } else {
            zhiN = zhiN - 3 - 1;
        }

        return GAN[ganN] + ZHI[zhiN];
    }

    /**
     * 根据阴历年计算生肖
     *
     * @param year
     * @return
     */
    private static String getZodiac(int year) {
        int zhiN = year % 12;
        return ZODIACS[zhiN];
    }

    /**
     * 年上起月
     *
     * @return
     */
    private static String getGanzhiMonth(String ganZhiYear, int month) {
        String nianGan = ganZhiYear.substring(0, 1);
        if ("甲".equals(nianGan) || "己".equals(nianGan)) {
            return NIAN_SHANG_QI_YUE[month - 1][0];
        } else if ("乙".equals(nianGan) || "庚".equals(nianGan)) {
            return NIAN_SHANG_QI_YUE[month - 1][1];
        } else if ("丙".equals(nianGan) || "辛".equals(nianGan)) {
            return NIAN_SHANG_QI_YUE[month - 1][2];
        } else if ("丁".equals(nianGan) || "壬".equals(nianGan)) {
            return NIAN_SHANG_QI_YUE[month - 1][3];
        } else if ("戊".equals(nianGan) || "癸".equals(nianGan)) {
            return NIAN_SHANG_QI_YUE[month - 1][4];
        } else {
            return "未知";
        }
    }

    /**
     * 纪日
     *
     * @param solarDay
     * @return
     */
    private static String getGanzhiDay(String solarDay) {
        int C = Integer.parseInt(solarDay.substring(0, 2));
        int Y = Integer.parseInt(solarDay.substring(2, 4));
        int M = Integer.parseInt(solarDay.substring(5, 7));
        if (M == 1 || M == 2) {
            int year = Integer.parseInt(solarDay.substring(0, 4)) - 1;
            C = year / 100;
            Y = year % 100;
            M += 12;
        }
        int D = Integer.parseInt(solarDay.substring(8));
        int i = ((M & 1) == 1) ? 0 : 6;

        int G = 4 * C + (int) (C / 4) + 5 * Y + (int) (Y / 4) + (int) (3 * (M + 1) / 5) + D - 3;
        int Z = 4 * C + G + 10 + i;

        int indexG = G % 10;
        indexG = (indexG == 0) ? 9 : (indexG - 1);

        int indexZ = Z % 12;
        indexZ = (indexZ == 0) ? 11 : (indexZ - 1);

        return GAN[indexG] + ZHI[indexZ];
    }

    /**
     * 日上起时
     *
     * @param ganZhiDay
     * @param time
     * @return
     */
    private static String getGanzhiTime(String ganZhiDay, int time) {
        String tianGan = ganZhiDay.substring(0, 1);
        if ((time & 1) == 1) {
            time = (time + 1) / 2;
        } else {
            time = time / 2;
        }

        if ("甲".equals(tianGan) || "己".equals(tianGan)) {
            return RI_SHANG_QI_SHI[time][0];
        } else if ("乙".equals(tianGan) || "庚".equals(tianGan)) {
            return RI_SHANG_QI_SHI[time][1];
        } else if ("丙".equals(tianGan) || "辛".equals(tianGan)) {
            return RI_SHANG_QI_SHI[time][2];
        } else if ("丁".equals(tianGan) || "壬".equals(tianGan)) {
            return RI_SHANG_QI_SHI[time][3];
        } else if ("戊".equals(tianGan) || "癸".equals(tianGan)) {
            return RI_SHANG_QI_SHI[time][4];
        } else {
            return "未知";
        }
    }

    private static String[] getWuxing(String ganZhiYear, String ganZhiMonth, String ganZhiDay, String ganZhiTime) {
        String[] wuxing = new String[8];
        wuxing[0] = getWuxingByGan(ganZhiYear.substring(0, 1));
        wuxing[1] = getWuxingByZhi(ganZhiYear.substring(1));
        wuxing[2] = getWuxingByGan(ganZhiMonth.substring(0, 1));
        wuxing[3] = getWuxingByZhi(ganZhiMonth.substring(1));
        wuxing[4] = getWuxingByGan(ganZhiDay.substring(0, 1));
        wuxing[5] = getWuxingByZhi(ganZhiDay.substring(1));
        wuxing[6] = getWuxingByGan(ganZhiTime.substring(0, 1));
        wuxing[7] = getWuxingByZhi(ganZhiTime.substring(1));
        return wuxing;
    }

    private static String getWuxingByGan(String gan) {
        if ("甲".equals(gan) || "乙".equals(gan)) {
            return "木";
        } else if ("丙".equals(gan) || "丁".equals(gan)) {
            return "火";
        } else if ("戊".equals(gan) || "己".equals(gan)) {
            return "土";
        } else if ("庚".equals(gan) || "辛".equals(gan)) {
            return "金";
        } else {
            return "水";
        }
    }

    private static String getWuxingByZhi(String zhi) {
        if ("寅".equals(zhi) || "卯".equals(zhi) || "辰".equals(zhi)) {
            return "木";
        } else if ("巳".equals(zhi) || "午".equals(zhi) || "未".equals(zhi)) {
            return "火";
        } else if ("申".equals(zhi) || "酉".equals(zhi) || "戌".equals(zhi)) {
            return "金";
        } else if ("亥".equals(zhi) || "子".equals(zhi) || "丑".equals(zhi)) {
            return "水";
        } else {
            return "土";
        }
    }

    private static String generateWuxingDesc(String[] wuXing) {
        StringBuilder desc = new StringBuilder(String.join("", wuXing));
        List<String> wuxingList = Arrays.asList(wuXing);
        if (!wuxingList.contains("金")) {
            desc.append("，五行缺金");
        } else if (!wuxingList.contains("木")) {
            desc.append("，五行缺木");
        } else if (!wuxingList.contains("水")) {
            desc.append("，五行缺水");
        } else if (!wuxingList.contains("火")) {
            desc.append("，五行缺火");
        } else if (!wuxingList.contains("土")) {
            desc.append("，五行缺土");
        } else {
            desc.append("，五行不缺");
        }

        return desc.toString();
    }

    public static void main(String[] args) {
        String birthday = "1989-01-03 14:15";
        System.out.println(guess(birthday));
    }
}
