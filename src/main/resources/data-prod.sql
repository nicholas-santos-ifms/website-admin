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

INSERT INTO empresa (id, nome, celular, cnpj, email, missao, sobre, telefone, valores, visao) VALUES
(1, 'Braseiro Lingui�as Gourmet', '(67) 99826-6778', '06931767000110', 'braseiroatacadista@gmail.com', 'missao 1', 'sobre 1', '(67) 99826-6778', 'valores 1', 'vis�o 1'),
(2, 'Puro Queijo', '(67) 9 9845-7291', '46497651000130', 'puroqueijo@outlook.com.br', 'missao 1', 'sobre 1', '(67) 3461-4602', 'valores 1', 'vis�o 1'),
(3, 'Produtos Hiper Caseiros', '(67) 3461-1702', '09653404000159', 'produtoshipercaseiros@sememail.com', 'missao 1', 'sobre 1', '(67) 3461-1702', 'valores 1', 'vis�o 1');

ALTER SEQUENCE empresa_sequence RESTART WITH 4;

INSERT INTO produto (id, nome, ativo, descricao, empresa_id) VALUES
(1, 'Produto 1', true, 'Teste do produto 1', 1),
(2, 'Produto 2', true, 'Teste do produto 2', 1),
(3, 'Produto 3', true, 'Teste do produto 3', 1),
(4, 'Produto 4', true, 'Teste do produto 4', 1),
(5, 'Produto 5', true, 'Teste do produto 5', 1),
(6, 'Produto 1', true, 'Teste do produto 1', 2),
(7, 'Produto 2', true, 'Teste do produto 2', 2),
(8, 'Produto 3', true, 'Teste do produto 3', 2),
(9, 'Produto 4', true, 'Teste do produto 4', 2),
(10, 'Produto 5', true, 'Teste do produto 5', 2),
(11, 'Produto 1', true, 'Teste do produto 1', 3),
(12, 'Produto 2', true, 'Teste do produto 2', 3),
(13, 'Produto 3', true, 'Teste do produto 3', 3),
(14, 'Produto 4', true, 'Teste do produto 4', 3),
(15, 'Produto 5', true, 'Teste do produto 5', 3);

ALTER SEQUENCE produto_sequence RESTART WITH 6;

INSERT INTO PAIS(id, nome) VALUES 
(1, 'Brasil'),
(2, 'Argentina'),
(3, 'Bol�via'),
(4, 'Chile'),
(5, 'Paraguai'),
(6, 'Venezuela');

-- SELECT setval('pais_sequence', 6, true);
ALTER SEQUENCE pais_sequence RESTART WITH 7;

INSERT INTO UF(id, nome, sigla, pais_id) VALUES
(1, 'Acre', 'AC', 1),
(2, 'Alagoas', 'AL', 1),
(3, 'Amap�', 'AP', 1),
(4, 'Amazonas', 'AM', 1),
(5, 'Bahia', 'BA', 1),
(6, 'Cear�', 'CE', 1),
(7, 'Distrito Federal', 'DF', 1),
(8, 'Esp�rito Santo', 'ES', 1),
(9, 'Goi�s', 'GO', 1),
(10, 'Maranh�o', 'MA', 1),
(11, 'Mato Grosso', 'MT', 1),
(12, 'Mato Grosso do Sul', 'MS', 1),
(13, 'Minas Gerais', 'MG', 1),
(14, 'Par�', 'PA', 1),
(15, 'Para�ba', 'PB', 1),
(16, 'Paran�', 'PR', 1),
(17, 'Pernambuco', 'PE', 1),
(18, 'Piau�', 'PI', 1),
(19, 'Rio de Janeiro', 'RJ', 1),
(20, 'Rio Grande do Norte', 'RN', 1),
(21, 'Rio Grande do Sul', 'RS', 1),
(22, 'Rond�nia', 'RO', 1),
(23, 'Roraima', 'RR', 1),
(24, 'Santa Catarina', 'SC', 1),
(25, 'S�o Paulo', 'SP', 1),
(26, 'Sergipe', 'SE', 1),
(27, 'Tocantins', 'TO', 1);

