package com.ssafy.lecture.java.s001;

import java.util.Calendar;        // Calendar?�� java.util?�� ?��?��.
import java.util.Date;            // Date?�� java.util?�� ?��?��.
// 참조 ???��
public class JavaObjectType {
    public static void main(String[] args) {
        // 기본 ???��?�� 배열?? 참조 ???��
        int [] m={1,2,3};            // 배열
        int [] n=new int[] {1,2,3} ; // 배열
        // 참조 ???�� - 객체 ???��
        String card="H8";            // 문자?��
        Date d=new Date();           // ?��?��
        Calendar cal=Calendar.getInstance();  //?��?��
        //?��?��?���? toString()?�� 붙음
        System.out.println(card);    // card.toString()
        System.out.println(d);       // d.toString()
        System.out.println(cal);     // cal.toString()
    }
}
