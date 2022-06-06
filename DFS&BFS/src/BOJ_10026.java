import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026 {
	static int visited[][];
	static int dx[] = {-1, 0, 0, 1};
	static int dy[] = {0, 1, -1, 0};
	
	static Boolean DFS(int i, int j, String arr[]) {
		if(visited[i][j] == 1)
			return false;
		
		char c = arr[i].charAt(j);
		visited[i][j] = 1;
		for(int k = 0; k < 4; k++) {
			if(i + dx[k] < 0 || j + dy[k] < 0 || i + dx[k] == arr.length || j + dy[k] == arr.length)
				continue;
			
			if(visited[i+dx[k]][j+dy[k]] == 0  && arr[i+dx[k]].charAt(j+dy[k]) == c)
				DFS(i+dx[k], j+dy[k], arr);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String arr1[] = new String[n];
		String arr2[] = new String[n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			arr1[i] = str;
			arr2[i] = str.replace('G', 'R');
		}
		
		visited = new int[n][n];
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == 0) {
					DFS(i, j, arr1);
					cnt++;
				}
			}
		}
		System.out.print(cnt+" ");
		
		visited = new int[n][n];
		cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j] == 0) {
					DFS(i, j, arr2);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
