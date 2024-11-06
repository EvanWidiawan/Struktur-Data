import java.util.Scanner;

class Passenger {
    String name;
    String destination;
    int cost;

    public Passenger(String name, String destination, int cost) {
        this.name = name;
        this.destination = destination;
        this.cost = cost;
    }
}

class CircularQueue {
    private int maxSize;
    private Passenger[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new Passenger[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(Passenger passenger) {
        if (!isFull()) {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queueArray[++rear] = passenger;
            nItems++;
            System.out.println("Penumpang " + passenger.name + " ditambahkan ke antrian.");
        } else {
            System.out.println("Antrian penuh, tidak bisa menambahkan penumpang.");
        }
    }

    public Passenger remove() {
        if (!isEmpty()) {
            Passenger temp = queueArray[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return temp;
        } else {
            System.out.println("Antrian kosong, tidak ada penumpang yang bisa dipanggil.");
            return null;
        }
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }
}

public class prak05_23051130053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularQueue queue = new CircularQueue(5); // Ubah ukuran antrian sesuai kebutuhan

        while (true) {
            System.out.println("\nPilih Menu:");
            System.out.println("1. Pendaftaran penumpang");
            System.out.println("2. Pemanggilan penumpang");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nMasukkan nama penumpang: ");
                    String name = scanner.next();
                    System.out.println("Pilih tujuan yang ingin dipesan:");
                    System.out.println("1. Jakarta");
                    System.out.println("2. Bandung");
                    System.out.println("3. Surabaya");
                    System.out.print("Masukkan nomor tujuan: ");
                    int destinationChoice = scanner.nextInt();
                    String destination;
                    int cost;
                    switch (destinationChoice) {
                        case 1:
                            destination = "Jakarta";
                            cost = 210;
                            break;
                        case 2:
                            destination = "Bandung";
                            cost = 185;
                            break;
                        case 3:
                            destination = "Surabaya";
                            cost = 197;
                            break;
                        default:
                            System.out.println("Pilihan tujuan tidak valid, penumpang tidak ditambahkan.");
                            continue;
                    }
                    Passenger passenger = new Passenger(name, destination, cost);
                    queue.insert(passenger);
                    break;
                case 2:
                    Passenger calledPassenger = queue.remove();
                    if (calledPassenger != null) {
                        System.out.println("Penumpang yang dipanggil: " + calledPassenger.name);
                        System.out.println("Tujuan: " + calledPassenger.destination);
                        System.out.println("Biaya: Rp" + calledPassenger.cost + " ribu");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid, silakan pilih menu yang benar.");
            }
        }
    }
}




 