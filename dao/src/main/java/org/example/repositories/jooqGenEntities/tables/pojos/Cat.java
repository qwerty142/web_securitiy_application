/*
 * This file is generated by jOOQ.
 */
package org.example.repositories.jooqGenEntities.tables.pojos;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.Nullable;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long catId;
    private LocalDateTime birthDate;
    private String breed;
    private String color;
    private Long ownerId;

    public Cat() {}

    public Cat(Cat value) {
        this.catId = value.catId;
        this.birthDate = value.birthDate;
        this.breed = value.breed;
        this.color = value.color;
        this.ownerId = value.ownerId;
    }

    @ConstructorProperties({ "catId", "birthDate", "breed", "color", "ownerId" })
    public Cat(
        @Nullable Long catId,
        @Nullable LocalDateTime birthDate,
        @Nullable String breed,
        @Nullable String color,
        @Nullable Long ownerId
    ) {
        this.catId = catId;
        this.birthDate = birthDate;
        this.breed = breed;
        this.color = color;
        this.ownerId = ownerId;
    }

    /**
     * Getter for <code>public.cat.cat_id</code>.
     */
    @Nullable
    public Long getCatId() {
        return this.catId;
    }

    /**
     * Setter for <code>public.cat.cat_id</code>.
     */
    public void setCatId(@Nullable Long catId) {
        this.catId = catId;
    }

    /**
     * Getter for <code>public.cat.birth_date</code>.
     */
    @Nullable
    public LocalDateTime getBirthDate() {
        return this.birthDate;
    }

    /**
     * Setter for <code>public.cat.birth_date</code>.
     */
    public void setBirthDate(@Nullable LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Getter for <code>public.cat.breed</code>.
     */
    @Size(max = 255)
    @Nullable
    public String getBreed() {
        return this.breed;
    }

    /**
     * Setter for <code>public.cat.breed</code>.
     */
    public void setBreed(@Nullable String breed) {
        this.breed = breed;
    }

    /**
     * Getter for <code>public.cat.color</code>.
     */
    @Size(max = 255)
    @Nullable
    public String getColor() {
        return this.color;
    }

    /**
     * Setter for <code>public.cat.color</code>.
     */
    public void setColor(@Nullable String color) {
        this.color = color;
    }

    /**
     * Getter for <code>public.cat.owner_id</code>.
     */
    @Nullable
    public Long getOwnerId() {
        return this.ownerId;
    }

    /**
     * Setter for <code>public.cat.owner_id</code>.
     */
    public void setOwnerId(@Nullable Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Cat other = (Cat) obj;
        if (this.catId == null) {
            if (other.catId != null)
                return false;
        }
        else if (!this.catId.equals(other.catId))
            return false;
        if (this.birthDate == null) {
            if (other.birthDate != null)
                return false;
        }
        else if (!this.birthDate.equals(other.birthDate))
            return false;
        if (this.breed == null) {
            if (other.breed != null)
                return false;
        }
        else if (!this.breed.equals(other.breed))
            return false;
        if (this.color == null) {
            if (other.color != null)
                return false;
        }
        else if (!this.color.equals(other.color))
            return false;
        if (this.ownerId == null) {
            if (other.ownerId != null)
                return false;
        }
        else if (!this.ownerId.equals(other.ownerId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.catId == null) ? 0 : this.catId.hashCode());
        result = prime * result + ((this.birthDate == null) ? 0 : this.birthDate.hashCode());
        result = prime * result + ((this.breed == null) ? 0 : this.breed.hashCode());
        result = prime * result + ((this.color == null) ? 0 : this.color.hashCode());
        result = prime * result + ((this.ownerId == null) ? 0 : this.ownerId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cat (");

        sb.append(catId);
        sb.append(", ").append(birthDate);
        sb.append(", ").append(breed);
        sb.append(", ").append(color);
        sb.append(", ").append(ownerId);

        sb.append(")");
        return sb.toString();
    }
}