create table if not exists prefecture (
  id smallint not null,
  name varchar(6) not null,
  primary key (id)
) engine = INNODB;