//package cs489.project.carrental.model.domain;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//public class Review {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long reviewId;
//
//    private int rate;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Car car;
//
//    private String comment;
//
//    @Column(
//            name = "created_at",
//            nullable = false
//    )
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @Column(
//            name = "updated_at",
//            nullable = false
//    )
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//
//}
