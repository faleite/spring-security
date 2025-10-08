-- Active: 1758978617585@@127.0.0.1@5432@security_db
-- CREATE DATABASE security_db;

SELECT * FROM users;

--------------- DELETE SEGURO -------------------

-- 1. Iniciar transação
BEGIN;

-- 2. Verificar
SELECT * FROM users WHERE name = 'Fabricio';

-- 3. Deletar
DELETE FROM users WHERE name = 'Fabricio';

-- 4. Se estiver correto, confirmar
COMMIT;
-- Ou desfazer se errou
-- ROLLBACK;

------------------------------------------------
