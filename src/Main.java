import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        int row, col;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("oynamak istediginiz tahtanın satırını giriniz:");
            row = scan.nextInt();

            System.out.print("oynamak isteigin sutun sayısını giriniz:");
            col = scan.nextInt();
            if (row <= 0 || col <= 0) {
                System.out.println("hatalı girdi ");

            } else
                break;
        }

        MayinTarlasi mayinoyunu = new MayinTarlasi(row, col);
        mayinoyunu.run();
        scan.close();
    }

}
