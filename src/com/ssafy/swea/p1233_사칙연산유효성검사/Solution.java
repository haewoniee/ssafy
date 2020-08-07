package com.ssafy.swea.p1233_사칙연산유효성검사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Solution {
	
	static int T = 10, N;
	
//	static class Node {
//		Node left, right;
//		int nodeNum;
//		String data;
//		
//		public Node(int nodeNum)
//		{
//			this.nodeNum = nodeNum;
//			this.left = null;
//			this.right = null;
//		}
//		
//		public int size()
//		{
//			int s = 1;
//			if (left != null)
//			{
//				s += left.size();
//			}
//			if (right != null)
//			{
//				s += right.size();
//			}
//			return s;
//		}
//		
//		public boolean add(String data, int nodeNum)
//		{
//			boolean flag = false;
//			if (nodeNum == this.nodeNum)
//			{
//				this.data = data;
//				flag = true;
//			}
//			else if (this.left != null && nodeNum == this.left.nodeNum)
//			{
//				flag = left.add(data, nodeNum);
//			}
//			else if (this.right != null && nodeNum == this.right.nodeNum)
//			{
//				flag = right.add(data, nodeNum);
//			}
//			else
//			{
//				if (this.left != null)
//				{
//					flag = left.add(data, nodeNum);					
//				}
//				if (this.right != null && !flag)
//				{
//					flag = right.add(data, nodeNum);
//				}
//			}
//			return flag;
//		}
//		public boolean add(String data, int nodeNum, int leftNum, int rightNum)
//		{
//			boolean flag = false;
//			if (nodeNum == this.nodeNum)
//			{
//				this.data = data;
//				this.left = new Node(leftNum);
//				this.right = new Node(rightNum);
//				flag = true;
//			}
//			else if (this.left != null && nodeNum == this.left.nodeNum)
//			{
//				flag = left.add(data, nodeNum, leftNum, rightNum);
//			}
//			else if (this.right != null && nodeNum == this.right.nodeNum)
//			{
//				flag = right.add(data, nodeNum, leftNum, rightNum);
//			}
//			else
//			{
//				if (this.left != null)
//				{
//					flag = left.add(data, nodeNum, leftNum, rightNum);					
//				}
//				if (this.right != null && !flag)
//				{
//					flag = right.add(data, nodeNum, leftNum, rightNum);
//				}
//			}
//			return flag;
//		}
//		public boolean add(String data, int nodeNum, int leftNum)
//		{
//			boolean flag = false;
//			if (nodeNum == this.nodeNum)
//			{
//				this.data = data;
//				this.left = new Node(leftNum);
//				flag = true;
//			}
//			else if (this.left != null && nodeNum == this.left.nodeNum)
//			{
//				flag = left.add(data, nodeNum, leftNum);
//			}
//			else if (this.right != null && nodeNum == this.right.nodeNum)
//			{
//				flag = right.add(data, nodeNum, leftNum);
//			}
//			else
//			{
//				if (this.left != null)
//				{
//					flag = left.add(data, nodeNum, leftNum);					
//				}
//				if (this.right != null && !flag)
//				{
//					flag = right.add(data, nodeNum, leftNum);
//				}
//			}
//			return flag;
//		}
//		
//		@Override
//		public String toString() {
//			return "Node [nodeNum=" + nodeNum + ", data=" + data + "]";
//		}		
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		
		for (int t = 1; t <= 10; t++)
		{
			N = Integer.parseInt(br.readLine().trim());
			int flag = 1;
			for (int i = 1; i <= N; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				st.nextToken();
				String data = st.nextToken();
				if (data.length() > 1)
				{
					//무조건 숫자여야함
					if (st.hasMoreTokens())
					{
						flag = 0;
						continue;
					}
				}
				else 
				{
					char c = data.charAt(0);
					if (Character.isDigit(c))
					{
						if (st.hasMoreTokens())
						{
							flag = 0;
							continue;
						}
					}
					else
					{
						if (st.hasMoreTokens())
						{
							st.nextToken();
							if (!st.hasMoreTokens())
							{
								flag = 0;
								continue;
							}
						}
						else
						{
							flag = 0;
							continue;
						}
					}
				}
			}
			System.out.println("#" + t + " " + flag);	
		}
		br.close();
	

	}

}
