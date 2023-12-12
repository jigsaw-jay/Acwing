package DataStructure;

import java.io.*;

/*838. 堆排序*/
public class Main838 {
    public static int N = 100010;
    public static int[] h = new int[N];
    public static int n, m, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = br.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        String[] s2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            h[++size] = Integer.parseInt(s2[i]);
        }
        for (int i = n / 2; i > 0; i--) {
            down(i);
        }
        while (m-->0){
            bw.write(h[1]+" ");
            h[1]=h[size--];
            down(1);
        }
        br.close();
        bw.close();
    }

    public static void down(int u) {
        int t = u;
        if (2 * u <= size && h[2 * u] < h[t]) {
            t = 2 * u;
        }
        if (2 * u + 1 <= size && h[2 * u + 1] < h[t]) {
            t = 2 * u + 1;
        }
        if (u != t) {
            swap(h, t, u);
            down(t);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}