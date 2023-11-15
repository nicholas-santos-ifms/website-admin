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
(1, 'Braseiro Linguiças Gourmet', '(67) 99826-6778', '06931767000110', 'braseiroatacadista@gmail.com', 'missao 1', 'sobre 1', '(67) 99826-6778', 'valores 1', 'visão 1'),
(2, 'Puro Queijo', '(67) 9 9845-7291', '46497651000130', 'puroqueijo@outlook.com.br', 'missao 1', 'sobre 1', '(67) 3461-4602', 'valores 1', 'visão 1'),
(3, 'Produtos Hiper Caseiros', '(67) 3461-1702', '09653404000159', 'produtoshipercaseiros@sememail.com', 'missao 1', 'sobre 1', '(67) 3461-1702', 'valores 1', 'visão 1');

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
(3, 'Bolívia'),
(4, 'Chile'),
(5, 'Paraguai'),
(6, 'Venezuela');

-- SELECT setval('pais_sequence', 6, true);
ALTER SEQUENCE pais_sequence RESTART WITH 7;

INSERT INTO UF(id, nome, sigla, pais_id) VALUES
(1, 'Acre', 'AC', 1),
(2, 'Alagoas', 'AL', 1),
(3, 'Amapá', 'AP', 1),
(4, 'Amazonas', 'AM', 1),
(5, 'Bahia', 'BA', 1),
(6, 'Ceará', 'CE', 1),
(7, 'Distrito Federal', 'DF', 1),
(8, 'Espírito Santo', 'ES', 1),
(9, 'Goiás', 'GO', 1),
(10, 'Maranhão', 'MA', 1),
(11, 'Mato Grosso', 'MT', 1),
(12, 'Mato Grosso do Sul', 'MS', 1),
(13, 'Minas Gerais', 'MG', 1),
(14, 'Pará', 'PA', 1),
(15, 'Paraíba', 'PB', 1),
(16, 'Paraná', 'PR', 1),
(17, 'Pernambuco', 'PE', 1),
(18, 'Piauí', 'PI', 1),
(19, 'Rio de Janeiro', 'RJ', 1),
(20, 'Rio Grande do Norte', 'RN', 1),
(21, 'Rio Grande do Sul', 'RS', 1),
(22, 'Rondônia', 'RO', 1),
(23, 'Roraima', 'RR', 1),
(24, 'Santa Catarina', 'SC', 1),
(25, 'São Paulo', 'SP', 1),
(26, 'Sergipe', 'SE', 1),
(27, 'Tocantins', 'TO', 1);

