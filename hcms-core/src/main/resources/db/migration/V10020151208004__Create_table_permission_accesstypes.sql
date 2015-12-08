CREATE TABLE permission_accesstypes (
    permission_id character varying(255) NOT NULL,
    access_permission_type_id integer NOT NULL,
    PRIMARY KEY(permission_id, access_permission_type_id)
);

ALTER TABLE permission_accesstypes ADD FOREIGN KEY (permission_id) REFERENCES m_permission (id) ON UPDATE CASCADE ON DELETE RESTRICT;