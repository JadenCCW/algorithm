import java.util.*;
import java.io.*;

public class DFS5 {
	
	static Scanner in;
	static int a[][], n, m, k;
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static Queue<Integer> q;
	static ArrayList<Integer> arr;
	static int tempcount;
	
	public static void main(String[] args) throws IOException{
		
		init();
		solve();
		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		a = new int[n][m];
		arr = new ArrayList<Integer>();
		tempcount = 0;
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				a[r][c]=1;
			}
		}
		for(int q = 0; q < k; q++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			for(int r = y1; r < y2; r++) {
				for(int c = x1; c < x2; c++) {
					a[r][c] = 0;
				}
			}
		}
		//System.out.println(Arrays.deepToString(a));
	}
	
	public static void solve() {
		int count = 0;
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(a[r][c]==1) {
					dfs(r, c);
					//System.out.println(Arrays.deepToString(a));
					count++;
					arr.add(tempcount);
					tempcount = 0;
				}
			}
		}
		System.out.println(count);
		Collections.sort(arr);
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i)+1+" ");
		}
	}
	
	public static void dfs(int x, int y) {
		a[x][y]=0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx<0||nx>=n||ny<0||ny>=m)
				continue;
			if(a[nx][ny]==1) {
				dfs(nx, ny);
				tempcount++;
			}
		}
	}
	
}
