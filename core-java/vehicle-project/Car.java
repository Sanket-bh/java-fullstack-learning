import java.util.Scanner;

public class Car extends vehicle{
    Scanner sc=new Scanner(System.in);
    public void createCar(){
        System.out.println("Want to Create Car: \n1. Yes\n2.No");
        int a=sc.nextInt();

        if(a==1){
            System.out.println("Enter no. of Wheels: ");
            int b=sc.nextInt();
            System.out.println("Enter the Speed: ");
            int c=sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Fuel type: ");
            String d=sc.nextLine();
            System.out.println("Enter Engine type: ");
            String e=sc.nextLine();
            System.out.println("Enter Model year: ");
            int f=sc.nextInt();
        }
        else {
            return;
        }
    }


    public Car(int noOfWheels, int speed, String fuelType, String engineType,int modelYear) {
        super(noOfWheels, speed, fuelType, engineType,modelYear);
    }


    public void Start(){
        System.out.println("Vehicle Started");
    }




}
