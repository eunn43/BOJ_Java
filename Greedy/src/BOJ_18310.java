import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18310 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String tmp[] = (br.readLine()).split(" ");
		
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(tmp[i]);
		
		Arrays.sort(arr);
		
		System.out.println(arr[(n - 1) / 2]);
	}

}
