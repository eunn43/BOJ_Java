import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(int i = 0; i < n ; i++) {
			int num = input.nextInt();
			if(num > idx) {
				while(idx < num) {
					stack.push(++idx);
					sb.append("+\n");
				}
			}
			else if(num != stack.peek()) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
	}

}