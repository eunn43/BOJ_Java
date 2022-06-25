import java.util.Scanner;

public class BOJ_1251 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int len = str.length();
		String ans = "";
		for(int i = 1; i < len-1; i++) {
			for(int j = i+1; j < len; j++) {
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				StringBuilder sb3 = new StringBuilder();
				StringBuilder sb = new StringBuilder();
				
				sb1.append(str.substring(0, i)).reverse().toString();
				sb2.append(str.substring(i, j)).reverse().toString();
				sb3.append(str.substring(j, len)).reverse().toString();
				sb.append(sb1).append(sb2).append(sb3);
				
				if(i == 1 && j == 2)
					ans = sb.toString();
				else if(ans.compareTo(sb.toString()) > 0)
					ans = sb.toString();			
			}
		}
		System.out.println(ans);
		input.close();
	}

}
