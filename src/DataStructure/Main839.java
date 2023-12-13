package DataStructure;

import java.io.*;
/*839. 模拟堆*/
public class Main839 {
    public static int N = 100010;
    public static int[] h = new int[N];
    public static int[] hp = new int[N];
    public static int[] ph = new int[N];
    public static int n, m, x, k, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            String op = s[0];
            if (op.equals("I")) {
                x = Integer.parseInt(s[1]);
                insert(x);
            } else if (op.equals("PM")) {
                bw.write(h[1] + "\n");
            } else if (op.equals("DM")) {
                deleteMin();
            } else if (op.equals("D")) {
                k = Integer.parseInt(s[1]);
                deleteK(k);
            } else if (op.equals("C")) {
                k = Integer.parseInt(s[1]);
                x = Integer.parseInt(s[2]);
                updateK(k, x);
            }
        }
        br.close();
        bw.close();
    }

    private static void updateK(int k, int x) {
        int u = ph[k];
        h[u] = x;
        down(u);
        up(u);
    }

    private static void deleteK(int k) {
        int u = ph[k];
        swapHeap(u, size--);
        down(u);
        up(u);
    }

    private static void deleteMin() {
        swapHeap(1, size--);
        down(1);
    }

    private static void insert(int x) {
        hp[++size] = ++m;
        ph[m] = size;
        h[size] = x;
        up(size);
    }

    public static void down(int u) {
        int t = u;
        if (2 * u <= size && h[2 * u] < h[t]) {
            t = 2 * u;
        }
        if (2 * u + 1 <= size && h[2 * u + 1] < h[t]) {
            t = 2 * u + 1;
        }
        if (t != u) {
            swapHeap(t, u);
            down(t);
        }
    }

    public static void up(int u) {
        while (u / 2 != 0 && h[u / 2] > h[u]) {
            swapHeap(u / 2, u);
            u /= 2;
        }
    }

    public static void swapHeap(int a, int b) {
        swap(h, a, b);
        swap(hp, a, b);
        swap(ph, hp[a], hp[b]);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}