import java.util.*;

public class RestoranRamen {
    private Map<Integer, Integer> daftarMeja;

    public RestoranRamen() {
        this.daftarMeja = new HashMap<Integer, Integer>();
    }

    public void tambahOrder(int n, int p) {
        int skrg = this.daftarMeja.getOrDefault(n, 0);
        this.daftarMeja.put(n, skrg + p);
    }

    public int tutupOrder(int n) {
        return this.daftarMeja.remove(n);
    }

    public int cekTotal(int n) {
        return this.daftarMeja.get(n);
    }

    public int totalMeja() {
        return this.daftarMeja.keySet().size();
    }

    public void cetakMeja() {
        if (totalMeja() == 0) {
            System.out.println("Restoran kosong");
        }
        for (Map.Entry<Integer, Integer> entry : this.daftarMeja.entrySet()) {
            System.out.printf("Meja %d = %d\n", entry.getKey(), entry.getValue());
        }
    }
}