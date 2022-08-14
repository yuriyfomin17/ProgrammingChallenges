package OlympiadProgrammingBook.chapter2.Recursion;
import java.util.Stack;

public class Subset {
    public static Stack<Integer> arr = new Stack<>();
    public static final int n = 3;

    public static void search(int k){
        if (k == n + 1){
            System.out.println(arr);
        } else {
            arr.add(k);
            search(k + 1);
            arr.pop();
            search(k + 1);
        }

    }

    public static void main(String[] args) {
        search(1);
    }
}
