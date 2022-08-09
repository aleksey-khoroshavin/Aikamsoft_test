--init DataBase

drop table if exists purchases cascade;
drop table if exists customers cascade;
drop table if exists productTimes cascade;

create table customers
(
    id        bigserial,
    firstName varchar(70) not null,
    lastName  varchar(90) not null,
    primary key (id)
);

create table productTimes
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
    product_id  bigint,
    primary key (record_id),
    constraint fk_customer foreign key (customer_id) references customers (id),
    constraint fk_good foreign key (product_id) references productTimes (id)
);