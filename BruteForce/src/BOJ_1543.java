import java.util.Scanner;

public class BOJ_1543 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String word = input.nextLine();
		int cnt = 0;
		for(int i = 0; i < line.length()-word.length()+1; i++) {	
			if(line.charAt(i) == word.charAt(0)) {
				Boolean flag = true;
				for(int j = 1; j < word.length(); j++) {
					if(line.charAt(i+j) != word.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					cnt++;
					i += word.length()-1;
				}
			}
		}
		System.out.println(cnt);
		input.close();
	}

}
