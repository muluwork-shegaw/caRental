package cs489.project.carrental.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long badgeId;

    private String badgeName;

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
