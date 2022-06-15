import java.util.Scanner;
import java.util.Stack;

public class BOJ_4949 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = "";
		while(true) {
			str += input.nextLine();
			if(str.equals("."))
				break;
			if(str.charAt(str.length()-1) != '.')
				continue;
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '(' || c == '[')
					stack.push(c);
				else if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					}
					stack.pop();
				}
				else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.isEmpty())
				flag = false;
			System.out.println(flag ? "yes" : "no");
			str = "";
		}
		input.close();
	}

}
