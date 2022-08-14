package problems.Repetitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String info = br.readLine();
        findRepetitions(info);

    }
    public static void findRepetitions(String string){
        int maxLength = 1;
        char[] chars = string.toCharArray();
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            queue.add(chars[i]);
            if (i + 1 < chars.length && chars[i] != chars[i + 1]){
                maxLength = Math.max(queue.size(), maxLength);
                queue.clear();
            }
        }
        maxLength = Math.max(queue.size(), maxLength);
        System.out.println(maxLength);
    }

}
