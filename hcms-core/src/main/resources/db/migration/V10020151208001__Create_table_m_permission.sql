create table m_permission (
    id character varying(255) NOT NULL primary key,
    permission_name character varying(255) NOT NULL unique,
    permission_description character varying(255),
    permission_object character varying(255) NOT NULL,
    is_system_permission boolean DEFAULT false NOT NULL,
    opt_lock bigint DEFAULT 0 NOT NULL,
    created_at timestamp with time zone DEFAULT timezone('utc'::text, now()) NOT NULL,
    created_by_id character varying(255) NOT NULL,
    updated_at timestamp with time zone DEFAULT timezone('utc'::text, now()) NOT NULL,
    updated_by_id character varying(255) NOT NULL,
    deleted_at timestamp with time zone,
    deleted_by_id character varying(255)
);