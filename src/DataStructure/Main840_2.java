package DataStructure;

import java.io.*;

/*840. 模拟散列表->开放寻址法*/
public class Main840_2 {
    public static int N = 200003;
    public static int[] h = new int[N];
    public static int flag = (int) 1e9 + 1;
    public static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        init();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            char op = s[0].charAt(0);
            x = Integer.parseInt(s[1]);
            if (op == 'I') {
                insert(x);
            } else if (op == 'Q') {
                bw.write(query(x) + "\n");
            }
        }
        br.close();
        bw.close();
    }

    private static void init() {
        for (int i = 0; i < h.length; i++) {
            h[i] = flag;
        }
    }

    private static String query(int x) {
        int k = find(x);
        if (h[k] != flag) {
            return "Yes";
        }
        return "No";
    }

    private static void insert(int x) {
        int k = find(x);
        h[k] = x;
    }

    public static int find(int x) {
        int k = (x % N + N) % N;
        while (h[k] != flag && h[k] != x) {
            k++;
            if (k == N) k = 0;
        }
        return k;
    }
}