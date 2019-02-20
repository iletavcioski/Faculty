import java.util.*;
import java.io.*;
import java.lang.*;

public class DN06_63180383 {
	public static void main(String[] args)  {

		Scanner s = new Scanner(System.in);
		int n, m, u;
		int counter0 = 0;
		int counter1 = 0;
		int[][] mat = new int[1005][1005];
		boolean[][] vis = new boolean[1005][1005];
		int[] v = new int[1005];
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};

		n = s.nextInt();
		m = s.nextInt();
		for (int i = 0; i < 1004; i++) {
			for (int j = 0; j < 1004; j++) {
				vis[i][j] = false;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = s.nextInt();
				if (mat[i][j] == 0) {
					counter0++;
				}
				if (mat[i][j] > counter1) {
					counter1 = mat[i][j];
				}
			}
		}
		u = s.nextInt();
		if (u == 1) {
			System.out.println(counter1);
		}
		if (u == 2) {
			System.out.println(counter0);
		}
		if (u == 3) {
			for (int i = 0; i <= counter1; i++) {
				v[i] = 0;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
						v[mat[i][j]]++;
						continue;
					}
					if (mat[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							int a = i + dx[k];
							int b = j + dy[k];
							if (a == n || b == m || a < 0 || b < 0) {
								continue;
							}
							if (mat[a][b] == 0) {
								v[mat[i][j]]++;
								break;
							}
						}
					}
				}
			}
			for (int i = 1; i <= counter1; i++) {
				System.out.println(v[i]);
			}
		}
		if (u == 4) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (mat[i][j] != 0) {
						for (int k = 0; k < 4; k++) {
							int a = i + dx[k];
							int b = j + dy[k];
							if (a == n || b == m || a < 0 || b < 0) {
								continue;
							}
							if (mat[a][b] == 0) {
								continue;
							}
							if (mat[i][j] != mat[a][b]) {
								vis[mat[i][j]][mat[a][b]] = true;
							}
						}
					}
				}
			}

			int m1 = -1;
			int m2 = -1;
			for (int i = 1; i <= counter1; i++) {
				int brojac = 0;
				for (int j = 1; j <= counter1; j++) {
					if (vis[i][j] == true) {
						brojac++;
					}
				}
				if (brojac > m1) {
					m1 = brojac;
					m2 = i;
				}
			}
			System.out.println(m2);
			System.out.println(m1);
		}
	}
}