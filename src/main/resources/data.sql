/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  nicho
 * Created: 20 de jul. de 2023
 */

-- Dados para producao --

INSERT INTO perfil (id, nome, created_at) VALUES
(1, 'ROLE_ADMIN', now()),
(2, 'ROLE_GERENTE', now()),
(3, 'ROLE_COORDENADOR', now()),
(4, 'ROLE_USUARIO', now()),
(5, 'ROLE_AVALIADOR', now()),
(6, 'ROLE_ORIENTADOR', now());

ALTER SEQUENCE perfil_sequence RESTART WITH 7;

-- INSERT INTO usuario (id, nome, email, instituicao_id, enabled, senha, status, cpf, sexo) VALUES 
-- (1, 'admin', 'admin@email.com', 1, true, '$2a$10$kU/CPhvynDqdPEqllCeBZurLhdWWAV909b9IhYP15Z6Db1E4V6l3W', 'ATIVO', '90593711513', 'MASCULINO'), 
-- (2, 'gerente-nv', 'gerente.nv@email.com', 1, true, '$2a$10$kU/CPhvynDqdPEqllCeBZurLhdWWAV909b9IhYP15Z6Db1E4V6l3W', 'ATIVO', '18529627555', 'MASCULINO');
-- 
-- ALTER SEQUENCE usuario_sequence RESTART WITH 2;

INSERT INTO produto (id, nome, ativo, descricao) VALUES
(1, 'Produto 1', true, 'Teste do produto 1'),
(2, 'Produto 2', true, 'Teste do produto 1'),
(3, 'Produto 3', true, 'Teste do produto 1'),
(4, 'Produto 4', true, 'Teste do produto 1'),
(5, 'Produto 5', true, 'Teste do produto 1');

ALTER SEQUENCE produto_sequence RESTART WITH 6;