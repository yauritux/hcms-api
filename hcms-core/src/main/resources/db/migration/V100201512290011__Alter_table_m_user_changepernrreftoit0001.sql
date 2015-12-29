ALTER TABLE m_user DROP CONSTRAINT m_user_pernr_fkey;

ALTER TABLE m_user ADD FOREIGN KEY (pernr, endda, begda) REFERENCES IT0001 (pernr, endda, begda) ON UPDATE CASCADE ON DELETE RESTRICT;

