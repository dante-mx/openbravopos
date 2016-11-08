--USER POS
--DROP USER OB_ADM CASCADE;
--DROP ROLE ROLE_OB_ADM;
--DROP PROFILE PROFILE_OB_ADM;

-- TABLESPACES POS
--DROP TABLESPACE OB_DATA INCLUDING CONTENTS AND DATAFILES;
--DROP TABLESPACE OB_INDEX INCLUDING CONTENTS AND DATAFILES;
--DROP TABLESPACE OB_DATA_HISTORIC INCLUDING CONTENTS AND DATAFILES;
--DROP TABLESPACE OB_INDEX_HISTORIC INCLUDING CONTENTS AND DATAFILES;

--USER PORTAL
--DROP USER PO_ADM CASCADE;
--DROP ROLE ROLE_PO_ADM;
--DROP PROFILE PROFILE_PO_ADM;

--TABLESPACES PORTAL
--DROP TABLESPACE PO_DATA INCLUDING CONTENTS AND DATAFILES;
--DROP TABLESPACE PO_INDEX INCLUDING CONTENTS AND DATAFILES;
--DROP TABLESPACE PO_DATA_HISTORIC INCLUDING CONTENTS AND DATAFILES;
--DROP TABLESPACE PO_INDEX_HISTORIC INCLUDING CONTENTS AND DATAFILES;


DROP USER POS_ADM CASCADE;
DROP ROLE ROLE_POS_ADM;
DROP PROFILE PROFILE_POS_ADM;
