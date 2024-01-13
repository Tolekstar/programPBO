import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class ItemMakanan {
    private String nama;
    private double harga;

    public ItemMakanan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }
}

class KeranjangBelanja {
    private Map<ItemMakanan, Integer> items;

    public KeranjangBelanja() {
        this.items = new HashMap<>();
    }

    public void tambahItem(ItemMakanan item, int jumlah) {
        items.put(item, items.getOrDefault(item, 0) + jumlah);
    }

    public void tampilkanKeranjang() {
        System.out.println("Keranjang Belanja:");
        double total = 0;
        for (Map.Entry<ItemMakanan, Integer> entry : items.entrySet()) {
            ItemMakanan item = entry.getKey();
            int jumlah = entry.getValue();
            double subtotal = item.getHarga() * jumlah;
            total += subtotal;
            System.out.println(item.getNama() + " - Jumlah: " + jumlah + " - Subtotal: Rp" + subtotal);
        }
        System.out.println("Total: Rp" + total);
    }
}

class Restoran {
    private List<ItemMakanan> menu;

    public Restoran() {
        this.menu = new ArrayList<>();
    }

    public void tambahKeMenu(ItemMakanan item) {
        menu.add(item);
    }

    public void tampilkanMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            ItemMakanan item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getNama() + " - Rp" + item.getHarga());
        }
    }
    public void stokmakanan(){

    }
    public List<ItemMakanan> getMenu() {
        return menu;
    }
}

public class SistemPemesananMakananOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Anda: ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("Masukkan Alamat Anda / no meja : ");
        String alamatPelanggan = scanner.nextLine();

        Restoran restoran = new Restoran();
        restoran.tambahKeMenu(new ItemMakanan("Paket Nasi & Ayam Goreng + Esteh", 20.000));
        restoran.tambahKeMenu(new ItemMakanan("Paket Nasi & Ayam Geprek + Esteh", 25.000));
        restoran.tambahKeMenu(new ItemMakanan("Paket Lalapan & cemilan", 10.000));

        KeranjangBelanja keranjang = new KeranjangBelanja();

        int pilihan;
        do {
            System.out.println("\n1. Tampilkan Menu");
            System.out.println("2. Tambah Item ke Keranjang");
            System.out.println("3. Lihat Keranjang");
            System.out.println("4. Pesan");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    restoran.tampilkanMenu();
                    break;
                case 2:
                    restoran.tampilkanMenu();
                    System.out.print("Masukkan nomor item untuk ditambahkan ke keranjang: ");
                    int nomorItem = scanner.nextInt();
                    if (nomorItem >= 1 && nomorItem <= restoran.getMenu().size()) {
                        ItemMakanan itemDipilih = restoran.getMenu().get(nomorItem - 1);
                        System.out.print("Masukkan jumlah: ");
                        int jumlah = scanner.nextInt();
                        keranjang.tambahItem(itemDipilih, jumlah);
                        System.out.println("Item ditambahkan ke keranjang!");
                    } else {
                        System.out.println("Nomor item tidak valid.");
                    }
                    break;
                case 3:
                    keranjang.tampilkanKeranjang();
                    break;
                case 4:
                    System.out.println("Terima kasih, " + namaPelanggan + "! Pesanan Anda akan dikirim ke alamat/no meja: " + alamatPelanggan);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 4);
    }
}
