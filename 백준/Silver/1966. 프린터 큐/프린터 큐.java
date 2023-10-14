import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();

        while (T-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();

            final LinkedList<int[]> queue = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                queue.offer(new int[]{i, in.nextInt()});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                final int[] front = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (front[1] < queue.get(i)[1]) {
                        queue.offer(front);
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    count++;
                    if (front[0] == M) {
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }

}
