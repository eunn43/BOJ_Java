import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2606 {
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];
	
	static int BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1;
		int count = 0;
		queue.offer(v);
		
		while(!queue.isEmpty()) {
			int cv = queue.poll();
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					queue.offer(nv);
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
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
		
		System.out.println(BFS(1));
		
		input.close();
	}

}
