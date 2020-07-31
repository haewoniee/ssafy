package com.ssafy.baekjoon.p2493_탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, tower;
	static Stack<int[]> st = new Stack<int[]>();
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		token = new StringTokenizer(br.readLine().trim());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			tower = Integer.parseInt(token.nextToken());
			while (!st.isEmpty() && st.peek()[0] < tower) {
				st.pop();
			}
			if (!st.empty()) {
				bw.write(st.peek()[1] + " ");
			} else {
				bw.write(0 + " ");
			}
			st.add(new int[] { tower, i + 1 });
		}
		br.close();
		bw.close();
	}

}
