DROP TABLE tasks;
CREATE TABLE tasks (_id serial primary key);
ALTER TABLE tasks ADD COLUMN description varchar;
ALTER TABLE tasks ADD COLUMN Category int;