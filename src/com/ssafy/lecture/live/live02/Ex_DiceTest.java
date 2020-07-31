package com.ssafy.lecture.live.live02;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {
	static int N, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("ì£¼ì‚¬?œ„ë¥? ?˜ì§? ?šŸ?ˆ˜ë¥? ?…? ¥?•´ì£¼ì„¸?š”.");
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[7];
		System.out.println("?ˆœ?—´:1, ì¤‘ë³µ?ˆœ?—´:2, ì¡°í•©:3, ì¤‘ë³µì¡°í•©:4");
		int swit = sc.nextInt();
		switch(swit)
		{
		case 1:
			System.out.println("-------?ˆœ?—´--------");
			permutation(0);
			System.out.println("totalCnt : " + totalCnt);
			System.out.println();
			break;
		case 2:
			System.out.println("------ì¤‘ë³µ?ˆœ?—´------");
			permutation_dup(0);
			System.out.println("totalCnt : " + totalCnt);
			break;
		case 3:
			System.out.println("--------ì¡°í•©-------");
			combination(0,1);
			System.out.println("totalCnt : " + totalCnt);
			break;
		case 4:
			System.out.println("------ì¤‘ë³µì¡°í•©------");
			combination_dup(0,1);
			System.out.println("totalCnt : " + totalCnt);
			break;
		}		
		sc.close();
		
	}
	
	private static void permutation(int cnt)
	{
		if (cnt == N)
		{
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for (int i = 1; i <= 6; i++)
		{
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
	
	private static void permutation_dup(int cnt)
	{
		if (cnt == N)
		{
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for (int i = 1; i <= 6; i++)
		{
			numbers[cnt] = i;
			permutation_dup(cnt+1);
		}
	}


	private static void combination(int cnt, int start)
	{
		if (cnt == N)
		{
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		for (int i = start; i <= 6; i++)
		{
			numbers[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static void combination_dup(int cnt, int start)
	{
		if (cnt == N)
		{
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for (int i = start; i <= 6; i++)
		{
			numbers[cnt] = i;
			combination_dup(cnt+1, i);
		}
	}

}
