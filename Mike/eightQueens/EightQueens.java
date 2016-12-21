package eightQueens;

public class EightQueens {

    static int[] placed;
    static int count = 1;
    
    public EightQueens(int N) {
        placed = new int[N];
    }

    public static void main(String args[]) {
        int number = 8;
        EightQueens queens = new EightQueens(number);
        queens.placeQueens(0, placed.length);        
    }

    private void placeQueens(int row, int size) {
        for (int queen = 0; queen < size; queen++) {
            if (isSquareAvailable(row, queen)) {
                placed[row] = queen;
                if (row == size -1) {
                    printBoard(placed);
                } else {
                    placeQueens(row + 1, size);
                }
            }
        }
    }

    static boolean isSquareAvailable(int row, int queen) {
        for (int i = 0; i < row; i++) {
            if (placed[i] == queen || (i - row) == (placed[i] - queen) || (i - row) == (queen - placed[i])) {
                return false;
            }
        }
        return true;
    }

    private void printBoard(int[] placed) {
        int N = placed.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (placed[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println("Solution #: " + count);
        System.out.println();
        count ++;
    }
    
}
