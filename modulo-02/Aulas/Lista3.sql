/*
Datas
Faça uma consulta que liste o total de empregados admitidos no ano de 1980. 
Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão.
*/

select	count(*) as [Total Admitidos em 1980],
		idEmpregado as ID,
		nomeempregado as Nome,
		datediff(year, datanascimento, dataadmissao) AS [Idade no Momento da Admissao]
from empregado 
where dataadmissao between convert(date, '01-01-1980', 103) and convert(date, '31-12-1980', 103)
group by idEmpregado, nomeempregado, datanascimento, dataadmissao;

/*
Ranking
Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. 
** DICA: Pesquise recursos específicos para esta funcionalidade.
*/
select top 1 cargo, count(*) as totalEmpregados
from empregado
group by cargo
order by totalEmpregados desc;
	   
/*
Contagem
Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
*/
select uf, count(idCidade) as totalCidadesExistentes
from cidade
group by uf;

/*
Alterando dados
Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'. 
Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 'Atendente'
devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inovação).
*/

insert into departamento (iddepartamento, nomedepartamento, localizacao)
values (50, 'Inovação','SÃO LEOPOLDO');

update empregado
set iddepartamento = 50
where datepart(month, dataadmissao) = 12 and cargo != 'Atendente';