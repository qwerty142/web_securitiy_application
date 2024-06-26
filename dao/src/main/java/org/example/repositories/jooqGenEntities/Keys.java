/*
 * This file is generated by jOOQ.
 */
package org.example.repositories.jooqGenEntities;


import javax.annotation.processing.Generated;

import org.example.repositories.jooqGenEntities.tables.Cat;
import org.example.repositories.jooqGenEntities.tables.CatCat;
import org.example.repositories.jooqGenEntities.tables.Owner;
import org.example.repositories.jooqGenEntities.tables.records.CatCatRecord;
import org.example.repositories.jooqGenEntities.tables.records.CatRecord;
import org.example.repositories.jooqGenEntities.tables.records.OwnerRecord;
import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.19.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CatRecord> CAT_PKEY = Internal.createUniqueKey(Cat.CAT, DSL.name("cat_pkey"), new TableField[] { Cat.CAT.CAT_ID }, true);
    public static final UniqueKey<OwnerRecord> OWNER_PKEY = Internal.createUniqueKey(Owner.OWNER, DSL.name("owner_pkey"), new TableField[] { Owner.OWNER.OWNER_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CatCatRecord, CatRecord> CAT_CAT__FKLGVUC33EV72XTXHI9YMNSGKOX = Internal.createForeignKey(CatCat.CAT_CAT, DSL.name("fklgvuc33ev72xtxhi9ymnsgkox"), new TableField[] { CatCat.CAT_CAT.CAT2_ID }, Keys.CAT_PKEY, new TableField[] { Cat.CAT.CAT_ID }, true);
    public static final ForeignKey<CatCatRecord, CatRecord> CAT_CAT__FKQHOKQXU4AS6Q9GQYO895J8P9W = Internal.createForeignKey(CatCat.CAT_CAT, DSL.name("fkqhokqxu4as6q9gqyo895j8p9w"), new TableField[] { CatCat.CAT_CAT.CAT1_ID }, Keys.CAT_PKEY, new TableField[] { Cat.CAT.CAT_ID }, true);
}
