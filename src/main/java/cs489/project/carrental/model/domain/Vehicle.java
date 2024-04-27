package cs489.project.carrental.model.domain;

import cs489.project.carrental.model.domain.Car;
import cs489.project.carrental.model.helperClass.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long vehicleID;
    private  String make;
    private  String model;
    private String picture;
    private String vehicleType;
    private int seatNum;

    @OneToMany(mappedBy = "vehicle")
    private List<Car> cars;

    @Column(
            name = "created_at",
            nullable = false
    )
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(
            name = "updated_at",
            nullable = false
    )
    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
