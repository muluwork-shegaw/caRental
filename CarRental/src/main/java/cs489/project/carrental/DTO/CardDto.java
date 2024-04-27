package cs489.project.carrental.DTO;


import lombok.Data;

@Data
public class CardDto {
    private String cardType;
    private String cardNumber;
    private Integer cvv;
    private String expirationDate;
}

