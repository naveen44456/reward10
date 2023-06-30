create table customer (id bigint generated by default as identity, name varchar(255), email_id varchar(255), contact_number varchar(255), primary key (id))
create table orders (id bigint generated by default as identity, order_date date, price NUMERIC(8,2), customer_id bigint, primary key (id))
alter table orders add constraint FKq1uengrrk45ucgcdp7kt7qc4k foreign key (customer_id) references customer