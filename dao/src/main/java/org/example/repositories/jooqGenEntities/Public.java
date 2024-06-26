/*
 * This file is generated by jOOQ.
 */
package org.example.repositories.jooqGenEntities;


import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.example.repositories.jooqGenEntities.tables.Cat;
import org.example.repositories.jooqGenEntities.tables.CatCat;
import org.example.repositories.jooqGenEntities.tables.Owner;
import org.jetbrains.annotations.NotNull;
import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.cat</code>.
     */
    public final Cat CAT = Cat.CAT;

    /**
     * The table <code>public.cat_cat</code>.
     */
    public final CatCat CAT_CAT = CatCat.CAT_CAT;

    /**
     * The table <code>public.owner</code>.
     */
    public final Owner OWNER = Owner.OWNER;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    @Override
    @NotNull
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    @NotNull
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Cat.CAT,
            CatCat.CAT_CAT,
            Owner.OWNER
        );
    }
}
