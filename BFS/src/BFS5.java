//7576 Tomato - Adjacency Graph
import java.util.*;
import java.io.*;

public class BFS5 {
	
	static Scanner in;
	static int a[][], n, m;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static Queue<Integer> q;
	
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
		m = in.nextInt();
		n = in.nextInt();
		q = new LinkedList<Integer>();
		in.nextLine();
		a = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				a[i][j] = in.nextInt();
				if(a[i][j]==1) {
					q.add(i);
					q.add(j);
				}
			}
		}
	}
	
	public static void solve() {
		bfs();
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				count = Math.max(count, a[i][j]);
			}
		}
		int zeroes = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j]==0) zeroes++;
			}
		}
		if(zeroes>0) {
			System.out.println(-1);
		}
		else {
			System.out.println(count-1);
		}
		System.out.println(Arrays.deepToString(a));
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0||nx>=n||ny<0||ny>=m)
					continue;
				if(a[nx][ny]==0) {
					q.add(nx);
					q.add(ny);
					a[nx][ny] = a[x][y]+1;
				}
			}
		}
	}
	
	

}
