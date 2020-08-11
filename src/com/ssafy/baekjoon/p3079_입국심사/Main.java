package com.ssafy.baekjoon.p3079_입국심사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long[] T;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = new long[N];
		
		for (int i = 0; i < N; i++)
		{
			T[i] = Long.parseLong(br.readLine().trim());
		}
		
		long l = 0;
		long r = M*T[N-1];
		long mid;
		while (l < r)
		{
			mid = (r - l)/2 + l;
			long pass = numPassed(mid);
			if (pass < M)
			{
				l = mid + 1;
			}
			else if (pass >= M)
			{
				r = mid;
			}
		}
		
		System.out.println(r);
		
		br.close();
	}
	
	static long numPassed(long time)
	{
		long total = 0;
		for (int i = 0; i < N; i++)
		{
			total += time / T[i];
		}
		return total;
	}

}
