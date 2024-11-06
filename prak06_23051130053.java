import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class mahasiswa {
    private String nimMhs;
    private String namaMhs;
    private double ipkMhs;

    public mahasiswa(String nim, String nama, double ipk) {
        nimMhs = nim;
        namaMhs = nama;
        ipkMhs = ipk;
    }

    public void lihatData() {
        System.out.println("||   " + nimMhs + "  ||  " + namaMhs + "  ||  " + ipkMhs + "   ||");
    }

    public String getNim() {
        return nimMhs;
    }

    public void setNim(String nim) {
        this.nimMhs = nim;
    }

    public String getNama() {
        return namaMhs;
    }

    public void setNama(String nama) {
        this.namaMhs = nama;
    }

    public double getIpk() {
        return ipkMhs;
    }

    public void setIpk(double ipk) {
        this.ipkMhs = ipk;
    }
}
class arai {
    private mahasiswa[] dt;
    private int jml_data;
    private int i;

    public void cariDenganPola(String pola) {
        for (i = 0; i < jml_data; i++) {
            if (dt[i].getNama().toLowerCase().contains(pola.toLowerCase())) {
                System.out.println("NIM  : " + dt[i].getNim());
                System.out.println("Nama : " + dt[i].getNama());
                System.out.println("IPK  : " + dt[i].getIpk());
                System.out.println("");
            }
        }
    }

    public void selectionSort(String sort) {
        for (int i = 0; i < jml_data - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < jml_data; j++) {
                if (sort.equalsIgnoreCase("nim")) {
                    if (dt[j].getNim().compareTo(dt[minIndex].getNim()) < 0) {
                        minIndex = j;
                    }
                } else if (sort.equalsIgnoreCase("nama")) {
                    if (dt[j].getNama().compareToIgnoreCase(dt[minIndex].getNama()) < 0) {
                        minIndex = j;
                    }
                }
            }
            mahasiswa temp = dt[minIndex];
            dt[minIndex] = dt[i];
            dt[i] = temp;
        }
        System.out.println(">>> Data berhasil diurutkan berdasarkan <<<" + sort.toUpperCase());
    }

    public arai(int max) {
        dt = new mahasiswa[max];
        jml_data = 0;
    }

    public void input(String nim, String nama, double ipk) {
        dt[jml_data] = new mahasiswa(nim, nama, ipk);
        jml_data++;
        System.out.println(">>> Tambah data BERHASIL <<<\n");
    }

    public void dataArai() {
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("||   NIM   ||   Nama   ||   IPK   ||");
        System.out.println("----------------------------");
        for (i = 0; i < jml_data; i++)
            dt[i].lihatData();
        System.out.println("----------------------------");
        System.out.println("");
    }

    public boolean cari(String cr) {
        for (i = 0; i < jml_data; i++) {
            if (dt[i].getNama().toLowerCase().contains(cr.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean ubahData(String cariNama, String newNim, String newNama, double newIpk) {
        boolean cri = cari(cariNama);
        if (cri == true) {
            dt[i].setNim(newNim);
            dt[i].setIpk(newIpk);
            dt[i].setNama(newNama);
            return true;
        } else
            return false;
    }

    public boolean hapus(String hps) {
        boolean cri = cari(hps);
        if (cri == true) {
            for (int j = i; j < jml_data - 1; j++)
                dt[j] = dt[j + 1];
            jml_data--;
            return true;
        } else
            return false;
    }
}

class datADT3 {
    public static void main(String[] args) {
        int i = 1, jml_arai = 100;
        Scanner sken = new Scanner(System.in);
        arai md = new arai(jml_arai);
        String nim, nama, cariData, newNim, newNama;
        double ipk, newIpk;

        int menu;
        do {
            System.out.println("Pilih Menu di bawah ini");
            System.out.println("1. Memasukkan data");
            System.out.println("2. Pencarian data");
            System.out.println("3. Penghapusan data");
            System.out.println("4. Penampilan data");
            System.out.println("5. Pengurutan data");
            System.out.println("6. Ubah data");
            System.out.println("7. Keluar");
            System.out.print("Anda memilih : ");
            menu = sken.nextInt();

            if (menu == 1) {
                System.out.println("\nMasukkan data mahasiswa ke-" + i);
                System.out.print("NIM  : ");
                nim = sken.next();
                sken.nextLine();
                System.out.print("Nama : ");
                nama = sken.nextLine();
                System.out.print("IPK  : ");
                while (!sken.hasNextDouble()) { // Error handling for invalid input
                    System.out.print("IPK harus angka. Masukkan IPK kembali: ");
                    sken.next(); // Clear the input buffer
                }
                ipk = sken.nextDouble();
                sken.nextLine();
                md.input(nim, nama, ipk);
                i++;
            } else if (menu == 2) {
                System.out.print("\nMasukkan pola pencarian: ");
                cariData = sken.next();
                md.cariDenganPola(cariData);
            } else if (menu == 3) {
                System.out.print("\nData NAMA yang anda hapus = ");
                cariData = sken.next();
                sken.nextLine();
                boolean sts = md.hapus(cariData);
                if (sts == true)
                    System.out.println("Data " + cariData + " berhasil dihapus");
                else
                    System.out.println("Data " + cariData + " TIDAK ditemukan");
                System.out.println("");
            } else if (menu == 4) {
                md.dataArai();
            } else if (menu == 5) {
               System.out.println("\nPilih kriteria pengurutan:");
               System.out.println("1. Berdasarkan NIM");
               System.out.println("2. Berdasarkan Nama");
               System.out.print("Pilihan Anda: ");
               int sortChoice = sken.nextInt();
               sken.nextLine(); // consume newline
               switch (sortChoice) {
                case 1:
                md.selectionSort("nim");
                System.out.println("Data berhasil diurutkan berdasarkan NIM");
                break;
                case 2:
                md.selectionSort("nama");
                System.out.println("Data berhasil diurutkan berdasarkan Nama");
                break;
            default:
                System.out.println("Pilihan tidak valid");
                break;
               }
            } else if (menu == 6) {
                System.out.print("\nMasukkan nama yang ingin diubah: ");
                cariData = sken.next();
                sken.nextLine();
                System.out.print("Masukkan NIM baru: ");
                newNim = sken.next();
                sken.nextLine();
                System.out.print("Masukkan nama baru: ");
                newNama = sken.nextLine();
                System.out.print("Masukkan IPK baru: ");
                while (!sken.hasNextDouble()) { 
                    System.out.print("IPK harus angka. Masukkan IPK kembali: ");
                    sken.next(); 
                }
                newIpk = sken.nextDouble();
                sken.nextLine();
                boolean sts = md.ubahData(cariData, newNim, newNama, newIpk);
                if (sts == true)
                    System.out.println("Data " + cariData + " berhasil diubah");
                else
                    System.out.println("Data " + cariData + " TIDAK ditemukan");
                System.out.println("");
            }

        } while (menu >= 1 && menu < 7);
    }
}