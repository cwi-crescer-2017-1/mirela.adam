/* 1
Datas
Liste todos os projetos que tiveram atrasos no in�cio da obra, exibir tamb�m o tempo previsto (em meses),
e o tempo realizado (em meses) para a conclus�o da obra.
*/
select	projeto,
		datediff(month, data_inicio_prev, data_fim_prev) as tempoPrevisto, 
		datediff(month, data_inicio_real, data_fim_real) as tempoRealizado
from licitacao
where data_inicio_real > data_inicio_prev;

/* 2
Ranking
Liste as TOP 10 empresas que tiveram maior faturamento, deve ser projetado tamb�m o valor m�dio por profissional.
Por exemplo:
Empresa	        Total Faturamento R$	Valor M�dio por Profissional
ABC Construcoes	    11,976,510.00	              48,426.81
*/

select distinct top 10	empresa_licitante,
						sum(valor_realizado) as TotalFaturamento,
						sum(valor_realizado) / sum(profissionais) as SalarioMedio
from licitacao
group by empresa_licitante
order by totalFaturamento desc;

/* 3
TOP Cidades
Liste as TOP 10 cidades com maior arreca��o de impostos.
*/
select top 10	municipio
from licitacao
group by municipio
order by sum(imposto_municipal) desc;

/* 4
Finais de semana
Liste todos os projetos que tiveram a data de in�cio (real) ocorrendo em finais de semana (s�bado ou domingo).
*/
select projeto
from licitacao
where DATEPART(DW, data_inicio_real) in (1,7);

/* 5
Empresas com sorte
Liste todas as empresas que tiveram (ou ter�o) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
*/
select empresa_licitante
from licitacao 
group by empresa_licitante, faturamento_1ano_anterior
having sum(valor_previsto) > faturamento_1ano_anterior * 0.5
order by empresa_licitante;

/* 6
Custo real
Liste os projetos exibindo o custo real do projeto. 
Caso o projeto seja de esfera federal deve ser descontado o imposto federal, e assim respectivamente para as esferas estaduais e municipais.
*/
select projeto, custoreal = case esfera 
								when 'Federal'   then valor_realizado - imposto_federal
								when 'Estadual'  then valor_realizado - imposto_estadual
								when 'Municipal' then valor_realizado - imposto_municipal
							end
from licitacao;

/* 7
Investiga��o
O projeto 17255 foi suspenso, o motivo foi o elevado custo para o or�amento anual do munic�pio. 
A partir de uma investiga��o mais detalhada foi visto que esse motivo n�o era a verdadeira raz�o. 
Explique por que este motivo n�o � v�lido apresentando uma consulta com dados.
*/

select	empresa_licitante, 
		convert(numeric(10,2), faturamento_1ano_anterior - faturamento_2ano_anterior) as diferencaFaturamentoEmUmAno, 
		convert(numeric(10,2) , lance_2Colocado - valor_previsto) as diferencaEntreLances
from licitacao 
where identificador='17255';
--diferen�a de faturamento de um ano para o outro � superior a 34,5 milh�es.
--diferen�a do segundo lance para o valor realizado � superior a 15 milh�es.