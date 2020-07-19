package com.example.calci;

import java.util.Calendar;

public class ageCalculator {
    private int startYear;
    private int startMonth;
    private int startDay;

    private int presentYear;
    private int presentMonth;
    private int presentDay;

    private int diffYear;
    private int diffMonth;
    private int diffDay;

    private Calendar today = Calendar.getInstance();

    //Get current date
    public int getpresentYear()
    {
        presentYear = today.get(Calendar.YEAR);
        return presentYear;
    }

    public int getpresentMonth(){
        presentMonth = today.get(Calendar.MONTH) + 1;
        return presentMonth;
    }

    public int getpresentDay(){
        presentDay = today.get(Calendar.DAY_OF_MONTH);
        return presentDay;
    }

    //Split birthday
    public void birthdayNumber(String birthDay){

        String[] dateArray = birthDay.split("\\/");

        startYear = Integer.parseInt(dateArray[2]);
        startDay = Integer.parseInt(dateArray[1]);
        startMonth = Integer.parseInt(dateArray[0]);

    }

    //Year difference
    public void diffYear(){
        diffYear = presentYear - startYear;
        if(diffYear < 0){
            diffYear = 0;
        }
    }

    //Month difference
    public void diffMonth(){
        if(startMonth > presentMonth){
            diffMonth = (presentMonth + 12) - startMonth;
            diffYear--;
        } else {
            diffMonth = presentMonth -  startMonth;
        }
    }

    //Day difference
    public void diffDay(){
        if(diffYear == 0 && startMonth >= presentMonth && startDay >= presentDay){
            diffDay = 0;
        } else {
            if (startDay > presentDay) {
                diffDay = (presentDay + 30) - startDay;
                if (diffMonth == 0) {
                    diffMonth = 11;
                    diffYear--;
                } else {
                    diffMonth--;
                }
            } else {
                diffDay = presentDay - startDay;
            }
        }
    }

    //Get result
    public String getResult(){
        return  diffYear + " years\n" + diffMonth + " months\n" +  diffDay + " days old";
    }

}
