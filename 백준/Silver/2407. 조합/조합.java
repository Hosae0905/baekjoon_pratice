import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 100
		int M = Integer.parseInt(st.nextToken());	// 6
		
		BigInteger[][] bi = new BigInteger[101][101];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					bi[i][j] = BigInteger.ONE;
				} else {
					bi[i][j] = bi[i - 1][j].add(bi[i - 1][j - 1]);
				}
			}
		}
		
		System.out.println(bi[N][M]);
		
	}
}