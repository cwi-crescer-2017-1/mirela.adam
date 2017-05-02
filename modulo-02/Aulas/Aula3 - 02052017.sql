/*
INNER JOIN: mais comum. 
Deve existir nas duas tabelas para ser exibido 
Exemplo abaixo existe dois associados, porém um possui idcidade nulo portanto não é exibido.
*/
select a.nome, c.idCidade
from associado a 
inner join cidade c on c.IDCidade = a.IDCidade;

--ou (outra forma)

select a.nome, c.idCidade, c.nome
from associado a, cidade c
where c.idcidade = a.IDCidade;


/*
LEFT JOIN: 
Exibe todos os registros da tabela da esquerda, mesmo que não possua referência com a tabela da direita
*/ 
select a.nome, c.idCidade
from associado a 
left join cidade c on c.IDCidade = a.IDCidade;

/*
RIGHT JOIN:
Exibe todos os registros da tabela da direita, mesmo que não esteja referenciado com a tabela da esquerda.
*/
select a.nome, c.idCidade
from associado a 
right join cidade c on c.IDCidade = a.IDCidade;

/*
SELF JOIN:
Referenciar com a própria tabela.
No exemplo temos um select para exibir o nome do gerente de cada empregado, 
considerando que o gerente também é um empregado.
*/
select emp.idempregado, emp.nomeempregado, emp.idgerente, ger.NomeEmpregado as nomeGerente
from empregado emp
left join empregado ger
on emp.IDGerente = ger.idgerente

/*
SUBQUERIES - EXISTS (com join):
No exemplo, percorre todas as cidades e verifica se existe pelo menos um associado vinculado a elas.
Se existe, retorna ID e Nome da cidade.
*/
select idcidade, nome
from cidade e 
where exists (	select 1
				from associado a
				where a.IDCidade = e.IDCidade
			 );

/*
SUBQUERIES (sem join):
Mesmo retorno do acima, porém com implementação mais simples.
Lembrando que a subquerie vai retornar a quantidade de linhas da tabela, diferente do exist que pode
ter performance melhor.
*/
select idcidade, nome
from cidade e
where idcidade in ( select idcidade
					from associado
				  );

/*SUBQUERIES NO SELECT E NO FROM*/

SELECT NOME, (	SELECT NOME 
				FROM CIDADE C 
				WHERE C.IDCIDADE = A.IDCIDADE
			 ) AS NOMECIDADE 
FROM ASSOCIADO A;

SELECT A.NOME, CITY.NOME AS NOMECIDADE
FROM ASSOCIADO A
INNER JOIN (SELECT IDCIDADE, (NOME + '-' + UF) AS NOME
			FROM CIDADE
			WHERE UF IN ('SC','PR','RS') ) AS CITY
ON CITY.IDCIDADE = A.IDCIDADE;

/*UNION - UNION ALL*/
--junta os dois resultados
select nome
from associado
union all
select nomeempregado
from empregado;

--ordena
select nome
from associado
union 
select nomeempregado
from empregado;

