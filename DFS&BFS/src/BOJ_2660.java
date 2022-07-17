import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2660 {
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static int ch[];

	static int BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1;
		int count = 1;
		queue.offer(v);
		boolean flag;
		while(!queue.isEmpty()) {
			flag = true;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int cv = queue.poll();
				for(int nv : graph.get(cv)) {
					if(ch[nv] == 0) {
						ch[nv] = 1;
						queue.offer(nv);
					}
				}
			}
			for(int i = 1; i <= n; i++)
				if(ch[i] == 0) {
					flag = false;
					break;
				}
			if(flag)
				break;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<Integer>());
		ch = new int[n + 1];

		while(true) {
			int a = input.nextInt();
			int b = input.nextInt();
			if(a == -1)
				break;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int min = n, cnt;
		int res[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			Arrays.fill(ch, 0);
			cnt = BFS(i);
			res[i] = cnt;
			if(cnt < min)
				min = cnt;
		}
		System.out.print(min+" ");
		cnt = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(res[i] == min) {
				cnt++;
				sb.append(i+" ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
		input.close();
	}

}
