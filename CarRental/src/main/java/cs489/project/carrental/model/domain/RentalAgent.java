package cs489.project.carrental.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class RentalAgent extends User {

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;


}
