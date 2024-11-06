import java.util.Scanner;

class Mahasiswa {
    private String nimMhs;
    private String namaMhs;
    private double ipkMhs;

    public Mahasiswa(String nim, String nama, double ipk) {
        nimMhs = nim;
        namaMhs = nama;
        ipkMhs = ipk;
    }

    public void lihatData() {
        System.out.println(nimMhs + " --> " + namaMhs + " --> " + ipkMhs);
    }

    public String getNim() {
        return nimMhs;
    }

    public String getNama() {
        return namaMhs;
    }

    public double getIpk() {
        return ipkMhs;
    }
}

class ArrayMahasiswa {
    private Mahasiswa[] dt;
    private int jml_data;
    private int i;

    public ArrayMahasiswa(int max) {
        dt = new Mahasiswa[max];
        jml_data = 0;
    }

    public void input(String nim, String nama, double ipk) {
        dt[jml_data] = new Mahasiswa(nim, nama, ipk);
        jml_data++;
        System.out.println(">>> Tambah data BERHASIL <<<");
    }

    public void dataArai() {
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("NIM       Nama        IPK");
        System.out.println("----------------------------");
        for (i = 0; i < jml_data; i++)
            dt[i].lihatData();
        System.out.println("----------------------------");
        System.out.println("");
    }

    public void selectionSort() {
        for (i = 0; i < jml_data - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < jml_data; j++) {
                if (dt[j].getNim().compareTo(dt[minIndex].getNim()) < 0) {
                    minIndex = j;
                }
            }
            Mahasiswa temp = dt[minIndex];
            dt[minIndex] = dt[i];
            dt[i] = temp;
        }
        System.out.println(">>> Data berhasil diurutkan menggunakan Selection Sort. <<<");
    }

    public void cariDanTampilkan(String cr) {
        boolean found = false;
        for (i = 0; i < jml_data; i++) {
            if (dt[i].getNama().toLowerCase().contains(cr.toLowerCase())) {
                if (!found) {
                    System.out.println(">>> Data yang cocok dengan pola pencarian \"" + cr + "\": <<<");
                    found = true;
                }
                dt[i].lihatData();
            }
        }
        if (!found) {
            System.out.println(">>> Data dengan pola pencarian \"" + cr + "\" tidak ditemukan. <<<");
        }
    }
}

class datADT3 {
    public static void main(String[] args) {
        int i = 1, jml_arai = 100;
        Scanner sken = new Scanner(System.in);
        ArrayMahasiswa md = new ArrayMahasiswa(jml_arai);
        String nim, nama, cariData;
        double ipk;

        int menu;
        do {
            System.out.println("Pilih Menu di bawah ini");
            System.out.println("1. Memasukkan data");
            System.out.println("2. Pencarian data");
            System.out.println("3. Penghapusan data");
            System.out.println("4. Penampilan data");
            System.out.println("5. Urutkan data (Selection Sort)");
            System.out.println("6. Keluar");
            System.out.print("Anda memilih : ");
            try {
                menu = Integer.parseInt(sken.nextLine());

                if (menu < 1 || menu > 6) {
                    System.out.println(">>> Perintah tidak valid. Masukkan angka antara 1 hingga 6. <<<");
                    continue; 
                }

                if (menu == 1) {
                    System.out.println("Masukkan data mahasiswa ke-" + i);
                    System.out.print("NIM  : ");
                    nim = sken.nextLine();
                    System.out.print("Nama : ");
                    nama = sken.nextLine();
                    System.out.print("IPK  : ");
                    ipk = Double.parseDouble(sken.nextLine());
                    md.input(nim, nama, ipk);
                    i++;
                } else if (menu == 2) {
                    System.out.print("Masukkan pola pencarian nama mahasiswa : ");
                    cariData = sken.nextLine();
                    md.cariDanTampilkan(cariData);
                } else if (menu == 3) {
                    System.out.print("Data NAMA yang anda hapus = ");
                    cariData = sken.nextLine();
                    
                } else if (menu == 4) {
                    md.dataArai();
                } else if (menu == 5) {
                    md.selectionSort();
                }
            } catch (NumberFormatException e) {
                System.out.println(">>> Perintah tidak valid. Masukkan angka antara 1 hingga 6. <<<");
                menu = 0; 
            }
        } while (menu != 6);
    }
}
