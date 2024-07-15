create table course (id bigint not null, category varchar(10) not null, status varchar(10) not null, name varchar(100) not null, primary key (id)) engine=InnoDB;
create table course_seq (next_val bigint) engine=InnoDB;
insert into course_seq values ( 1 );
create table lesson (course_id bigint not null, id bigint not null, youtube_url varchar(11) not null, name varchar(100) not null, primary key (id)) engine=InnoDB;
create table lesson_seq (next_val bigint) engine=InnoDB;
insert into lesson_seq values ( 1 );
alter table lesson add constraint FKjs3c7skmg8bvdddok5lc7s807 foreign key (course_id) references course (id);
