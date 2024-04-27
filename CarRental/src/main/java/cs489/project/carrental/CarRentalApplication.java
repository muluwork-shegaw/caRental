package cs489.project.carrental;

import cs489.project.carrental.service.VehicleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CarRentalApplication implements CommandLineRunner {
    private VehicleService vehicleService;

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password1 = "password123";
        String hashedPassword1 = encoder.encode(password1);

        String password2 = "p@ssw0rd";
        String hashedPassword2 = encoder.encode(password2);

        // Print out the hashed passwords
        System.out.println("Hashed Password 1: " + hashedPassword1);
        System.out.println("Hashed Password 2: " + hashedPassword2);
    }

//    @Override
//    public void run(String... args) throws Exception {
////        List<VehicleDto> vehicles = createSampleVehicles();
//        VehicleDto vehicle1 = new VehicleDto();
//        vehicle1.setMake("Toyota");
//        vehicle1.setModel("Camry");
//        vehicle1.setVehicleType("Sedan");
//        vehicle1.setSeatNum(5);
//        vehicle1.setPicture("lkjhgfdfcgv");
//        // Set other vehicle properties
//        // Save sample vehicles to the database
//        vehicleService.saveVehicle(vehicle1);
//    }
//
//    private List<VehicleDto> createSampleVehicles() {
//        List<VehicleDto> vehicles = new ArrayList<>();
//
//        // Create sample vehicles
//        VehicleDto vehicle1 = new VehicleDto();
//        vehicle1.setMake("Toyota");
//        vehicle1.setModel("Camry");
//        vehicle1.setVehicleType("Sedan");
//        vehicle1.setSeatNum(5);
//        vehicle1.setPicture("lkjhgfdfcgv");
//        // Set other vehicle properties
//
//        VehicleDto vehicle2 = new VehicleDto();
//        vehicle2.setMake("Honda");
//        vehicle2.setModel("Accord");
//        vehicle2.setVehicleType("Sedan");
//        vehicle2.setSeatNum(5);
//        vehicle2.setPicture("lkjhgfdfcgv");
//
//        // Set other vehicle properties
//
//        // Add vehicles to the list
//        vehicles.add(vehicle1);
//        vehicles.add(vehicle2);
//
//        return vehicles;
//    }
}
