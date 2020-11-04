create table proximity_product(
	id serial primary key,
	name varchar(100),
	cost numeric
);

create table proximity_payment_method(
	id serial primary key,
	name varchar(100)
);

insert into proximity_payment_method values (1, 'Coin');
insert into proximity_payment_method values(2, 'Bill');
insert into proximity_payment_method values(3, 'Credit Card');

create table proximity_machine_type(
	id serial primary key,
	name varchar(100)
);

insert into proximity_machine_type values (1,'XYZ1');
insert into proximity_machine_type values (2,'XYZ2');

create table proximity_machine_type_payment_method(
	machine_type integer,
	payment_method integer,
	constraint fk_pmtpm_payment_method foreign key (payment_method) references proximity_payment_method(id),
	constraint fk_pmtpm_machine_type foreign key (machine_type) references proximity_machine_type(id)
);

insert into proximity_machine_type_payment_method values (1,1);
insert into proximity_machine_type_payment_method values (1,2);
insert into proximity_machine_type_payment_method values (2,1);
insert into proximity_machine_type_payment_method values (2,2);
insert into proximity_machine_type_payment_method values (2,3);

create table proximity_machine(
	id serial primary key,
	capacity numeric,
	machine_type integer,
	balance numeric,
	is_connected boolean,
	constraint fk_pm_machine_type foreign key (machine_type) references proximity_machine_type(id)
);

create table proximity_machine_product(
	machine_id integer,
	product_id integer,
	quantity integer,
	constraint fk_product_marchine foreign key (product_id) references proximity_product(id),
	constraint fk_product_product foreign key (product_id) references proximity_product(id)
);

create table proximity_transaction(
	id serial primary key,
	machine_id integer,
	product_id integer,
	change numeric,
	cdate date,
	payment_method integer,
	constraint fk_pt_payment_method foreign key (payment_method) references proximity_payment_method(id),
	constraint fk_machine_transaction foreign key (machine_id) references proximity_machine(id),
	constraint fk_product_transaction foreign key (product_id) references proximity_product(id)
);