package com.ssafy.live.lec02;

import java.util.Arrays;

//?��?��, 1~N까�?
public class P1_PermutationTest {

	private static int N = 4, R = 2;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0);
		
	}

	
	//�??��?�� ?��리에 ?��?�� 뽑기
	private static void permutation(int cnt) // cnt: ?��?��까�? 뽑�? ?��?��?�� �??��
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= N; i++)
		{
			//중복 ?��?��
			if (isSelected[i]) continue;
			
			numbers[cnt] = i; //?��?��?��?���? ?��?��
			isSelected[i] = true;
			
			permutation(cnt+1); //?��?�� ?���? ?��?�� 뽑기
			isSelected[i] = false;
		}
	}
}
