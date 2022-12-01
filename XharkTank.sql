CREATE TABLE IF NOT EXISTS public.offer_entity
(
    id bigint NOT NULL DEFAULT nextval('offer_entity_id_seq'::regclass),
    added_on timestamp(6) without time zone,
    updated_on timestamp(6) without time zone,
    version integer,
    amount numeric(38,2),
    comment character varying(255) COLLATE pg_catalog."default",
    equity numeric(38,2),
    investor character varying(255) COLLATE pg_catalog."default",
    pitch_id bigint,
    CONSTRAINT offer_entity_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.offer_entity
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.pitch_entity
(
    id bigint NOT NULL DEFAULT nextval('pitch_entity_id_seq'::regclass),
    added_on timestamp(6) without time zone,
    updated_on timestamp(6) without time zone,
    version integer,
    ask_amount numeric(38,2),
    entrepreneur character varying(255) COLLATE pg_catalog."default",
    equity numeric(38,2),
    pitch_idea character varying(255) COLLATE pg_catalog."default",
    pitch_title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT pitch_entity_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pitch_entity
    OWNER to postgres;