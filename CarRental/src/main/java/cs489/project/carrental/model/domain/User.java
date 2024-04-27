package cs489.project.carrental.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fName;
    private String lName;
    private String phoneNumber;
    @ManyToOne
    private Address address;

    @Column(
            name = "email",
            unique = true,
            nullable = false
    )
    private String email;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;


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
    private Boolean deleted = Boolean.FALSE;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();


    public void addRole(Role role) {
        roles.add(role);
    }

}
