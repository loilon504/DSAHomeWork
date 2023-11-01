import java.io.*;
import java.util.*;

class query {
    int state;
    String todoString;
    int todoInt;

    public query(int state, String todoString, int todoInt) {
        this.state = state;
        this.todoString = todoString;
        this.todoInt = todoInt;
    }
}

public class Solution {

    public static char[] S;
    public static query[] st;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        S = new char[2000005];
        st = new query[2000005];
        int nS = 0, nST = 0;
        int q = input.nextInt();
        for (int test = 1; test <= q; test++) {
            int state = input.nextInt();
            if (state == 1) {
                String todoString = input.nextLine().trim();
                st[++nST] = new query(1, "", todoString.length());
                for (int i = 0; i < todoString.length(); i++) S[++nS] = todoString.charAt(i);
            }
            if (state == 2) {
                int todoInt = input.nextInt();
                String todoString = "";
                for (int i = nS - todoInt + 1; i <= nS; i++) {
                    todoString += S[i];
                }
                st[++nST] = new query(2, todoString, 0);
                nS -= todoInt;
            }
            if (state == 3) {
                int todoInt = input.nextInt();
                System.out.println(S[todoInt]);
            }
            if (state == 4) {
                if (nST == 0) continue;
                if (st[nST].state == 1) {
                    nS -= st[nST].todoInt;
                } else {
                    for (int i = 0, x = st[nST].todoString.length(); i < x; i++) {
                        S[++nS] = st[nST].todoString.charAt(i);
                    }
                }
                nST--;
            }
            // for (int i = 1; i <= nS; i++) System.out.print(S[i]);
            // System.out.println();
        }
    }
}
