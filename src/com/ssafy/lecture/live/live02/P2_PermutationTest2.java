package com.ssafy.lecture.live.live02;

import java.util.Arrays;
import java.util.Scanner;

//input arrλ°μ? κ±°κΈ°? rκ°μ ??΄ λ½κΈ°
public class P2_PermutationTest2 {

	private static int N, R;
	private static int[] numbers, input;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R];
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++)
		{
			input[i] = sc.nextInt();
		}
		sc.close();
		
		permutation(0);
		
	}

	
	//μ§?? ? ?λ¦¬μ ??΄ λ½κΈ°
	private static void permutation(int cnt) // cnt: ??¬κΉμ? λ½μ? ??΄? κ°??
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++)
		{
			//μ€λ³΅ ??Έ
			if (isSelected[i]) continue;
			
			numbers[cnt] = input[i]; //?΄?Ή?«?λ₯? ?¬?©
			isSelected[i] = true;
			
			permutation(cnt+1); //?€? ?λ¦? ??΄ λ½κΈ°
			isSelected[i] = false;
		}
	}
}
