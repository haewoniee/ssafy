package com.ssafy.live02;

import java.util.Arrays;

//순열, 1~N까지
public class P1_PermutationTest {

	private static int N = 4, R = 2;
	private static int[] numbers;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];
		
		permutation(0);
		
	}

	
	//지정된 자리에 순열 뽑기
	private static void permutation(int cnt) // cnt: 현재까지 뽑은 순열의 갯수
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 1; i <= N; i++)
		{
			//중복 확인
			if (isSelected[i]) continue;
			
			numbers[cnt] = i; //해당숫자를 사용
			isSelected[i] = true;
			
			permutation(cnt+1); //다음 자리 순열 뽑기
			isSelected[i] = false;
		}
	}
}
