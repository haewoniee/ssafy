package com.ssafy.baekjoon.p12869_뮤탈리스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, cnt;
	static int[] select = new int[3];
	static int[] attack = {9,4,1}, minArr;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		M = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int[] scv = new int[3];
		while (st.hasMoreTokens())
		{
			scv[N] = Integer.parseInt(st.nextToken());
			N++;
		}
		
		pw.write(cnt + "\n");
		pw.close();
		br.close();
	}
}
