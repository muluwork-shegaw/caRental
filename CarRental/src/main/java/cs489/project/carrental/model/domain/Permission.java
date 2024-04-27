package cs489.project.carrental.model.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(
            name = "name",
            unique = true,
            nullable = false
    )
    private String name;

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

    @Column(
            name = "deleted",
            nullable = false,
            columnDefinition = "boolean default false"
    )
    private Boolean deleted = false;


    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles;
}
