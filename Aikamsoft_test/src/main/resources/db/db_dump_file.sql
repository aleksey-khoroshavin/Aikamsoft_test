--init DataBase

drop table if exists purchases cascade;
drop table if exists customers cascade;
drop table if exists products cascade;

create table customers
(
    id        bigserial,
    firstName varchar(70) not null,
    lastName  varchar(90) not null,
    primary key (id)
);

create table products
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
    date_of_purchase date,
    primary key (record_id),
    constraint fk_customer foreign key (customer_id) references customers (id),
    constraint fk_good foreign key (product_id) references products (id)
);

insert into customers(firstname, lastname) values ('Антон', 'Иванов');
insert into customers(firstname, lastname) values ('Николай', 'Иванов');
insert into customers(firstname, lastname) values ('Валентин', 'Петров');

insert into products (name, cost) values ('Минеральная вода', 100);
insert into products (name, cost) values ('Хлеб', 30);
insert into products (name, cost) values ('Сметана', 70);
insert into products (name, cost) values ('Колабаса', 300);
insert into products (name, cost) values ('Сыр', 420);

insert into purchases (customer_id, product_id, date_of_purchase) values (1, 2, to_date('09.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (1, 3, to_date('09.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (1, 1, to_date('04.03.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (1, 5, to_date('11.06.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (1, 3, to_date('29.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (1, 2, to_date('05.04.2022', 'dd.mm.yyyy'));

insert into purchases (customer_id, product_id, date_of_purchase) values (2, 1, to_date('09.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (2, 1, to_date('03.04.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (2, 5, to_date('04.03.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (2, 5, to_date('11.06.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (2, 5, to_date('29.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (2, 2, to_date('05.04.2022', 'dd.mm.yyyy'));

insert into purchases (customer_id, product_id, date_of_purchase) values (3, 4, to_date('09.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (3, 4, to_date('03.04.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (3, 3, to_date('04.03.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (3, 5, to_date('11.06.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (3, 1, to_date('29.08.2022', 'dd.mm.yyyy'));
insert into purchases (customer_id, product_id, date_of_purchase) values (3, 2, to_date('05.04.2022', 'dd.mm.yyyy'));