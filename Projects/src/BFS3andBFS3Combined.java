import java.util.*;
import java.io.*;

public class BFS3andBFS3Combined {
	
	static Scanner in;
	static int n, m, s;
	static boolean[] v;
	static ArrayList<Integer>[] a;
    static Queue<Integer> q;
	static String result;
	
	public static void main(String[] args) {
		
		try {
			init();
			solve();
		}
		catch(Exception e) {
			System.out.println();
			System.out.println("Boi you stoopid");
			e.printStackTrace();
		}
		
	}
	
	public static void init() {
		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt();
		v = new boolean[n+1];
		a = new ArrayList[n+1];
        q = new LinkedList<Integer>();
		result = "";
		for(int i = 0; i < n+1; i++) {
			a[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x].add(y);
			a[y].add(x);
		}
		for(int i = 0; i < n; i++) {
			Collections.sort(a[i]);
		}
	}
	
	public static void solve() {
		dfs(s);
		System.out.println(result);
		result = "";
        v = new boolean[n+1];
        bfs(s);
		System.out.println(result);
	}
	
	public static void dfs(int s) {
		v[s] = true;
		result += s+" ";
		for(int i = 0; i < a[s].size(); i++) {
			int temp = a[s].get(i);
			if(v[temp])	continue;
			dfs(temp);			
		}
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
				v[curr] = true;
			}
		}
	}

}
