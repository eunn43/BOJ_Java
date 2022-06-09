import java.util.Scanner;

public class BOJ_2635 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int max = 0;
		String answer = "";
		for(int i = n; i >= n / 2; i--) {
			int cnt = 2;
			int first = n;
			int second = i;
			String str = n + " " + i;
			while(first - second >= 0) {
				int third = first - second;
				first = second;
				second = third;
				str += " " + third;
				cnt++;
			}
			if(max < cnt) {
				max = cnt;
				answer = str;
			}
		}
		System.out.println(max);
		System.out.println(answer);
		input.close();
	}

}
