-- borra la bd si existe
DROP DATABASE IF EXISTS pon_el_hombro;
-- creamos la bd
CREATE DATABASE pon_el_hombro;
-- activamos la bd
USE pon_el_hombro;


-- Tabla tipo vacuna
CREATE TABLE tb_estado(
id_esta int auto_increment,
nom_esta varchar(100) NOT NULL unique,
primary key (id_esta)
);

INSERT INTO tb_estado VALUES (null,"No vacunado");
INSERT INTO tb_estado VALUES (null,"Vacunado");


-- Tabla tipo vacuna
CREATE TABLE tb_tipo_vacuna(
id_tpva int auto_increment,
nom_tpva varchar(100) NOT NULL unique,
dosis_tpva char(4) NOT NULL,
pais_tpva varchar(100) NOT NULL,
primary key (id_tpva)
);

INSERT INTO tb_tipo_vacuna (id_tpva, nom_tpva, dosis_tpva, pais_tpva) VALUES ('1', 'sinorphan', '2', 'China');
INSERT INTO tb_tipo_vacuna (id_tpva, nom_tpva, dosis_tpva, pais_tpva) VALUES ('2', 'Pfizer', '2', 'USA');

-- Tabla cargos
CREATE TABLE rol(
id_car int auto_increment,
nom_car varchar(100) NOT NULL unique,
primary key (id_car)
);

insert into rol values (null, "ROLE_ADMIN");
insert into rol values (null, "ROLE_DOCTOR");
insert into rol values (null, "ROLE_DOCTORA");

-- tabla empleados
CREATE TABLE tb_empleados(
id_emp  int auto_increment,
nom_emp varchar(100) NOT NULL unique,
ape_emp varchar(100) NOT NULL,
tlf_emp char(9) NOT NULL unique,
edad_emp varchar(2) not null,
usr_emp varchar(45) NOT NULL unique,
cla_emp varchar(300) NOT NULL,
idcargo    int not null,
esrado tinyint default(1),
primary key (id_emp),
foreign key (idcargo) references rol(id_car)
);

select * from tb_empleados;
insert into tb_empleados values (null,"Juan Diego","Mejia",234543217,26,"juand26","1234",1,1);
insert into tb_empleados values (null,"Anna Patricia","Mamani",564789834,21,"annap21","1221",1,1);
insert into tb_empleados values (null,"Oliver Luis","Palacios",665478978,25,"oliverl25","3435",2,1);
insert into tb_empleados values (null,"Pepe Juan","Velasuqez",435667898,26,"pepej26","5654",1,1);
insert into tb_empleados values (null,"Brenda Luana","Chuquilin",330098908,20,"brendal20","3432",1,1);
insert into tb_empleados values (null,"Carol Rut","Palacios",456600989,29,"carolr29","4543",2,1);
insert into tb_empleados values (null,"Antonio Arturo","De las casas",567748909,26,"antonioa26","4345",2,1);
insert into tb_empleados values (null,"Glenn Arturo","Mejia",009098643,24,"glenna24","2222",1,1);



-- tabla ciudadanos
CREATE TABLE tb_ciudadanos(
id_ciud int auto_increment,
nom_ciud varchar(100) NOT NULL unique,
ape_ciud varchar(100) NOT NULL,
tlf_ciud char(9) NOT NULL unique,
direccion_ciud varchar(200) NOT NULL,
dni_ciud char(9) NOT NULL unique,
nacim_ciud date NOT NULL,
idestado int  NOT NULL,
primary key (id_ciud),
foreign key (idestado) references tb_estado(id_esta));

select * from tb_ciudadanos;

insert into tb_ciudadanos values (null,"Juan","Mejia",12345678,"La esperanza","22222222","1999-12-20",1);
insert into tb_ciudadanos values (null,"Martin","Mejia",12345677,"La esperanza","11111111","2001-12-21",1);
insert into tb_ciudadanos values (null,"Glenn","Mejia",12345666,"La esperanza","10101010","2018-12-21",1);
insert into tb_ciudadanos values (null,"Diego","Mejia",12345656,"La esperanza","20987290","2018-12-21",1);
insert into tb_ciudadanos values (null,"Pepe","Mejia",12323432,"La esperanza","23789000","2018-12-21",1);
insert into tb_ciudadanos values (null,"Arturo","Mejia",10094356,"La esperanza","23435654","2018-12-21",1);
insert into tb_ciudadanos values (null,"Alan","Mejia",11100045,"La esperanza","34543490","2018-12-21",1);
insert into tb_ciudadanos values (null,"Alverto","Mejia",12343276,"La esperanza","00985643","2018-12-21",1);
insert into tb_ciudadanos values (null,"Aldair","Mejia",12300980,"La esperanza","23437655","2018-12-21",1);


-- tabla detalle ciudadanos
CREATE TABLE tb_detalle_ciudadanos(
iddetalle int auto_increment,
idempleados  int not null ,
idvacuna    int not null ,
idciudadanos int not null,
fecha_dosis date ,
numero_vacu char(4),
primary key (iddetalle),
foreign key (idciudadanos) references tb_ciudadanos(id_ciud),
foreign key (idempleados) references tb_empleados(id_emp),
foreign key (idvacuna) references tb_tipo_vacuna(id_tpva));


select * from tb_detalle_ciudadanos;


-- detallado de vacunacon de cada ciudadano
select e.nom_emp,v.nom_tpva,c.nom_ciud,d.fecha_dosis,d.numero_vacu from tb_detalle_ciudadanos d 
join tb_tipo_vacuna v on d.idvacuna=v.id_tpva join tb_ciudadanos c on d.idciudadanos=c.id_ciud join tb_empleados e 
on d.idempleados=e.id_emp;


-- vacubads y no vacunados
select e.nom_esta as estado,count(*) as cantidad from tb_ciudadanos c 
join tb_estado e on c.idestado=e.id_esta
group by e.id_esta;

-- tio de vacuna
select t.nom_tpva as vacuna,count(*) as cantidad from tb_ciudadanos c 
join tb_tipo_vacuna t on c.idvacuna=t.id_tpva
group by t.id_tpva;

select usr_emp,cla_emp,esrado from tb_empleados where usr_emp ='glenna24';
select e.usr_emp,r.nom_car from rol r inner join tb_empleados e on r.id_car=e.idcargo where e.usr_emp ='glenna24';




-- consulta hacia la tabla de talles con esrtado 
select e.nom_emp,v.nom_tpva,c.nom_ciud,d.fecha_dosis,d.numero_vacu,j.nom_esta from tb_detalle_ciudadanos d 
join tb_tipo_vacuna v on d.idvacuna=v.id_tpva join tb_ciudadanos c on d.idciudadanos=c.id_ciud join tb_empleados e 
on d.idempleados=e.id_emp join tb_estado j on d.idestado=j.id_esta ;

-- consulta hacia la tabla de talles con esrtado de fintro de vacunado 
select e.nom_emp,v.nom_tpva,c.nom_ciud,d.fecha_dosis,d.numero_vacu,j.nom_esta from tb_detalle_ciudadanos d 
join tb_tipo_vacuna v on d.idvacuna=v.id_tpva join tb_ciudadanos c on d.idciudadanos=c.id_ciud join tb_empleados e 
on d.idempleados=e.id_emp join tb_estado j on d.idestado=j.id_esta where j.nom_esta="Vacunado";


select v.nom_tpva as Vacunas,count(*) as cantidad from tb_detalle_ciudadanos d 
join tb_tipo_vacuna v on d.idvacuna=v.id_tpva group by v.nom_tpva;




