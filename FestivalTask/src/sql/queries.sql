drop database fest;
create database fest;
use fest;

--drop table group_member;
--drop table class;
--#drop table person;
CREATE TABLE person(
	id INT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50),
    address VARCHAR(255),
	birthday DATE NOT NULL,
    role ENUM('teacher', 'pupil'),
    PRIMARY KEY (id)
);
INSERT INTO person (name, surname, address, birthday, role) VALUES
	('Анатолій', 'Анапкін', 'м.Київ, вул.Арсенівська 1, кв.1', '1981-01-01', 'teacher'),
	('Борис', 'Борисов', 'м.Київ, вул.Бориспільська 2, кв.2', '2000-02-02', 'pupil'),
    ('Василь', 'Василенко', 'м.Київ, вул.Василевської 3, кв.3', '2000-03-03', 'pupil'),
    ('Денис', 'Денисов', 'м.Київ, вул.Дорогожицька 4, кв.4', '2000-04-04', 'pupil'),
    ('Ернест', 'Естімов', 'м.Київ, вул.Еспланадна 5, кв.5', '2000-05-05', 'pupil'),
    ('Євген', 'Єршов', 'м.Київ, вул.Європейська 6, кв.6', '2000-06-06', 'pupil'),
    ('Іван', 'Іваненко', 'м.Київ, вул.Івана Богуна 10, кв.10', '1982-10-10', 'teacher'),
    ('Жанна', 'Жаковська', 'м.Київ, вул.Житомирська 11, кв.11', '2001-01-01', 'pupil'),
    ('Захар', 'Заньковецький', 'м.Київ, вул.Замкова 12, кв. 12', '2001-02-02', 'pupil'),
    ('Микола', 'Миколаєнко', 'м.Київ, вул.Миргородська 12, кв.12', '2001-03-03', 'pupil'),
    ('Назар', 'Назаренко', 'м.Київ, вул.Народного ополчення 13, кв.13', '2001-04-04', 'pupil'),
    ('Олексій', 'Оніщук', 'м.Київ, вул.Олени Теліги 14, кв.14', '2001-05-05', 'pupil');

CREATE TABLE class(
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(5),
    teacher_id INT NOT NULL,
    room SMALLINT NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FOREIGN KEY(teacher_id) REFERENCES person(id)
);
INSERT INTO class(name, teacher_id, room) VALUES('9A', 1, 110), ('9B', 7, 220);

CREATE TABLE group_member(
	person_id INT NOT NULL,
    class_id INT NOT NULL,
    CONSTRAINT FOREIGN KEY(person_id) REFERENCES person(id),
    CONSTRAINT FOREIGN KEY(class_id) REFERENCES class(id)
);
INSERT INTO group_member VALUES(2,1),(3,1),(4,1),(5,1),(6,1),
(8,2),(9,2),(10,2),(11,2),(12,2);

SELECT p.name, p.surname, p.address, p.birthday, c.name as class FROM person p
JOIN group_member g
ON g.person_id=p.id
JOIN class c ON g.class_id=c.id
WHERE c.name='9A' AND p.role='pupil';