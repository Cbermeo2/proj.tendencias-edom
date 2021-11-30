
CREATE TABLE cafeteria(
id serial   primary key not null,
nombre varchar (25),
telefono varchar (25),
direccion varchar (50)
);

CREATE TABLE productos(
id serial    primary key not null,
nombre varchar(255) ,
id_cafeteria int  not null,
foreign key (id_cafeteria) references cafeteria(id) on delete cascade on update cascade
);


CREATE TABLE persona(
id serial    primary key not null,
    cedula varchar (25),
    nombre varchar (25),
    apellido varchar (25),
    direccion varchar (50)
);
CREATE TABLE entrega(
 id serial    primary key not null,
        fecha varchar (25),
        persona_id int,
        producto_id int,
        foreign key (persona_id) references persona(id) on delete cascade on update cascade,
        foreign key (producto_id) references productos(id) on delete cascade on update cascade


);
