﻿CREATE OR REPLACE FUNCTION STUD11.REGION_NAME(V_LAST_NAME IN VARCHAR2)
  RETURN VARCHAR2
  AS
    V_RES VARCHAR2(20);
    V_TEST NUMBER;
  BEGIN
    SELECT COUNT(LAST_NAME)
    INTO V_TEST 
    FROM S_EMP 
    WHERE LAST_NAME = V_LAST_NAME;

    IF(V_TEST != 0) THEN
      SELECT S_REGION.NAME
      INTO V_RES
      FROM S_REGION, S_DEPT, S_EMP  
      WHERE S_REGION.ID = S_DEPT.REGION_ID AND S_DEPT.ID = S_EMP.DEPT_ID AND S_EMP.LAST_NAME = V_LAST_NAME;

    ELSE
      V_RES := '0';
    END IF;

    RETURN V_RES;
  END;