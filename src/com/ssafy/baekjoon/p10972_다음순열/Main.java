package com.ssafy.baekjoon.p10972_다음순열;

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
		
		
		if (next_perm())
		{
			for (int i = 0; i < N; i++)
			{
				System.out.print(numbers[i] + " ");
			}
		}
		else
		{
			System.out.println(-1);
		}
		
		sc.close();
	}

	static boolean next_perm()
	{
		boolean flag = false;
		int i;
		for (i = N-2; i >= 0; i--)
		{
			//��������
			if (numbers[i] < numbers[i+1])
			{
				flag = true;
				break;
			}
		}
		
		if (i == -1)
		{
			return flag;
		}
		
		int j;
		for (j = N-1; j > i; j--)
		{
			if (numbers[j] > numbers[i])
			{
				break;
			}
		}
		
		swap(i,j);
		
		//j������ ���ҵ� ������
		for (j = 1; j + i <= (i+N)/2; j++)
		{
			swap(j+i, N-j);
		}
		return flag;
		
	}
	
	static void swap(int i, int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
