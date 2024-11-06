// tugas pertama
import java.util.Scanner;
/////////////////////////////////////////////////////////////////
class prak01_23051130053 {
	private int[] dt; // array
	private int jml_data;
	private int i;
//--------------------------------------------------------------
	public prak01_23051130053() { // constructor
		dt = new int[100]; // array sebanyak 100 indek
		jml_data = 0; // jumlah data mula-mula nol
	}
//--------------------------------------------------------------
// method input untuk memasukkan data ke dalam array
	public void input(int data) {
		dt[jml_data] = data;
		jml_data++;
	}
//--------------------------------------------------------------
// method untuk menampilkan data yang ada dalam array
// method tidak mengembalikan nilai (menggunakan void) --> PROCEDURE
	public void lihat () {
		for(i=0; i<jml_data; i++) // menampilkan data
			System.out.println(dt[i]);
		System.out.println("");
	}
	// 
	public int hitungJumlah(int cr) {
		int count = 0;
		for (i= 0; i < jml_data; i++) {
			if (dt[i] == cr)
			count++;
		}
		return count; // Mengulang kode diatas
	}

	public boolean cari(int cr) {
		int count = hitungJumlah(cr);
		if(count>0) {
			System.out.println("Data " + cr + " Ditemukan dengan jumlah " + count);
			return true;
		}else {
			System.out.println("Data" + cr +"Tidak ditemukan");
			return false;
		}
	}

//--------------------------------------------------------------
// method untuk menghapus data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
	public boolean hapus(int hps) {
		boolean cri = cari(hps);
		if (cri) { // bila data ditemukan maka dihapus
			for(int j=i; j<jml_data-1; j++) // melakukan penimpaan data
				dt[j] = dt[j+1];
			jml_data--; // jangan lupa jumlah data dikurangi satu!!!
			return true;
		}
		else // bila data tidak ditemukan
			return false;
	}
} // end class metod

/////////////////////////////////////////////////////////////////////////
class tgsPertamaOK {
	public static void main(String[] args) {
		int i=1, dat, cariData;
		try (Scanner sken = new Scanner(System.in)) {
			prak01_23051130053 md = new prak01_23051130053(); // memanggil class metod dengan variabel md
			
//----------------------------------------------------------------------

			int menu;
			while (true) {
				System.out.println("Pilih Menu di bawah ini");
				System.out.println("1. Memasukkan data");
				System.out.println("2. Pencarian data");
				System.out.println("3. Penghapusan data");
				System.out.println("4. Penampilan data");
				System.out.println("5. Keluar");
				System.out.print("Anda memilih : ");
				
				if (sken.hasNextInt()) {
					menu = sken.nextInt();
					sken.nextLine(); //membuat baris baru
				}else {
					System.out.println("Sistem error!");
					System.out.println("Perintah salah, silahkan masukkan angka 1 - 5 untuk memulai");
					sken.nextLine();
					continue;
				}
					  		
				if (menu==1){
			  		System.out.print("Masukkan data ke-" + i + " = ");
					dat = sken.nextInt();
					md.input(dat); // memanggil method input pada class metod
					i++;
				}
				
				if (menu==2) {
					System.out.print("Data yang anda cari = ");
				 	cariData = sken.nextInt();
				 	md.cari(cariData); // memanggil method cari pada class metod
				 	
				 				
				} else if (menu==3) {
					System.out.print("Data yang anda hapus = ");
				 	cariData = sken.nextInt();
				 	boolean sts = md.hapus(cariData); // memanggil method hapus pada class metod
				 	if (sts==true)
				 		System.out.println("Data " + cariData + " berhasil dihapus");
				 	else
				 		System.out.println("Data " + cariData + " TIDAK ditemukan");
					
					System.out.println("");

				} else if (menu==4) {
					md.lihat();
				
			}else if (menu == 5){
				System.out.println("Terimakasih telah menggunakan");
				break;
			}else {
				System.out.println("Hanya dapat input angka 1 - 5");
			}
} // end main()
		}
} // end class tgsPertamaOK
}