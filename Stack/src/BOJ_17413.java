import java.util.Scanner;
import java.util.Stack;

public class BOJ_17413 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean flag = false;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '<') {
				flag = !flag;
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append('<');
			}
			else if(str.charAt(i) == '>') {
				flag = !flag;
				sb.append(str.charAt(i));
			}
			else if(flag) {
				sb.append(str.charAt(i));
			}
			else if(!flag){
				if(str.charAt(i) == ' ') {
					while(!stack.isEmpty())
						sb.append(stack.pop());
					sb.append(' ');
				}
				else
					stack.push(str.charAt(i));
			}
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
		input.close();
	}

}
