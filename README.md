# Parking Lot System

This is a simple parking lot system implemented in Java. It allows you to create a parking lot, park cars, leave slots, and perform various queries.

## Installation and Setup

1. Clone the repository to your local machine:
2. Install Java preferrably java ver 1.8.
3. Run the file Main.java to open cmd shell.

Once the program is running, you can interact with it using the following commands:

- `$ create_parking_lot {input for no of lots required as integer}`: Creates a parking lot with the the required no of slots.
- `$ park {input registration number} {input for colour of car}`: Park the slots in the first slot available.
- `$ leave {Input for slot number as an integer}`: Will free the desired slot.
- `$ exit`: To exit the cmd shell.
- `$ status`: Will give the current status of parking i.e which slot has car parked in it with color and registration number.
- `$registration_numbers_for_cars_with_colour {input for color}`: Will give the registration number of cars with the input color.
- `$slot_numbers_for_cars_with_colour {input for color}`: Will give the slot number of cars with the input color.
- `$slot_number_for_registration_number {input for registration number}`: Will give the slot number of cars with the input registration number.
  
