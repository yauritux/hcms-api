CREATE TABLE user_roles (
    m_user_id character varying(255) NOT NULL,
    m_role_id character varying(255) NOT NULL,
    PRIMARY KEY (m_user_id, m_role_id)
);

ALTER TABLE user_roles ADD FOREIGN KEY (m_user_id) REFERENCES m_user (id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE user_roles ADD FOREIGN KEY (m_role_id) REFERENCES m_role (id) ON UPDATE CASCADE ON DELETE RESTRICT;