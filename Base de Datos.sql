drop database if exists DBRegistro;

Create database DBRegistro;

Create table Persona(
	codigoPersona int not null auto_increment,
    DPI varchar(15) not null,
    nombrePersona varchar(200) not null,
    primary key PK_codigoPersona (codigoPersona)	

);

