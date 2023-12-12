package DataStructure;

import java.io.*;
import java.util.HashMap;

/*240. 食物链*/
public class Main240 {
    public static int N = 50010;
    public static int[] p = new int[N];
    public static int[] d = new int[N];
    public static int n, m, x, y, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        while (m-- > 0) {
            String[] s2 = br.readLine().split(" ");
            char op = s2[0].charAt(0);
            x = Integer.parseInt(s2[1]);
            y = Integer.parseInt(s2[2]);
            if (x > n || y > n) {
                res++;
            } else {
                int px = find(x);
                int py = find(y);
                if (op == '1') {
                    if (px == py && (d[x] - d[y]) % 3 != 0) {
                        res++;
                    } else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] - d[x];
                    }
                } else if (op == '2') {
                    if (px == py && (d[x] - d[y] - 1) % 3 != 0) {
                        res++;
                    } else if (px != py) {
                        p[px] = py;
                        d[px] = d[y] + 1 - d[x];
                    }
                }
            }
        }
        bw.write(res + "");
        br.close();
        bw.close();
    }

    public static int find(int x) {
        if (p[x] != x) {
            int temp = p[x];
            p[x] = find(p[x]);
            d[x] += d[temp];
        }
        return p[x];
    }
}