package com.ssafy.live02;

//input arr받아서 거기서 r개의 조합 뽑기

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
	
	// 지정된 자리에 조합 뽑기
	private static void combination(int cnt, int start) //cnt: 현재까지 뽑은 조합 수, start: 조합에 시작점으로 시도할 index
	{
		if (cnt == R)
		{
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		//앞선 수의 선택 다음부터 시도
		for (int i = start; i < N; i++)
		{
			numbers[cnt] = input[i];	
			combination(cnt+1, i+1);
		}
	}
}
