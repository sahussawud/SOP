package Car_Service;

import java.util.ArrayList;

public class Car {
    private static ArrayList<Car> CarList = new ArrayList<Car>();
    private String color;
    private String type;
    private int displacement;
    private boolean sunroof;
    private int speed;

    public static ArrayList<Car> getCarsInstance() {
        if (CarList.isEmpty()) {
            CarList = new ArrayList<Car>();
        }
        return CarList;
    }

    public int getSpeed() {
        return speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void hasSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
