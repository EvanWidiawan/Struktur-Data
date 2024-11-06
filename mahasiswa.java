// penyimpanan data mahasiswa
import java.util.Scanner;
import java.util.regex.Matcher; // IMPORT Matcher
import java.util.regex.Pattern; // IMPORT Pattern
/////////////////////////////////////////////////////////////////

// class untuk menyimpan data mahasiswa -> membuat tipe data ADT
class mahasiswa { // mahasiswa mempunyai 3 data, nim, nama, dan ipk
	private String nimMhs;
	private String namaMhs;
	private double ipkMhs;
//--------------------------------------------------------------
	// constructor
	public mahasiswa(String nim, String nama, double ipk) {
		nimMhs = nim;
		namaMhs = nama;
		ipkMhs = ipk;
	}
//--------------------------------------------------------------
	// method untuk menampilkan data mahasiswa
	public void lihatData() {
		System.out.println(nimMhs + " --> " + namaMhs + " --> " + ipkMhs);
	}
//--------------------------------------------------------------
	// method memperoleh (mengambil) data nim, nama, ipk
	public String getNim()
		{ return nimMhs; }
//--------------------------------------------------------------
	public String getNama()
		{ return namaMhs; }
//--------------------------------------------------------------
	public double getIpk()
		{ return ipkMhs; }
} // end class mahasiswa
/////////////////////////////////////////////////////////////////

//class untuk menyimpan data mahasiswa di array
class arai {
	private mahasiswa[] dt; // membuat array dengan tipe data ADT 
	private int jml_data;
	private int i;
    private static Pattern pola; //TAMBAHKAN VARIABEL pola
    private static Matcher cocok; //TAMBAHKAN VARIABEL cocok
//--------------------------------------------------------------
	public arai(int max) { // constructor
		dt = new mahasiswa[max]; // creating array
		jml_data = 0; // jumlah data mula-mula nol
	}
//--------------------------------------------------------------
	// method input untuk memasukkan data ke dalam array
	public void input(String nim, String nama, double ipk) {
		dt[jml_data] = new mahasiswa(nim,nama,ipk);
		jml_data++; // jika ada data masuk maka jumlah datanya bertambah
		System.out.println("Tambah data BERHASIL");
	}
//--------------------------------------------------------------
// method dataArai untuk menampilkan data yang ada dalam array
// method tidak mengembalikan nilai (menggunakan void) --> PROCEDURE
	public void dataArai() { // menampilkan isi dari array
		System.out.println("");
		System.out.println("----------------------------");
		System.out.println("NIM       Nama        IPK");
		System.out.println("----------------------------");
		for(i=0; i<jml_data; i++)
			dt[i].lihatData();
		System.out.println("----------------------------");
		System.out.println("");
	}
//--------------------------------------------------------------
// method cari untuk mencari data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
// pencarian data berdasarkan nama mahasiswa
	public boolean cari(String cr) {
        pola = Pattern.compile(cr); // INISIALISAI Pattern
		for(i=0; i<jml_data; i++) { // mencari data pada setiap elemen array
            cocok = pola.matcher(dt[i].getNama()); // pengecekan data dengan pola data yang dicari
            if( cocok.find() == true ) // pengecekan hasil pencocokan data, ada atau tidak
				break; // jika sama maka pencarian dihentikan
        }
		if(i == jml_data) // apakah pencarian yang dilakukan sebanyak jumlah elemen array?
			return false; // jika true data TIDAK ditemukan (false)
		else
			return true; // jika false data ditemukan (true)
	}
//--------------------------------------------------------------
	public String nim(){
		return dt[i].getNim();
	}
//--------------------------------------------------------------
	public String nama(){
		return dt[i].getNama();
	}
//--------------------------------------------------------------	
	public double ipk(){
		return dt[i].getIpk();
	}
//--------------------------------------------------------------
// method hapus untuk menghapus data yang ada dalam array
// method mengembalikan nilai (tidak menggunakan void) --> FUNCTION
	public boolean hapus(String hps) {
		boolean cri = cari(hps); // memanggil method cari
		if (cri==true) { // bila data ditemukan maka dihapus
			for(int j=i; j<jml_data-1; j++)
				dt[j] = dt[j+1];
			jml_data--; // jangan lupa jumlah data dikurangi satu!!!
			return true;
		}
		else // bila data tidak ditemukan
			return false;
	}
} // end class arai
/////////////////////////////////////////////////////////////////////////

class datADT3 {
	public static void main(String[] args) {
		int i=1, jml_arai=100;
		Scanner sken = new Scanner(System.in).useDelimiter(System.lineSeparator() + "|\n")
		arai md = new arai(jml_arai); // memanggil class arai dengan variabel md
		String nim, nama, cariData;
		double ipk;
		
//----------------------------------------------------------------------

		int menu;
		do {
			System.out.println("Pilih Menu di bawah ini");
			System.out.println("1. Memasukkan data");
			System.out.println("2. Pencarian data");
			System.out.println("3. Penghapusan data");
			System.out.println("4. Penampilan data");
			System.out.println("5. Keluar");
			System.out.print("Anda memilih : ");
	  		menu = sken.nextInt();
	  			  		
	  		if (menu==1){
		  		System.out.println("Masukkan data mahasiswa ke-" + i);
		  		System.out.print("NIM  : ");
		  		nim = sken.next();
		  		System.out.print("Nama : ");
		  		nama = sken.next();
		  		System.out.print("IPK  : ");
	  			ipk = sken.nextDouble();
	  			md.input(nim,nama,ipk); // memanggil method input pada class metod
	  			i++;
			}
			
			if (menu==2) {
				System.out.print("Data mahasiswa yang anda cari [tulis nama] = ");
			 	cariData = sken.next();
			  	boolean hasil = md.cari(cariData); // memanggil method cari pada class metod
			  	if (hasil==true) {
					System.out.println("Data ditemukan");
				  	System.out.println("NIM  : " + md.nim());
				  	System.out.println("Nama : " + md.nama());
				  	System.out.println("IPK  : " + md.ipk());
		  		}
			  	else
			  		System.out.println("Data " + cariData + " tidak ditemukan ");
			  	System.out.println("");
						
			} else if (menu==3) {
				System.out.print("Data NAMA yang anda hapus = ");
	  		 	cariData = sken.next();
	  		 	boolean sts = md.hapus(cariData); // memanggil method hapus pada class metod
	  		 	if (sts==true)
	  		 		System.out.println("Data " + cariData + " berhasil dihapus");
	  		 	else
	  		 		System.out.println("Data " + cariData + " TIDAK ditemukan");
				
				System.out.println("");
	
			} else if (menu==4) {
				md.dataArai();
			}
		} while (menu >= 1 && menu < 5);
	} // end main()
} // end class datADT
