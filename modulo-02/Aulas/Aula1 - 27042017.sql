--criar tabela
create table Carro (
        placa           varchar(8) ,
        cor             varchar(20),
        marca           varchar(30),
        modelo          varchar(30),
        proprietario    varchar(150),
        email           varchar(100),
        telefone        varchar(100)
    );

--insert into / inserindo registros na tabela carro
insert into Carro 
      (placa, 
       cor, 
       marca,
       modelo,
       proprietario,
       email,
       telefone) 
   values
      ('ABC-3401', 
       'branco',
       'fiat', 
       'palio',
       'carlos da silva', 
       'carlos.silva@company.com', 
       '9987-0102')
	   
-- retornando todos os registros
Select * From Carro;

-- retornando apenas linhas onde o valor da coluna "proprietario" seja igual à 'julia de souza'
Select * 
  From Carro 
 Where proprietario = 'julia de souza';

 --Inserindo os registros
 insert into carro 
   (placa, cor, marca, modelo, proprietario, email, telefone) 
  values 
   ('IAB-0101', 'preto', 'honda', 'civic', 'augusta cavalcante', 'augusta.cavalcante@company.com', '8778-4556');

insert into carro
     (placa, cor, marca, modelo, proprietario, email, telefone) 
   values
     ('IXT-7181', 'cinza', 'volkswagen', 'passat', 'julia de souza', 'julia.souza@company.com', '9660-0669');

-- consulta com filtro
Select modelo, marca, placa
  From Carro 
 Where marca = 'volkswagen';

 -----------------------------------------------------------------------------------------------------

 --criar tabela pais
create table pais
	(idpais int not null,
	nome varchar(50) not null,
	sigla varchar(3),
	constraint pk_pais primary key (idpais) --chave primaria
 );

 --inserindo um país
 insert into pais (idpais, nome, sigla)
 values 2, 'Brazil', 'BRA');

 -- alter table > adicionando coluna
 alter table Pais add DDI varchar(5);

 -- criar sequência
 Create sequence SEQ_PAIS;

 -- dropar/eliminar tabela 
 drop table pais;

 --criar tabela com identity (auto incremento)
 create table Pais
    ( IDPais   int  IDENTITY  not null,
      Nome     varchar(50)    not null,
      Sigla    varchar(3)
    );

--inserindo em tabela que possui identity
insert into pais(nome, sigla)
values ('Brazil','BRA')

-- alterando para adicionar a chave primária
alter table Pais add constraint pk_pais primary key (idPais);

-- criar tabela com chave primaria e chave unica e check 
create table Pais
    ( IDPais   int  IDENTITY  not null,
      Nome     varchar(50)    not null,
      Sigla    varchar(3),
	  Situacao char(1),
	  constraint pf_pais primary key (idpais),
	  constraint uk_pais_nome unique (nome),
	  constraint cc_pais_situacao check (Situacao in ('A','I'))
    );


select * from pais;

insert into pais(nome, sigla, situacao)
values ('Chile','CHL', 'A');

---------------------------------------------------------------------------------------------------------------

Create table Cidade 
(
  IDCidade  int         not null,
  Nome      varchar(30) not null,
  UF        varchar(2)  not null,
    constraint PK_Cidade primary key (IDCidade)
);	

Create table Associado 
(
  IDAssociado    int         not null,
  Nome           varchar(50) not null,
  DataNascimento datetime    not null,
  Sexo           char(1)     not null,
  CPF            varchar(11) ,
  Endereco       varchar(35),
  Bairro         varchar(25),
  Complemento    varchar(20),
  IDCidade       int,
     constraint PK_Associado primary key (IDAssociado),
	 constraint FK_Associado foreign key (IDCidade)
	    references Cidade (IDCidade)
);

insert into Cidade (IDCidade, Nome, UF)
   values (1, 'Sao Leopoldo', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (2, 'Porto Alegre', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (3, 'Parobe', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (4, 'Taquara', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (105, 'São Paulo', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (106, 'Guarulhos', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (27, 'Rio de Janeiro', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (108, 'Brasilia', 'DF');
insert into Cidade (IDCidade, Nome, UF)
   values (109, 'Belo Horizonte', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (110, 'Uberlândia', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (5, 'Cidade de Alagoas', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (6, 'Maceio', 'AL');
insert into Cidade (IDCidade, Nome, UF)
   values (7, 'Itu', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (8, 'Campinas', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (9, 'Guaratingueta', 'SP');
insert into Cidade (IDCidade, Nome, UF)
   values (10, 'Santa Barbara', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (11, 'Campos dos Goitacases', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (12, 'Sao Gabriel', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (13, 'Brasopolis', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (14, 'Cristina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (15, 'Umbuzeiro', 'PB');
insert into Cidade (IDCidade, Nome, UF)
   values (16, 'Vicosa', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (17, 'Macae', 'RJ');
insert into Cidade (IDCidade, Nome, UF)
   values (18, 'Sao Luis', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (19, 'Cuiaba', 'MT');
insert into Cidade (IDCidade, Nome, UF)
   values (20, 'Sao Borja', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (21, 'Natal', 'RN');
insert into Cidade (IDCidade, Nome, UF)
   values (22, 'Diamantina', 'MG');
insert into Cidade (IDCidade, Nome, UF)
   values (23, 'Campo Grande', 'MS');
insert into Cidade (IDCidade, Nome, UF)
   values (24, 'Fortaleza', 'CE');
insert into Cidade (IDCidade, Nome, UF)
   values (25, 'Bage', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (26, 'Bento Goncalves', 'RS');
insert into Cidade (IDCidade, Nome, UF)
   values (28, 'Pinheiro', 'MA');
insert into Cidade (IDCidade, Nome, UF)
   values (29, 'Salvador', 'BA');
insert into Cidade (IDCidade, Nome, UF)
   values (30, 'Garanhuns', 'PE');
Insert into Cidade (IDCidade, Nome, UF)
   values (31, 'São Paulo', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (32, 'Guarulhos', 'SP');    
Insert into Cidade (IDCidade, Nome, UF)
   values (33, 'Rio de Janeiro', 'RJ');    
Insert into Cidade (IDCidade, Nome, UF)
   values (34, 'Brasilia', 'DF');    
Insert into Cidade (IDCidade, Nome, UF)
   values (35, 'Belo Horizonte', 'MG');        
Insert into Cidade (IDCidade, Nome, UF)
   values  (36, 'Uberlândia', 'MG');      
Insert into Cidade (IDCidade, Nome, UF)
   values  (37, 'Santana do Livramento', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (38, 'Santa Maria', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (39, 'Santa Rosa', 'RS');
Insert into Cidade (IDCidade, Nome, UF)
   values  (40, 'São Francisco de Paula', 'RS');    

-- ASSOCIADOS...
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo)
  values 
      (1, 
       'Ana Paula Padrao', 
       convert(datetime, '10/05/1980', 103), 
       'F' );
--
insert into Associado 
      (IDAssociado, 
       Nome, 
       DataNascimento, 
       Sexo)
  values  
      (2, 
       'Joao Soares', 
       convert(datetime, '20/02/1980', 103), 
       'M' );

-- criar tabela com o retorno do select (no caso abaixo com todos os campos devido ao *)
select * into CopiaCidade from cidade;

-- deletar
delete from cidade 
where IDCidade = 1;

-- update: atualizar - lembrar do where
update cidade
set nome = 'Novo Hamburgo'
where IDCidade = 1

