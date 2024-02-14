package entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    public Integer totalSlots;

    public List<ParkingSlot> parkingSlots;

    public ParkingLot(String inputSlots){
        Integer totalSl=Integer.parseInt(inputSlots);
        this.totalSlots=totalSl;
        parkingSlots=new ArrayList<>(totalSlots);
        for(int i=1;i<=totalSlots;i++){
            ParkingSlot parkingSlot = new ParkingSlot(i);
            parkingSlots.add(parkingSlot);
        }
        
    }
    
    public Integer parkingCar(Car car){

        for (ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.getCar()!=null){
                if(parkingSlot.getCar().getRegistartionNumber().equals(car.getRegistartionNumber())){
                    return -2;
                }
                
            }
        }
        for(ParkingSlot parkingSlot: parkingSlots){
            if(parkingSlot.getCar()==null){
                Integer parkedSlotNumber=parkingSlot.setCar(car);
                return parkedSlotNumber;
            }
        }
        return -1;
    }

    public Integer leaveParking(Integer inputSlotNumber){
        for(ParkingSlot parkingSlot: parkingSlots){
            if(parkingSlot.getSlotNumber().equals(inputSlotNumber) && parkingSlot.getCar()!=null){
                parkingSlot.setCar(null);
                return inputSlotNumber;
            }
            else if(parkingSlot.getSlotNumber().equals(inputSlotNumber) && parkingSlot.getCar()==null){
                return -2;
            }
            else{
                continue;
            }
        }
        return -1;
    }

    public void getStatus(){
        System.out.println("SlotNo RegistrationNo Color");
        for(ParkingSlot parkingSLot: parkingSlots){
            if(parkingSLot.getCar()!=null){
                System.out.println(parkingSLot.getSlotNumber() + " " + parkingSLot.getCar().getRegistartionNumber() + " " + parkingSLot.getCar().getColour());
            }
        }
    }

    public Integer getSlotNumberWithRegistrationNo(String registrationNumber){
        for(ParkingSlot parkingSlot: parkingSlots){
            Car car = parkingSlot.getCar();
            if(car!=null){
                String carRegistrationNumber= car.getRegistartionNumber();
                if(carRegistrationNumber.equals(registrationNumber)){
                    return parkingSlot.getSlotNumber();
                }
            }
        }
        return -1;
    }

    public List<Integer> getSlotNumberWithColor(String color){
        List<Integer> slotNumbers= new ArrayList<>();
        for(ParkingSlot parkingSlot: parkingSlots){
            Car car = parkingSlot.getCar();
            if(car!=null){
                String carColor= car.getColour();
                if(carColor.equals(color)){
                    slotNumbers.add(parkingSlot.getSlotNumber());
                }
            }
        }
        return slotNumbers;
    }

    public List<String> getRegistationNoWithColor(String color){
        List<String> registrationNumbers= new ArrayList<>();
        for(ParkingSlot parkingSlot: parkingSlots){
            Car car = parkingSlot.getCar();
            if(car!=null){
                String carColor= car.getColour();
                if(carColor.equals(color)){
                    registrationNumbers.add(car.getRegistartionNumber());
                }
        }
        }
        return registrationNumbers;
    }
}
