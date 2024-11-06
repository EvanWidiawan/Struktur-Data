import java.util.Scanner;

class Node {
    String pemilik;
    String jenis;
    String nomorPolisi;
    String merk;
    String warna;
    Node next;

    public Node(String pemilik, String jenis, String nomorPolisi, String merk, String warna) {
        this.pemilik = pemilik;
        this.jenis = jenis;
        this.nomorPolisi = nomorPolisi;
        this.merk = merk;
        this.warna = warna;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void tambahData(String pemilik, String jenis, String nomorPolisi, String merk, String warna) {
        Node newNode = new Node(pemilik, jenis, nomorPolisi, merk, warna);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void tampilkanData() {
        Node current = head;
        while (current != null) {
            System.out.println("Nama Pemilik: " + current.pemilik);
            System.out.println("Jenis Kendaraan: " + current.jenis);
            System.out.println("Nomor Polisi: " + current.nomorPolisi);
            System.out.println("Merk: " + current.merk);
            System.out.println("Warna: " + current.warna);
            System.out.println("--------------------");
            current = current.next;
        }
    }
}

public class prak07_23051130053 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Pemilik Kendaraan");
            System.out.println("2. Tampilkan Data Pemilik Kendaraan");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = input.nextInt();
            input.nextLine(); // Membuang newline character setelah input angka

            if (pilihan == 1) {
                System.out.print("Masukkan nama pemilik: ");
                String pemilik = input.nextLine();

                System.out.print("Masukkan jenis kendaraan (R2 untuk motor, R4 untuk mobil): ");
                String jenis = input.nextLine();

                System.out.print("Masukkan nomor polisi: ");
                String nomorPolisi = input.nextLine();

                System.out.print("Masukkan merk kendaraan: ");
                String merk = input.nextLine();

                System.out.print("Masukkan warna kendaraan: ");
                String warna = input.nextLine();

                linkedList.tambahData(pemilik, jenis, nomorPolisi, merk, warna);
                System.out.println("Data berhasil ditambahkan!");
            } else if (pilihan == 2) {
                if (linkedList.head == null) {
                    System.out.println("Tidak ada data pemilik kendaraan.");
                } else {
                    System.out.println("Data Pemilik Kendaraan:");
                    linkedList.tampilkanData();
                }
            } else if (pilihan == 3) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        }
        input.close();
    }
}
