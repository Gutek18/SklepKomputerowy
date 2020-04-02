import java.util.InputMismatchException;
import java.util.Scanner;

public class Sklep {


    public static void main(String[] args) {

        opcjeWyboru();
    }

    private static void opcjeWyboru() {
        Magazyn magazyn = new Magazyn();
        String operacja;
        do {
            System.out.println(
                    "------------------------------\n" +
                            "Co chcesz zrobić?\n" +
                            "(D)odaj sprzęt\n" +
                            "(L)ista komputerów\n" +
                            "(O)blicz moc\n" +
                            "(S)przedaj komputer\n" +
                            "(W)yjdż");
            operacja = odczytajDane("operację");
            if ("d".equalsIgnoreCase(operacja)) {
                dodajNowySprzetDoMagazynu(magazyn);
            } else if ("l".equalsIgnoreCase(operacja)) {
                magazyn.listaSprzetu();
            } else if ("o".equalsIgnoreCase(operacja)) {
                obliczMoc(magazyn);
            } else if ("s".equalsIgnoreCase(operacja)) {
                sprzedajKomputer(magazyn);
            }
        } while (!"w".equalsIgnoreCase(operacja));
    }

    private static void sprzedajKomputer(Magazyn magazyn) {
        System.out.println("Podaj lp. komputera który checesz usunąć od 0 do " + magazyn.elementy.size());
        int value = getValue(magazyn);
        magazyn.sprzedajKomputer(value);
    }

    private static void obliczMoc(Magazyn magazyn) {
        System.out.println("Podaj lp. komputera którego checesz obliczyć moc");
        int value = getValue(magazyn);
        magazyn.mocOperacyjnaKomputera(value);
    }

    private static int getValue(Magazyn magazyn) {
        magazyn.listaSprzetu();
        int value = 0;
        boolean sprawdz;
        do {
            sprawdz = false;
            try {
                value = odczytajLiczbe();
                int rozmiar = Magazyn.rozmiarMapy;
                if (rozmiar <= value && value >= rozmiar) {
                    System.out.println("Nieprawidłowa wartość! Wybierz komputer z listy");
                    sprawdz = true;
                }
            } catch (NullPointerException ex) {
                System.out.println("Nieprawidłowa wartość!");
            }
        } while (sprawdz);
        return value;
    }

    private static Komputer dodajNowySprzetDoMagazynu(Magazyn magazyn) {
        String procesor = odczytajDane("model procesora");
        double procesorTaktowanie = odczytajWartoscLiczbowa("taktowanie procesora [GHz]");
        double ram = odczytajWartoscLiczbowa("ilość Ram [Gb]");
        double ramTaktowanie = odczytajWartoscLiczbowa("taktowanie ram [GHz]");
        Komputer komputer = new Komputer(procesor, procesorTaktowanie, ram, ramTaktowanie);
        magazyn.dodajElementDoSklepu(komputer);
        return komputer;
    }

    private static int odczytajLiczbe() {
        Integer wartosc = Integer.valueOf(0);
        boolean type = false;
        do {
            Scanner wpisz = new Scanner(System.in);
            try {
                wartosc = wpisz.nextInt();
                if (wartosc instanceof Integer) {
                    type = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Niepoprawne dane, wpisz ponownie!");
            }
        } while (!type);
        return wartosc;
    }

    private static double odczytajWartoscLiczbowa(String nazwaParametru) {
        Double wartosc = Double.valueOf(0);
        boolean type = false;
        do {
            System.out.print("Wpisz " + nazwaParametru + ":");
            Scanner wpisz = new Scanner(System.in);
            try {
                wartosc = wpisz.nextDouble();
                if (wartosc instanceof Double) {
                    type = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Niepoprawne dane, wpisz ponownie!");
            }
        } while (!type);
        return wartosc;
    }

    private static String odczytajDane(String nazwaParametru) {
        Scanner wpisz = new Scanner(System.in);
        System.out.print("Wpisz " + nazwaParametru + ":");
        String nazwa = wpisz.next();
        return nazwa;
    }
}