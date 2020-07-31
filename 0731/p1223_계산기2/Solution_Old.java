package com.ssafy.swea.p1223_계산기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Solution {
	
	static Stack<String> stack;
	static String[] post;
	static int length, T = 10;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = 1;
		String original;
		while (T > 0)
		{
			length = Integer.parseInt(br.readLine().trim());
			original = br.readLine().trim();
			stack = new Stack<String>();
			int result = 0;
			post = new String[length];
			
			int curIdx = 0;
			for (int i = 0; i < length; i++)
			{				
				String cur = Character.toString(original.charAt(i));
				try {
					//숫자면 무조건 넣기
					int a = Integer.parseInt(cur);
					post[curIdx] = cur;
					curIdx++;
				}
				catch (Exception e)
				{
					if (stack.empty())
					{
						stack.add(cur);
					}
					else
					{
						//+면 있는거 다 꺼내서 post에 넣고 자기자신 넣기
						if (cur.equals("+"))
						{
							
							while (!stack.empty())
							{
								post[curIdx] = stack.pop();
								curIdx++;
							}
							stack.add(cur);
						}
						
						//*면 있는거 다 꺼내보면서 *가 있으면 post에 넣고 +가 있으면 다시 스택에 넣고 자기자신 넣기
						else if (cur.equals("*"))
						{
							while (!stack.empty())
							{
								if (stack.peek().equals('*'))
								{
									post[curIdx] = stack.pop();
									curIdx++;
								}
								else
								{
									break;
								}
							}
							stack.add(cur);
						}
					}

				}
			}
			while (!stack.empty())
			{
				post[curIdx] = stack.pop();
				curIdx++;
			}
			result = calculate();
			bw.append("#" + t + " " + result);
			bw.newLine();
			t++;
			T--;
		}
		br.close();		
		bw.close();

	}

	
	static int calculate()
	{
		int result = 0;
		for (int i = 0; i < length; i++)
		{
			String cur = post[i];
			try 
			{
				Integer.parseInt(cur);
				stack.add(cur);
			}
			catch (Exception e)
			{
				int second = Integer.parseInt(stack.pop());
				int first = Integer.parseInt(stack.pop());
				
				if (cur.equals("+"))
				{
					result = first + second;
				}
				else if (cur.equals("*"))
				{
					result = first * second;
				}
				stack.add(Integer.toString(result));
			}
		}
		return result;
	}
}
