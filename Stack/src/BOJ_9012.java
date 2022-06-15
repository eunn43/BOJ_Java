import java.util.Scanner;
import java.util.Stack;

public class BOJ_9012 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		for(int i = 0; i < n; i++) {
			String str = input.nextLine();
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(')
					stack.push(str.charAt(j));
				else {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty())
				flag = false;
			System.out.println(flag ? "YES" : "NO");
		}
		input.close();
	}

}
