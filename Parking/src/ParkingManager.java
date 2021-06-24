import Models.Bike;
import Models.Car;
import Models.Vehicle;
import Utility.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingManager {

    List<Vehicle> vehicles = new ArrayList<>();

    public void add(VehicleType vehicleType, int entryHour) {

        int index  = vehicles.size();

        if(vehicleType.equals(VehicleType.CAR)) {

            Car car = new Car(index);
            car.setEntryHour(entryHour);
            vehicles.add(car);
            System.out.println("Your car number is => " + index);

        } else if (vehicleType.equals(VehicleType.BIKE)) {


            Bike bike = new Bike(index);
            bike.setEntryHour(entryHour);
            vehicles.add(bike);
            System.out.println("Your bike number is => " + index);

        }

    }

    public void remove(VehicleType vehicleType, int id, int exitHour) {

        if(vehicleType.equals(VehicleType.CAR)) {

            Car car = (Car) vehicles.get(id);
            car.setExitHour(exitHour);
            displayReceiptOfCar(car);

        } else if (vehicleType.equals(VehicleType.BIKE)) {

            Bike bike = (Bike) vehicles.get(id);
            bike.setExitHour(exitHour);
            displayReceiptOfBike(bike);

        }

    }

    public boolean contains(int id) {
        boolean isContained = false;

        try{
            isContained = vehicles.get(id) != null;
        } catch(Exception exception) {
            System.out.println(" Id not found : " + exception.getMessage());
        }

        return isContained;
    }

    private void displayReceiptOfCar(Car car) {

        displayHeader();
        System.out.println("Entry Hour : " + car.getEntryHour());
        System.out.println("Exit Hour : " + car.getExitHour());
        System.out.println("Total Price : " + car.getCost());

    }

    private void displayReceiptOfBike(Bike bike) {

        displayHeader();
        System.out.println("Entry Hour : " + bike.getEntryHour());
        System.out.println("Exit Hour : " + bike.getExitHour());
        System.out.println("Total Price : " + bike.getCost());

    }

    private void displayHeader() {

        displayStars();
        System.out.println("BILL");
        displayStars();

    }

    static void displayStars() {

        for(int i = 0; i <= 25; i++)
            System.out.print("*");
        System.out.println();

    }

}
