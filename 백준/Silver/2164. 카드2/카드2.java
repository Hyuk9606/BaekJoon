
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (queue.size() != 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.println(queue.poll());
	}
}
