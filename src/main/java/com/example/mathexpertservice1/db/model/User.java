package com.example.mathexpertservice1.db.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Table(name = "usr")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @UuidGenerator
    @GeneratedValue
    private UUID id;
    @NotBlank
    private String username;

}
