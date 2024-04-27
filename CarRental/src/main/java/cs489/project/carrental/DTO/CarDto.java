package cs489.project.carrental.DTO;




import lombok.Data;

@Data
public class CarDto {
    private int year;
    private String licensePlate;
    private float rentalRate;
    private String availabilityStatus;
    private float startPrice;
    private String registrationId;
    private String insuranceExpDate;
}



