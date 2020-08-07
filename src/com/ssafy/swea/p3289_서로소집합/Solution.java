package com.ssafy.swea.p3289_서로소집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= T; t++)
		{
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N+1];
			make_set(N);
			bw.write("#" + t + " ");
			for (int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				if (Integer.parseInt(st.nextToken()) == 0)
				{
					//합
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					union(a,b);
				}
				else
				{
					//확인
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					if (find_set(a) != find_set(b))
					{
						bw.write('0');
					}
					else
					{
						bw.write('1');
					}
				}
			}
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	static void union(int a, int b)
	{
		int aP = find_set(a);
		int bP = find_set(b);
		if (aP < bP)
		{
			map[b] = aP;
			map[bP] = aP;
		}
		else if (bP < aP)
		{
			map[a] = bP;
			map[aP] = bP; 
		}
	}
	
	static int find_set(int num)
	{
		if (num == map[num])
		{
			return num;
		}
		else
		{
			map[num] = find_set(map[num]);
			return map[num];
		}
	}
	
	static void make_set(int num)
	{
		for (int i = 1; i <= num; i++)
		{
			map[i] = i;
		}
	}
}
