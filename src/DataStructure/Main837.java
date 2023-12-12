package DataStructure;

import java.io.*;

/*837. 连通块中点的数量*/
public class Main837 {
    public static int N = 100010;
    public static int[] size = new int[N];
    public static int[] p = new int[N];
    public static int n, m, a, b;
    public static String op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            op = s2[0];
            if (op.equals("C")) {
                a = Integer.parseInt(s2[1]);
                b = Integer.parseInt(s2[2]);
                connect(a, b);
            } else if (op.equals("Q1")) {
                a = Integer.parseInt(s2[1]);
                b = Integer.parseInt(s2[2]);
                if (find(a) == find(b)) {
                    bw.write("Yes\n");
                } else {
                    bw.write("No\n");
                }
            } else if (op.equals("Q2")) {
                a = Integer.parseInt(s2[1]);
                bw.write(size[find(a)] + "\n");
            }
        }
        br.close();
        bw.close();
    }

    public static void connect(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        size[find(b)] += size[find(a)];
        p[find(a)] = find(b);
    }

    public static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}