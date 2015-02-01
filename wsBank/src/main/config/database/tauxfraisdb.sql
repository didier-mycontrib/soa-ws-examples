create database if not exists tauxfraisdb;
use tauxfraisdb;

drop table if exists T_TauxInterets;
create table T_TauxInterets (
  num_plage integer not null primary key,
  nb_mois_min integer,nb_mois_max integer,
  taux_mens double);

insert into T_TauxInterets values(1,0,11,0.5);
insert into T_TauxInterets values(2,12,60,0.4);
insert into T_TauxInterets values(3,61,240,0.6);

drop table if exists T_FraisDossier;
create table T_FraisDossier (
  num_plage integer not null primary key,
  montant_min integer,montant_max integer,
  frais double);

insert into T_FraisDossier values(1,0,25000,100.0);
insert into T_FraisDossier values(2,25001,100000,300.0);
insert into T_FraisDossier values(3,100001,999999999,600.0);

show tables;
select * from T_TauxInterets;
select * from T_FraisDossier;
