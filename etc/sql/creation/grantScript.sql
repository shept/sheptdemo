SET search_path to s1, pg_catalog;
GRANT ALL ON SCHEMA s1 to postgres;
GRANT USAGE on SCHEMA s1 to sheptdemo_group;

GRANT ALL ON 
	address,
	person
	
TO postgres;

GRANT SELECT, INSERT, UPDATE, DELETE ON 
	address,
	person

TO sheptdemo_group;

GRANT SELECT, UPDATE ON 
	address,
	person
	
TO sheptdemo_group; 

GRANT SELECT, UPDATE ON 
	address_id_seq,
	person_id_seq
	
TO sheptdemo_group; 

