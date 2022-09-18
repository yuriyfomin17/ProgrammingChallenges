package problems.TwoKnights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static void calculateCombinations(long n) {
        long totalNumberOfCOmbinations = (n * n * (n * n - 1)) / 2;
        long hittingComb = 4 * (n - 1) * (n - 2);
        long result = totalNumberOfCOmbinations - hittingComb;
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        long n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n  ; i++) {
            calculateCombinations(i);
        }
    }
}
