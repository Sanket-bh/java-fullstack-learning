import java.util.Scanner;

public class vehicle {

    private int noOfWheels;
    private int speed;
    private String fuelType;
    private String engineType;
    private int modelYear;



    public vehicle(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public vehicle(int noOfWheels, int speed, String fuelType, String engineType, int modelYear) {
        this.noOfWheels = noOfWheels;
        this.speed = speed;
        this.fuelType = fuelType;
        this.engineType = engineType;
        this.modelYear=modelYear;
    }

    public void setSpeed(int speed) {
        this.speed = speed;

    }
    public int getSpeed() {
        return speed;
    }
}

