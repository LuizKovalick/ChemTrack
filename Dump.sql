-- Rodar queries na ordem em que aparecem.
CREATE DATABASE chemtrack;

USE chemtrack;

CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo ENUM('ALUNO', 'PROFESSOR') NOT NULL,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE conteudo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    autor_id BIGINT,
    titulo VARCHAR(255) NOT NULL,
    texto TEXT,
    url_pdf VARCHAR(255),
    url_video VARCHAR(255),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);

CREATE TABLE exercicio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pergunta VARCHAR(255) NOT NULL,
    pontos INT,
    alternativa_1 VARCHAR(255),
    alternativa_2 VARCHAR(255),
    alternativa_3 VARCHAR(255),
    alternativa_correta VARCHAR(255) NOT NULL,
    conteudo_id BIGINT,
    FOREIGN KEY (conteudo_id) REFERENCES conteudo(id)
);

CREATE TABLE resposta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    exercicio_id BIGINT,
    resposta_dada VARCHAR(255),
    acertou BOOLEAN,
    respondido_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (exercicio_id) REFERENCES exercicio(id)
);

CREATE TABLE pontuacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT UNIQUE,
    pontos INT DEFAULT 0,
    nivel INT DEFAULT 0,
    atualizado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

CREATE TABLE insignia (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    icone_url VARCHAR(255),
    criada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE insignia_conquistada (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    insignia_id BIGINT,
    data_conquista DATE NOT NULL,
    UNIQUE KEY uq_usuario_insignia (usuario_id, insignia_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (insignia_id) REFERENCES insignia(id)
);

-- Conteúdo contento vídeo.
INSERT INTO conteudo (titulo, texto, url_pdf, url_video) VALUES 
('Haber-Bosch', 'O processo Haber-Bosch é o principal método de produção de amônia a partir de nitrogênio e hidrogênio. A amônia produzida, utilizada principalmente como fertilizante, é atualmente responsável por aproximadamente 1,8% das emissões globais de dióxido de carbono ( The Royal Society, 2020 ).', NULL, 'https://www.youtube.com/watch?v=OxnX2izLbY8');

-- Conteúdo contento pdf.
INSERT INTO conteudo (titulo, texto, url_pdf, url_video) VALUES 
('Química 1', 'Introdução à química.', 'https://educapes.capes.gov.br/bitstream/capes/552911/2/Livro%20Introducao%20a%20Quimica.pdf', NULL);

-- Exercício/Desafios
INSERT INTO exercicio (pergunta, pontos, alternativa_1, alternativa_2, alternativa_3, alternativa_correta) VALUES
('Qual o símbolo químico da água?', 10, 'O', 'C', 'He', 'H2O');

INSERT INTO exercicio (pergunta, pontos, alternativa_1, alternativa_2, alternativa_3, alternativa_correta) VALUES
('Qual o símbolo químico do Hélio?', 10, 'O', 'C', 'H2O', 'He');

INSERT INTO exercicio (pergunta, pontos, alternativa_1, alternativa_2, alternativa_3, alternativa_correta) VALUES
('Qual elemento foi sintetizado pelo método de Haber-Bosch?', '20', 'Álcool', 'Acetona', 'Carbono', 'Amônia');
