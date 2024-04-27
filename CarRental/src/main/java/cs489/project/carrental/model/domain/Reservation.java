package cs489.project.carrental.model.domain;

import cs489.project.carrental.model.helperClass.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationID;
    private float price;
    @NotNull
    private LocalDateTime dateTimeStart;
    @NotNull
    private LocalDateTime dateTimeEnd;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;


    @ManyToOne
    @JoinColumn(name = "pickupLocation_id")
    @NotNull
    private Branch pickupLocation;

    @ManyToOne
    @JoinColumn(name = "dropOffLocation_id")
    @NotNull
    private Branch dropOffLocation;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToOne(mappedBy = "reservation")
    private Bill bill;

    @OneToOne(mappedBy = "reservation")
    private Feedback feedback;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;

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
