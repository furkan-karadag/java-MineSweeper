import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        int row, col;
        Scanner scan = new Scanner(System.in);

        System.out.print("oynamak istediginiz tahtanın satırını giriniz:");
        row = scan.nextInt();

        System.out.print("oynamak isteigin sutun sayısısı:");
        col = scan.nextInt();
        MayinTarlasi mayinoyunu = new MayinTarlasi(row, col);
        mayinoyunu.run();
        scan.close();
    }

}
