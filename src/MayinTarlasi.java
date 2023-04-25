
import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {

    int rowNumber, colNumber;
    // map bizim mayınların yerini sakladığımız yer
    int[][] map;
    int[][] board;
    int size;
    boolean game = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    // ! constructor
    // kullanıcının kaça kaçlık oyun istediğini belirleme
    public MayinTarlasi(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        // kullanıcıdan alınan satır ve sütün numaralrıyla tahtamızı oluşturduk
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;

    }

    // ! PUBLİC METHODS

    public void run() {
        int row, col;
        prepare();
        print(map);
        System.out.println(" OYUN BAsALDI...");
        while (game) {
            print(board);
            while (true) {
                System.out.println("satır gir:");
                row = scan.nextInt();
                System.out.println("sutun gir:");
                col = scan.nextInt();
                if (row > rowNumber || col > colNumber) {
                    System.out.println("hatalı girdi ");

                }
                else if (row < 0 || col < 0) {
                    System.out.println("hatalı girdi ");

                } else
                    break;

            }
            if (map[row][col] != -1) {
                check(row, col);
            } else {
                game = false;
                System.out.println("OYUN bitti");
            }

        }
    }

    // mayınların nerde olduğunu kontrol ediyo ve etrafında kaç tane mayıın var bize
    // gösteriyo

    public void check(int r, int c) {
        int start_row, start_col, finish_row, finish_col;

        int bombs = 0;

        if (r > 0 && r < rowNumber - 1) {
            start_row = r - 1;
            finish_row = r + 1;
        } else if (r == 0) {
            start_row = r;
            finish_row = r + 1;
        } else {
            start_row = r - 1;
            finish_row = r;
        }

        if (c > 0 && c < colNumber - 1) {
            start_col = c - 1;
            finish_col = c + 1;
        } else if (c == 0) {
            start_col = c;
            finish_col = c + 1;
        } else {
            start_col = c - 1;
            finish_col = c;
        }
        for (int i = start_row; i <= finish_row; i++) {
            for (int j = start_col; j <= finish_col; j++) {
                if ((i == r && j == c)) // || (i < 0 || j < 0) || (i >= ROW || j >= COL)
                {
                    continue;
                }
                if (map[i][j] == -1) {
                    bombs++;

                }
            }
        }
        board[r][c] = bombs;
    }

    // oyunda mayınları yerleşmesini sağlar
    public void prepare() {
        int randRow, randCol, count = 0;
        while (count != (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }

        }

    }

    public void print(int[][] array) {
        for (int i = 0; i < rowNumber; i++) {

            for (int j = 0; j < colNumber; j++) {
                if (array[i][j] == -1)
                    System.out.print("|X");
                else if (array[i][j] == 0)
                    System.out.print("| ");
                else {
                    if (array[i][j] == -2)
                        System.out.print("|0");
                    else
                        System.out.print("|" + array[i][j]);
                }

            }

            System.out.println("| ");
        }

    }

}