INSERT INTO cidade (id, nome, uf_id) VALUES (1, '�gua Boa (Rochedo)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (2, '�gua Clara', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (3, 'Albuquerque (Corumb�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (4, 'Alcin�polis', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (5, 'Alto Sucuri� (Para�so das �guas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (6, 'Amamba�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (7, 'Amandina (Ivinhema)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (8, 'Amolar (Corumb�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (9, 'Anast�cio', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (10, 'Anauril�ndia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (11, 'Ang�lica', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (12, 'Anhandui (Campo Grande)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (13, 'Ant�nio Jo�o', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (14, 'Aparecida do Taboado', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (15, 'Aquidauana', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (16, 'Aral Moreira', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (17, 'Arapu� (Tr�s Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (18, 'Areado (S�o Gabriel do Oeste)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (19, '�rvore Grande (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (20, 'Baian�polis (Corguinho)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (21, 'B�lsamo (Ribas do Rio Pardo)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (22, 'Bandeirantes', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (23, 'Bataguassu', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (24, 'Bataypor�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (25, 'Ba�s (Costa Rica)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (26, 'Bela Alvorada (Para�so das �guas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (27, 'Bela Vista', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (28, 'Bocaj� (Douradina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (29, 'Bocaj� (Laguna Carap�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (30, 'Bodoquena', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (31, 'Bom Fim (Jaraguari)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (32, 'Bonito', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (33, 'Boqueir�o (Jardim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (34, 'Brasil�ndia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (35, 'Caarap�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (36, 'Cabeceira do Ap� (Ponta Por�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (37, 'Cachoeira (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (38, 'Camapu�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (39, 'Camis�o (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (40, 'Campestre (Ant�nio Jo�o)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (41, 'Campo Grande', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (42, 'Cap�o Seco (Sidrol�ndia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (43, 'Caracol', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (44, 'Carumb� (Itapor�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (45, 'Cassil�ndia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (46, 'Chapad�o do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (47, 'Cipol�ndia (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (48, 'Coimbra (Corumb�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (49, 'Congonhas (Bandeirantes)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (50, 'Corguinho', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (51, 'Coronel Sapucaia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (52, 'Corumb�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (53, 'Costa Rica', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (54, 'Coxim', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (55, 'Cristalina (Caarap�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (56, 'Cruzaltina (Douradina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (57, 'Culturama (F�tima do Sul)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (58, 'Cupins (Aparecida do Taboado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (59, 'Debrasa (Brasil�ndia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (60, 'Deod�polis', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (61, 'Dois Irm�os do Buriti', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (62, 'Douradina', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (63, 'Dourados', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (64, 'Eldorado', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (65, 'F�tima do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (66, 'Figueir�o', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (67, 'Garcias (Tr�s Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (68, 'Gl�ria de Dourados', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (69, 'Gua�u (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (70, 'Gua�ul�ndia (Gl�ria de Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (71, 'Guadalupe do Alto Paran� (Tr�s Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (72, 'Guia Lopes da Laguna', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (73, 'Iguatemi', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (74, 'Ilha Comprida (Tr�s Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (75, 'Ilha Grande (Aparecida do Taboado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (76, 'Indai� do Sul (Cassil�ndia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (77, 'Indai� Grande (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (78, 'Ind�polis (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (79, 'Inoc�ncia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (80, 'Ipezal (Ang�lica)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (81, 'Itahum (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (82, 'Itapor�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (83, 'Itaquira�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (84, 'Ivinhema', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (85, 'Jacare� (Japor�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (86, 'Japor�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (87, 'Jaraguari', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (88, 'Jardim', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (89, 'Jate�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (90, 'Jauru (Coxim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (91, 'Juscel�ndia (Rio Verde de Mato Grosso)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (92, 'Jut�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (93, 'Lad�rio', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (94, 'Lagoa Bonita (Deod�polis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (95, 'Laguna Carap�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (96, 'Maracaju', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (97, 'Miranda', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (98, 'Montese (Itapor�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (99, 'Morangas (Inoc�ncia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (100, 'Morraria do Sul (Bodoquena)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (101, 'Morumbi (Eldorado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (102, 'Mundo Novo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (103, 'Navira�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (104, 'Nhecol�ndia (Corumb�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (105, 'Nioaque', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (106, 'Nossa Senhora de F�tima (Bela Vista)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (107, 'Nova Alvorada do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (108, 'Nova Am�rica (Caarap�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (109, 'Nova Andradina', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (110, 'Nova Casa Verde (Nova Andradina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (111, 'Nova Esperan�a (Jate�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (112, 'Nova Esperan�a (Rio Negro)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (113, 'Nova Jales (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (114, 'Novo Horizonte do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (115, 'Oriente (Aparecida do Taboado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (116, 'Paiagu�s (Corumb�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (117, 'Palmeiras (Dois Irm�os do Buriti)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (118, 'Pana (Nova Alvorada do Sul)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (119, 'Panambi (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (120, 'Para�so das �guas', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (121, 'Parana�ba', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (122, 'Paranhos', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (123, 'Pedro Gomes', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (124, 'Picadinha (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (125, 'Pirapora (Itapor�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (126, 'Piraputanga (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (127, 'Ponta Por�', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (128, 'Ponte Vermelha (S�o Gabriel do Oeste)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (129, 'Pontinha do Cocho (Camapu�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (130, 'Porto Esperan�a (Corumb�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (131, 'Porto Murtinho', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (132, 'Porto Vilma (Deod�polis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (133, 'Porto XV de Novembro (Bataguassu)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (134, 'Presidente Castelo (Deod�polis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (135, 'Prud�ncio Thomaz (Rio Brilhante)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (136, 'Quebra C�co (Sidrol�ndia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (137, 'Quebracho (Anauril�ndia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (138, 'Ribas do Rio Pardo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (139, 'Rio Brilhante', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (140, 'Rio Negro', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (141, 'Rio Verde de Mato Grosso', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (142, 'Rochedinho (Campo Grande)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (143, 'Rochedo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (144, 'Sanga Puit� (Ponta Por�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (145, 'Santa Rita do Pardo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (146, 'Santa Terezinha (Itapor�)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (147, 'S�o Gabriel do Oeste', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (148, 'S�o Jo�o do Apore (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (149, 'S�o Jos� (Vicentina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (150, 'S�o Jos� do Sucuri� (Inoc�ncia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (151, 'S�o Pedro (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (152, 'S�o Pedro (Inoc�ncia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (153, 'S�o Rom�o (Coxim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (154, 'Selv�ria', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (155, 'Sete Quedas', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (156, 'Sidrol�ndia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (157, 'Sonora', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (158, 'Tacuru', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (159, 'Tamandar� (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (160, 'Taquari (Coxim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (161, 'Taquarussu', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (162, 'Taunay (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (163, 'Terenos', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (164, 'Tr�s Lagoas', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (165, 'Velhacaria (Parana�ba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (166, 'Vicentina', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (167, 'Vila Formosa (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (168, 'Vila Marques (Aral Moreira)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (169, 'Vila Rica (Vicentina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (170, 'Vila Uni�o (Deod�polis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (171, 'Vila Vargas (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (172, 'Vista Alegre (Maracaju)', 12);