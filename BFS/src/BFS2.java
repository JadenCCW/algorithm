//Baekjoon 2178 - Adjacency Graph
import java.io.*;
import java.util.*;

public class BFS2 {
	
	static Scanner in;
	static int a[][], n, m;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static Queue<Integer> q;
	static int temp;
	
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
		temp = 2;
		q = new LinkedList<Integer>();
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
		bfs(0, 0);
		//System.out.println(Arrays.deepToString(a));
		System.out.println(a[n-1][m-1]-1);
	}
	
	public static void bfs(int x, int y) {
		q.add(x);
		q.add(y);
		a[x][y] = temp;
		temp++;
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m)
					continue;
				if(a[nx][ny]==1) {
					q.add(nx);
					q.add(ny);
					a[nx][ny] = a[x][y] + 1;
				}
			}
			//temp++;
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