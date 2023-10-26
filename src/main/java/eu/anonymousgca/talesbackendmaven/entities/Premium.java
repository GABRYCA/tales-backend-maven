package eu.anonymousgca.talesbackendmaven.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class Premium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "premiumId", nullable = false)
    private Integer id;

    @Column(name = "isPremium")
    private Boolean isPremium;

    @Size(max = 255)
    @Column(name = "subscriptionType")
    private String subscriptionType;

    @Column(name = "subscriptionDate")
    private Instant subscriptionDate;

    @Column(name = "expiryDate")
    private Instant expiryDate;

}