
CREATE TABLE IF NOT EXISTS student (
   id SERIAL,
   nickname VARCHAR(100) NOT NULL,
   fullname VARCHAR(100) NOT NULL,
   age INT,
   status BOOLEAN,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS course (
  id SERIAL,
  description VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  student_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (student_id ) REFERENCES student(id)
);
