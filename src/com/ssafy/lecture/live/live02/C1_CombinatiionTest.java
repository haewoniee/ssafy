package com.ssafy.lecture.live.live02;

//input arr받아서 거기에서 r개의 조합 뽑기

import java.util.Arrays;
import java.util.Scanner;

public class C1_CombinatiionTest {
	
	static int N, R;
	static int[] numbers, input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
				
		input = new int[N];
		for(int i = 0; i < N; i++)
		{
			input[i] = sc.nextInt();
		}
		sc.close();

		numbers = new int[R];
		
		combination(0,0);
	}
	
	private static void combination(int cnt, int start) 
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i < N; i++)
		{
			numbers[cnt] = input[i];	
			combination(cnt+1, i+1);
		}
	}
}
