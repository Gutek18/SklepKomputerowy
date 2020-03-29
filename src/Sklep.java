import java.util.Scanner;

public class Sklep {

    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn();
        String operacja;

        do {
            System.out.println("Co chcesz zrobić?\n" +
                    "(D)odaj sprzęt\n" +
                    "(L)ista sprzęt\n" +
                    "(O)blicz moc\n" +
                    "(S)przedaj komputer\n" +
                    "(W)yjdż");
            operacja = odczytajDane("operację");
            if ("d".equalsIgnoreCase(operacja)) {
                dodajNowySprzetDoMagazynu(magazyn);
            } else if ("l".equalsIgnoreCase(operacja)) {
                magazyn.listaSprzetu();
            } else if ("o".equalsIgnoreCase(operacja)) {
                System.out.println("Podaj lp. komputera którego checesz obliczyć moc");
                int value = odczytajWartosc();
                magazyn.mocOperacyjnaKomputera(value);
            } else if ("s".equalsIgnoreCase(operacja)) {
                System.out.println("Podaj lp. komputera który checesz usunąć");
                int value = odczytajWartosc();
                magazyn.sprzedajKomputer(value);
            }
        } while (!"w".equalsIgnoreCase(operacja));
    }

    private static Komputer dodajNowySprzetDoMagazynu(Magazyn magazyn) {
        String procesor = odczytajDane("model procesora");
        String procesorTaktowanie = odczytajDane("taktowanie procesora [GHz]");
        String ram = odczytajDane("ilość Ram [Gb]");
        String ramTaktowanie = odczytajDane("taktowanie ram [GHz]");
        Komputer komputer = new Komputer(procesor, Double.valueOf(procesorTaktowanie), Double.valueOf(ram), Double.valueOf(ramTaktowanie));
        magazyn.dodajElementDoSklepu(komputer);
        return komputer;
    }

    private static int odczytajWartosc() {
        Scanner wpisz = new Scanner(System.in);
        int wartosc = wpisz.nextInt();
        return wartosc;
    }

    private static String odczytajDane(String nazwaParametru) {
        Scanner wpisz = new Scanner(System.in);
        System.out.println("Wpisz " + nazwaParametru + ":");
        String nazwa = wpisz.nextLine();
        return nazwa;
    }

}