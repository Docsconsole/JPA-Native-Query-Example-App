package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "player")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Player-query",
                query = "SELECT player.* FROM PLAYER AS player WHERE player.ID = ?",
                resultClass = Player.class
        )
})
public class Player implements Serializable {

    private static final long serialVersionUID = 88889999998L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "game")
    private String game;
    @Column(name = "age")
    private Long age;
    @Column(name = "salary_income")
    private Long salaryIncome;

}
