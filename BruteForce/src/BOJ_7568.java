import java.util.ArrayList;
import java.util.Scanner;

class Person {
	int x, y;
	Person(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_7568 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Person> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int x = input.nextInt();
			int y = input.nextInt();
			list.add(new Person(x, y));
		}
		for(int i = 0; i < n ; i++) {
			int cnt = 1;
			for(int j = 0; j < n; j++) {
				if(list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y)
					cnt++;
			}
			System.out.print(cnt+" ");
		}
		System.out.println();
		input.close();
	}

}
