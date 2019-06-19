import java.io.*;
import java.util.*;

public class DFS1 {
	
	static Scanner in;
	static int a[][], n, m;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) {
		try {
			init();
			solve();
		}
		catch(Exception e){
			System.out.println("Bruh you stoopid");
			e.printStackTrace();
		}
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		a = new int[n][m];
		for(int i = 0; i < n; i++) {
			String temp = in.nextLine();
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(temp.charAt(j)+"");
			}
		}
	}
	
	public static void solve() {
		int count = 0;
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(a[r][c]==1) {
					dfs(r, c);
					System.out.println(Arrays.deepToString(a));
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int x, int y) {
		a[x][y]=0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m)
				continue;
			if(a[nx][ny]==1)
				dfs(nx, ny);
		}
	}
}
/*
4
5
11110
00010
11000
00111
*/