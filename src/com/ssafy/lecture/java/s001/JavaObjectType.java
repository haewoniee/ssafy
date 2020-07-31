package com.ssafy.lecture.java.s001;

import java.util.Calendar;        // Calendar?Š” java.util?— ?ˆ?‹¤.
import java.util.Date;            // Date?Š” java.util?— ?ˆ?‹¤.
// ì°¸ì¡° ???…
public class JavaObjectType {
    public static void main(String[] args) {
        // ê¸°ë³¸ ???…?˜ ë°°ì—´?? ì°¸ì¡° ???…
        int [] m={1,2,3};            // ë°°ì—´
        int [] n=new int[] {1,2,3} ; // ë°°ì—´
        // ì°¸ì¡° ???… - ê°ì²´ ???…
        String card="H8";            // ë¬¸ì?—´
        Date d=new Date();           // ?˜¤?Š˜
        Calendar cal=Calendar.getInstance();  //?˜¤?Š˜
        //??™?œ¼ë¡? toString()?´ ë¶™ìŒ
        System.out.println(card);    // card.toString()
        System.out.println(d);       // d.toString()
        System.out.println(cal);     // cal.toString()
    }
}
