/*
 * This file is generated by jOOQ.
 */
package org.example.repositories.jooqGenEntities.tables;


import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.processing.Generated;

import org.example.repositories.jooqGenEntities.Keys;
import org.example.repositories.jooqGenEntities.Public;
import org.example.repositories.jooqGenEntities.tables.records.OwnerRecord;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class Owner extends TableImpl<OwnerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.owner</code>
     */
    public static final Owner OWNER = new Owner();

    /**
     * The class holding records for this type
     */
    @Override
    @NotNull
    public Class<OwnerRecord> getRecordType() {
        return OwnerRecord.class;
    }

    /**
     * The column <code>public.owner.owner_id</code>.
     */
    public final TableField<OwnerRecord, Long> OWNER_ID = createField(DSL.name("owner_id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.owner.birth_date</code>.
     */
    public final TableField<OwnerRecord, LocalDateTime> BIRTH_DATE = createField(DSL.name("birth_date"), SQLDataType.LOCALDATETIME(6), this, "");

    private Owner(Name alias, Table<OwnerRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Owner(Name alias, Table<OwnerRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.owner</code> table reference
     */
    public Owner(String alias) {
        this(DSL.name(alias), OWNER);
    }

    /**
     * Create an aliased <code>public.owner</code> table reference
     */
    public Owner(Name alias) {
        this(alias, OWNER);
    }

    /**
     * Create a <code>public.owner</code> table reference
     */
    public Owner() {
        this(DSL.name("owner"), null);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    @NotNull
    public Identity<OwnerRecord, Long> getIdentity() {
        return (Identity<OwnerRecord, Long>) super.getIdentity();
    }

    @Override
    @NotNull
    public UniqueKey<OwnerRecord> getPrimaryKey() {
        return Keys.OWNER_PKEY;
    }

    @Override
    @NotNull
    public Owner as(String alias) {
        return new Owner(DSL.name(alias), this);
    }

    @Override
    @NotNull
    public Owner as(Name alias) {
        return new Owner(alias, this);
    }

    @Override
    @NotNull
    public Owner as(Table<?> alias) {
        return new Owner(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public Owner rename(String name) {
        return new Owner(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public Owner rename(Name name) {
        return new Owner(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public Owner rename(Table<?> name) {
        return new Owner(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    public Owner where(Condition condition) {
        return new Owner(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    public Owner where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    public Owner where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    public Owner where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    @PlainSQL
    public Owner where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    @PlainSQL
    public Owner where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    @PlainSQL
    public Owner where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    @PlainSQL
    public Owner where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    public Owner whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @NotNull
    public Owner whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}