package problems.TwoKnights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    private static final int smallStep = 1;
    private static final int bigStep = 2;
    private static HashSet<Integer> board = new HashSet<>();
    private static int count = 0;

    private static int xBound = 3;
    private static int yBound = 3;

    private static int boardSize;
    private static HashSet<Integer> hashSet = new HashSet<>();
    private static final int[][] possibleMoves = {
            {smallStep, bigStep},
            {-smallStep, bigStep},

            {smallStep, -bigStep},
            {-smallStep, -bigStep},

            {bigStep, smallStep},
            {bigStep, -smallStep},

            {-bigStep, smallStep},
            {-bigStep, -smallStep}


    };


    private static void possbileKnightMoves(int startX, int startY) {
        for (int[] move : possibleMoves) {
            int changeX = startX + move[0];
            int changeY = startY + move[1];
            if (isInBound(changeX, changeY)) board.add(Objects.hash(changeX, changeY));
        }
    }

    private static boolean isInBound(int x, int y) {
        return x >= 0 && x < xBound && y >= 0 && y < yBound;

    }

    private static void findAllComobinations(int y) {
        if (y == yBound) return;
        for (int x = 0; x < xBound; x++) {
            board.add(Objects.hash(x, y));
            possbileKnightMoves(x, y);
            countPossibleCombinationsFroGivenBoard(x, y);
            findAllComobinations(y + 1);
        }
    }

    private static void countPossibleCombinationsFroGivenBoard(int startingX, int startingY) {
        for (int i = 0; i < xBound; i++) {
            for (int j = 0; j < yBound; j++) {
                int currentCoordinate = Objects.hash(i, j);
                int hash1 = Objects.hash(startingX, startingY, i, j);
                int hash2 = Objects.hash(i, j, startingX, startingY);
                if (!board.contains(currentCoordinate) && !hashSet.contains(hash1) && !hashSet.contains(hash2)) {
                    count++;
                    hashSet.add(hash1);
                    hashSet.add(hash2);
                } else board.remove(currentCoordinate);
            }
        }
    }

    private static void boardIntizialization(int boardSize) {
        xBound = boardSize;
        yBound = boardSize;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        int N = Integer.parseInt(br.readLine());
//        for (int i = 1; i <= n; i++) {
//            boardIntizialization(i);
//            findAllComobinations(0);
//            System.out.println(count);
//        }
        for (long n = 1; n <= N; n++) {

            long result = ((n * n * (n * n - 1)) / 2 ) - (4 * (n - 1) * (n - 2));
            System.out.println(result);
        }


    }


}
