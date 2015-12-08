CREATE TABLE m_user (
    id character varying(25) NOT NULL primary key,
    user_name character varying(255) NOT NULL unique,
    user_email character varying(255) NOT NULL unique,
    user_password character varying(255) NOT NULL,
    user_valid_from timestamp with time zone,
    user_valid_thru timestamp with time zone,
    is_system_user boolean DEFAULT false NOT NULL,
    user_auth_token character varying(500),
    user_auth_token_valid_thru timestamp with time zone,
    opt_lock bigint DEFAULT 0 NOT NULL,
    created_at timestamp with time zone DEFAULT timezone('utc'::text, now()) NOT NULL,
    created_by_id character varying(255) NOT NULL,
    updated_at timestamp with time zone DEFAULT timezone('utc'::text, now()) NOT NULL,
    updated_by_id character varying(255) NOT NULL,
    deleted_at timestamp with time zone,
    deleted_by_id character varying(255)
);