//1697
import java.util.*;
import java.io.*;
public class BFS4 {
	
	static Scanner in;
	static int a[], n, m;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		init();
		solve();
		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		a = new int[50];
		q = new LinkedList<Integer>();
		a[n] = 1;
	}
	
	public static void solve() {
		bfs(n);
		//System.out.println(Arrays.toString(a));
	}
	
	public static void bfs(int x) {
		int ans = 0;
		q.add(x);
		while(!q.isEmpty()) {
			x = q.poll();
			
			//System.out.println(q);
			if(x==m) {
				ans = a[x]-1;
				break;
			}
			int nx = 0;
			
			nx = x + 1;
			//System.out.println(nx);
			if(nx>=0&&nx<=49&&a[nx]==0) {
				a[nx] = a[x]+1;
				q.add(nx);
			}
			
			nx = x - 1;
			if(nx>=0&&nx<=49&&a[nx]==0) {
				a[nx] = a[x]+1;
				q.add(nx);
			}
			
			nx = x * 2;
			if(nx>=0&&nx<=49&&a[nx]==0) {
				a[nx] = a[x]+1;
				q.add(nx);
			}
			
		}
		System.out.println(ans);
	}

}
