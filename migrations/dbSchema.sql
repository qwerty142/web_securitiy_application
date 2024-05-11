create table cat if not exists
(
    cat_id     bigserial
        primary key,
    birth_date timestamp(6),
    breed      varchar(255),
    color      varchar(255),
    owner_id   bigint
);

create table cat_cat if not exists(
    cat1_id bigint,
    cat2_id bigint
);

create table owner if not exists
(
    owner_id   bigserial
        primary key,
    birth_date timestamp(6)
);
