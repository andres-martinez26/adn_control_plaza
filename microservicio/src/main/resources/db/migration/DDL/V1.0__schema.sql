create table alquiler (
 id int(11) not null,
 nombre varchar(100) not null,
 numero varchar(12) not null,
 fecha_pago datetime null,
 estado_pago varchar(30),
 letra_local varchar(1),
 primary key (id)
);
