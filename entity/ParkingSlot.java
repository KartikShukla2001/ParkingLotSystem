package entity;

public class ParkingSlot {
    public Integer slotNumber;

    public Car car;

    ParkingSlot(Integer slotNumber){
        this.slotNumber=slotNumber;
        this.car=null;
    }

    public Integer getSlotNumber(){
        return slotNumber;
    }

    public Car getCar(){
        return car;
    }

    public Integer setCar(Car car){
        this.car=car;
        return slotNumber;
    }

    
}
