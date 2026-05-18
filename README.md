# 🚀 Proyek Kelompok - Struktur Data dan Algoritma (Java)

> Proyek akhir praktikum mata kuliah Data Structures and Algorithm.  
> Kelompok kami mengimplementasikan **tiga** aplikasi berbasis Java yang menerapkan **Tree (BST & Expression Tree)**, **Hash Table**, dan **Graph** untuk menyelesaikan permasalahan dunia nyata.

---

## 👥 Anggota Kelompok (Kelompok 5)

| NIM         | Nama                       |
|-------------|----------------------------|
| 2902714100  | Darren Jehonathan          |
| 2902692466  | Evelyn Kimora Tiju         |
| 2902724442  | Gabriel Sigalingging       |
| 2902706736  | Joshua Christian Supit     |
| 2902733131  | Renata Mutiara Nirwana     |

---

## 📁 Daftar Aplikasi

### 1. 🌳 Sistem Manajemen Data Berbasis Tree (BST & Expression Tree)
**File:** `TugasTree.java`

- **Expression Tree**  
  Menerima ekspresi matematika dalam bentuk **infix** (contoh: `(3 + 5) * 2`), mengonversinya ke postfix, membangun pohon, lalu mengevaluasi hasilnya menggunakan traversal rekursif.  
- **Binary Search Tree (BST)**  
  Menyimpan data integer secara terurut dengan operasi `insert()`, `search()`, dan `delete()`.

**Struktur Data:**  
- Binary Search Tree (BST)  
- Expression Tree (Binary Tree khusus)

**Kompleksitas:**  
- BST: rata-rata O(log n), terburuk O(n)  
- Expression Tree: O(n) untuk membangun & evaluasi

---

### 2. 🗂️ Sistem Manajemen Data dengan Hash Table
**File:** `Sistem Manajemen Data Mahasiswa.zip` / `SistemManajemenSiswa.java`

- Menggunakan `HashMap<String, Mahasiswa>` (Hash Table) untuk menyimpan data mahasiswa berdasarkan **NIM** sebagai kunci unik.
- Fitur: Tambah, Cari, Edit, Hapus, Tampilkan Semua, dan Jumlah Mahasiswa.
- Pencarian sangat cepat karena akses langsung ke lokasi memori berdasarkan hash dari NIM.

**Struktur Data:**  
- Hash Table (Java `HashMap`)

**Kompleksitas:**  
- Rata-rata O(1) untuk insert, search, delete (dengan fungsi hash yang baik).

---

### 3. 🗺️ Aplikasi Simulasi Jaringan dengan Graph
**File:** `Main.java`

- Memodelkan jaringan lokasi (kota/titik) sebagai **graph** dengan adjacency list (`HashMap<String, List<Edge>>`).
- Mengimplementasikan **algoritma Dijkstra** untuk mencari **jalur terpendek** dari titik awal ke titik tujuan.
- Menggunakan `PriorityQueue` untuk memproses node dengan jarak terkecil terlebih dahulu.
- Output: urutan jalur dan total jarak (km).

**Struktur Data:**  
- Graph (adjacency list), Priority Queue, HashMap

**Kompleksitas:**  
- Dijkstra: O((V + E) log V)

---

## 🛠️ Cara Menjalankan Program

Pastikan Anda memiliki **Java JDK 8+** terinstal.

### ▶️ Menjalankan Expression Tree & BST
```bash
javac TugasTree.java
java TugasTree
```

### ▶️ Menjalankan Hash Table (Manajemen Mahasiswa)
```bash
javac SistemManajemenSiswa.java
java SistemManajemenSiswa
```

### ▶️ Menjalankan Simulasi Graph (Dijkstra)
```bash
javac Main.java
java Main
```
Ikuti instruksi pada layar (masukkan titik awal dan tujuan, misalnya `A` dan `E`).

---

## 📊 Analisis Singkat Performa

| Struktur Data       | Operasi Utama              | Rata-rata   | Terburuk    | Kelebihan                                  | Kekurangan                              |
|---------------------|----------------------------|-------------|-------------|--------------------------------------------|------------------------------------------|
| **BST**             | insert, search, delete     | O(log n)    | O(n)        | Data terurut, pencarian cepat              | Bisa tidak seimbang (skewed)            |
| **Expression Tree** | build, evaluate            | O(n)        | O(n)        | Menjaga prioritas operator secara natural  | Hanya untuk ekspresi matematika          |
| **Hash Table**      | put, get, remove           | O(1)        | O(n)        | Akses super cepat berbasis key             | Tidak terurut, rawan collision           |
| **Graph (Dijkstra)**| shortest path              | O((V+E) log V)| O((V+E) log V) | Memodelkan hubungan kompleks               | Implementasi lebih rumit, boros memori   |

---

## 📌 Catatan Penting

- Program **BST & Expression Tree** mendukung ekspresi dengan operator `+`, `-`, `*`, `/` dan tanda kurung `()`.
- Program **Hash Table** menggunakan NIM sebagai **kunci** (unik) – jika NIM sudah ada, data tidak akan ditimpa tanpa peringatan (bisa disesuaikan).
- Program **Graph** sudah dilengkapi contoh jaringan (A, B, C, D, E, F) dengan bobot jarak. Anda dapat menambahkan simpul/edge baru di kode.

---

## 🔗 Link Repository

- **GitHub:** https://github.com/hmnty11/Group-Project-data-structures-and-algorithm.git

---

## 📄 Lisensi

Tugas ini dibuat untuk keperluan akademik. Silakan digunakan sebagai referensi belajar.

---


