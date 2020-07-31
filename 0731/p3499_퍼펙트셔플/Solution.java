package com.ssafy.swea.p3499_퍼펙트셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N;
	static Queue<String> first, second;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			first = new LinkedList<String>();
			second = new LinkedList<String>();
			
			for (int i = 0; i < Math.ceil(N/2.0); i++)
			{
				first.add(st.nextToken());
			}
			for (int j = 0; j < N/2; j++)
			{
				second.add(st.nextToken());
			}
			
			int flag = 0;
			bw.append("#" + t + " ");
			for (int i = 0; i < N; i++)
			{
				if (flag == 0)
				{
					bw.append(first.poll() + " ");
				}
				else
				{
					bw.append(second.poll() + " ");
				}
				flag ^= 1;
			}
			
			bw.newLine();
		}
		bw.close();
		br.close();
	}

}
