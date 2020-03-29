import java.util.HashMap;
import java.util.Map;

public class Magazyn {
    private int i = 1;
    Map<Integer, Komputer> elementy = new HashMap<>();

    void dodajElementDoSklepu(Komputer sprzet) {
        elementy.put(i, sprzet);
        i++;
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
    }

    void sprzedajKomputer(int key) {
        elementy.remove(key);
    }
}
