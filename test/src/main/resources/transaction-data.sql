INSERT INTO TRANSACTION (reference,iban, creation_date, amount, fee, description) VALUES ('000011', 'ES9820385778983000000001', '2022-12-31 23.59.59', 0.38, 0, 'First test transaction');
INSERT INTO TRANSACTION (reference,iban, creation_date, amount, fee, description) VALUES ('22345A', 'ES9820385778983000000004', '2022-12-31 23.59.59', 1.5, 1, 'Second test transaction');
INSERT INTO TRANSACTION (reference,iban, creation_date, amount, fee, description) VALUES ('32345A', 'ES9820385778983000000003', '2022-12-31 23.59.59', 1000, 500, 'Third test transaction');
INSERT INTO TRANSACTION (reference,iban, creation_date, amount, fee, description) VALUES ('42345A', 'ES9820385778983000000004', '2022-12-31 23.59.59', 9999999, 100, 'Fourth test transaction');
INSERT INTO TRANSACTION (reference, iban, creation_date, amount, fee, description) VALUES ('12345A', 'ES9820385778983000000003', '2022-12-31 23.59.59', 12121212, 9999, 'Fifth test transaction');
INSERT INTO TRANSACTION (reference, iban, creation_date, amount, fee, description) VALUES ('12345B', 'ES9820385778983000000003', '2022-12-31 23.59.59', 100, 60, 'Sixth test transaction, today, calculated date in test');
INSERT INTO TRANSACTION (reference, iban, creation_date, amount, fee, description) VALUES ('12345D', 'ES9820385778983000000006', '2050-12-31 23.59.59', 500, 100, 'Sixth test transaction, future');
INSERT INTO TRANSACTION (reference, iban, creation_date, amount, fee, description) VALUES ('12345E', 'ES9820385778983000000006', '2000-12-31 23.59.59', 300, 250, 'Sixth test transaction, past');