/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package check;

/**
 *
 * @author ADMIN
 */
public class Car {
    String colour; 
    int EnginePower; 
    boolean Convertible;
    boolean ParkingBrake;

    public Car() {
    }

    public Car(String colour, int EnginePower, boolean Convertible, boolean ParkingBrake) {
        this.colour = colour;
        this.EnginePower = EnginePower;
        this.Convertible = Convertible;
        this.ParkingBrake = ParkingBrake;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getEnginePower() {
        return EnginePower;
    }

    public void setEnginePower(int EnginePower) {
        this.EnginePower = EnginePower;
    }

    public boolean isConvertible() {
        return Convertible;
    }

    public void setConvertible(boolean Convertible) {
        this.Convertible = Convertible;
    }

    public boolean isParkingBrake() {
        return ParkingBrake;
    }

    public void setParkingBrake(boolean ParkingBrake) {
        this.ParkingBrake = ParkingBrake;
    }
    public void pressStartButton(){
        System.out.println("You have pressed the start button”");
    }
    public void pressAcceleratorButton(){
        System.out.println("You have pressed the Accelerator button”");
    }

    @Override
    public String toString() {
        return "Car{" + "colour=" + colour + ", EnginePower=" + EnginePower + ", Convertible=" + Convertible + ", ParkingBrake=" + ParkingBrake + '}';
    }
    
    public void output(){
        System.out.println(toString());
    }
}
