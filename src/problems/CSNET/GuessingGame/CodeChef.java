package problems.CSNET.GuessingGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef {
    public static void findProbability(long M, long N) {
        int counter = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (isOdd(i + j)) counter++;
            }
        }
        long total = M * N;
        if (counter == 0) {
            System.out.printf("0/%d", total);

        } else if (total % counter == 0) {
            System.out.printf("%d/%d", 1, total / counter);
        } else {
            System.out.printf("%d/%d", counter, total);
        }

    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int numberOfTestCases = Integer.parseInt(br.readLine());
        if (numberOfTestCases >= 1 && numberOfTestCases <= 1_00_000) {
            for (int i = 0; i < numberOfTestCases; i++) {
                String[] currentString = br.readLine().split(" ");
                long M = Long.parseLong(currentString[0]);
                long N = Long.parseLong(currentString[1]);

                if (M >= 1 && M <= 1_000_000_000 && N >= 1 && N <= 1_000_000_000) {
                    findProbability(M, N);
                }

            }
        }

    }

}
