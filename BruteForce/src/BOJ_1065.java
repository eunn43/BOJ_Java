import java.util.Scanner;

public class BOJ_1065 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int cnt = 99;
		if(n < 100)
			cnt = n;
		else {
			if(n == 1000)
				n = 999;
			int a, b, c;
			for(int i = 100; i <= n; i++) {
				a = i / 100;
				b = (i / 10) % 10;
				c = i % 10;
				
				if(2 * b == a + c)
					cnt++;
			}
		}

		System.out.println(cnt);
		input.close();
	}

}
