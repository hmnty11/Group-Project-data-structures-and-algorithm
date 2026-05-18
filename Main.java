import java.util.HashMap;
import java.util.Scanner;

// Class Mahasiswa
class Mahasiswa {
    String nama;
    double ipk;

    // Constructor
    Mahasiswa(String nama, double ipk) {
        this.nama = nama;
        this.ipk = ipk;
    }
}

public class Main {

    public static void main(String[] args) {

        // HashMap untuk menyimpan data mahasiswa
        HashMap<String, Mahasiswa> dataMahasiswa = new HashMap<>();

        Scanner input = new Scanner(System.in);

        int pilihan;

        do {

            System.out.println("\n===== SISTEM MANAJEMEN DATA MAHASISWA =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Cari Mahasiswa");
            System.out.println("3. Edit Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Tampilkan Semua Data");
            System.out.println("6. Jumlah Mahasiswa");
            System.out.println("7. Keluar");

            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                // MENU TAMBAH MAHASISWA
                case 1:

                    System.out.print("Masukkan NIM  : ");
                    String nim = input.nextLine();

                    // Validasi NIM duplikat
                    if (dataMahasiswa.containsKey(nim)) {
                        System.out.println("NIM sudah terdaftar!");
                        break;
                    }

                    System.out.print("Masukkan Nama : ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan IPK  : ");
                    double ipk = input.nextDouble();
                    input.nextLine();

                    // Simpan ke HashMap
                    dataMahasiswa.put(nim, new Mahasiswa(nama, ipk));

                    System.out.println("Data mahasiswa berhasil ditambahkan!");
                    break;

                // MENU CARI MAHASISWA
                case 2:

                    System.out.print("Masukkan NIM yang dicari: ");
                    String cariNim = input.nextLine();

                    if (dataMahasiswa.containsKey(cariNim)) {

                        Mahasiswa mhs = dataMahasiswa.get(cariNim);

                        System.out.println("\n===== DATA DITEMUKAN =====");
                        System.out.println("NIM  : " + cariNim);
                        System.out.println("Nama : " + mhs.nama);
                        System.out.println("IPK  : " + mhs.ipk);

                    } else {
                        System.out.println("Data mahasiswa tidak ditemukan!");
                    }

                    break;

                // MENU EDIT MAHASISWA
                case 3:

                    System.out.print("Masukkan NIM yang ingin diedit: ");
                    String editNim = input.nextLine();

                    if (dataMahasiswa.containsKey(editNim)) {

                        System.out.print("Masukkan Nama Baru : ");
                        String namaBaru = input.nextLine();

                        System.out.print("Masukkan IPK Baru  : ");
                        double ipkBaru = input.nextDouble();
                        input.nextLine();

                        // Update data
                        dataMahasiswa.put(editNim,
                                new Mahasiswa(namaBaru, ipkBaru));

                        System.out.println("Data berhasil diperbarui!");

                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }

                    break;

                // MENU HAPUS MAHASISWA
                case 4:

                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    String hapusNim = input.nextLine();

                    if (dataMahasiswa.containsKey(hapusNim)) {

                        dataMahasiswa.remove(hapusNim);

                        System.out.println("Data berhasil dihapus!");

                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }

                    break;

                // MENU TAMPILKAN SEMUA DATA
                case 5:

                    if (dataMahasiswa.isEmpty()) {

                        System.out.println("Belum ada data mahasiswa.");

                    } else {

                        System.out.println("\n===== DATA MAHASISWA =====");

                        for (String key : dataMahasiswa.keySet()) {

                            Mahasiswa data = dataMahasiswa.get(key);

                            System.out.println("------------------------");
                            System.out.println("NIM  : " + key);
                            System.out.println("Nama : " + data.nama);
                            System.out.println("IPK  : " + data.ipk);
                        }
                    }

                    break;

                // MENU JUMLAH MAHASISWA
                case 6:

                    System.out.println("Jumlah mahasiswa: "
                            + dataMahasiswa.size());

                    break;

                // MENU KELUAR
                case 7:

                    System.out.println("Program selesai.");
                    break;

                // INPUT TIDAK VALID
                default:

                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 7);

        input.close();
    }
}