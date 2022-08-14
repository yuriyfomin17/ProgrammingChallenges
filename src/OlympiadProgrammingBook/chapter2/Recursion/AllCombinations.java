package OlympiadProgrammingBook.chapter2.Recursion;

import java.util.Stack;

public class AllCombinations {
    public static Stack<Integer> arr = new Stack<>();
    public static final int n = 3;
    public static boolean[] chosen = new boolean[n];

    public static void search( ){
        if (arr.size() == n){
            System.out.println(arr);
        } else {
            for (int i = 1; i <= n ; i++) {
                if (chosen[i - 1]) continue;
                arr.push(i);
                chosen[i - 1] = true;
                search();
                chosen[i - 1] = false;
                arr.pop();
            }
        }
    }

    public static void main(String[] args) {
        search();
    }
}
