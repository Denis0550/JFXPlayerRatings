package com.densor.jfxplayerratings.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "pl_ratings_one")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "game_week")
    private int gameWeek;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "rating")
    private int playerRating;

}




