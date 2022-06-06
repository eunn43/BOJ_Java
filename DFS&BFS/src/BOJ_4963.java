import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4963 {
	static int w, h;
	static int [][] visited, arr;
	static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int dy[] = {-1, 0,  1, -1, 1, -1, 0, 1};
	
	static Boolean DFS(int i, int j) {
		if(visited[i][j] == 1 || arr[i][j] == 0)
			return false;
		
		visited[i][j] = 1;
		for(int k = 0; k < 8; k++) {
			if(i + dx[k] < 0 || j + dy[k] < 0 || i + dx[k] == h || j + dy[k] == w)
				continue;
			
			if(visited[i+dx[k]][j+dy[k]] == 0  && arr[i+dx[k]][j+dy[k]] == 1)
				DFS(i+dx[k], j+dy[k]);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0"))
				break;
			
			w = Integer.parseInt(str.split(" ")[0]);
			h = Integer.parseInt(str.split(" ")[1]);
			arr = new int[h][w];
			visited = new int[h][w];
			int cnt = 0;
			
			for(int i = 0; i < h; i++) {
				str = br.readLine();
				for(int j = 0; j < w; j++)
					arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}

			for(int i = 0; i < h; i++)
				for(int j = 0; j < w; j++)
					if(DFS(i, j))
						cnt++;
			
			System.out.println(cnt);
		}
	}

}
