package com.civil.aviation.human.common.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils
{

    /**
     * 8位日期格式化
     */
    public static final String YYYY  = "yyyy";

    /**
     * 格式化时间
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化当前时间
     *
     * @param format
     * @return
     */
    public static String formatNow(String format)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }
}
