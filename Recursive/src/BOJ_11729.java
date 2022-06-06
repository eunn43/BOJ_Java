import java.util.Scanner;

public class BOJ_11729 {
	static StringBuilder sb;
	static void hanoi(int n, int from, int by, int to) {
		if(n == 0)
			return;
		hanoi(n-1, from, to, by);
		sb.append(from+" "+to+"\n");
		hanoi(n-1, by, from, to);			
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		sb = new StringBuilder();
		System.out.println((int)Math.pow(2, n)-1);
		hanoi(n, 1, 2, 3);
		System.out.println(sb);
		input.close();
	}

}
