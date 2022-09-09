create table account
(
    id             serial
        primary key,
    account_type   varchar(50) not null,
    account_number varchar(50) not null
);

alter table account
    owner to postgres;

create table statement
(
    id         serial
        primary key,
    account_id integer
        constraint statement_account_id_fk
            references account,
    date_field varchar(100) not null,
    amount     varchar(100) not null
);

alter table statement
    owner to postgres;

