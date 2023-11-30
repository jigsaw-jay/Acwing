package DataStructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*中缀表达式求值*/
public class Main3302 {
    public static Stack<Integer> num = new Stack<>();
    public static Stack<Character> op = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> pr = new HashMap<>();
        pr.put('+', 1);
        pr.put('-', 1);
        pr.put('*', 2);
        pr.put('/', 2);
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j) - '0';
                }
                i = j - 1;
                num.push(x);
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                while (op.peek() != '(') {
                    calc();
                }
                op.pop();
            } else {
                while (op.size()>0&&op.peek()!='('&&pr.get(op.peek())>=pr.get(c)){
                    calc();
                }
                op.push(c);
            }
        }
        while (op.size()>0) calc();
        bw.write(num.peek() + "\n");
        br.close();
        bw.close();
    }

    public static void calc() {
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int res = 0;
        if (c == '+') {
            res = a + b;
        } else if (c == '-') {
            res = a - b;
        } else if (c == '*') {
            res = a * b;
        } else if (c == '/') {
            res = a / b;
        }
        num.push(res);
    }
}