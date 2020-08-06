package com.ssafy.baekjoon.p2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hw_algo0806_대전_4반_한혜원 {
	
	static int N, R, minDiff;
	static int[] bitters, sours, chosen;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine().trim());
		sours = new int[N];
		bitters = new int[N];
		minDiff = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			sours[i] = Integer.parseInt(st.nextToken());
			bitters[i] = Integer.parseInt(st.nextToken());
		}
		
		for (R = 1; R <= N; R++)
		{
			chosen = new int[R];
			nCr(0,0);
		}
		bw.write("" + minDiff);
		bw.newLine();
		bw.close();
		br.close();
	}
	
	static void nCr(int cnt, int start)
	{
		if (cnt == R)
		{
			int bitter = 0, sour = 1;
			for (int i = 0; i < R; i++)
			{
				sour *= sours[chosen[i]];
				bitter += bitters[chosen[i]];
			}
			minDiff = Math.min(minDiff, Math.abs(sour - bitter));
			return;
		}
		
		for (int i = start; i < N; i++)
		{
			chosen[cnt] = i;
			nCr(cnt+1, i+1);
		}
	}

}
