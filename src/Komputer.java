public class Komputer {

    String procesor;
    double procesorCzestotliwosc;
    double ram;
    double ramTaktowanie;

    public Komputer(String procesor, double procesorCzestotliwosc, double ram, double ramTaktowanie) {
        this.procesor = procesor;
        this.procesorCzestotliwosc = procesorCzestotliwosc;
        this.ram= ram;
        this.ramTaktowanie = ramTaktowanie;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public double getProcesorCzestotliwosc() {
        return procesorCzestotliwosc;
    }

    public void setProcesorCzestotliwosc(double procesorCzestotliwosc) {
        this.procesorCzestotliwosc = procesorCzestotliwosc;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getRamTaktowanie() {
        return ramTaktowanie;
    }

    public void setRamTaktowanie(double ramTaktowanie) {
        this.ramTaktowanie = ramTaktowanie;
    }

    @Override
    public String toString() {
        return "Komputer{" +
                "procesor='" + procesor + '\'' +
                ", procesorCzestotliwosc=" + procesorCzestotliwosc +
                ", ram=" + ram +
                ", ramTaktowanie=" + ramTaktowanie +
                '}';
    }
}
