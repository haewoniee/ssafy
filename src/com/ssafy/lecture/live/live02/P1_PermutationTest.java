package com.ssafy.lecture.live.live02;

import java.util.Arrays;

//??΄, 1~NκΉμ?
public class P1_PermutationTest {

	private static int N = 4, R = 2;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
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
		
		for (int i = 1; i <= N; i++)
		{
			//μ€λ³΅ ??Έ
			if (isSelected[i]) continue;
			
			numbers[cnt] = i; //?΄?Ή?«?λ₯? ?¬?©
			isSelected[i] = true;
			
			permutation(cnt+1); //?€? ?λ¦? ??΄ λ½κΈ°
			isSelected[i] = false;
		}
	}
}
