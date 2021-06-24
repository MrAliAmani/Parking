package Models;

import Utility.Constants;
import Utility.Utilities;

public class Bike extends Vehicle {

    int id;

    public Bike(int id) {
        super(id);
        this.entrancePrice = Constants.BIKE_ENTRANCE_PRICE;
        this.hourPrice = Constants.BIKE_HOUR_PRICE;
    }

    @Override
    public String getCost() {
        int cost = Utilities.convertToInteger(this.entrancePrice)
                + Utilities.convertToInteger(this.hourPrice)*(this.exitHour - this.entryHour);
        return String.valueOf(cost);
    }

}
