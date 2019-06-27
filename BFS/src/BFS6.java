import java.util.*;
import java.io.*;

public class BFS6 {
	
	static Scanner in;
	static int a[], floors, s, goal, up, down;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		init();
		solve();
		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		floors = in.nextInt();
		s = in.nextInt()-1;
		goal = in.nextInt()-1;
		up = in.nextInt();
		down = in.nextInt();
		a = new int[floors];
		a[s]=1;
		q = new LinkedList<Integer>();
	}
	
	public static void solve() {
		bfs(s);
	}
	
	public static void bfs(int x) {
		int ans = 0;
		q.add(x);
		while(!q.isEmpty()) {
			x = q.poll();
			//System.out.println(Arrays.toString(a));
			if(x==goal) {
				ans = a[x]-1;
				break;
			}
			
			int nx = 0;
			nx = x + up;
			if(nx<0||nx>=floors)
				continue;
			if(nx>=0&&nx<=floors&&a[nx]==0) {
				a[nx] = a[x]+1;
				q.add(nx);
			}
			
			nx = x - down;
			if(nx<0||nx>=floors)
				continue;
			if(nx>=0&&nx<=floors&&a[nx]==0) {
				a[nx] = a[x]+1;
				q.add(nx);
			}
			
		}
		if(ans!=0)
			System.out.println(ans);
		else
			System.out.println("use the stairs");
	}
	
}
