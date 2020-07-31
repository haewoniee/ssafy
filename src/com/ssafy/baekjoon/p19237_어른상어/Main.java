package com.ssafy.baekjoon.p19237_어른상어;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, TLE = 1000, sharkCnt, tick;
	static int[][][] map;
	static int[][] dir = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Shark[] sharks;
	static ArrayList<int[]> smells = new ArrayList<int[]>();

	public static class Shark {
		int num, r, c, dir;
		int[][] priorities = new int[5][4];

		public Shark(int num, int r, int c) {
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
		tick = 0;
		//설정
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
					smells.add(new int[] {i, j});
				}
			}
		}
		
		//상어들 방향 저장
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < M; i++)
		{
			sharks[i].setDir(Integer.parseInt(st.nextToken()));
		}
		
		//상어들 우선순위 저장
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
//		printMap();

		while (!endFlag && tick <= TLE)
		{
			tick++;
			ArrayList<int[]> newPoints = new ArrayList<int[]>();;
			
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
								newPoints.add(new int[] {newR, newC, s.num});
								s.dir = pr[i];
								movedFlag = true;
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
								newPoints.add(new int[] {newR, newC, s.num});
								s.dir = pr[i];
								movedFlag = true;
								break;
							}
						}
					}


				}
			}
			
			// 냄새 -1
			for (Iterator<int[]> it = smells.iterator(); it.hasNext(); )
			{
				int[] sm = it.next();
				if (map[sm[0]][sm[1]][1] > 0)
				{
					map[sm[0]][sm[1]][1]--;
				}
				if (map[sm[0]][sm[1]][1] == 0)
				{
					map[sm[0]][sm[1]][1] = 0;
					it.remove();
				}
			}
			
			//새로운 냄새 남기기, 충돌있으면 상어 제거 (r -> -1)
			for (int[] newPt : newPoints)
			{
				if (map[newPt[0]][newPt[1]][1] == 0 || map[newPt[0]][newPt[1]][0] == newPt[2])
				{
					sharks[newPt[2]-1].r = newPt[0];
					sharks[newPt[2]-1].c = newPt[1];
					if (map[newPt[0]][newPt[1]][1] == 0)
					{
						map[newPt[0]][newPt[1]][0] = newPt[2];
						smells.add(new int[] {newPt[0], newPt[1]});
					}
					else
					{
						map[newPt[0]][newPt[1]][1] = K;
					}
					map[newPt[0]][newPt[1]][1] = K;

				}
				else
				{
					sharkCnt--;
					if (sharkCnt == 1)
					{
						endFlag = true;
						break;
					}
					sharks[newPt[2]-1].r = -1;
				}
			}
//			printMap();

		}
		tick = tick > TLE? -1 : tick;
		System.out.println(tick);
		br.close();
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j][1] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
