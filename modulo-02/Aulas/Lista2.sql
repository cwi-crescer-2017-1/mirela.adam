/*Ordena��o
Fa�a uma consulta que retorne os empregados em ordem de admiss�o, projetar apenas ID e Nome.*/
select idEmpregado, nomeEmpregado
from empregado
order by DataAdmissao;

/*Filtros
Fa�a uma consulta que liste todos os empregados que n�o recebam comiss�o, deve ser ordenado pelo sal�rio. */
select *
from empregado
where comissao is null
order by salario;

/*C�lculo
Fa�a uma consulta que retorno o nome dos empregados, o sal�rio anual (considere 13 sal�rios), 
projete tamb�m a comiss�o (considere 12x). As colunas que dever�o ser exibidas s�o:
ID do Empregado
Nome
Salario Anual
Comiss�o Anual
Renda Anual'*/

select idEmpregado, nomeempregado, 
		(salario*13) as SalarioAnual, (comissao*12) as ComissaoAnual, 
		((salario*13)+(comissao*12)) as RendaAnual
from empregado;

/*C�lculo e Filtros
Fa�a uma consulta que liste todos os empregados que tenham o sal�rio anual seja inferior a 
R$ 18500 ou que tenham o cargo de Atendente. Projetar as seguintes colunas:
ID do Empregado
Nome
Cargo
Sal�rio Mensal*/

select idEmpregado, nomeEmpregado, cargo, salario
from empregado
where salario*13 < 18500 
or cargo like 'Atendente';


	   


