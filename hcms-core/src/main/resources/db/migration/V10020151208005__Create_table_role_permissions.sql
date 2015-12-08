CREATE TABLE role_permissions (
    m_role_id character varying(255) NOT NULL,
    m_permission_id character varying(255) NOT NULL,
    PRIMARY KEY (m_role_id, m_permission_id)
);

ALTER TABLE role_permissions ADD FOREIGN KEY (m_role_id) REFERENCES m_role (id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE role_permissions ADD FOREIGN KEY (m_permission_id) REFERENCES m_permission (id) ON UPDATE CASCADE ON DELETE RESTRICT;