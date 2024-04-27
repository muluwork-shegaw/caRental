package cs489.project.carrental.DTO;


import lombok.Data;

@Data
public class CustomerDto {
    private String fName;
    private String lName;
    private String email;
    private String phoneNumber;
    private String dob;
    private String driverLicenceId;
    private BadgeDto badge;
}

