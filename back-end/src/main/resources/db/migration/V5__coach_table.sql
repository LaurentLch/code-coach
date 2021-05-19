create table coach_info
(
    id           integer generated by default as identity
        constraint coach_info_pk
            primary key,
    introduction varchar(255),
    availability varchar(255),
    coach_topic  varchar(255)

);

alter table coach_info
    owner to student;

create unique index coach_info_id_index
    on coach_info (id);