import java.util.Scanner;

public class BOJ_2503 {
	static boolean isSame(String n) {
		if(n.charAt(0) == n.charAt(1))
			return true;
		if(n.charAt(1) == n.charAt(2))
			return true;
		if(n.charAt(2) == n.charAt(0))
			return true;
		if(n.charAt(1) == '0' || n.charAt(2) == '0')
			return true;
		return false;		
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];
		int str[] = new int[n];
		int bal[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
			str[i] = input.nextInt();
			bal[i] = input.nextInt();
		}
		
		int cnt = 0;
		for(int i = 123; i <= 987; i++) {
			if(isSame(String.valueOf(i)))
				continue;
			for(int j = 0; j < n; j++) {
				
			}
		}
		System.out.println(cnt);
		input.close();
	}

}