INSERT INTO cidade (id, nome, uf_id) VALUES (1, 'Água Boa (Rochedo)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (2, 'Água Clara', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (3, 'Albuquerque (Corumbá)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (4, 'Alcinópolis', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (5, 'Alto Sucuriú (Paraíso das Águas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (6, 'Amambaí', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (7, 'Amandina (Ivinhema)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (8, 'Amolar (Corumbá)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (9, 'Anastácio', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (10, 'Anaurilândia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (11, 'Angélica', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (12, 'Anhandui (Campo Grande)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (13, 'Antônio João', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (14, 'Aparecida do Taboado', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (15, 'Aquidauana', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (16, 'Aral Moreira', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (17, 'Arapuã (Três Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (18, 'Areado (São Gabriel do Oeste)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (19, 'Árvore Grande (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (20, 'Baianópolis (Corguinho)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (21, 'Bálsamo (Ribas do Rio Pardo)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (22, 'Bandeirantes', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (23, 'Bataguassu', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (24, 'Batayporã', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (25, 'Baús (Costa Rica)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (26, 'Bela Alvorada (Paraíso das Águas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (27, 'Bela Vista', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (28, 'Bocajá (Douradina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (29, 'Bocajá (Laguna Carapã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (30, 'Bodoquena', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (31, 'Bom Fim (Jaraguari)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (32, 'Bonito', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (33, 'Boqueirão (Jardim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (34, 'Brasilândia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (35, 'Caarapó', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (36, 'Cabeceira do Apá (Ponta Porã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (37, 'Cachoeira (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (38, 'Camapuã', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (39, 'Camisão (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (40, 'Campestre (Antônio João)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (41, 'Campo Grande', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (42, 'Capão Seco (Sidrolândia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (43, 'Caracol', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (44, 'Carumbé (Itaporã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (45, 'Cassilândia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (46, 'Chapadão do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (47, 'Cipolândia (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (48, 'Coimbra (Corumbá)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (49, 'Congonhas (Bandeirantes)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (50, 'Corguinho', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (51, 'Coronel Sapucaia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (52, 'Corumbá', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (53, 'Costa Rica', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (54, 'Coxim', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (55, 'Cristalina (Caarapó)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (56, 'Cruzaltina (Douradina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (57, 'Culturama (Fátima do Sul)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (58, 'Cupins (Aparecida do Taboado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (59, 'Debrasa (Brasilândia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (60, 'Deodápolis', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (61, 'Dois Irmãos do Buriti', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (62, 'Douradina', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (63, 'Dourados', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (64, 'Eldorado', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (65, 'Fátima do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (66, 'Figueirão', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (67, 'Garcias (Três Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (68, 'Glória de Dourados', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (69, 'Guaçu (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (70, 'Guaçulândia (Glória de Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (71, 'Guadalupe do Alto Paraná (Três Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (72, 'Guia Lopes da Laguna', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (73, 'Iguatemi', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (74, 'Ilha Comprida (Três Lagoas)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (75, 'Ilha Grande (Aparecida do Taboado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (76, 'Indaiá do Sul (Cassilândia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (77, 'Indaiá Grande (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (78, 'Indápolis (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (79, 'Inocência', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (80, 'Ipezal (Angélica)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (81, 'Itahum (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (82, 'Itaporã', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (83, 'Itaquiraí', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (84, 'Ivinhema', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (85, 'Jacareí (Japorã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (86, 'Japorã', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (87, 'Jaraguari', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (88, 'Jardim', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (89, 'Jateí', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (90, 'Jauru (Coxim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (91, 'Juscelândia (Rio Verde de Mato Grosso)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (92, 'Jutí', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (93, 'Ladário', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (94, 'Lagoa Bonita (Deodápolis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (95, 'Laguna Carapã', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (96, 'Maracaju', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (97, 'Miranda', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (98, 'Montese (Itaporã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (99, 'Morangas (Inocência)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (100, 'Morraria do Sul (Bodoquena)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (101, 'Morumbi (Eldorado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (102, 'Mundo Novo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (103, 'Naviraí', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (104, 'Nhecolândia (Corumbá)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (105, 'Nioaque', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (106, 'Nossa Senhora de Fátima (Bela Vista)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (107, 'Nova Alvorada do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (108, 'Nova América (Caarapó)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (109, 'Nova Andradina', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (110, 'Nova Casa Verde (Nova Andradina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (111, 'Nova Esperança (Jateí)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (112, 'Nova Esperança (Rio Negro)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (113, 'Nova Jales (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (114, 'Novo Horizonte do Sul', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (115, 'Oriente (Aparecida do Taboado)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (116, 'Paiaguás (Corumbá)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (117, 'Palmeiras (Dois Irmãos do Buriti)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (118, 'Pana (Nova Alvorada do Sul)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (119, 'Panambi (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (120, 'Paraíso das Águas', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (121, 'Paranaíba', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (122, 'Paranhos', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (123, 'Pedro Gomes', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (124, 'Picadinha (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (125, 'Pirapora (Itaporã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (126, 'Piraputanga (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (127, 'Ponta Porã', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (128, 'Ponte Vermelha (São Gabriel do Oeste)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (129, 'Pontinha do Cocho (Camapuã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (130, 'Porto Esperança (Corumbá)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (131, 'Porto Murtinho', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (132, 'Porto Vilma (Deodápolis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (133, 'Porto XV de Novembro (Bataguassu)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (134, 'Presidente Castelo (Deodápolis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (135, 'Prudêncio Thomaz (Rio Brilhante)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (136, 'Quebra Côco (Sidrolândia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (137, 'Quebracho (Anaurilândia)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (138, 'Ribas do Rio Pardo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (139, 'Rio Brilhante', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (140, 'Rio Negro', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (141, 'Rio Verde de Mato Grosso', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (142, 'Rochedinho (Campo Grande)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (143, 'Rochedo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (144, 'Sanga Puitã (Ponta Porã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (145, 'Santa Rita do Pardo', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (146, 'Santa Terezinha (Itaporã)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (147, 'São Gabriel do Oeste', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (148, 'São João do Apore (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (149, 'São José (Vicentina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (150, 'São José do Sucuriú (Inocência)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (151, 'São Pedro (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (152, 'São Pedro (Inocência)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (153, 'São Romão (Coxim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (154, 'Selvíria', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (155, 'Sete Quedas', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (156, 'Sidrolândia', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (157, 'Sonora', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (158, 'Tacuru', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (159, 'Tamandaré (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (160, 'Taquari (Coxim)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (161, 'Taquarussu', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (162, 'Taunay (Aquidauana)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (163, 'Terenos', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (164, 'Três Lagoas', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (165, 'Velhacaria (Paranaíba)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (166, 'Vicentina', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (167, 'Vila Formosa (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (168, 'Vila Marques (Aral Moreira)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (169, 'Vila Rica (Vicentina)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (170, 'Vila União (Deodápolis)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (171, 'Vila Vargas (Dourados)', 12);
INSERT INTO cidade (id, nome, uf_id) VALUES (172, 'Vista Alegre (Maracaju)', 12);