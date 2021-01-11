package com.zelenev.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Address")
@Table(
        name = "address",
        schema = "public"
)
public class Address implements Serializable {

    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            schema = "public",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "address_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "card_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "address_to_card_id_fk"
            )
    )
    private Card card;

    @Column(
            name = "country",
            nullable = false,
            length = 100
    )
    private String country;

    @Column(
            name = "city",
            nullable = false,
            length = 100
    )
    private String city;

    @Column(
            name = "street",
            nullable = false,
            length = 100
    )
    private String street;

    @Column(
            name = "building",
            nullable = false
    )
    private Integer building;

    @Column(
            name = "postcode",
            nullable = false,
            length = 11
    )
    private String postcode;

    public Address() {
    }

    public Address(Card card,
                   String country,
                   String city,
                   String street,
                   Integer building,
                   String postcode) {
        this.card = card;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.postcode = postcode;
    }

    public Address(Integer id,
                   Card card,
                   String country,
                   String city,
                   String street,
                   Integer building,
                   String postcode) {
        this.id = id;
        this.card = card;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.postcode = postcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuilding() {
        return building;
    }

    public void setBuilding(Integer building) {
        this.building = building;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) && card.equals(address.card) && country.equals(address.country) && city.equals(address.city) && street.equals(address.street) && building.equals(address.building) && postcode.equals(address.postcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card, country, city, street, building, postcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", card=" + card +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
