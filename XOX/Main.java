
import java.util.Scanner;

public class Main {
    public static char[][] pano = new char[3][3];
    public static char suanki_oyuncu = 'X';
    public static void main(String[] args) {
        System.out.println("XOX oyununa hoş geldiniz!");

        pano_yukle();
        pano_ciz();

        while (true) {
            oyuncuyu_hareket_ettir();
            pano_ciz();
            
            if (kazanan_varmi()) {
                System.out.println("Kazanan oyuncu: " + suanki_oyuncu);
                break;
            }
            if (pano_dolumu()) {
                System.out.println("Oyun bitti!");
                break;
            }
            
            oyuncu_degistir();
        }

    }

    public static void pano_yukle() {
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                pano[i][y] = '-';
            }
        }
    }
    public static void pano_ciz() {
        System.out.println("pano: ");
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(pano[i][y] + " ");
            }
            System.out.println();
        }
    }
    public static void oyuncuyu_hareket_ettir() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Oyuncu " + suanki_oyuncu + ", hamlenizi girin (row and column) (Örn: 0 1): ");
            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && pano[row][col] == '-') {
                pano[row][col] = suanki_oyuncu;

                break;
            }
            else {
                System.out.println("Buraya hareket edemezsiniz!");
            }
        }
    }
    public static boolean kazanan_varmi() {
        //dikey ve yatay durumları kontrol ediyoruz
        for (int i = 0; i < 3; i++) {
            if (pano[i][0] == suanki_oyuncu && pano[i][1] == suanki_oyuncu && pano[i][2] == suanki_oyuncu){
                return true;
            }
            if (pano[0][i] == suanki_oyuncu && pano[1][i] == suanki_oyuncu && pano[2][i] == suanki_oyuncu) {
                return true;
            }
        }

        //çaprazları kontrol ediyoruz
        if (pano[0][0] == suanki_oyuncu && pano[1][1] == suanki_oyuncu && pano[2][2] == suanki_oyuncu) {
            return true;
        }
        if (pano[0][2] == suanki_oyuncu && pano[1][1] == suanki_oyuncu && pano[2][0] == suanki_oyuncu) {
            return true;
        }


        return false;
    }
    public static boolean pano_dolumu() {
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                if (pano[i][y] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void oyuncu_degistir() {
        suanki_oyuncu = (suanki_oyuncu == 'X') ? 'O' : 'X';
    }
}