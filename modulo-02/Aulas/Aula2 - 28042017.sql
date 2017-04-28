select * from empregado;
--count, max, min, distinct

select count(1) as totalEmpregados
from empregado;

select count(*)
from Empregado;

select distinct cargo from Empregado;

select	count(1) TotalEmpregados,
		count(distinct Cargo) CargosDistintos,
		min(salario) menorSalario,
		max(salario) maiorSalario,
		sum(salario) totalSalarios,
		sum(comissao) totalComissao
from empregado;

select	idEmpregado, salario, comissao,
		salario + isnull(comissao, 0) as totalMensal
from empregado;

 
select iddepartamento,
		count(1) as totalEmpregado
from empregado
group by iddepartamento;

select	cargo,
		count(1) as totalEmpregado
from Empregado
group by cargo;

select cargo, count(1) as total
from empregado
group by cargo
having count(1) > 0;


-- 
select convert(date, '12/05/2017' , 103);
--

select nomeEmpregado,
		dataAdmissao,
		DateDiff(Year, DataAdmissao, getdate()) AnoTrabalho
from empregado;

select	nome, 
		replace(replace(Nome, 'ção','cion'), 'sao','san') NomeCidade,
		UF
from cidade;


select	idAssociado,
		nome,
		case when sexo = 'F' then 'Feminino'
			 when sexo = 'M' then 'Masculino'
			 else 'sei lá'
		end
from Associado