package com.ssafy.baekjoon.p1113_수영장만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[][] map, visited, water;
	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		water = new int[N][M];
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			char[] inp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = inp[j] - '0';
				mx = Math.max(9-map[i][j], mx);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				water[i][j] = mx - map[i][j];
			}
		}

		for (int h = mx; h > 0; h--) {
			visited = new int[N][M];

			for (int r = 1; r < N-1; r++) {
				for (int c = 1; c < M-1; c++) {
					if (visited[r][c] == 0 && water[r][c] > 0) {
						for (int i = 0; i < 4; i++) {
							int newR = r + dr[i];
							int newC = c + dc[i];
							// 주변으로 물이 흘러내림
							if (rangeCheck(newR, newC)
									&& map[newR][newC] + water[newR][newC] < map[r][c] + water[r][c]) {
								visited[r][c] = 1;
								BFS(r, c, h);
								break;
							}
						}
					}
				}
			}
		}
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				cnt += water[r][c];
			}
		}
		
		System.out.println(cnt);
		br.close();
	}

	static void BFS(int r, int c, int h) {
		Queue<int[]> que = new LinkedList<int[]>();

		que.offer(new int[] { r, c });

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			water[cur[0]][cur[1]]--;

			for (int i = 0; i < 4; i++) {
				int newR = r + dr[i];
				int newC = c + dc[i];
				if (newR == 0 || newR == N-1 || newC == 0 || newC == M-1)
					continue;
				if (rangeCheck(newR, newC) && visited[newR][newC] == 0) {
					if (water[newR][newC] > 0 && map[newR][newC] + water[newR][newC] == h)
					{
						visited[newR][newC] = 1;
						que.offer(new int[] {newR, newC});
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

	static boolean rangeCheck(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

}
