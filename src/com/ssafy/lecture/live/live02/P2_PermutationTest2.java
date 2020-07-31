package com.ssafy.lecture.live.live02;

import java.util.Arrays;
import java.util.Scanner;

//input arr받아?�� 거기?�� r개의 ?��?�� 뽑기
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

	
	//�??��?�� ?��리에 ?��?�� 뽑기
	private static void permutation(int cnt) // cnt: ?��?��까�? 뽑�? ?��?��?�� �??��
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++)
		{
			//중복 ?��?��
			if (isSelected[i]) continue;
			
			numbers[cnt] = input[i]; //?��?��?��?���? ?��?��
			isSelected[i] = true;
			
			permutation(cnt+1); //?��?�� ?���? ?��?�� 뽑기
			isSelected[i] = false;
		}
	}
}
