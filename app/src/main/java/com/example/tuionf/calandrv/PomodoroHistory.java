package com.example.tuionf.calandrv;

/**
 * Created by tuion on 2017/8/24.
 */

public class PomodoroHistory  {

    private String day;
    private String weekDay;
    private Pomodoro pomodoro;
    private boolean isFirst = false;


    public PomodoroHistory(boolean isFirst,String day, String weekDay) {
        this.day = day;
        this.weekDay = weekDay;
        this.isFirst = isFirst;
    }

    public PomodoroHistory(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Pomodoro getPomodoro() {
        return pomodoro;
    }

    public void setPomodoro(Pomodoro pomodoro) {
        this.pomodoro = pomodoro;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }
}
