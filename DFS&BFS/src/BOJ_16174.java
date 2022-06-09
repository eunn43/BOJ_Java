import java.util.Scanner;

public class BOJ_16174 {
	static int n;
	static int [][] visited, arr;
	
	static Boolean DFS(int i, int j) {		
		visited[i][j] = 1;
		int val = arr[i][j];
		if(val == -1)
			return true;
		
		if(i+val < n && visited[i+val][j] == 0)
			if(DFS(i+val, j))
				return true;
		if(j+val < n && visited[i][j+val] == 0)
			if(DFS(i, j+val))
				return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		arr = new int[n][n];
		visited = new int[n][n];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				arr[i][j] = input.nextInt();
		
		System.out.println(DFS(0, 0) ? "HaruHaru" : "Hing");
		
		input.close();
	}

}
