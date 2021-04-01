import java.util.*;

public class Dompet<T extends Number> {
    private ArrayList<Transaction<T>> transactions;


     public Dompet() {
        // Constructor tanpa parameter, transactions diinisialisasi dengan array list baru
        this.transactions = new ArrayList<Transaction<T>>();
    }


    public Dompet(T initialBalance) {
        // Constructor dengan parameter T initialBalance, inisialisasi transactions dengan array list baru dan tambahkan transaksi tambah dengan value initial balance
        /* contoh transaksi tambah: new Transaction<T>('+', initialBalance) */
        this.transactions = new ArrayList<Transaction<T>>();
        addMoney(initialBalance);
    }

    public void addMoney(T money) {
        // Buat prosedur addMoney dengan parameter T money, tambahkan transaksi tambah dengan senilai money
        this.transactions.add(new Transaction<T>('+', money));
    }

    public boolean takeMoney(T money) {
        // Tambahkan transaksi kurang sebesar money (perlu ada pengecekan apakah balance cukup atau tidak)
        // false bila transaksi gagal, true bila berhasil
        if (getBalance() < money.doubleValue()) {
            return false;
        }
        this.transactions.add(new Transaction<T>('-', money));
        return true;
    }

    public void setBalance(T balance) {
        // Mengganti transaksi agar bernilai sama dengan balance
        // Tips: inisialisasi ulang transactions, lalu tambahkan transaksi tambah sebanyak balance
        this.transactions.clear();
        this.transactions.add(new Transaction<T>('+', balance));
    }

    // Akses nilai Double dilakukan dengan .doubleValue()
    // Contoh: amount.doubleValue()

    public Double getBalance(){
        // Mencari balance dompet dari transaksi dengan cara menghitung total transaksi
        double total = 0.0D;
        for (Transaction<T> t : this.transactions) {
            if (t.getType() == '+') {
                total += t.getAmount().doubleValue();
            } else {
                total -= t.getAmount().doubleValue();
            }
        }
        return total;
    }

    public void printTransactions() {
        // Print seluruh transaksi yang ada pada array
        // Format: Transactions [indeks + 1]: [tipe transaksi] [amount]
        // Contoh: Transactions 3: + 500
        for (int i = 0; i < this.transactions.size(); i++) {
            Transaction<T> t = this.transactions.get(i);
            System.out.printf("Transactions %d: %c %d\n", i + 1, t.getType(), t.getAmount().intValue());
        }
    }

    public Double getAverageTransaction() {
        // Mencari rata-rata transaksi (jika tidak ada transaksi, berikan hasil null)
        if (this.transactions.isEmpty()) {
            return null;
        }
        Double now = this.getBalance();
        return now.doubleValue() / Integer.valueOf(this.transactions.size()).doubleValue();
    }

    public Double getMinimumTransaction() {
        // Mencari nilai minimum transaksi (jika tidak ada transaksi, berikan hasil null; hanya perlu membandingkan nilainya saja tanpa peduli type)
        if (this.transactions.isEmpty()) {
            return null;
        }
        double min = this.transactions.get(0).getAmount().doubleValue();
        for (Transaction<T> t : this.transactions) {
            if (t.getAmount().doubleValue() < min) {
                min = t.getAmount().doubleValue();
            }
        }
        return Double.valueOf(min);
    }

    public Double getMaximumTransaction() {
        // Mencari nilai maksimum transaksi (jika tidak ada transaksi, berikan hasil null; hanya perlu membandingkan nilainya saja tanpa peduli type)
        if (this.transactions.isEmpty()) {
            return null;
        }
        double max = this.transactions.get(0).getAmount().doubleValue();
        for (Transaction<T> t : this.transactions) {
            if (t.getAmount().doubleValue() > max) {
                max = t.getAmount().doubleValue();
            }
        }
        return Double.valueOf(max);
    }
}