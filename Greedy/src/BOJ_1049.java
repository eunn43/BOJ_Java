import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1049	±‚≈∏¡Ÿ
public class BOJ_1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str.split(" ")[0]);
		int m = Integer.parseInt(str.split(" ")[1]);
		int minPkg = 1000;
		int minEa = 1000;
		
		for(int i = 0; i < m; i++) {
			str = br.readLine();
			int pkg = Integer.parseInt(str.split(" ")[0]);
			int ea = Integer.parseInt(str.split(" ")[1]);
			if(pkg < minPkg)
				minPkg = pkg;
			if(ea < minEa)
				minEa = ea;
		}
		
		int cost = minPkg * ((n / 6) + 1) < minPkg * (n / 6) + (n % 6) * minEa ? 
				minPkg * ((n / 6) + 1) : minPkg * (n / 6) + (n % 6) * minEa;

		if(cost > minEa * n)
			cost = minEa * n;
		System.out.println(cost);
	}

}
