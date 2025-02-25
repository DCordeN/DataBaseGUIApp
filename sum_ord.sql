﻿CREATE OR REPLACE FUNCTION STUD11.SUM_ORD(V_NAME IN VARCHAR2)
  RETURN NUMBER
  AS
    V_TEST NUMBER;
    V_RES NUMBER;
  BEGIN
    SELECT COUNT(*)
    INTO V_TEST
    FROM S_CUSTOMER
    WHERE NAME = V_NAME;

    IF(V_TEST != 0) THEN
      SELECT SUM(TOTAL)
      INTO V_RES
      FROM S_ORD, S_CUSTOMER 
      WHERE S_ORD.CUSTOMER_ID = S_CUSTOMER.ID AND S_CUSTOMER.NAME = V_NAME;
    ELSE
      V_RES := 0;
    END IF;

    RETURN V_RES;
  END;