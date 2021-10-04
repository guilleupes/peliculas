
/* Nombre BD: bd4 */

create table formatos(
cod_for int(5) primary key,
nom_for varchar(20) not null
);

create table generos(
cod_gen int(5) primary key,
nom_gen varchar(20) not null
);

create table peliculas(
cod_pel int(5) primary key,
tit_pel varchar(100) not null,
año_pel int(4) not null,
cod_for int(5) not null,
cod_gen int(5) not null,
foreign key(cod_for) references formatos(cod_for),
foreign key(cod_gen) references generos(cod_gen)
);

insert into formatos values (1,'Dvd');
insert into formatos values (2,'Bluray');

insert into generos values (1,'Accion');
insert into generos values (2,'Ciencia Ficcion');
insert into generos values (3,'Drama');
insert into generos values (4,'Infantil');

insert into peliculas values(11111,'Shrek',2000,1,4);
insert into peliculas values(22222,'The Matrix - Reloaded',2004,1,2);
insert into peliculas values(33333,'El Perfume',2008,2,3);

select * from formatos;
select * from generos;
select * from peliculas;

select cod_pel, tit_pel, año_pel, nom_for, nom_gen 
from peliculas, formatos, generos 
where peliculas.cod_for=formatos.cod_for 
and peliculas.cod_gen=generos.cod_gen 
order by peliculas.cod_pel asc

