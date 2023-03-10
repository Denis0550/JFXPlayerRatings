package com.densor.jfxplayerratings.entity;


import javax.persistence.*;

@Entity
@Table(name = "mu_players")
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

    public MunPlayers() {
    }

    public MunPlayers(Long id, int sqNumber, String position, String firstName, String lastName, String nationality) {
        this.id = id;
        this.sqNumber = sqNumber;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSqNumber() {
        return sqNumber;
    }

    public void setSqNumber(int sqNumber) {
        this.sqNumber = sqNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
