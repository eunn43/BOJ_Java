import java.util.Scanner;
import java.util.Stack;

public class BOJ_10773 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < k; i++) {
			int n = input.nextInt();
			if(n == 0)
				stack.pop();
			else
				stack.push(n);
		}
		int cnt = 0;
		while(!stack.isEmpty()) {
			cnt += stack.pop();
		}
		System.out.println(cnt);
		input.close();
	}

}
