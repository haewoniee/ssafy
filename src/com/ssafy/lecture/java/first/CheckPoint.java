package com.ssafy.lecture.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int bmi = weight+100-height;
		System.out.println("λΉλ§?μΉλ " + bmi + "???€.");
		if (bmi > 0)
		{
			System.out.println("?Ή? ?? λΉλ§?΄κ΅°μ");
		}
		sc.close();
	}

}
