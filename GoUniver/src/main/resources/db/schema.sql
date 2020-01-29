create table users
(
	id int auto_increment,
	email varchar(100) not null,
	password varchar(100) not null,
	first_name varchar(100) null,
	last_name varchar(100) null,
	isadmin tinyint default 0 null,
	constraint email_UNIQUE
		unique (email),
	constraint id_UNIQUE
		unique (id)
);

alter table users
	add primary key (id);



create table exams
(
	id int auto_increment,
	subject varchar(255) not null,
	constraint id_UNIQUE
		unique (id),
	constraint subject_UNIQUE
		unique (subject)
);

alter table exams
	add primary key (id);



create table majors
(
	id int auto_increment,
	title varchar(255) not null,
	constraint id_UNIQUE
		unique (id),
	constraint title_UNIQUE
		unique (title)
);

alter table majors
	add primary key (id);



create table major_exams
(
	id int auto_increment,
	major_id int not null,
	exam_id int not null,
	constraint id_UNIQUE
		unique (id),
	constraint exam_id
		foreign key (exam_id) references exams (id),
	constraint major_id
		foreign key (major_id) references majors (id)
);

create index exam_id_idx
	on major_exams (exam_id);

create index major_id_idx
	on major_exams (major_id);

alter table major_exams
	add primary key (id);



create table student_majors
(
	id int auto_increment
		primary key,
	student_id int not null,
	major_id int not null,
	constraint student_id
		foreign key (student_id) references users (id),
	constraint student_majors
		foreign key (major_id) references majors (id)
);

create index student_id_idx
	on student_majors (student_id);

create index student_majors_idx
	on student_majors (major_id);



create table marks
(
	id int auto_increment,
	student_id int not null,
	exam_id int not null,
	mark int default 0 null,
	constraint id_UNIQUE
		unique (id),
	constraint `exam-id`
		foreign key (exam_id) references exams (id),
	constraint `student-id`
		foreign key (student_id) references users (id)
);

create index exam_id_idx
	on marks (exam_id);

alter table marks
	add primary key (id);

