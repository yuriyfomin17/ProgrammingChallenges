package problems.CSNET.MissingNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int n = Integer.parseInt(br.readLine());
        String info = br.readLine();
        int[] arr = Arrays.stream(info.split(" ")).mapToInt(Integer::parseInt).toArray();

        findMissingNumber(n, arr);
    }

    public static void findMissingNumber(int n, int[] arr) {
        int[] neededNumbers = IntStream.rangeClosed(1, n).toArray();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int x: arr) hashSet.add(x);
        for (int x: neededNumbers) {
            if (!hashSet.contains(x)) System.out.println(x);
        }
    }
}
