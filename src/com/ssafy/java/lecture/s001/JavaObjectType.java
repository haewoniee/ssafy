package com.ssafy.java.lecture.s001;

import java.util.Calendar;        // Calendar? java.util? ??€.
import java.util.Date;            // Date? java.util? ??€.
// μ°Έμ‘° ???
public class JavaObjectType {
    public static void main(String[] args) {
        // κΈ°λ³Έ ???? λ°°μ΄?? μ°Έμ‘° ???
        int [] m={1,2,3};            // λ°°μ΄
        int [] n=new int[] {1,2,3} ; // λ°°μ΄
        // μ°Έμ‘° ??? - κ°μ²΄ ???
        String card="H8";            // λ¬Έμ?΄
        Date d=new Date();           // ?€?
        Calendar cal=Calendar.getInstance();  //?€?
        //???Όλ‘? toString()?΄ λΆμ
        System.out.println(card);    // card.toString()
        System.out.println(d);       // d.toString()
        System.out.println(cal);     // cal.toString()
    }
}
