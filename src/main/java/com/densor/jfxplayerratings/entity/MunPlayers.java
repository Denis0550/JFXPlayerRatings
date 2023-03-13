package com.densor.jfxplayerratings.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "mu_players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MunPlayers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player", nullable = false)
    private Long id;

    @Column(name = "sq_number")
    private int sqNumber;

    @Column(name = "position")
    private String position;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nationality")
    private String nationality;

}
