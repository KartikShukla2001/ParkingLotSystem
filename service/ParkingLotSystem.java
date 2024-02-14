package service;
import java.util.*;
import java.util.logging.Logger;

import javax.rmi.CORBA.Util;

import entity.Car;
import entity.ParkingLot;

public class ParkingLotSystem {
    
    public void parkingLotCommands(){
        Scanner scanner = new Scanner(System.in);

        ParkingLot parkingLot = null;

        while (true) {

            System.out.println("Plese enter $ help to see all available commands");

            String command = scanner.nextLine().trim();

            String[] commands = command.split(" ");

            if(!commands[0].equals("$")){
                System.out.println("Please enter '$ ' before the command");
            }


            if(commands[1].equals("help")){
                System.out.println("$ create_parking_lot {input for no of lots required as integer}");
                System.out.println("$ park {input registration number} {input for colour of car}");
                System.out.println("$ leave {Input for slot number as an integer}");
                System.out.println("$ exit");
                System.out.println("$ status");
                System.out.println("$ registration_numbers_for_cars_with_colour {input for color}");
                System.out.println("$ slot_numbers_for_cars_with_colour {input for color}");
                System.out.println("$ slot_number_for_registration_number {input for registration number}");
            }
            else if(commands[1].equals("create_parking_lot")){
                if(commands[2].isEmpty()){
                    System.out.println("Incorrect Input please provide size of parking lot");

                }
                else{
                    parkingLot = new ParkingLot(commands[2]);
                    System.out.println("Created Parking Lot with " + commands[2] + " slots");
                }
            }
            else if(commands[1].equals("park")){
                if(parkingLot!=null){
                    String registrationNumber=commands[2];
                    String colour=commands[3];
                    Car car = new Car(registrationNumber,colour);

                    Integer parkedSlotNumber=parkingLot.parkingCar(car);

                    if(parkedSlotNumber==-1){
                        System.out.println("Parking lot is full");
                    }
                    else if(parkedSlotNumber==-2){
                        System.out.println("Car with registration no " + registrationNumber + " is already parked");
                    }
                    else{
                        System.out.println("Car is Parked at slot number " + parkedSlotNumber);
                    }
                }
                else{
                    System.out.println("Please Create a parking lot first, using the command create_parking_lot");
                }
            }
            else if(commands[1].equals("leave")){
                if(parkingLot!=null){
                    try{
                        Integer slotNumber = Integer.parseInt(commands[2]);
                        Integer leave = parkingLot.leaveParking(slotNumber);
                        if(leave==-1){
                            System.out.println("Invalid Slot Number");
                        } 
                        else if(leave==-2){
                            System.out.println("Parking Slot is already empty");
                        }
                        else{
                            System.out.println("Slot Number " + leave + " is now available");
                        }
                        }
                    catch (NumberFormatException ex){
                        System.out.println("Please provide Integer for slot Number");
                    }
                }
                 else{
                    System.out.println("Please create a parking lot");
                }           
            }
            else if(commands[1].equals("status")){
                if(parkingLot!=null){
                    parkingLot.getStatus();
                }
                else{
                    System.out.println("Please create a parking lot");
                }
            }
            else if(commands[1].equals("registration_numbers_for_cars_with_colour")){
                if(parkingLot!=null){
                    String color = commands[2];
                    List<String> registrationNumbers = parkingLot.getRegistationNoWithColor(color);

                    if(registrationNumbers.size()==0){
                        System.out.println("No car of color " + color + "is parked");
                    }
                    else{
                        int counter=0;
                        for(String a: registrationNumbers){
                            counter++;
                            if(counter==registrationNumbers.size()){
                                System.out.println(a);
                            }
                            else{
                                System.out.println(a + ",");
                            }
                        }
                    }
                }
                else{
                    System.out.println("Please create a parking lot");
                }

            }
            else if(commands[1].equals("slot_number_for_registration_number")){
                
                if(parkingLot!=null){
                    String registrationNumber = commands[2];
                    Integer slotNo = parkingLot.getSlotNumberWithRegistrationNo(registrationNumber);

                    if(slotNo==-1){
                        System.out.println("Invald Slot Number");
                    }
                    else{
                        System.out.println("1");
                    }
                }
                else{
                    System.out.println("Please create a paring lot");
                }
            }
            else if(commands[1].equals("slot_numbers_for_cars_with_colour")){
                if(parkingLot!=null){
                    String color = commands[2];
                    List<Integer> slotNumbers = parkingLot.getSlotNumberWithColor(color);

                    if(slotNumbers.size()==0){
                        System.out.println("No car of color " + color + "is parked");
                    }
                    else{
                        int counter=0;
                        for(Integer a: slotNumbers){
                            counter++;
                            if(counter==slotNumbers.size()){
                                System.out.println(a);
                            }
                            else{
                                System.out.println(a + ",");
                            }
                        }
                    }
                }
                else{
                    System.out.println("Please Create a Parking lot");
                }
            }
            else if(commands[1].equals("exit")){
                System.exit(0);
                break;
            }
            else{
                System.out.println("Invalid Command");
            }   
            
        }


    }
}
