create table empresa(
 id int primary key not null auto_increment,
 nome varchar(40),
 fantasia varchar(40),
 pessoa varchar(20),
 fone varchar(40),
 rua varchar(40),
 numero varchar(12),
 complemento varchar(40),
 cep varchar(40),
 bairro varchar(40),
 estado int,
 municipio int,
 cnpj varchar(40),
 ie varchar(40),
 tipo_IE varchar(40),
 data_cadastro Date,
 data_atualiza Date,
 situacao int
 )
 
 create table estado(
 id int primary key not null auto_increment,
 nome varchar(40),
 
 )
 
 
   --Criando a referencia da tabela estado na tabela Municipio
   CREATE TABLE municipio
   (
		id INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(45) NOT NULL,
		estado_id INT NOT NULL,
        
	PRIMARY KEY (`id`),
	INDEX id_estado_idx (estado_id ASC),
    CONSTRAINT id_estado FOREIGN KEY (estado_id) REFERENCES estado (id)
    );

-- A foreign key foi excluida - depois um drop na tabela de municiopio e depois executado novamente o script acima
	-- ALTER TABLE `sistema`.`municipio` 
	-- DROP FOREIGN KEY `id_estado`;
	-- ALTER TABLE `sistema`.`municipio` 
	-- DROP INDEX `id_estado_idx` ;
	
    ALTER TABLE empresa ADD FOREIGN KEY (estado_id) REFERENCES estado(id)
    ALTER TABLE empresa ADD FOREIGN KEY (municipio_id) REFERENCES municipio(id)
    
    --Inserção dos estados 
    INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('1', 'Acre');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('2', 'Alagoas');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('3', 'Amapá');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('4', 'Amazonas');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('5', 'Bahia');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('6', 'Ceará');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('7', 'Distrito Federal');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('8', 'Espírito Santo');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('9', 'Góias');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('10', 'Maranhão');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('11', 'Mato Grosso');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('12', 'Mato Grosso do Sul');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('13', 'Minas Gerais');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('14', 'Pará');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('15', 'Paraíba');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('16', 'Paraná');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('17', 'Pernambuco');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('18', 'Piauí');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('19', 'Rio de Janeiro');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('20', 'Rio Grande do Norte');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('21', 'Rio Grande do Sul');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('22', 'Rondônia');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('23', 'Roraima');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('24', 'Santa Catarina');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('25', 'São Paulo');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('26', 'Sergipe');
INSERT INTO `sistema`.`estado` (`id`, `nome`) VALUES ('27', 'Tocantins');


-- Excluindo uma coluna
ALTER TABLE `sistema`.`estado` 
DROP FOREIGN KEY `empresa_id`;
ALTER TABLE `sistema`.`estado` 
DROP COLUMN `empresa`,
DROP INDEX `empresa_id_idx` ;


   