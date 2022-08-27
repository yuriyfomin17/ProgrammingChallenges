package problems.NumberSpiral;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Main {
    private static int n = 0;

    private static long maxN = 0;


    private static long getNumbers(long requiredRow, long requiredCol) {
        long biggestNumber = maxN * maxN;
        long lowestNumber = (maxN - 1) * (maxN - 1) + 1;
        long maxRow;
        long maxCol;
        long topNumber;
        long bottomNumber;
        if (biggestNumber % 2 == 0) {
            maxRow = maxN;
            maxCol = 1;
            bottomNumber = biggestNumber;
            topNumber = lowestNumber;
        } else {
            maxRow = 1;
            maxCol = maxN;
            bottomNumber = lowestNumber;
            topNumber = biggestNumber;
        }
        long abs = Math.abs(maxRow + maxCol - requiredRow - requiredCol);
        if (requiredRow < maxN && requiredCol == maxN) {
            if (topNumber == biggestNumber) return topNumber - abs;
            else return topNumber + abs;
        } else if ((requiredRow == maxN && requiredCol < maxN) || (requiredRow == maxN && requiredCol == maxN)) {
            if (bottomNumber == lowestNumber) return bottomNumber + abs;
            else return bottomNumber - abs;
        }

        return 0;

    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
//        InputStreamReader r = new InputStreamReader(new FileInputStream("/Users/icom/Desktop/ProgrammingChallenges/src/problems/NumberSpiral/inputData1.txt"), StandardCharsets.UTF_8);
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(r);
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            if (string == null || string.equals("")) continue;
            String[] arr = string.trim().split(" ");
            long currRow = Long.parseLong(arr[0]);
            long currCol = Long.parseLong(arr[1]);
            maxN = Math.max(currRow, currCol);
            long currAnswer = getNumbers(currRow, currCol);
            answer.append(currAnswer);
            if (i < n - 1) answer.append("\n");
        }
        System.out.println(answer);
    }

}
