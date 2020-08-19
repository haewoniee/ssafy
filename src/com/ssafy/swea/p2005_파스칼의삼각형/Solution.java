package com.ssafy.swea.p2005_파스칼의삼각형;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int t = 1; t <= T; t++)
		{
			int N = sc.nextInt();
            int[] old = new int[1];
            for (int n = 1; n <= N; n++)
            {
                int[] newArr = new int[n];
                newArr[0] = 1;
                newArr[n-1] = 1;
                for (int i = 0; i < n; i++)
                {
                    if (i > 0 && i < n-1)
                    {
	                    newArr[i] = old[i] + old[i-1];
                    }
                    System.out.print(newArr[i] + " ");
                }
                System.out.println();
                old = newArr;
            }
        }
		sc.close();
	}
}