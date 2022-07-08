import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2667 {
	static int cnt;
	static int visited[][];
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, 1, -1, 0};
	
	static void DFS(int i, int j, String arr[]) {
		if(visited[i][j] == 1)
			return;
		
		visited[i][j] = 1;
		for(int k = 0; k < 4; k++) {
			if(i + dx[k] < 0 || j + dy[k] < 0 || i + dx[k] == arr.length || j + dy[k] == arr.length)
				continue;
			
			if(visited[i+dx[k]][j+dy[k]] == 0  && arr[i+dx[k]].charAt(j+dy[k]) == '1') {
				cnt++;
				DFS(i+dx[k], j+dy[k], arr);
			}
		}
		return;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		visited = new int[n][n];
		String arr[] = new String[n];
		
		input.nextLine();
		for(int i = 0; i < n; i++)
			arr[i] = input.nextLine();

		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == 0 && arr[i].charAt(j) == '1') {
					cnt = 1;
					DFS(i, j, arr);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		input.close();
	}

}
