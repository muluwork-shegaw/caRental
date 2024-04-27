package cs489.project.carrental.DTO;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VehicleDto {
    private String make;
    private String model;
    private String picture;
    private String vehicleType;
    private int seatNum;
}

