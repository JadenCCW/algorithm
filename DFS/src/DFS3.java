//Baekjoon 1260 - Adjacency List
import java.util.*;
import java.io.*;

public class DFS3 {
	
	static Scanner in;
	static int n, m, s;
	static boolean[] v;
	static ArrayList<Integer>[] a;
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
	}
	
	public static void solve() {
		dfs(s);
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

}
