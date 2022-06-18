import java.util.Scanner;

public class BOJ_1476 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int E = input.nextInt();
		int S = input.nextInt();
		int M = input.nextInt();
		int e = 1, s = 1, m = 1, year = 1;
		
		while(true) {
			if(e == E && s == S && m == M)
				break;
			e++;
			s++;
			m++;
			if(e > 15)
				e = 1;
			if(s > 28)
				s = 1;
			if(m > 19)
				m = 1;
			year++;
		}
		System.out.println(year);
		input.close();
	}

}
