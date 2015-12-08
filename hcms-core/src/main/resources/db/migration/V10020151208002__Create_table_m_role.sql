create table m_role (
    id character varying(255) NOT NULL primary key,
    role_name character varying(255) NOT NULL unique,
    role_description character varying(255),
    is_system_role boolean DEFAULT false NOT NULL,
    opt_lock bigint DEFAULT 0 NOT NULL,
    created_at timestamp with time zone DEFAULT timezone('utc'::text, now()) NOT NULL,
    created_by_id character varying(255) NOT NULL,
    updated_at timestamp with time zone DEFAULT timezone('utc'::text, now()) NOT NULL,
    updated_by_id character varying(255) NOT NULL,
    deleted_at timestamp with time zone,
    deleted_by_id character varying(255)
);