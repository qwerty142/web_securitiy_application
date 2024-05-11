/*
 * This file is generated by jOOQ.
 */
package org.example.repositories.jooqGenEntities.tables.records;


import java.beans.ConstructorProperties;

import javax.annotation.processing.Generated;

import org.example.repositories.jooqGenEntities.tables.CatCat;
import org.jetbrains.annotations.NotNull;
import org.jooq.impl.TableRecordImpl;


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
public class CatCatRecord extends TableRecordImpl<CatCatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.cat_cat.cat1_id</code>.
     */
    public void setCat1Id(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.cat_cat.cat1_id</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getCat1Id() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.cat_cat.cat2_id</code>.
     */
    public void setCat2Id(@NotNull Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.cat_cat.cat2_id</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getCat2Id() {
        return (Long) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CatCatRecord
     */
    public CatCatRecord() {
        super(CatCat.CAT_CAT);
    }

    /**
     * Create a detached, initialised CatCatRecord
     */
    @ConstructorProperties({ "cat1Id", "cat2Id" })
    public CatCatRecord(@NotNull Long cat1Id, @NotNull Long cat2Id) {
        super(CatCat.CAT_CAT);

        setCat1Id(cat1Id);
        setCat2Id(cat2Id);
        resetChangedOnNotNull();
    }

    /**
     * Create a detached, initialised CatCatRecord
     */
    public CatCatRecord(org.example.repositories.jooqGenEntities.tables.pojos.CatCat value) {
        super(CatCat.CAT_CAT);

        if (value != null) {
            setCat1Id(value.getCat1Id());
            setCat2Id(value.getCat2Id());
            resetChangedOnNotNull();
        }
    }
}