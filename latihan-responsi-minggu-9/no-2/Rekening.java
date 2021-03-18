public class Rekening {
    // Daftar transaksi yang telah dilakukan pada rekening ini
    private Transaksi[] daftarTransaksi;
    // Jumlah transaksi yang telah dilakukan pada rekening ini
    private int jumlahTransaksi;
    // Jumlah transaksi maksimum yang dapat disimpan
    private int maxTransaksi;

    // Konstruktor, dengan nilai maxTransaksi awal
    public Rekening(int maxTrans) {
        this.maxTransaksi = maxTrans;
        this.jumlahTransaksi = 0;
        this.daftarTransaksi = new Transaksi[this.maxTransaksi];
    }

    // Getter
    public int getJumlahTransaksi() {
        return this.jumlahTransaksi;
    }
    public int getMaxTransaksi() {
        return this.maxTransaksi;
    }

    // Mengembalikan array baru yang berisi `count` transaksi terakhir yang dilakukan
    public Transaksi[] getLastTransaksi(int count) {
        Transaksi[] transaksi = new Transaksi[count];
        for(int i = 0; i < count; i++){
            transaksi[i] = this.daftarTransaksi[this.getJumlahTransaksi() - count + i];
        }
        return transaksi;
    }

    // Mengembalikan saldo pada rekening, yaitu hasil penjumlahan perubahan semua transaksi yang telah dilakukan
    public double getSaldo() {
        double saldo = 0;
        for(int i = 0; i < this.jumlahTransaksi; i++){
            saldo += this.daftarTransaksi[i].getPerubahan();
        }
        return saldo;
    }

    // Membuat transaksi baru yang menambahkan `amount` uang pada rekening.
    // `amount` harus positif dan harus ada sisa tempat di rekening.
    // Mengembalikan status berhasil/gagal penyimpanan uang. (Jika berhasil, mengembalikan true)
    public boolean simpanUang(double amount) {
        boolean status = false;
        if(this.getJumlahTransaksi() != this.getMaxTransaksi() && amount > 0){
            this.daftarTransaksi[this.getJumlahTransaksi()] = new Transaksi(this, amount);
            this.jumlahTransaksi++;
            status = true;
        }
        return status;
    }

    // Membuat transaksi baru yang mengurangi `amount` uang pada rekening.
    // `amount` harus positif dan lebih kecil dari saldo, dan harus ada sisa tempat di rekening.
    // Harus ada sisa tempat di rekening.
    // Mengembalikan status berhasil/gagal penarikan uang. (Jika berhasil, mengembalikan true)
    public boolean tarikUang(double amount) {
        boolean status = false;
        if(this.getJumlahTransaksi() != this.getMaxTransaksi() && amount > 0 && this.getSaldo() >= amount){
            this.daftarTransaksi[this.getJumlahTransaksi()] = new Transaksi(this, amount * -1);
            this.jumlahTransaksi++;
            status = true;
        }
        return status;
    }
}