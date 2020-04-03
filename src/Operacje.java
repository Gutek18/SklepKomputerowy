import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Operacje {

    protected static void opcjeWyboru() {
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

    protected static Komputer dodajNowySprzetDoMagazynu(Magazyn magazyn) {
        String procesor = odczytajDane("model procesora");
        double procesorTaktowanie = odczytajWartoscLiczbowa("taktowanie procesora [GHz]");
        double ram = odczytajWartoscLiczbowa("ilość Ram [Gb]");
        double ramTaktowanie = odczytajWartoscLiczbowa("taktowanie ram [GHz]");
        Komputer komputer = new Komputer(procesor, procesorTaktowanie, ram, ramTaktowanie);
        magazyn.dodajElementDoSklepu(komputer);
        return komputer;
    }

    protected static void sprzedajKomputer(Magazyn magazyn) {
        System.out.println("Podaj lp. komputera który checesz usunąć " + magazyn.elementy.keySet());
        int liczba = magazyn.elementy.size();
        Set<Integer> tab = magazyn.elementy.keySet();
        if (liczba <= 0) {
            System.out.println("Nie ma komputerów na sprzedaż!");
        } else {
            int value = getValue(magazyn);
            if (tab.contains(value)) {
                magazyn.sprzedajKomputer(value);
            } else {
                System.out.println("Nie ma takiego komputera na sprzedaż!");
            }
        }
    }

    protected static void obliczMoc(Magazyn magazyn) {
        Set<Integer> tab = magazyn.elementy.keySet();
        int liczba = magazyn.elementy.size();
        int value = 0;
        if (liczba <= 0) {
            System.out.println("Nie ma żadnych komputerów do obliczenia mocy");
        } else {
            System.out.println("Podaj lp. komputera którego checesz obliczyć moc");
            try {
                value = getValue(magazyn);
            } catch (NullPointerException e) {
                System.out.println("To nie jest liczba!");
            } catch (InputMismatchException ex) {
                System.out.println("To nie jest liczba!");
            }
            if (tab.contains(value)) {
                magazyn.mocOperacyjnaKomputera(value);
            }
        }
    }

    protected static int getValue(Magazyn magazyn) {
        magazyn.listaSprzetu();
        Scanner wpisz = new Scanner(System.in);
        int value = 0;
        boolean sprawdz;
        do {
            sprawdz = false;
            try {
                value = wpisz.nextInt();
                int rozmiar = Magazyn.rozmiarMapy;
                if (rozmiar <= value || value >= rozmiar || value < 1) {
                    System.out.println("Nieprawidłowa wartość! Wybierz komputer z listy");
                    sprawdz = false;
                } else {
                    sprawdz = true;
                }
            } catch (NullPointerException ex) {
                System.out.println("Nieprawidłowa wartość!");
            }
        } while (!sprawdz);
        return value;
    }

    protected static double odczytajWartoscLiczbowa(String nazwaParametru) {
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

    protected static String odczytajDane(String nazwaParametru) {
        Scanner wpisz = new Scanner(System.in);
        System.out.print("Wpisz " + nazwaParametru + ":");
        String nazwa = wpisz.next();
        return nazwa;
    }
}

