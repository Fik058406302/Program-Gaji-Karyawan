import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class GajiKaryawan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variabel Data Karyawan
        String nama;
        String golongan;
        int jamLembur = 0;
        int indexLembur = 0;
        double gajiLembur = 0;
        int gajiPokok = 0;
        int indexGolongan = 0;
        double totalPenghasilan;

        // Input Data Karyawan
        System.out.print("Masukkan Nama Karyawan : ");
        nama = sc.nextLine().toUpperCase();
        System.out.print("Masukkan Golongan (A/B/C) : ");
        golongan = sc.nextLine().toUpperCase();
        System.out.print("Masukkan Jam Lembur : ");
        jamLembur = sc.nextInt();

        // Golongan Karyawan
        if (golongan.equals("A")) {
            indexGolongan = 0;
        } else if (golongan.equals("B")) {
            indexGolongan = 1;
        } else if (golongan.equals("C")) {
            indexGolongan = 2;
        } else {
            System.out.println("Golongan tidak ditemukan. Masukkan golongan yang tersedia (A/B/C)!");
            return;
        }

        // Array gaji pokok sesuai golongan (index 0=A, 1=B, 2=C)
        int[] gajiPokokArray = {5000000, 6500000, 9500000};
        // Array persentase lembur (index 0=1jam, 1=2jam, ..., 4=>=5jam)
        int[] persenLembur = {30, 32, 34, 36, 38};

        gajiPokok = gajiPokokArray[indexGolongan];

        // Gaji Lembur (berdasarkan jam)
        if (jamLembur == 1) {
            indexLembur = 0;
        } else if (jamLembur == 2) {
            indexLembur = 1;
        } else if (jamLembur == 3) {
            indexLembur = 2;
        } else if (jamLembur == 4) {
            indexLembur = 3;
        } else if (jamLembur >= 5) {
            indexLembur = 4;
        }
        
        if (jamLembur > 0) {
            gajiLembur = (persenLembur[indexLembur] / 100.0) * gajiPokok;
        }

        // Total Penghasilan
        totalPenghasilan = gajiPokok + gajiLembur;
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("id", "ID"));
        nf.setMaximumFractionDigits(0);

        // Output Slip Gaji
        System.out.println("\nPT MENCARI CINTA SEJATI");
        System.out.println("========== SLIP GAJI KARYAWAN =============");
        System.out.println("NAMA                : " + nama);
        System.out.println("GOLONGAN KARYAWAN   : " + golongan);
        System.out.println("TOTAL GAJI POKOK    : " + nf.format(gajiPokok));
        System.out.println("TOTAL JAM LEMBUR    : " + jamLembur + " jam");
        System.out.println("TOTAL GAJI LEMBUR   : " + nf.format(gajiLembur) + " (" + (jamLembur > 0 ? persenLembur[indexLembur] : 0) + "% dari gaji pokok)");
        System.out.println("-------------------------------------------");
        System.out.println("TOTAL PENGHASILAN   : " + nf.format(totalPenghasilan));
        System.out.println("===========================================");

    sc.close();
    }
}
