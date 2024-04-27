package cs489.project.carrental.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Customer extends User {


    @Temporal(TemporalType.DATE)
    private Date dob;

    private String driverLicenceId;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @OneToMany(mappedBy = "customer")
    @NotEmpty
    private List<Card> cards;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

}
