package com.densor.jfxplayerratings.entity;


import javax.persistence.*;

@Entity
@Table(name = "pl_ratings_one")
public class PlayerRatings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "game_week")
    private int gameWeek;

    @Column(name = "sq_number")
    private int squadNumber;

    @Column(name = "rating")
    private int playerRating;

    public PlayerRatings() {
    }

    public PlayerRatings(Long id, int gameWeek, int squadNumber, int playerRating) {
        this.id = id;
        this.gameWeek = gameWeek;
        this.squadNumber = squadNumber;
        this.playerRating = playerRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameWeek() {
        return gameWeek;
    }

    public void setGameWeek(int gameWeek) {
        this.gameWeek = gameWeek;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public int getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(int playerRating) {
        this.playerRating = playerRating;
    }
}




