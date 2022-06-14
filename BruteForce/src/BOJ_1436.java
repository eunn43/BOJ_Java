import java.util.Scanner;

public class BOJ_1436 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int num = 0;
		int cnt = 0;
		while(true) {
			if(String.valueOf(num).contains("666"))
				cnt++;
			if(n == cnt)
				break;
			num++;
		}
		System.out.println(num);
		input.close();
	}

}
