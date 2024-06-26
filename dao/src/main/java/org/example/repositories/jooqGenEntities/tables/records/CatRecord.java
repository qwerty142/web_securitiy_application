/*
 * This file is generated by jOOQ.
 */
package org.example.repositories.jooqGenEntities.tables.records;


import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.example.repositories.jooqGenEntities.tables.Cat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CatRecord extends UpdatableRecordImpl<CatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.cat.cat_id</code>.
     */
    public void setCatId(@Nullable Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.cat.cat_id</code>.
     */
    @Nullable
    public Long getCatId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.cat.birth_date</code>.
     */
    public void setBirthDate(@Nullable LocalDateTime value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.cat.birth_date</code>.
     */
    @Nullable
    public LocalDateTime getBirthDate() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.cat.breed</code>.
     */
    public void setBreed(@Nullable String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.cat.breed</code>.
     */
    @Size(max = 255)
    @Nullable
    public String getBreed() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.cat.color</code>.
     */
    public void setColor(@Nullable String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.cat.color</code>.
     */
    @Size(max = 255)
    @Nullable
    public String getColor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.cat.owner_id</code>.
     */
    public void setOwnerId(@Nullable Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.cat.owner_id</code>.
     */
    @Nullable
    public Long getOwnerId() {
        return (Long) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CatRecord
     */
    public CatRecord() {
        super(Cat.CAT);
    }

    /**
     * Create a detached, initialised CatRecord
     */
    @ConstructorProperties({ "catId", "birthDate", "breed", "color", "ownerId" })
    public CatRecord(@Nullable Long catId, @Nullable LocalDateTime birthDate, @Nullable String breed, @Nullable String color, @Nullable Long ownerId) {
        super(Cat.CAT);

        setCatId(catId);
        setBirthDate(birthDate);
        setBreed(breed);
        setColor(color);
        setOwnerId(ownerId);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised CatRecord
     */
    public CatRecord(org.example.repositories.jooqGenEntities.tables.pojos.Cat value) {
        super(Cat.CAT);

        if (value != null) {
            setCatId(value.getCatId());
            setBirthDate(value.getBirthDate());
            setBreed(value.getBreed());
            setColor(value.getColor());
            setOwnerId(value.getOwnerId());
            resetChangedOnNotNull();
        }
    }
}
