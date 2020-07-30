package com.ssafy.baekjoon.p19237_어른상어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K, TLE = 1000, sharkCnt, tick = 0;
	static int[][][] map;
	static int[][] dir = {{},{-1,0},{1,0},{0,-1},{0,1}};
	static Shark[] sharks;
	
	public static class Shark {
		int num, r, c, dir;
		int[][] priorities = new int[5][4];
		LinkedList<int[]> smells = new LinkedList<int[]>();
		
		public Shark(int num, int r, int c)
		{
			this.num = num;
			this.r = r;
			this.c = c;
		}

		public void setDir(int dir) {
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sharks = new Shark[M];
		sharkCnt = M;
		map = new int[N][N][2];
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++)
			{
				map[i][j] = new int[] {Integer.parseInt(st.nextToken()), 0};
				if (map[i][j][0] > 0)
				{
					int sharkNum = map[i][j][0];
					sharks[sharkNum-1] = new Shark(sharkNum, i,j);
					map[i][j] = new int[] {sharkNum, K};
					sharks[sharkNum-1].smells.add(new int[] {i, j});
				}
			}
		}
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < M; i++)
		{
			sharks[i].setDir(Integer.parseInt(st.nextToken()));
		}
		
		
		for (int i = 0; i < M; i++)
		{
			for (int j = 1; j <= 4; j++)
			{
				st = new StringTokenizer(br.readLine().trim());
				for (int p = 0; p < 4; p++)
				{
					sharks[i].priorities[j][p] = Integer.parseInt(st.nextToken()); 
				}
			}
		}
	
		boolean endFlag = false;
		printMap();

		while (!endFlag && tick < TLE)
		{
			for (Shark s : sharks)
			{
				if (s.r != -1)
				{
					int[] pr = s.priorities[s.dir];
					boolean movedFlag = false;
					//4방 탐색하면서 이동방향 정하기
					for (int i = 0; i < 4; i++)
					{
						int[] newdir = dir[pr[i]];
						int newR = s.r + newdir[0];
						int newC = s.c + newdir[1];
						//비었으면 그쪽으로 이동
						if (newR >= 0 && newR < N && newC >= 0 && newC < N)
						{
							if (map[newR][newC][1] == 0)
							{
								s.r = newR;
								s.c = newC;
								s.dir = pr[i];
								movedFlag = true;
								break;								
							}
							else if (map[newR][newC][1] == 4 && map[newR][newC][0] != s.num)
							{
								//겹쳤음. 상어제거
								sharkCnt--;
								s.r = -1;
								movedFlag = true;
								if (sharkCnt == 1)
								{
									endFlag = true;
									break;
								}
								break;
							}
						}
					}
					if (!movedFlag)
					{
						//자신의 냄새가 있는 칸으로 이동
						for (int i = 0; i < 4; i++)
						{
							int[] newdir = dir[pr[i]];
							int newR = s.r + newdir[0];
							int newC = s.c + newdir[1];
							if (newR >= 0 && newR < N && newC >= 0 && newC < N
									&& map[newR][newC][1] > 0 && map[newR][newC][0] == s.num)
							{
								s.r = newR;
								s.c = newC;
								s.dir = pr[i];
								movedFlag = true;
								break;
							}
						}
					}

					if (s.r != -1)
					{
						s.smells.add(new int[] {s.r, s.c});
						map[s.r][s.c] = new int[] {s.num, K};
					}

				}
			}
			for (Shark s : sharks)
			{
				for (Iterator<int[]> it = s.smells.iterator(); it.hasNext(); )
				{
					int[] sm = it.next();
					if (!(sm[0] == s.r && sm[1] == s.c))
					{
						if (map[sm[0]][sm[1]][1] > 0)
						{
							map[sm[0]][sm[1]][1]--;
						}
						if (map[sm[0]][sm[1]][1] == 0)
						{
							map[sm[0]][sm[1]][0] = 0;
							it.remove();
						}
					}

				}

			}
			tick++;
			printMap();

		}
		tick = tick == TLE? 0 : tick;
		System.out.println(tick);
		br.close();
	}
	
	static void printMap()
	{
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.print(map[i][j][1] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
