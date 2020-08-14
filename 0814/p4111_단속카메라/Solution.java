package com.ssafy.swea.p4111_단속카메라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, K, R, answer;
	static HashSet<Integer> cameraSet;
	static ArrayList<Integer> cameras;
	static int[] diffs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++)
		{
			answer = 0;
			N = Integer.parseInt(br.readLine().trim());
			K = Integer.parseInt(br.readLine().trim());
			cameraSet = new HashSet<Integer>();
			cameras = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int n = 0; n < N; n++)
			{
				int cam = Integer.parseInt(st.nextToken());
				if (!cameraSet.contains(cam))
				{
					cameras.add(cam);
					cameraSet.add(cam);
				}
			}
			Collections.sort(cameras);
			
			N = cameras.size();
			diffs = new int[N-1];
			

			for (int i = 0; i < N-1; i++)
			{
				diffs[i] = cameras.get(i+1) - cameras.get(i);
			}
			Arrays.sort(diffs);
			
			if (N <= K)
			{
				answer = 0;
			}
			else
			{
				for (int i = 0; i <= diffs.length - K; i++)
				{
					answer += diffs[i];
				}
			}
			pw.write("#" + t + " " + answer + "\n");
		}
		pw.close();
		br.close();
	}
	

}
