package com.ssafy.baekjoon.p10974_모든순열;

import java.util.Scanner;


public class Main {

	static int[] numbers;
	static boolean[] visited;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		numbers = new int[n];
		visited = new boolean[n+1];
		permutation(0);
		
		
		sc.close();
	}

	static void permutation(int cnt)
	{
		if (cnt == n)
		{
			for (int i = 0; i < n; i++)
			{
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++)
		{
			if (visited[i]) continue;
			
			visited[i] = true;
			numbers[cnt] = i; 
			permutation(cnt+1);
			visited[i] = false;
		}
	}
}
