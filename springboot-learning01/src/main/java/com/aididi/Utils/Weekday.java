package com.aididi.Utils;

/**
 * @Auther: Administrator
 * @Date: 2018/4/22 0022 20:45
 * @Description:
 */
public enum  Weekday {
    SUN(0),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);

    private int value;

    private Weekday(int value){
        this.value = value;
    }

    public static Weekday getNextDay(Weekday nowDay){
        int nextDayValue = nowDay.value;

        if (++nextDayValue == 7){
            nextDayValue =0;
        }

        return getWeekdayByValue(nextDayValue);
    }

    public static Weekday getWeekdayByValue(int value) {
        for (Weekday c : Weekday.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
}

class Test2{
    public static void main(String[] args) {
        System.out.println("nowday ====> " + Weekday.SAT);
        System.out.println("nowday int ====> " + Weekday.SAT.ordinal());
        // 输出 SUN
        System.out.println("nextday ====> " + Weekday.getNextDay(Weekday.SAT));

        //输出：
        //nowday ====> SAT
        //nowday int ====> 6
        //nextday ====> SUN
    }
}