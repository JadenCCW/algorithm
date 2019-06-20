import java.util.*;
import java.io.*;

public class BFS3 {
	
	static Scanner in;
	static int n, m, s;
	static boolean[] v;
	static ArrayList<Integer>[] a;
	static String result;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		
		init();
		solve();
		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt();
		v = new boolean[n+1];
		a = new ArrayList[n+1];
		result = "";
		for(int i = 0; i < n+1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		q = new LinkedList<Integer>();
		for(int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
	}
	
	public static void solve() {
		bfs(s);
		System.out.println(result);
	}
	
	public static void bfs(int s) {
		v[s] = true;
		q.add(s);
		result += s + " ";
		while(!q.isEmpty()) {
			int temp = q.poll();
			for(int i = 0; i < a[temp].size(); i++) {
				int curr = a[temp].get(i);
				if(v[curr]==true)
					continue;
				result += curr + " ";
				q.add(curr);
			}
		}
	}

}
