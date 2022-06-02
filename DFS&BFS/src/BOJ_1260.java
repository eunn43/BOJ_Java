import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];
	
	static void DFS(int v) {
		for(int nv : graph.get(v)) {
			if(ch[nv] == 0) {
				ch[nv] = 1;
				System.out.print(" "+nv);
				DFS(nv);
			}
		}
	}
	
	static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1;
		queue.offer(v);
		System.out.print(v);
		
		while(!queue.isEmpty()) {
			int cv = queue.poll();
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					queue.offer(nv);
					System.out.print(" "+nv);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int v = input.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<Integer>());
		ch = new int[n + 1];
		for(int i = 0; i < m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i = 0; i <= n; i++)
			Collections.sort(graph.get(i));
		
		ch[v] = 1;
		System.out.print(v);
		
		DFS(v);
		System.out.println();
		
		for(int i = 0; i <= n; i++)
			ch[i] = 0;
		
		BFS(v);
		
		input.close();
	}

}
