package DataStructure;

import java.io.*;

/*滑动窗口（单调队列）*/
public class Main154 {
    public static int N = 1000010;
    public static int[] que = new int[N];
    public static int[] a = new int[N];
    public static int hh, tt, n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        k = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        init();
        for (int i : maxWindow(n, k, s2)) {
            bw.write(i + " ");
        }
        init();
        bw.write("\n");
        for (int i : minWindow(n, k, s2)) {
            bw.write(i + " ");
        }
        br.close();
        bw.close();
    }

    public static void init() {
        hh = 0;
        tt = -1;
    }

    public static int[] maxWindow(int n, int k, String[] s) {
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] res = new int[n - k + 1];
        int u = 0;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i + 1 - que[hh] > k) {
                hh++;
            }
            while (hh <= tt && a[que[tt]] >= a[i]) {
                tt--;
            }
            que[++tt] = i;
            if (i + 1 >= k) {
                res[u++] = a[que[hh]];
            }
        }
        return res;
    }

    public static int[] minWindow(int n, int k, String[] s) {
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int[] res = new int[n - k + 1];
        int u = 0;
        for (int i = 0; i < n; i++) {
            if (hh <= tt && i + 1 - que[hh] > k) {
                hh++;
            }
            while (hh <= tt && a[que[tt]] <= a[i]) {
                tt--;
            }
            que[++tt] = i;
            if (i + 1 >= k) {
                res[u++] = a[que[hh]];
            }
        }
        return res;
    }
}