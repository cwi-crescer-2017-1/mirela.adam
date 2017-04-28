/*Ordenação
Faça uma consulta que retorne os empregados em ordem de admissão, projetar apenas ID e Nome.*/
select idEmpregado, nomeEmpregado
from empregado
order by DataAdmissao;

/*Filtros
Faça uma consulta que liste todos os empregados que não recebam comissão, deve ser ordenado pelo salário. */
select *
from empregado
where comissao is null
order by salario;

/*Cálculo
Faça uma consulta que retorno o nome dos empregados, o salário anual (considere 13 salários), 
projete também a comissão (considere 12x). As colunas que deverão ser exibidas são:
ID do Empregado
Nome
Salario Anual
Comissão Anual
Renda Anual'*/

select idEmpregado, nomeempregado, 
		(salario*13) as SalarioAnual, (comissao*12) as ComissaoAnual, 
		((salario*13)+(comissao*12)) as RendaAnual
from empregado;

/*Cálculo e Filtros
Faça uma consulta que liste todos os empregados que tenham o salário anual seja inferior a 
R$ 18500 ou que tenham o cargo de Atendente. Projetar as seguintes colunas:
ID do Empregado
Nome
Cargo
Salário Mensal*/

select idEmpregado, nomeEmpregado, cargo, salario
from empregado
where salario*13 < 18500 
or cargo like 'Atendente';


	   


