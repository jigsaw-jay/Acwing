package DataStructure;

import java.io.*;

/*836. 合并集合*/
public class Main836 {
    public static int N = 100010;
    public static int[] p = new int[N];
    public static int n, m, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        init(n);
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            char op = s2[0].charAt(0);
            a = Integer.parseInt(s2[1]);
            b = Integer.parseInt(s2[2]);
            if (op == 'M') {
                if (find(a) != find(b)) {
                    M(a, b);
                }
            } else if (op == 'Q') {
                bw.write(Q(a, b) + "\n");
            }
        }
        br.close();
        bw.close();
    }

    public static void init(int n) {
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    public static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void M(int a, int b) {
        p[find(a)] = find(b);
    }

    public static String Q(int a, int b) {
        if (find(a) == find(b)) {
            return "Yes";
        } else {
            return "No";
        }
    }
}