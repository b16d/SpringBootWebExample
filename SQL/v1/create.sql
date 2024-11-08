
DROP TABLE IF EXISTS "user".application_user;

CREATE TABLE IF NOT EXISTS "user".application_user
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 2 MINVALUE 1 MAXVALUE 1000 CACHE 1 ),
    name text COLLATE pg_catalog."default",
    family_name text COLLATE pg_catalog."default",
    CONSTRAINT application_user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "user".application_user
    OWNER to postgres;