--liquibase formatted sql

--changeset v.zavoznikov:1

create table users (
    id serial primary key,
    login varchar(64) not null unique,
    password varchar(32) not null
);