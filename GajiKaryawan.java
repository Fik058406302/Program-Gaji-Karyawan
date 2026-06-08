import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class GajiKaryawan {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Variabel Data Karyawan
            String nama;
            String golongan = "";
            int jamLembur = 0;
            int indexLembur = -1;
            double gajiLembur = 0;
            int gajiPokok = 0;
            int indexGolongan = 0;
            double totalPenghasilan;

            // Array data
            int[] gajiPokokArray = {5000000, 6500000, 9500000};
            int[] persenLembur = {30, 32, 34, 36, 38};

            // 1. Input Nama Karyawan
            while (true) {
                System.out.print("Masukkan Nama Karyawan : ");
                nama = sc.nextLine().trim().toUpperCase();
                if (!nama.isEmpty()) {
                    break; // Keluar loop jika nama tidak kosong
                }
                System.out.println("Nama tidak boleh kosong!\n");
            }

            // 2. Input Golongan (Loop hingga valid)
            while (true) {
                System.out.print("Masukkan Golongan (A/B/C) : ");
                golongan = sc.nextLine().trim().toUpperCase();

                if (golongan.equals("A")) {
                    indexGolongan = 0;
                    break;
                } else if (golongan.equals("B")) {
                    indexGolongan = 1;
                    break;
                } else if (golongan.equals("C")) {
                    indexGolongan = 2;
                    break;
                } else {
                    System.out.println("Golongan tidak ditemukan. Masukkan golongan yang tersedia (A/B/C)!\n");
                }
            }

            // 3. Input Jam Lembur (Loop hingga valid)
            while (true) {
                System.out.print("Masukkan Jam Lembur : ");
                try {
                    String inputLembur = sc.nextLine().trim(); // Menggunakan nextLine agar buffer Scanner bersih
                    jamLembur = Integer.parseInt(inputLembur);
                    
                    if (jamLembur < 0) {
                        System.out.println("Jam lembur tidak boleh negatif.\n");
                    } else {
                        break; // Keluar loop jika angka valid dan tidak negatif
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Masukkan angka untuk jam lembur.\n");
                }
            }

            // Proses Hitung Gaji Pokok
            gajiPokok = gajiPokokArray[indexGolongan];

            // Proses Hitung Gaji Lembur
            if (jamLembur > 0) {
                if (jamLembur == 1) {
                    indexLembur = 0;
                } else if (jamLembur == 2) {
                    indexLembur = 1;
                } else if (jamLembur == 3) {
                    indexLembur = 2;
                } else if (jamLembur == 4) {
                    indexLembur = 3;
                } else {
                    indexLembur = 4; // Untuk jamLembur >= 5
                }
                gajiLembur = (persenLembur[indexLembur] / 100.0) * gajiPokok;
            }

            // Total Penghasilan
            totalPenghasilan = gajiPokok + gajiLembur;
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
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
        }
    }
}
