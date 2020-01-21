package com.wenxia.snippet.birthinfo;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhouw
 * @Description
 * @Date 2020-01-21
 */
@Getter
@Setter
public class BirthInfo {

    // 阳历
    // 日期
    private String solarDay;
    // 时间，精确到分即可
    private String time;
    // 星期
    private String weekday;
    // 星座
    private String constellation;

    // 阴历
    // 阴历年
    private String lunarYear;
    // 阴历月日
    private String lunarDay;
    // 生辰
    private String period;
    // 属相
    private String zodiac;
    // 八字
    private String bazi;
    // 五行
    private String wuxing;
    private String wuxingDesc;

    @Override
    public String toString() {
        return solarDay + " " + time + "\n" + weekday + "\n" + constellation + "\n\n" + lunarYear
                + lunarDay + "\n" + period + "\n" + zodiac + "\n" + bazi + "\n" + wuxing + "\n" + wuxingDesc;
    }
}