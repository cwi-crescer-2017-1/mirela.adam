/* 1
Múltiplos acessos
Liste o nome do empregado, o nome do gerente e o departamento de cada um.
*/

select e.nomeempregado, g.nomeempregado as NomeGerente, d.nomeDepartamento
from empregado e
left join empregado g 
on e.IDGerente = g.idempregado
left join departamento d
on e.iddepartamento = d.iddepartamento

/* 2
Maior Salário
Liste o deparamento (id e nome) com o empregado de maior salário.
*/

select top 1 e.iddepartamento, d.NomeDepartamento
from empregado e
inner join departamento d
on e.IDDepartamento = d.IDDepartamento
order by e.salario desc

select distinct d.iddepartamento, d.nomedepartamento
from empregado e
inner join departamento d on e.iddepartamento = d.iddepartamento
where e.salario = ( select max(c.salario)
					from empregado c
					where c.iddepartamento is not null )

/*
Reajuste salarial
Aplique uma alteração salarial em todos os empregados que o departamento fique na 
localidade de SAO PAULO, este reajuste deve ser de 17,3%. 
Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.
*/
select * 
into EmpregadoAux 
from Empregado;

select * from empregado

update empregado
set salario = salario + (salario*0.173)
where	iddepartamento in (select iddepartamento  
					      from departamento
						  where localizacao='SAO PAULO'
						  )

/*
Cidades duplicadas
Liste todas as cidades duplicadas (nome e UF iguais).
*/

select c.nome, c.uf
from cidade c
	inner join cidade c1
	on c.nome = c1.nome and c.uf = c1.uf
group by c.nome, c.uf
having count(*) > 1
order by c.nome, c.uf;

/*
Definindo Cidades
Faça uma alteração nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. 
Mas atenção! apenas a cidade com maior ID deve ser alterada.

Explicação adicional - VIEW
Para reaproveitar uma consulta SQL um dos recursos oferecidos é a criação de VIEWS. 
Neste recurso o comando SQL é salvo no dicionário de dados do SGBD e pode ser reutilizado novamente.
Um exemplo disso seria uma consulta que retorna apenas as cidades do RS.

Create view vwCidades_Gauchas as
   Select IDCidade,
          Nome
   From   Cidade
   Where  UF = 'RS';

Para utilizar esta consulta ela deve ser referenciada no FROM como se fosse uma fonte de dados qualquer:
Select IDCidade, 
       Nome 
  From vwCidades_Gauchas;
*/
update cidade
set nome = nome + ' *'
where idcidade in (select max(c.IDCidade)
				   from cidade c
					inner join cidade c1
					on c.nome = c1.nome and c.uf = c1.uf
			       group by c.nome, c.uf
				   having count(*) > 1);			
	