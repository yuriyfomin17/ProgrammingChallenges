package problems.NumberSpiral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;


public class Main {
    private static int n = 0;
    private static Direction currentDirection = Direction.RIGHT;

    private static int maxN = 0;
    private static int idxDirection = 0;

    private static long nextGridNum = 1;
    private static int currRow = 0;
    private static int maxRow = 0;
    private static int maxCol = 0;
    private static int currCol = 0;
    private static HashMap<Integer, Long> hashMap = new HashMap<>();

    enum Direction {UP, DOWN, LEFT, RIGHT}

    private static Direction[] oneRoundSpiral = {Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.RIGHT, Direction.UP};


    private static void getNumbers() {
        int [] coordinateChange = getDirection(currentDirection);

        while (currRow < n && currCol < n){
            hashMap.put(Objects.hash(currRow, currCol), nextGridNum++);
            if (isFillLimitReached(currRow, currCol)){
                currentDirection = oneRoundSpiral[idxDirection++];
                if (idxDirection == oneRoundSpiral.length) idxDirection = 0;
                coordinateChange = getDirection(currentDirection);
            }
            currRow += coordinateChange[0];
            currCol += coordinateChange[1];

        }


    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
//        InputStreamReader r = new InputStreamReader(new FileInputStream("/Users/icom/Desktop/ProgrammingChallenges/src/problems/NumberSpiral/inputData2.txt"), StandardCharsets.UTF_8);

        BufferedReader br = new BufferedReader(r);
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++  ){
            String string = br.readLine();
            if (string!= null && string.equals("")) continue;
            if (string != null){
                String[] arr = string.trim().split(" ");
                int[] resultArr = new int[2];
                resultArr[0] = Integer.parseInt(arr[0]);
                resultArr[1] = Integer.parseInt(arr[1]);
                n = Math.max(n, Math.max(resultArr[0], resultArr[1]));
                int hash = Objects.hash(resultArr[0] - 1, resultArr[1] - 1);
                if (n < maxN){
                    System.out.println(hashMap.get(hash));
                } else {
                    getNumbers();
                    System.out.println(hashMap.get(hash));

                }
            }

        }
    }

    public static boolean isFillLimitReached(int currRow, int currColumn){
        if (currRow > maxRow){
            maxRow = currRow;
            return true;
        } else if (currColumn > maxCol) {
            maxCol = currColumn;
            return true;
        }
        return (currRow == 0 || currColumn == 0 || currRow == n || currColumn == n);
    }

    private static int[] getDirection(Direction direction) {
        int[] currDirection = new int[2];
        if (direction.equals(Direction.UP)) {
            currDirection[0] = -1;
            currDirection[1] = 0;
        } else if (direction.equals(Direction.DOWN)) {
            currDirection[0] = 1;
            currDirection[1] = 0;
        } else if (direction.equals(Direction.LEFT)) {
            currDirection[0] = 0;
            currDirection[1] = -1;
        } else if (direction.equals(Direction.RIGHT)) {
            currDirection[0] = 0;
            currDirection[1] = 1;
        }
        return currDirection;
    }
}
