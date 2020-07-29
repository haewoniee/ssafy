package com.ssafy.baekjoon.p10973_이전순열;

import java.util.Scanner;

public class Main {

	static int N;
	static int[] numbers;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		for (int i = 0; i < N; i++)
		{
			numbers[i] = sc.nextInt();
		}
		
		if (prev_perm())
		{
			for (int i = 0; i < N; i++)
			{
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
		}
		else
		{
			System.out.println(-1);
		}
		
		sc.close();
	}
	
	static boolean prev_perm()
	{
		boolean flag = false;
		
		//뒤에서부터 내림차순 찾기
		int i;
		for (i = N-2; i >= 0; i--)
		{
			if (numbers[i+1] < numbers[i])
			{
				flag = true;
				break;
			}
		}
		
		if (i == -1)
		{
			return flag;
		}
		
		//다시 뒤에서부터 numbers[i]보다 작은 수 찾기
		int j;
		for (j = N-1; j > i; j--)
		{
			if (numbers[j] < numbers[i])
			{
				break;
			}
		}
		
		swap(i,j);
		
		//i번째 이후를 뒤집기
		for (j = 1; j + i <= (i+N)/2; j++)
		{
			swap(j+i, N-j);
		}

		
		return flag;
	}
	
	static void swap(int i, int j)
	{
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	
	}

}
