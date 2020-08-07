package com.ssafy.swea.p8275_햄스터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, X, M, mxHam;
	static int[] cages, mxCages;
	static int[][] records;
	static boolean sFlag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cages = new int[N+1];
			mxCages = new int[N];
			records = new int[M][3];
			mxHam = -1;
			sFlag = false;
			
			for (int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				records[i][0] = Integer.parseInt(st.nextToken());
				records[i][1] = Integer.parseInt(st.nextToken());
				records[i][2] = Integer.parseInt(st.nextToken());
			}
			nCr(1);
			System.out.print("#" + t + " ");
			if (sFlag)
			{
				for (int i = 0; i < mxCages.length; i++)
				{
					System.out.print(mxCages[i] + " ");
				}
				System.out.println();
			}
			else
			{
				System.out.println(-1);
			}
		}

		br.close();
	}
	
	static void nCr(int cnt)
	{
		if (cnt == N+1)
		{
			//검사
			boolean flag = true;
			int s = 0;
			for (int i = 0; i < records.length; i++)
			{
				s = 0;
				for (int j = records[i][0]; j <= records[i][1]; j++)
				{
					s += cages[j];
				}
				if (s != records[i][2])
				{
					flag = false;
					break;
				}
			}
			if (flag)
			{
				sFlag = true;
				s = 0;
				for (int i = 1; i < cages.length; i++)
				{
					s += cages[i];
				}
				if (s > mxHam)
				{
					mxHam = s;
					for (int i = 0; i < mxCages.length; i++)
					{
						mxCages[i] = cages[i+1];
					}
				}
			}
			return;
		}
		for (int i = 0; i <= X; i++)
		{
			cages[cnt] = i;
			nCr(cnt+1);
		}
	}

}
