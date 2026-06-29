package practice.pattern;

public class MatrixRotation {

    static int[][] INIT_MATRIX = {{1,2,3},{4,5,6},{7,8,9}};

    public static void main(String[] args) {
        int[][] cw = rotateClockwise(INIT_MATRIX);
        int[][] ccw = rotateCounterClockwise(INIT_MATRIX);
        print(cw, ccw);
    }

    static int[][] rotateClockwise(int[][] initMatrix) {
        int r = initMatrix.length;
        int c = initMatrix[0].length;

        int[][] rotatedMatrix = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotatedMatrix[j][r - 1 - i] = initMatrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    static int[][] rotateCounterClockwise(int[][] initMatrix) {
        int r = initMatrix.length;
        int c = initMatrix[0].length;

        int[][] rotatedMatrix = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotatedMatrix[c - 1 - j][i] = initMatrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    private static void print(int[][] cw, int[][] ccw) {
        System.out.println("--- [Original] ---");
        for (int i = 0; i < INIT_MATRIX.length; i++) {
            for (int j = 0; j < INIT_MATRIX[0].length; j++) {
                System.out.printf("%d ", INIT_MATRIX[i][j]);
            }
            System.out.println();
        }

        System.out.println("--- [Clockwise] ---");
        for (int i = 0; i < cw.length; i++) {
            for (int j = 0; j < cw[0].length; j++) {
                System.out.printf("%d ", cw[i][j]);
            }
            System.out.println();
        }

        System.out.println("--- [Counter-Clockwise] ---");
        for (int i = 0; i < ccw.length; i++) {
            for (int j = 0; j < ccw[0].length; j++) {
                System.out.printf("%d ", ccw[i][j]);
            }
            System.out.println();
        }
    }
}
