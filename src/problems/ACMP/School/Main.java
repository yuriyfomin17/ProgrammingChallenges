package problems.ACMP.School;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Main {
    public static void main(String[] args) throws IOException {

        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        br.readLine();
        String info = br.readLine().trim();
        int[] arr = Arrays.stream(info.split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> dequeOdd = new ArrayDeque<>();
        Deque<Integer> dequeEven = new ArrayDeque<>();
        Arrays.stream(arr).forEach(value -> {
            if (value % 2 == 0) dequeEven.add(value);
            else dequeOdd.add(value);
        });
        System.out.println(dequeOdd.stream().map(el -> Integer.toString(el)).collect(joining(" ")));
        System.out.println(dequeEven.stream().map(el -> Integer.toString(el)).collect(joining(" ")));
        System.out.println(dequeEven.size() >= dequeOdd.size() ? "YES": "NO");

    }
}
