import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724 {
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];
	
	static int BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		if(ch[v] == 1)
			return 0;
		ch[v] = 1;
		if(graph.get(v).size() == 0)
			return 1;
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
		
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(BFS(i) != 0)
				cnt++;
		}
		
		System.out.println(cnt);
		
		input.close();
	}

}
