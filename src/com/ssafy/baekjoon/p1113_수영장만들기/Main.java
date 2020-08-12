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

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] inp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = inp[j] - '0';
			}
		}

		Queue<int[]> que = new LinkedList<int[]>();
		for (int h = 1; h <= 9; h++) {
			visited = new int[N][M];
			visited[0][0] = 1;
			que.add(new int[] { 0, 0 });
			while (!que.isEmpty()) {
				int[] cur = que.poll();
				boolean busted = false;
				if (cur[0] == 0 || cur[0] == N - 1 || cur[1] == 0 || cur[1] == M - 1) {
					busted = true;
				}
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < 4; i++) {
					int newR = cur[0] + dr[i];
					int newC = cur[1] + dc[i];
					
					if (rangeCheck(newR, newC)) {
						if (visited[newR][newC] == 0) {
							visited[newR][newC] = 1;
							que.add(new int[] { newR, newC });
							if (map[cur[0]][cur[1]] < h) {
								if (!busted && (newR == 0 || newR == N - 1 || newC == 0 || newC == M - 1)) {
									
									if (map[newR][newC] < h) {
										busted = true;
									} else {
										
										min = Math.min(min, map[newR][newC]);
									}
								} else {
									
									min = Math.min(min, map[newR][newC]);
								}
							}
						}
						
					}
				}
				if (!busted && min != Integer.MAX_VALUE && min > map[cur[0]][cur[1]]) {
					cnt += min - map[cur[0]][cur[1]];
					map[cur[0]][cur[1]] = min;
					printMap();
				}
			}
		}
		System.out.println(cnt);
		br.close();
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

	static boolean rangeCheck(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

}
