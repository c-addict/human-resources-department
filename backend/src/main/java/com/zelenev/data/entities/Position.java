package com.zelenev.data.entities;


import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Position")
@Table(
        name = "position",
        schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_position_title",
                        columnNames = "title"
                )
        }
)
public class Position implements Serializable {

    @Id
    @SequenceGenerator(
            name = "position_sequence",
            sequenceName = "position_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "position_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "title",
            nullable = false,
            length = 100
    )
    private String title;

    @OneToMany(
            mappedBy = "position",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Card> cards;

    public Position() {
    }

    public Position(String title) {
        this.title = title;
    }

    public Position(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return id.equals(position.id) && title.equals(position.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
