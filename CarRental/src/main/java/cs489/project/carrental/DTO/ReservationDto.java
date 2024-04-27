package cs489.project.carrental.DTO;


import lombok.Data;

@Data
public class ReservationDto {
    private float price;
    private String dateTimeStart;
    private String dateTimeEnd;
    private String reservationStatus;
}

