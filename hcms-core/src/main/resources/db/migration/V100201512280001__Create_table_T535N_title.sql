CREATE TABLE T535N (
  art char(1) NOT NULL,
  title character varying(15) NOT NULL,
  duevo char(1),
  ttout character varying(15) NOT NULL
);

ALTER TABLE T535N ADD PRIMARY KEY(art, title);
