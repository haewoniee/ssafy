package com.ssafy.lecture.live.live02;

//input arrλ°μ? κ±°κΈ°? rκ°μ μ‘°ν© λ½κΈ°

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
;
		
		combination(0,0);
	}
	
	// μ§?? ? ?λ¦¬μ μ‘°ν© λ½κΈ°
	private static void combination(int cnt, int start) //cnt: ??¬κΉμ? λ½μ? μ‘°ν© ?, start: μ‘°ν©? ??? ?Όλ‘? ???  index
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//??  ?? ? ? ?€?λΆ??° ??
		for (int i = start; i < N; i++)
		{
			numbers[cnt] = input[i];	
			combination(cnt+1, i+1);
		}
	}
}
