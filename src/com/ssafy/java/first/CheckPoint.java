package com.ssafy.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int bmi = weight+100-height;
		System.out.println("비만수치는 " + bmi + "입니다.");
		if (bmi > 0)
		{
			System.out.println("당신은 비만이군요");
		}
		sc.close();
	}

}
