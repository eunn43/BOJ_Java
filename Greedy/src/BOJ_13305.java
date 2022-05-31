import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int dis[] = new int[n-1];
		int cost[] = new int[n-1];
		for(int i = 0; i < n - 1; i++) {
			dis[i] = Integer.parseInt(st1.nextToken());
			cost[i] = Integer.parseInt(st2.nextToken());
		}
		
		int min = cost[0];
		long total = 0;
		long distance = 0;
		for(int i = 0; i < n - 1; i++) {
			if(min > cost[i]) {
				total += distance * min;
				min = cost[i];
				distance = 0;
			}
			distance += dis[i];
		}
		total += distance * min;
		System.out.println(total);
	}

}
