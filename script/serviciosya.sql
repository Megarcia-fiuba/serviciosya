CREATE SEQUENCE public.occupation_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.occupation_seq
    OWNER TO postgres;

-- Table: public.occupation

-- DROP TABLE public.occupation;

CREATE TABLE public.occupation
(
    id integer NOT NULL DEFAULT nextval('occupation_seq'::regclass),
    name character varying(48) COLLATE pg_catalog."default" NOT NULL,
    description character varying(128) COLLATE pg_catalog."default" NOT NULL,
    parent integer,
    CONSTRAINT pk_occupation_id PRIMARY KEY (id),
    CONSTRAINT fk_occupation_to_occupation FOREIGN KEY (parent)
        REFERENCES public.occupation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.occupation
    OWNER to postgres;



CREATE SEQUENCE public.country_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.country_seq
    OWNER TO postgres;

-- Table: public.country

-- DROP TABLE public.country;

CREATE TABLE public.country
(
    id integer NOT NULL DEFAULT nextval('country_seq'::regclass),
    name character varying(48) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_country_id PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.country
    OWNER to postgres;



CREATE SEQUENCE public.province_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.province_seq
    OWNER TO postgres;

-- Table: public.province

-- DROP TABLE public.province;

CREATE TABLE public.province
(
    id integer NOT NULL DEFAULT nextval('province_seq'::regclass),
    name character varying(48) COLLATE pg_catalog."default" NOT NULL,
    country_id integer NOT NULL,
    CONSTRAINT province_pkey PRIMARY KEY (id),
    CONSTRAINT fk_province_to_country_id FOREIGN KEY (country_id)
        REFERENCES public.country (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.province
    OWNER to postgres;



CREATE SEQUENCE public.city_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.city_seq
    OWNER TO postgres;

-- Table: public.city

-- DROP TABLE public.city;

CREATE TABLE public.city
(
    id integer NOT NULL DEFAULT nextval('city_seq'::regclass),
    name character varying(48) COLLATE pg_catalog."default" NOT NULL,
    province_id integer NOT NULL,
    CONSTRAINT city_pkey PRIMARY KEY (id),
    CONSTRAINT fk_city_province_id FOREIGN KEY (province_id)
        REFERENCES public.province (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.city
    OWNER to postgres;


CREATE SEQUENCE public.provider_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.provider_seq
    OWNER TO postgres;

-- Table: public.provider

-- DROP TABLE public.provider;

CREATE TABLE public.provider
(
    id integer NOT NULL DEFAULT nextval('provider_seq'::regclass),
    name character varying(48) COLLATE pg_catalog."default" NOT NULL,
    lastName character varying(48) COLLATE pg_catalog."default" NOT NULL,
    dni integer NOT NULL,
    email character varying(128) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(48) COLLATE pg_catalog."default" NOT NULL,
    city_id integer NOT NULL,
    address character varying(128) COLLATE pg_catalog."default" NOT NULL,
    status integer NOT NULL,
    CONSTRAINT provider_pkey PRIMARY KEY (id),
    CONSTRAINT "ux_provider_dni	" UNIQUE (dni),
    CONSTRAINT ux_provider_email UNIQUE (email),
    CONSTRAINT "ux_provider_phone	" UNIQUE (phone)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.provider
    OWNER to postgres;



CREATE SEQUENCE public.occupation_x_provider_seq
    INCREMENT 1
    START 4
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.occupation_x_provider_seq
    OWNER TO postgres;

-- Table: public.occupation_x_provider

-- DROP TABLE public.occupation_x_provider;

CREATE TABLE public.occupation_x_provider
(
    id integer NOT NULL DEFAULT nextval('occupation_x_provider_seq'::regclass),
    provider_id integer NOT NULL,
    occupation_id integer NOT NULL,
    CONSTRAINT occupation_x_provider_pkey PRIMARY KEY (id),
    CONSTRAINT ux_occupation_x_provider UNIQUE (provider_id, occupation_id),
    CONSTRAINT fk_oxp_to_occupation FOREIGN KEY (occupation_id)
        REFERENCES public.occupation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_oxp_to_provider FOREIGN KEY (provider_id)
        REFERENCES public.provider (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.occupation_x_provider
    OWNER to postgres;