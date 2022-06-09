import java.util.Scanner;

public class BOJ_17626 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double n = input.nextInt();
		int cnt = 5;
		
		for(int i = (int) Math.sqrt(n); i > 0; i--) {
			if(i * i == n && cnt > 1)
				cnt = 1; 
			for(int j = i; j > 0; j--) {
				if(i * i + j * j == n && cnt > 2)
					cnt = 2;
				for(int k = j; k > 0; k--) {
					if(i * i + j * j + k * k == n && cnt > 3)
						cnt = 3;
					for(int l = k; l > 0; l--) {
						if(i * i + j * j + k * k + l * l == n && cnt > 4)
							cnt = 4;
					}
				}
			}
		}
		
		System.out.println(cnt);
		input.close();
	}

}
