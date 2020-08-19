package com.ssafy.baekjoon.p10800_컬러볼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static class Ball implements Comparable<Ball>
	{
		@Override
		public String toString() {
			return "Ball [index=" + index + ", color=" + color + ", weight=" + weight + "]";
		}

		int index, color, weight, colorIdx;
		
		public Ball(int index, int color, int weight) {
			this.index = index;
			this.color = color;
			this.weight = weight;
		}
		

		public void setColorIdx(int colorIdx) {
			this.colorIdx = colorIdx;
		}

		@Override
		public int compareTo(Ball o) {
			if (this.weight == o.weight)
			{
				return this.color - o.color;
			}
			return this.weight - o.weight;
		}
	}
	
	static int N;
	static Ball[] ballArr;
	
	//answerArr: index별로 답을 저장하는 arr
	static int[] ansArr;
	
	static HashMap<Integer, Integer> colorSumMap = new HashMap<Integer, Integer>();

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine().trim());
		ballArr = new Ball[N];
		ansArr = new int[N];
		
		StringTokenizer st = null;
		
		for (int n = 0; n < N; n++)
		{
			st = new StringTokenizer(br.readLine().trim());
			int color = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			ballArr[n] = new Ball(n, color, weight);
			colorSumMap.put(color, 0);
		}
		
		Arrays.sort(ballArr);

		int sum = 0, colorSum = 0, pastColor = -1;
		//답 = 전체누적합 - 같은색누적합 - 같은무게다른색 합
		for (int i = 0; i < N; i++)
		{
			int color = ballArr[i].color;
			if (i > 0)
			{
				sum += ballArr[i-1].weight;
			}
			colorSum = colorSumMap.get(color);
			colorSumMap.put(color, colorSum + ballArr[i].weight);
			if (ballArr[i-1].weight == ballArr[i].weight)
			{
				if (pastColor == color)
				{
					ansArr[ballArr[i].index] = ansArr[ballArr[i-1].index];
				}
				else
				{
					
				}
			}
			
			pastColor = ballArr[i].color;
//			ansArr[ballArr[i].index] = sum - colorSum - cnt * ballArr[i].weight;
		}
		for (int i = 0; i < N; i++)
		{
			pw.write(ansArr[i] + "\n");
		}
		
		pw.close();
		br.close();
	}
	
}