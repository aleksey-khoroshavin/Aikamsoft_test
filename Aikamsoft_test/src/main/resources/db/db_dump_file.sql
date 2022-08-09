--init DataBase

drop table if exists purchases cascade;
drop table if exists customers cascade;
drop table if exists goods cascade;

create table customers
(
    id      bigserial,
    name    varchar(70) not null,
    surname varchar(90) not null,
    primary key (id)
);

create table goods
(
    id   bigserial,
    name varchar(100) not null,
    cost integer      not null,
    primary key (id)
);

create table purchases
(
    record_id   bigserial,
    customer_id bigint,
    good_id     bigint,
    primary key (record_id),
    constraint fk_customer foreign key (customer_id) references customers (id),
    constraint fk_good foreign key (good_id) references goods (id)
);