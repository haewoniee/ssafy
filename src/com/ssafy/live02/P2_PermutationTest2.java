package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

//input arr받아서 거기서 r개의 순열 뽑기
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

	
	//지정된 자리에 순열 뽑기
	private static void permutation(int cnt) // cnt: 현재까지 뽑은 순열의 갯수
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++)
		{
			//중복 확인
			if (isSelected[i]) continue;
			
			numbers[cnt] = input[i]; //해당숫자를 사용
			isSelected[i] = true;
			
			permutation(cnt+1); //다음 자리 순열 뽑기
			isSelected[i] = false;
		}
	}
}
