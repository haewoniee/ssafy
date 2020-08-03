package com.ssafy.baekjoon.p2493_탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		int N = Integer.parseInt(br.readLine().trim());
		Stack<Integer> st = new Stack<Integer>();
		StringTokenizer tok = new StringTokenizer(br.readLine().trim());
		int[] map = new int[500001];
		
		for (int i = 1; i <= N; i++)
		{
			int top = Integer.parseInt(tok.nextToken());
			map[top] = i;
			if (st.isEmpty())
			{
				bw.append(0 + " ");
				st.push(top);
				continue;
			}
			while (!st.isEmpty() && st.peek() < top)
			{
				st.pop();
			}
			if (!st.isEmpty())
			{
				bw.append(map[st.peek()] + " ");
			}
			else
			{
				bw.append(0 + " ");
			}
			st.push(top);
		}
		bw.newLine();
		bw.close();
		br.close();
	}

}
