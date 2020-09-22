package com.reggie.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import static java.time.temporal.TemporalAdjusters.*;

@Slf4j
public class DateUtil {
    public static final String DATE_LOCAL = "^[1-9]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
    public static final String DATE_ISO = "^[1-9]\\d{3}/([1-9]|0[1-9]|1[0-2])/([1-9]|0[1-9]|[1-2][0-9]|3[0-1])$";
    public static final String DATE_NUMBER = "^[1-9]\\d{3}(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";

    public static Date toDate(LocalDate date) {
        if (null == date) {
            return null;
        }
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate toLocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * exp: 2016-12-08 12:23:44 => 2016-12-08 00:00:00
     *
     * @param date
     * @return
     */
    public static LocalDate toLocalDate(LocalDateTime date) {
        if (null == date) {
            return null;
        }
        return date.toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获取"yyyyMMdd"格式的日期字符串
     *
     * @param date 需要转换成"yyyyMMdd"的日期类
     * @return the string 转换后的字符串
     */
    public static String toNumericString(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DatePattern.DAY_INT.getFormatter());
    }

    /**
     * 只用指定格式转成日期字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String toFormatString(LocalDate date, DatePattern pattern) {
        return toFormatString(date, pattern.getFormatter());
    }

    public static String toFormatString(LocalDate date, DateTimeFormatter formatter) {
        if (date == null) {
            return null;
        }
        return date.format(formatter);
    }

    public static String toFormatString(LocalDate date, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return toFormatString(date, formatter);
        } catch (IllegalArgumentException e) {
            log.error("Invalid toFormatString {}", format);
        }
        return null;
    }

    /**
     * 获取"yyyy-MM-dd"格式的日期字符串
     *
     * @param date 需要转换成"yyyy-MM-dd"的日期类
     * @return the string 转换后的字符串
     */
    public static String toString(LocalDate date) {
        return date == null ? null : date.toString();
    }

    /**
     * 字符串，不指定格式的转换成日期.
     *
     * @param strDate 日期的字符串
     * @return the date 日期类，如：yyyy/MM/dd yyyy-MM-dd yyyyMMdd
     */
    public static LocalDate fromString(String strDate) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        }
        if (strDate.length() == 10 && strDate.matches(DATE_LOCAL)) {
            return LocalDate.parse(strDate);
        } else if (strDate.length() == 8 && strDate.matches(DATE_NUMBER)) {
            return fromNumericString(strDate);
        } else if (strDate.length() == 28 && strDate.indexOf('T') == 10
                && strDate.indexOf('.') == 19 && strDate.indexOf('+') == 23) {
            return OffsetDateTime.ofInstant(Instant.from(DatePattern.TIME_WITH_ZONE.getFormatter().parse(strDate)), ZoneId.systemDefault()).toLocalDate();
        } else if (strDate.matches(DATE_ISO)) {
            return LocalDate.parse(strDate, DatePattern.DAY_WITHOUT_ZERO.getFormatter());
        }
        log.error("parse {} to Local Date failed!", strDate);
        return null;
    }

    public static LocalDate fromNumericString(String numericString) {
        return fromDatePattern(numericString, DatePattern.DAY_INT);
    }

    public static LocalDate fromISOString(String strDate) {
        if (strDate == null || strDate.trim().length() <= 0) {
            return null;
        }
        return LocalDate.parse(strDate);
    }

    public static LocalDate fromDatePattern(String strDate, DatePattern pattern) {
        if (strDate == null || strDate.trim().length() <= 0) {
            return null;
        }
        return LocalDate.parse(strDate, pattern.getFormatter());
    }

    public static LocalDateTime fromTimeStamp(long timeStamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timeStamp), ZoneId.systemDefault());
    }

    public static LocalDateTime fromString(String time, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            return fromString(time, formatter);
        } catch (IllegalArgumentException e) {
            log.error("Invalid toFormatString {}", format);
        }
        return null;
    }

    public static LocalDateTime fromString(String time, DatePattern pattern) {
        return fromString(time, pattern.getFormatter());
    }

    public static LocalDateTime fromString(String time, DateTimeFormatter formatter) {
        if (time == null || time.trim().length() <= 0) {
            return null;
        }
        return LocalDateTime.parse(time, formatter);
    }

    public static String toDateTimeString(LocalDateTime createdTime) {
        return toFormatString(createdTime, DatePattern.SECOND);
    }

    public static String toFormatString(LocalDateTime createdTime, DatePattern pattern) {
        return createdTime == null ? null : createdTime.format(pattern.getFormatter());
    }

    public static String toFormatString(LocalDateTime createdTime, String pattern) {
        return createdTime == null ? null : createdTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * exp: 2016-12-08 12:23:44 => 2016-12-08 23:59:59
     *
     * @param date
     * @return
     */
    public static LocalDateTime getEndOfDate(LocalDateTime date) {
        if (null == date) {
            return null;
        }
        return LocalDateTime.of(date.toLocalDate(), LocalTime.MAX);
    }

    public static LocalDate moveDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    public static LocalDate getFirstDayOfYear() {
        return LocalDate.now().with(firstDayOfYear());
    }

    public static LocalDate getLastDayOfYear(LocalDate now) {
        return now.with(lastDayOfYear());
    }

    public static LocalDate moveToEndOfMonth(LocalDate date) {
        return date.with(lastDayOfMonth());
    }

    public static int differ(LocalDate d1, LocalDate d2) {
        return (int) Math.abs(d1.toEpochDay() - d2.toEpochDay());
    }

    public static long getMilliSecond(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static LocalDate getToday() {
        return LocalDate.now();
    }

    public static LocalDate getMaxDate(LocalDate... dates) {
        return Arrays.stream(dates).filter(Objects::nonNull).max(Comparator.naturalOrder()).orElse(null);
    }

    public static LocalDate getMinDate(LocalDate... dates) {
        return Arrays.stream(dates).filter(Objects::nonNull).min(Comparator.naturalOrder()).orElse(null);
    }

    public static String getYearSeason(LocalDate date) {
        return date.getYear() + "-" + date.get(IsoFields.QUARTER_OF_YEAR);
    }

    public static boolean isEndOfMonth(LocalDate date) {
        return date.getDayOfMonth() == date.lengthOfMonth();
    }

    public static LocalDate getEndOfMonth(LocalDate date) {
        return date.withDayOfMonth(date.lengthOfMonth());
    }

    public static boolean isEndOf(LocalDate date, String frequency) {
        if (isEndOfMonth(date)) {
            switch (frequency) {
                case "season":
                    return date.getMonthValue() % 3 == 0;
                case "semi":
                    return date.getMonthValue() % 6 == 0;
                case "year":
                    return date.getMonth() == Month.DECEMBER;
                default:
            }
        }
        return false;
    }

    public static LocalDate getLastEndOf(LocalDate date, String frequency) {
        int k;
        switch (frequency) {
            case "season":
                k = 3;
                break;
            case "semi":
                k = 6;
                break;
            case "year":
                k = 12;
                break;
            default:
                throw new IllegalArgumentException("frequency " + frequency + " is not supported");
        }

        int offset = date.getMonthValue() % k;
        if (offset == 0) {
            offset = k;
        }

        return getEndOfMonth(date.minusMonths(offset));
    }

    public static LocalDate moveDateBy(LocalDate date, String frequency) {
        switch (frequency) {
            case "season":
                return getEndOfMonth(date.minusMonths(3));
            case "semi":
                return getEndOfMonth(date.minusMonths(6));
            case "year":
                return getEndOfMonth(date.minusYears(1));
            default:
        }
        throw new IllegalArgumentException("frequency " + frequency + " is not supported");
    }

    public static LocalDate moveToEndOfNextWeek(LocalDate date) {
        return date.with(next(DayOfWeek.MONDAY)).with(next(DayOfWeek.SUNDAY));
    }

    public static LocalDate moveToEndOfThisWeek(LocalDate date) {
        return date.with(nextOrSame(DayOfWeek.SUNDAY));
    }

    public static LocalDate moveToEndOfLastWeek(LocalDate date) {
        return date.with(previous(DayOfWeek.SUNDAY));
    }

    public static LocalDate moveToEndOfNextMonth(LocalDate date) {
        return date.with(firstDayOfNextMonth()).with(lastDayOfMonth());
    }

    public static LocalDate moveToEndOfThisMonth(LocalDate date) {
        return date.with(lastDayOfMonth());
    }

    public static LocalDate moveToEndOfLastMonth(LocalDate date) {
        return date.minusMonths(1).with(lastDayOfMonth());
    }

    public static LocalDate moveToEndOfNextSeason(LocalDate date) {
        LocalDate lastDay = date.plusMonths(3);
        Month month = lastDay.getMonth();
        while (month != Month.MARCH && month != Month.JUNE && month != Month.SEPTEMBER && month != Month.DECEMBER) {
            lastDay = lastDay.plusMonths(1);
            month = lastDay.getMonth();
        }
        return lastDay.with(lastDayOfMonth());
    }

    public static LocalDate moveToEndOfThisSeason(LocalDate date) {
        LocalDate lastDay = date;
        Month month = lastDay.getMonth();
        while (month != Month.MARCH && month != Month.JUNE && month != Month.SEPTEMBER && month != Month.DECEMBER) {
            lastDay = lastDay.plusMonths(1);
            month = lastDay.getMonth();
        }
        return lastDay.with(lastDayOfMonth());
    }

    public static LocalDate moveToEndOfLastSeason(LocalDate date) {
        LocalDate lastDay = date.minusMonths(3);
        Month month = lastDay.getMonth();
        while (month != Month.MARCH && month != Month.JUNE && month != Month.SEPTEMBER && month != Month.DECEMBER) {
            lastDay = lastDay.plusMonths(1);
            month = lastDay.getMonth();
        }
        return lastDay.with(lastDayOfMonth());
    }

    public static LocalDate moveToEndOfNextSemi(LocalDate date) {
        LocalDate lastDay = date;
        if (lastDay.getMonthValue() <= 6) {
            lastDay = lastDay.with(lastDayOfYear());
        } else {
            lastDay = lastDay.plusYears(1).withMonth(6).with(lastDayOfMonth());
        }
        return lastDay;
    }

    public static LocalDate moveToEndOfThisSemi(LocalDate date) {
        LocalDate lastDay = date;
        if (lastDay.getMonthValue() <= 6) {
            lastDay = lastDay.withMonth(6).with(lastDayOfMonth());
        } else {
            lastDay = lastDay.withMonth(12).with(lastDayOfMonth());
        }
        return lastDay;
    }

    public static LocalDate moveToEndOfLastSemi(LocalDate date) {
        LocalDate lastDay = date;
        if (lastDay.getMonthValue() <= 6) {
            lastDay = lastDay.minusYears(1).with(lastDayOfYear());
        } else {
            lastDay = lastDay.withMonth(6).with(lastDayOfMonth());
        }
        return lastDay;
    }

    public static int getMonthDis(LocalDate start, LocalDate end) {
        int diffYear = start.getYear() - end.getYear();
        return diffYear * 12 + start.getMonth().getValue() - end.getMonth().getValue();
    }

    public static LocalDate getBeginningOfNextMonth(LocalDate date) {
        return date.plusMonths(1).withDayOfMonth(1);
    }

    public static LocalDate getEndOfLastMonth(LocalDate date) {
        LocalDate lastMonth = date.minusMonths(1);
        return lastMonth.withDayOfMonth(lastMonth.lengthOfMonth());
    }

    @Getter
    public enum DatePattern {
        /** yyyy-MM */
        MONTH("yyyy-MM"),
        /** yyyy-ww */
        WEEK("yyyy-ww"),
        /** yyyy-MM-dd */
        DAY("yyyy-MM-dd"),
        /** yyyy/MM/dd */
        DAY_2("yyyy/MM/dd"),
        /** yyyyMMdd */
        DAY_INT("yyyyMMdd"),
        /** yyyy-MM-dd HH */
        HOUR("yyyy-MM-dd HH"),
        /** yyyy-MM-dd HH:mm */
        MINUTE("yyyy-MM-dd HH:mm"),
        /** yyyy-MM-dd HH:mm:ss */
        SECOND("yyyy-MM-dd HH:mm:ss"),
        /** yyyyMMddHHmmss */
        ANNOUNCEMENT_TIME("yyyyMMddHHmmss"),
        /** yyyy-MM-dd'T'HH:mm:ss.SSSZ */
        TIME_WITH_ZONE("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
        /** yyyyMMdd HH:mm:ss */
        BRAIN_TIME("yyyyMMdd HH:mm:ss"),
        /** yyyy/M/d */
        DAY_WITHOUT_ZERO("yyyy/M/d"),
        /** HH:mm:ss */
        TIME("HH:mm:ss");

        private String value;
        private DateTimeFormatter formatter;
        DatePattern(String value) {
            this.value = value;
            this.formatter = DateTimeFormatter.ofPattern(value);
        }
    }
}