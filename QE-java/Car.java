package com.example;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car(){
        tyres=4;
        doors=4;
    }
    public void displayCharcteristics(){
        System.out.println("Make: "+ make);
        System.out.println("Color: "+ color);
        System.out.println("Transmission: "+ transmission);

    }
    public void accelerate(){
        System.out.println("Car is moving forward");
    }
    public void brake(){
        System.out.println("Car has stopped.");
    }
public static void main(String[] args){
    Car carname=new Car();
    carname.make=2014;
    carname.color="Black";
    carname.transmission="Manual";
    
    carname.displayCharcteristics();
    carname.accelerate();
    carname.brake();

}
}
