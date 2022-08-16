package problems.NumberSpiral;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    private static int n = 0;

    private static long nextGridNum = 1;
    private static int currRow = 0;
    private static int maxRow = 0;
    private static int currCol = 0;
    private static int macCol = 0;

    enum Direction {UP, DOWN, LEFT, RIGHT}

    private static Direction[] oneRoundSpiral = {Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.DOWN, Direction.RIGHT, Direction.UP};


    private static void getNumbers(List<int[]> coordinates) {
        long[][] matrix = new long[n][n];
        int idxDirection = 0;
        int [] coordinateChange = getDirection(Direction.RIGHT);

        while (currRow < n && currCol < n){

            matrix[currRow][currCol] = nextGridNum++;
            if (isFillLimitReached(currRow, currCol)){
                Direction currentDirection = oneRoundSpiral[idxDirection++];
                if (idxDirection == oneRoundSpiral.length) idxDirection = 0;
                coordinateChange = getDirection(currentDirection);
            }

            currRow += coordinateChange[0];
            currCol += coordinateChange[1];

        }

        coordinates.forEach(currentCoordinate ->{
            System.out.println(matrix[currentCoordinate[0] - 1][currentCoordinate[1] - 1]);
        });


    }

    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        n = Integer.parseInt(br.readLine());
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < n ; i++  ){
            String string = br.readLine();
            if (string!= null && string.equals("")) continue;
            if (string != null){
                String[] arr = string.trim().split(" ");
                int[] resultArr = new int[2];
                resultArr[0] = Integer.parseInt(arr[0]);
                resultArr[1] = Integer.parseInt(arr[1]);
                n = Math.max(n, Math.max(resultArr[0], resultArr[1]));
                coordinates.add(resultArr);
            }

        }
        getNumbers(coordinates);
    }

    public static boolean isFillLimitReached(int currRow, int currColumn){
        if (currRow > maxRow){
            maxRow = currRow;
            return true;
        } else if (currColumn > macCol) {
            macCol = currColumn;
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
