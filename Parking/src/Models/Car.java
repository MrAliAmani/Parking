package Models;

import Utility.Constants;
import Utility.Utilities;

public class Car extends Vehicle {

    int id;

    public Car(int id) {
        super(id);
        this.entrancePrice = Constants.CAR_ENTRANCE_PRICE;
        this.hourPrice = Constants.CAR_HOUR_PRICE;
    }

    @Override
    public String getCost() {
        int cost = Utilities.convertToInteger(this.entrancePrice)
                + Utilities.convertToInteger(this.hourPrice)*(this.exitHour - this.entryHour);
        return String.valueOf(cost);
    }

}
