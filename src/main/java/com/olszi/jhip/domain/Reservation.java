package com.olszi.jhip.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * A Reservation.
 */
@Entity
@Table(name = "reservation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_from")
    private ZonedDateTime date_from;

    @Column(name = "date_to")
    private ZonedDateTime date_to;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDate_from() {
        return date_from;
    }

    public Reservation date_from(ZonedDateTime date_from) {
        this.date_from = date_from;
        return this;
    }

    public void setDate_from(ZonedDateTime date_from) {
        this.date_from = date_from;
    }

    public ZonedDateTime getDate_to() {
        return date_to;
    }

    public Reservation date_to(ZonedDateTime date_to) {
        this.date_to = date_to;
        return this;
    }

    public void setDate_to(ZonedDateTime date_to) {
        this.date_to = date_to;
    }

    public Client getClient() {
        return client;
    }

    public Reservation client(Client client) {
        this.client = client;
        return this;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public Reservation room(Room room) {
        this.room = room;
        return this;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation reservation = (Reservation) o;
        if (reservation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reservation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reservation{" +
            "id=" + getId() +
            ", date_from='" + getDate_from() + "'" +
            ", date_to='" + getDate_to() + "'" +
            "}";
    }
}
