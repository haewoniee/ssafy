package com.ssafy.swea.p1223_계산기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
	
	static int T, N, idx;
	static int[] eqArr;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = 10;

		for (int t = 1; t <= T; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			char[] eq = br.readLine().trim().toCharArray();
			stack = new Stack<Integer>();
			eqArr = new int[N];
			idx = 0;
			//후위연산식 만들기
			for (int i = 0; i < N; i++)
			{
				//숫자이면 리스트에 담기
				if (eq[i] - '0' >= 0 && eq[i] - '0' <= 9)
				{
					eqArr[idx] = eq[i] - '0';
					idx++;
				}
				else
				{
					switch (eq[i])
					{
					//더하기가 나오면, 있는거 다 빼서 equation에 넣기
					case '+':
						while (!stack.empty())
						{
							eqArr[idx] = stack.pop();
							idx++;
						}
						break;
					case '*':
						//곱하기가 나오면, 곱하기보다 낮은 +가 나오면 다시 넣고 아닌경우에만 eqarr에 넣기
						while (!stack.empty())
						{
							if ((char) (stack.peek() + '0') == '+')
							{
								break;
							}
							else
							{
								eqArr[idx] = stack.pop();
								idx++;
							}
						}
						break;
					}
					stack.add(eq[i] - '0');
				}	
			}
			while (!stack.empty())
			{
				eqArr[idx] = stack.pop();
				idx++;
			}
			int result = calculate();
			System.out.println("#" + t + " " + result);
		}
		
		br.close();
		bw.close();
	}

	static int calculate()
	{
		for (int i = 0; i < N; i++)
		{
			int cur = eqArr[i];
			//숫자
			if (cur >= 0)
			{
				stack.add(cur);
			}
			else
			{
				int first = stack.pop();
				int second = stack.pop();
				int res = 0;
				switch (cur)
				{
				case -5:
					res = first + second;
					break;
				case -6:
					res = first * second;
					break;
				}
				stack.add(res);
			}
		}
		return stack.pop();
	}
	
}
