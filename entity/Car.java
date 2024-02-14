package entity;

public class Car {
    public String registrationNumber;

    public String colour;

    public Car(String registrationNumber,String colour){
        this.registrationNumber=registrationNumber;
        this.colour=colour;
    }

    public String getRegistartionNumber(){
        return registrationNumber;
    }

    public String getColour(){
        return colour;
    }
}
