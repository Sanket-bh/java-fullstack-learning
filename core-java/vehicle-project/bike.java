public class bike extends vehicle {
    String startType;
    int modelYear;
    public bike(int noOfWheels, int speed, String fuelType, String engineType,int modelYear) {
        super(noOfWheels, speed, fuelType, engineType,modelYear);
    }

    public void Start(){
        if(modelYear<2015){
            System.out.println("Bike kick Started");
        }
        else{
            System.out.println("Bike Self-Start");
        }

    }
}
