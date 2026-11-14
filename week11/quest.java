
import java.util.*;

public class question5 {

    static int[][] exitDistance(char[][] plan) {

        int m = plan.length;
        int n = plan[0].length;

        int[][] dist = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (plan[i][j] == 'E') {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
                else {
                    dist[i][j] = -1;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cell = q.poll();

            int x = cell[0];
            int y = cell[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < m &&
                    ny >= 0 && ny < n &&
                    plan[nx][ny] != '#' &&
                    dist[nx][ny] == -1) {

                    dist[nx][ny] = dist[x][y] + 1;

                    q.add(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        char[][] plan = {
            {'.', '#', '.', 'E'},
            {'.', '.', '.', '#'},
            {'E', '#', '.', '.'}
        };

        int[][] ans = exitDistance(plan);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
