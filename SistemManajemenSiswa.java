import java.util.HashMap;
import java.util.Scanner;

// Kelas Siswa untuk menyimpan nama dan IPK
class Siswa {
    String nama;
    double ipk;

    // Constructor
    Siswa(String nama, double ipk) {
        this.nama = nama;
        this.ipk = ipk;
    }
}

// Kelas utama dengan nama sesuai file: SistemManajemenSiswa
public class SistemManajemenSiswa {

    public static void main(String[] args) {
        // HashMap sebagai implementasi Hash Table
        HashMap<String, Siswa> dataSiswa = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== SISTEM MANAJEMEN SISWA (HASH TABLE) =====");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Cari Siswa");
            System.out.println("3. Edit Siswa");
            System.out.println("4. Hapus Siswa");
            System.out.println("5. Tampilkan Semua Data");
            System.out.println("6. Jumlah Siswa");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1: // TAMBAH SISWA
                    System.out.print("Masukkan NIM: ");
                    String nim = input.nextLine();
                    if (dataSiswa.containsKey(nim)) {
                        System.out.println("NIM sudah terdaftar!");
                        break;
                    }
                    System.out.print("Masukkan Nama: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan IPK: ");
                    double ipk = input.nextDouble();
                    input.nextLine();
                    dataSiswa.put(nim, new Siswa(nama, ipk));
                    System.out.println("Data siswa berhasil ditambahkan!");
                    break;

                case 2: // CARI SISWA
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cariNim = input.nextLine();
                    if (dataSiswa.containsKey(cariNim)) {
                        Siswa s = dataSiswa.get(cariNim);
                        System.out.println("\n===== DATA DITEMUKAN =====");
                        System.out.println("NIM  : " + cariNim);
                        System.out.println("Nama : " + s.nama);
                        System.out.println("IPK  : " + s.ipk);
                    } else {
                        System.out.println("Data siswa tidak ditemukan!");
                    }
                    break;

                case 3: // EDIT SISWA
                    System.out.print("Masukkan NIM yang ingin diedit: ");
                    String editNim = input.nextLine();
                    if (dataSiswa.containsKey(editNim)) {
                        System.out.print("Masukkan Nama Baru: ");
                        String namaBaru = input.nextLine();
                        System.out.print("Masukkan IPK Baru: ");
                        double ipkBaru = input.nextDouble();
                        input.nextLine();
                        dataSiswa.put(editNim, new Siswa(namaBaru, ipkBaru));
                        System.out.println("Data berhasil diperbarui!");
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;

                case 4: // HAPUS SISWA
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    String hapusNim = input.nextLine();
                    if (dataSiswa.containsKey(hapusNim)) {
                        dataSiswa.remove(hapusNim);
                        System.out.println("Data berhasil dihapus!");
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;

                case 5: // TAMPILKAN SEMUA DATA
                    if (dataSiswa.isEmpty()) {
                        System.out.println("Belum ada data siswa.");
                    } else {
                        System.out.println("\n===== DATA SISWA =====");
                        for (String key : dataSiswa.keySet()) {
                            Siswa data = dataSiswa.get(key);
                            System.out.println("------------------------");
                            System.out.println("NIM  : " + key);
                            System.out.println("Nama : " + data.nama);
                            System.out.println("IPK  : " + data.ipk);
                        }
                    }
                    break;

                case 6: // JUMLAH SISWA
                    System.out.println("Jumlah siswa: " + dataSiswa.size());
                    break;

                case 7: // KELUAR
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);

        input.close();
    }
}