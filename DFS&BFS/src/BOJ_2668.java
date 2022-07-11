import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2668 {
	static int start;
	static int[] visited;
	static List<Integer> list;
	
	static void DFS(int idx, int arr[]) {
		if(arr[idx] == start)
			list.add(start);
		
		if(visited[arr[idx]] == 0) {
			visited[idx] = 1;
			DFS(arr[idx], arr);
			visited[idx] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int [n+1];
		visited = new int[n+1];
		list = new LinkedList<>();
		for(int i = 1; i <= n; i++)
			arr[i] = input.nextInt();
		
		for(int i = 1; i <= n; i++) {
			visited[i] = 1;
			start = i;
			DFS(i, arr);
			visited[i] = 0;
		}

		Collections.sort(list);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		input.close();
	}

}
