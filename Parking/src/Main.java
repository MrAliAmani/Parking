import Utility.Constants;
import Utility.Operation;
import Utility.VehicleType;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ParkingManager parkingManager = new ParkingManager();

        String userOption;
        do {

            boolean isReturn;
            boolean isHourValid;

            displayOptions();
            userOption = getUserOption();

            if(userOption.equals(Operation.ADD.getOperationType())) {

                displayAddMenu();
                userOption = getUserOption();

                isReturn = isReturnToMenu(userOption);
                if(isReturn) {
                    displayWrongOptionMessage();
                    continue;
                }

                if(userOption.equals(VehicleType.CAR.getVehicleType())) {

                    System.out.println("Please enter entry hour : ");
                    int entryHour = getHour();
                    isHourValid = isValidHour(entryHour);
                    if (!isHourValid){
                        System.out.println("Entry hour is not valid!");
                        continue;
                    }

                    parkingManager.add(VehicleType.CAR, entryHour);

                } else if(userOption.equals(VehicleType.BIKE.getVehicleType())) {

                    System.out.println("Please enter entry hour : ");
                    int entryHour = getHour();
                    isHourValid = isValidHour(entryHour);
                    if (!isHourValid){
                        System.out.println("Entry hour is not valid!");
                        continue;
                    }

                    parkingManager.add(VehicleType.BIKE, entryHour);

                } else {

                    displayWrongOptionMessage();

                }

            } else if(userOption.equals(Operation.REMOVE.getOperationType())) {

                displayRemoveMenu();
                userOption = getUserOption();

                isReturn = isReturnToMenu(userOption);
                if(isReturn) {
                    displayWrongOptionMessage();
                    continue;
                }

                if(userOption.equals(VehicleType.CAR.getVehicleType())) {

                    int id = getId();
                    if(!parkingManager.contains(id)){
                        System.out.println("There is no such car!");
                        continue;
                    }

                    System.out.println("Please enter exit hour : ");
                    int exitHour = getHour();
                    if(!isValidHour(exitHour)){
                        System.out.println("Entry hour is not valid!");
                        continue;
                    }

                    parkingManager.remove(VehicleType.CAR, id, exitHour);

                } else if(userOption.equals(VehicleType.BIKE.getVehicleType())) {

                    int id = getId();
                    if(!parkingManager.contains(id)){
                        System.out.println("There is no such bike!");
                        continue;
                    }

                    System.out.println("Please enter exit hour : ");
                    int exitHour = getHour();
                    if(!isValidHour(exitHour)){
                        System.out.println("Entry hour is not valid!");
                        continue;
                    }

                    parkingManager.remove(VehicleType.BIKE, id, exitHour);

                } else {

                    displayWrongOptionMessage();

                }

            } else if(userOption.equals(Operation.QUIT.getOperationType())) {

                return ;

            } else {

                displayWrongOptionMessage();

            }

        } while (userOption != "q");
    }

    public static String getUserOption() {

        String userOption;
        Scanner userInput = new Scanner(System.in);
        userOption = userInput.next();

        return userOption;
    }

    private static boolean isReturnToMenu(String userOption) {

        return !(userOption.equals(String.valueOf(VehicleType.CAR.getVehicleType()))
                || userOption.equals(String.valueOf(VehicleType.BIKE.getVehicleType())));

    }

    private static int getHour() {

        int hour;

        Scanner userInput = new Scanner(System.in);
        hour = userInput.nextInt();

        return hour;

    }

    public static int getId() {

        int id;

        System.out.println("Please enter your vehicle number : ");
        Scanner userInput = new Scanner(System.in);
        id = userInput.nextInt();

        return id;

    }

    public static boolean isValidHour(int hour) {
        return (hour <= 24 && hour >= 0);
    }

    public static void displayOptions() {

        displayStars();
        System.out.println("Parking system program");
        displayStars();
        System.out.println("1." + Constants.ADD_VEHICLE);
        System.out.println("2." + Constants.REMOVE_VEHICLE);
        System.out.println("q.Quit");

    }

    public static void displayAddMenu() {

        displayStars();
        System.out.println(Constants.ADD_VEHICLE);
        displayStars();
        displayVehicleTypes();

    }

    public static void displayRemoveMenu() {

        displayStars();
        System.out.println(Constants.REMOVE_VEHICLE);
        displayStars();
        displayVehicleTypes();

    }

    public static void displayVehicleTypes() {

        System.out.println(VehicleType.CAR.getVehicleType() + "." + VehicleType.CAR);
        System.out.println(VehicleType.BIKE.getVehicleType() + "." + VehicleType.BIKE);

    }

    public static void displayStars() {

        for(int i = 0; i <= 25; i++)
            System.out.print("*");
        System.out.println();

    }

    public static void displayWrongOptionMessage() {

        System.out.println("You Selected the wrong option!");

    }

}
