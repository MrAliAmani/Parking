package Models;

public abstract class Vehicle {

    int id;
    int entryHour;
    int exitHour;
    String entrancePrice;
    String hourPrice;

    Vehicle(int id) {
        this.id = id;
    }

    public abstract String getCost();

    public void setEntryHour(int entryHour) {
        this.entryHour = entryHour;
    }

    public int getEntryHour() {
        return entryHour;
    }

    public void setExitHour(int exitHour) {
        this.exitHour = exitHour;
    }

    public int getExitHour() {
        return exitHour;
    }

}
