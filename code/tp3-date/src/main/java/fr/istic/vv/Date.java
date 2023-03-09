package fr.istic.vv;


import java.util.Objects;

class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
        return false;
    }
        int maxDay = daysInMonth(month, year);
        return day <= maxDay;
    }

    public static boolean isLeapYear(int year) { return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0); }

    public Date nextDate() { int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;
        int daysInMonth = daysInMonth(month, year);
        if (nextDay > daysInMonth) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }
        return new Date(nextDay, nextMonth, nextYear); }

    public Date previousDate() { int prevDay = day - 1;
        int prevMonth = month;
        int prevYear = year;
        if (prevDay == 0) {
            prevMonth--;
            if (prevMonth == 0) {
                prevMonth = 12;
                prevYear--;
            }
            prevDay = daysInMonth(prevMonth, prevYear);
        }
        return new Date(prevDay, prevMonth, prevYear); }

    public int compareTo(Date other) {
        Objects.requireNonNull(other, "Cannot compare to null");
        if (year != other.year) {
            return Integer.compare(year, other.year);
        } else if (month != other.month) {
            return Integer.compare(month, other.month);
        } else {
            return Integer.compare(day, other.day);
        } }

    private static int daysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

}

