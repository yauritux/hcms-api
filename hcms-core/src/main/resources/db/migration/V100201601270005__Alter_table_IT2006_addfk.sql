ALTER TABLE IT2006 ADD FOREIGN KEY (subty) REFERENCES T591S (subty) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE IT2006 ADD FOREIGN KEY (ktart) REFERENCES T556B (ktart) ON UPDATE CASCADE ON DELETE RESTRICT;