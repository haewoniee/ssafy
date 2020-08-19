package com.ssafy.baekjoon.p11967_불켜기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y, a, b, cnt, prevR, prevC;
	static int[][] bright, visited, dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static HashMap<Integer, ArrayList<int[]>> sMap = new HashMap<Integer, ArrayList<int[]>>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		bright = new int[N+1][N+1];
		visited = new int[N+1][N+1];
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			int roomNum = (x-1)*N+y;
			if (!sMap.containsKey(roomNum))
			{
				sMap.put(roomNum, new ArrayList<int[]>());
			}
			sMap.get(roomNum).add(new int[] {a,b});
 		}
		
		bright[1][1] = 1;
		cnt = 1;
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] {1,1});
		while (!que.isEmpty())
		{
			int[] cur = que.poll();
			int r = cur[0];
			int c = cur[1];
			if (bright[r][c] == 1)
			{
				int roomNum = (r-1)*N + c;
				if (sMap.containsKey(roomNum))
				{
					//불켜기
					for (int[] toTurnOn : sMap.get(roomNum))
					{
						if (bright[toTurnOn[0]][toTurnOn[1]] == 0)
						{
							bright[toTurnOn[0]][toTurnOn[1]] = 1;
							cnt++;
							//방문 초기화
							visited = new int[N+1][N+1];
							visited[r][c] = 1;
						}
					}
				}
			}
			//이동 
			boolean dupCheck = false;
			for (int i = 0; i < 4; i++)
			{
				int newR = r + dir[i][0];
				int newC = c + dir[i][1];
				if (rangeCheck(newR, newC) && visited[newR][newC] == 0 && bright[newR][newC] == 1)
				{
					if (newR == prevR && newC == prevC)
					{
						dupCheck = true;
					}
					else
					{
						visited[newR][newC] = 1;
						que.offer(new int[] {newR, newC});						
					}
				}
			}
			if (dupCheck)
			{
				visited[prevR][prevC] = 1;
				que.offer(new int[] {prevR, prevC});
			}
			prevR = r;
			prevC = c;			
		}
		System.out.println(cnt);
		br.close();
	}
	
	
	static boolean rangeCheck(int r, int c)
	{
		if (r > 0 && r <= N && c > 0 && c <= N)
		{
			return true;
		}
		return false;
	}

}
