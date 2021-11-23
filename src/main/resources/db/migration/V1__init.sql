CREATE TABLE Cliente
(
    Id serial   primary key not null,
    Nombre varchar (25),
    Apellido Varchar (25),
    Edad  Varchar (25),
    Direccion_Residencia varchar (50)
);

CREATE TABLE Paquete
(
    Id serial  primary key not null,
    Nombre varchar (25),
    Fechaentrega  Varchar (25),
    Hora  Varchar (25),
    Direccion_Residencia varchar (50)
);