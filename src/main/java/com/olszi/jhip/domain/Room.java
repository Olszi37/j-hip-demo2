package com.olszi.jhip.domain;

import com.olszi.jhip.enums.BedTypes;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A Room.
 */
@Entity
@Table(name = "room")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "beds")
    @Enumerated(EnumType.STRING)
    private BedTypes beds;

    @Column(name = "description")
    private String description;

    @Column(name = "price", precision=10, scale=2)
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Room name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Room capacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BedTypes getBeds() {
        return beds;
    }

    public Room beds(BedTypes beds) {
        this.beds = beds;
        return this;
    }

    public void setBeds(BedTypes beds) {
        this.beds = beds;
    }

    public String getDescription() {
        return description;
    }

    public Room description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Room price(BigDecimal price) {
        this.price = price;
        return this;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        if (room.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), room.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Room{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", beds='" + getBeds() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
}
