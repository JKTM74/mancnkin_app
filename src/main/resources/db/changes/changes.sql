--liquibase formatted sql

--changeset v.zavoznikov:1

create table users (
    id serial primary key,
    login varchar(64) not null unique,
    password varchar(32) not null
);
--changeset v.eremin:1
alter table users rename to player;
--changeset v.eremin:2
alter table player rename column password to pass;
--changeset s.vagin:1
create table room (
    id serial primary key,
    name varchar(64) not null unique,
    isActive boolean not null,
    info JSONb not null
);