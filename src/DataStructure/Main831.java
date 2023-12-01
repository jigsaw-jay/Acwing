package DataStructure;

import java.io.*;

/*831. KMP字符串*/
public class Main831 {
    public static int N = 100010;
    public static int M = 1000010;
    public static int[] next = new int[N];
    public static char[] p = new char[N];
    public static char[] s = new char[M];
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = (" " + br.readLine()).toCharArray();
        m = Integer.parseInt(br.readLine());
        s = (" " + br.readLine()).toCharArray();
        Next(n,p);
        KMP(m,p,s);
        br.close();
    }

    public static void Next(int n, char[] p) {
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
    }

    public static void KMP(int m, char[] p, char[] s) throws IOException {
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                bw.write(i-n +" ");
                j = next[j];
            }
        }
        bw.close();
    }
}