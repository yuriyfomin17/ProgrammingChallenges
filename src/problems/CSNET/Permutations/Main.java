package problems.CSNET.Permutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static int n = 882193;


    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        n = Integer.parseInt(br.readLine());
        if (n == 1) System.out.println("1");
        else if (n == 2) System.out.println("NO SOLUTION");
        else if (n == 3) System.out.println("NO SOLUTION");
        else if (n == 4) System.out.println("2 4 1 3");
        else {

            beautifulComb();
        }
    }

    public static void beautifulComb() {
        Queue<Integer> queue = new ArrayDeque<>();
        IntStream.rangeClosed(1, n).forEach(queue::add);
        ArrayList<Integer> arr = new ArrayList<>();
        int lastElem = queue.poll();

        arr.add(lastElem);
        while (queue.size() != 0) {
            int nextElem = queue.poll();
            if (isBeautifulComb(lastElem, nextElem)) {
                arr.add(nextElem);
                lastElem = nextElem;
            }
            else {
                queue.add(nextElem);
            }
        }
        if (arr.size() == n) System.out.println(arr.stream().map(Objects::toString).collect(Collectors.joining(" ")));
        else System.out.println("NO SOLUTION");

    }

    public static boolean isBeautifulComb(int num1, int num2) {
        return Math.abs(num1 - num2) != 1;
    }


}
