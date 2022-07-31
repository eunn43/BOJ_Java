import java.util.Scanner;

public class BOJ_1107 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int len = input.nextInt();
		boolean arr[] = new boolean[10];
		for(int i = 0; i < len; i++) {
			int idx = input.nextInt();
			arr[idx] = true;
		}
	
		int min = Math.abs(n - 100), cnt;
		for(int i = 0; i <= 1000000; i++) {
			String str = i+"";
			boolean flag = true;
			for(int j = 0; j < str.length(); j++) {
				if(arr[str.charAt(j)-'0']) {
					flag = false;
					break;
				}	
			}
			if(flag) {
				cnt = str.length() + Math.abs(n - i);
				if(cnt < min)
					min = cnt;
			}	
		}

		System.out.println(min);
		input.close();

	}

}
