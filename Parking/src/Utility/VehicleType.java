package Utility;

public enum VehicleType {

    CAR("1"), BIKE("2");

    String carType;

    VehicleType(String carType) {
        this.carType = carType;
    }

    public String getVehicleType() {
        return carType;
    }
}
