-- Create Role, Database, e.t.c

CREATE DATABASE sheptdemo
  WITH ENCODING='UTF8';

-- Create Role, Database, e.t.c


CREATE ROLE sheptdemo_group
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE;

CREATE ROLE sheptdemo LOGIN
  ENCRYPTED PASSWORD 'md507a461b1b379c0b4116ac9e5aed17539'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE;
GRANT sheptdemo_group TO sheptdemo;

CREATE SCHEMA s1
  AUTHORIZATION postgres;
GRANT ALL ON SCHEMA s1 TO postgres;
GRANT USAGE on SCHEMA s1 to sheptdemo_group;

-- we need language for store procedures
CREATE LANGUAGE plpgsql;


