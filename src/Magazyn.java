import java.util.HashMap;
import java.util.Map;

public class Magazyn {
    Map<Integer, Komputer> elementy = new HashMap<>();
    protected static int rozmiarMapy = 1;

    void dodajElementDoSklepu(Komputer sprzet) {
        elementy.put(rozmiarMapy, sprzet);
        rozmiarMapy++;
    }

    double mocOperacyjnaKomputera(int key) {
        Komputer comp = elementy.get(key);
        double moc = (comp.getProcesorCzestotliwosc() * (comp.getRam() * comp.getRamTaktowanie()));
        String value = comp.toString();
        System.out.println("Moc obliczeniowa komputera " + value + ", wynosi: " + moc);
        return moc;
    }

    void listaSprzetu() {
        for (Map.Entry<Integer, Komputer> entry : elementy.entrySet()) {
            int k = entry.getKey();
            Komputer v = entry.getValue();
            System.out.println("Lp: " + k + ", " + v);
        }
        System.out.println("Liczba dostepnych komputerów: " + elementy.size());
    }

    void sprzedajKomputer(double key) {
        elementy.remove(key);
    }
}