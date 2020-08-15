package com.ssafy.baekjoon.p1917_정육면체전개도;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int maxR, minR, minC, maxC, cntFolded;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[6][6];
		for (int t = 0; t < 3; t++)
		{
			cntFolded = 0;
			visited = new boolean[6][6];
			for (int i = 0; i < 6; i++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 6; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean found = false;
			for (int i = 0; i < 6 && !found; i++)
			{
				for (int j = 0; j < 6; j++)
				{
					if (map[i][j] == 1)
					{
						maxR = i;
						maxC = j;
						minR = i;
						minC = j;
						visited[i][j] = true;
						DFS(i, j);
						found = true;
						break;
					}
				}
			}
			boolean correct = true;
			
			if (maxR - minR == 3 && maxC - minC == 2)
			{
				//맨 윗줄이나 맨 아랫줄이 3개 이상 차있는 경우 무조건 실패
				int upCnt = 0, dnCnt = 0;
				for (int i = minR; i <= maxR; i++)
				{
					if (map[i][minC] == 1)
					{
						upCnt++;
					}
					if (map[i][maxC] == 1)
					{
						dnCnt++;
					}
				}
				if (upCnt >= 3 || dnCnt >= 3)
				{
					correct = false;
				}
				if (cntFolded != 10)
				{
					correct = false;
				}
			}
			else if (maxR - minR == 2 && maxC - minC == 3)
			{
				//맨 윗줄이나 맨 아랫줄이 3개 이상 차있는 경우 무조건 실패
				int upCnt = 0, dnCnt = 0;
				for (int i = minC; i <= maxC; i++)
				{
					if (map[minR][i] == 1)
					{
						upCnt++;
					}
					if (map[maxR][i] == 1)
					{
						dnCnt++;
					}
				}
				if (upCnt >= 3 || dnCnt >= 3)
				{
					correct = false;
				}
				if (cntFolded != 10)
				{
					correct = false;
				}
			}
            else if (maxR - minR == 1 && maxC - minC == 4)
            {
                int upCnt = 0, dnCnt = 0;

                for (int i = minC; i <= maxC; i++)
				{
					if (map[minR][i] == 1)
					{
						upCnt++;
					}
					if (map[maxR][i] == 1)
					{
						dnCnt++;
					}
				}
                if (upCnt < 3 || dnCnt < 3)
                {
                    correct = false;
                }

            }
            else if (maxR - minR == 4 && maxC - minC == 1)
            {
                int upCnt = 0, dnCnt = 0;

                for (int i = minR; i <= maxR; i++)
				{
					if (map[i][minC] == 1)
					{
						upCnt++;
					}
					if (map[i][maxC] == 1)
					{
						dnCnt++;
					}
				}
                if (upCnt < 3 || dnCnt < 3)
                {
                    correct = false;
                }

            }
			else
			{
				correct = false;
			}

			if (correct)
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
		}
		br.close();
	}
	
	
	static void DFS(int r, int c)
	{
		int cnt = 0;
		for (int i = 0; i < 4; i++)
		{
			int newR = r + dr[i];
			int newC = c + dc[i];
			if (rangeCheck(newR, newC) && map[newR][newC] == 1)
			{
				cnt++;
				if ( !visited[newR][newC])
				{
					maxR = Math.max(maxR, newR);
					maxC = Math.max(maxC, newC);
					minR = Math.min(minR, newR);
					minC = Math.min(minC, newC);
					visited[newR][newC] = true;
					DFS(newR,newC);					
				}
			}
		}
		cntFolded += cnt;
	}

	static boolean rangeCheck(int r, int c)
	{
		if (r >= 0 && r < 6 && c >= 0 && c < 6)
		{
			return true;
		}
		return false;
	}
}