create table app (
    id bigint not null primary key,
    name varchar(255) not null,
    description varchar,
    url varchar,
    created_at timestamp not null
);

create table deployment(

    id bigint not null primary key,
    revision varchar(255) not null,
    changelog varchar ,
    description varchar,
    "user" varchar(255) not null,
    created_at timestamp not null,
    app_id bigint not null
);

alter table deployment add constraint deployment_app_fk foreign key(app_id) references app(id);
