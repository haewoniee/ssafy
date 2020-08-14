package com.ssafy.baekjoon.p1113_수영장만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[][] map, visited;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static boolean busted;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		list = new ArrayList<int[]>();
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			char[] inp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = inp[j] - '0';
				mx = Math.max(map[i][j], mx);
			}
		}

		visited = new int[N][M];

		for (int h = 1; h < mx; h++) {
			for (int r = 1; r < N-1; r++) {
				for (int c = 1; c < M-1; c++) {
					if (visited[r][c] == 0 && map[r][c] == h) {
						//BFS돌아서 같은 블록 다 맞춰줌
						busted = false;
						list.clear();
						list.add(new int[] {r,c});
						visited[r][c] = 1;
						BFS(r,c,h);
						visited = new int[N][M];

						if (!busted)
						{
							for (int[] p : list)
							{
								cnt++;
								map[p[0]][p[1]]++;
							}
							printMap();
						}

					}
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
	}

	static void BFS(int r, int c, int h) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.offer(new int[] { r, c });

		while (!que.isEmpty() && !busted) {

			for (int q = 0; q < que.size(); q++)
			{
				int[] cur = que.poll();
				for (int i = 0; i < 4; i++) {
					int newR = cur[0] + dr[i];
					int newC = cur[1] + dc[i];
					if (isBoundary(newR, newC) && map[newR][newC] <= h)
					{
						busted = true;
						return;
					}
					
					if (rangeCheck(newR, newC) && visited[newR][newC] == 0) {

						if (map[newR][newC] < h)
						{
							list.clear();
							busted = true;
							return;
						}
						
						if (map[newR][newC] == h)
						{
							visited[newR][newC] = 1;
							que.add(new int[] {newR, newC});
							list.add(new int[] {newR, newC});
						}
					}
				}
			}

		}
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	static boolean isBoundary(int r, int c)
	{
		if (r == 0 || r == N-1 || c == 0 || c == M-1)
		{
			return true;
		}
		return false;
	}

	static boolean rangeCheck(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

}
