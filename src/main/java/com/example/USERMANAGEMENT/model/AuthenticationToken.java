package com.example.USERMANAGEMENT.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;

    private  String tokenValue;

    private LocalDateTime tokenCreationDate;

    @OneToOne
    @JoinColumn (name= "fk-userId")
    private  User user;



    public AuthenticationToken(User user) {
        this.tokenValue= UUID.randomUUID().toString();
        this.tokenCreationDate = LocalDateTime.now();
        this.user = user;
    }


}
