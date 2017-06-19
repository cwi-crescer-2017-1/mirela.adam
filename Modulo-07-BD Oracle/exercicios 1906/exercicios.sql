/*
Exercício 1
Auditoria Loteria
Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. A auditoria deve monitorar tanto as apostas quanto os números de cada aposta.
*/

Create table LogAposta (
  IDLogAposta   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
  IDAposta       integer not null,
    constraint PK_LogAposta 
       primary key (IDLogAposta)
);

Create table LogNumeroAposta (
  IDLogNumeroAposta  integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
  IDNumeroAposta       integer not null,
    constraint PK_LogNumeroAposta 
       primary key (IDLogNumeroAposta)
);

Create sequence sqLogAposta;

Create sequence sqLogNumeroAposta;

---
create or replace
trigger TR_AUD1_APOSTA
    after insert or update or delete on APOSTA
    for each row
Declare
  v_operacao char(1);
  v_IDAposta integer;
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDAposta := :new.IDAposta;
  elsif UPDATING then
     v_operacao := 'U';       
     v_IDAposta := :old.IDAposta;
  else
     v_operacao := 'D';
     v_IDAposta := :old.IDAposta;
  end if;
  
  insert into LogAposta (idlogaposta, usuario, data, operacao, idaposta)
  values (sqlogaposta.nextval, user, sysdate, v_operacao, v_idaposta);

End TR_AUD1_APOSTA;

----

create or replace
trigger TR_AUD1_NUMEROAPOSTA
    after insert or update or delete on NUMERO_APOSTA
    for each row
Declare
  v_operacao char(1);
  v_IDNumeroAposta integer;
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDNumeroAposta := :new.IDNumero_Aposta;
  elsif UPDATING then
     v_operacao := 'U';       
     v_IDNumeroAposta := :old.IDNumero_Aposta;
  else
     v_operacao := 'D';
     v_IDNumeroAposta := :old.IDNumero_Aposta;
  end if;
  
  insert into LogNumeroAposta (idlognumeroaposta, usuario, data, operacao, idnumeroaposta)
  values (sqlogaposta.nextval, user, sysdate, v_operacao, v_idnumeroaposta);

End TR_AUD1_NUMEROAPOSTA;

/*
Exercício 2
TOP Estados
Liste os estados com maior número de apostas, e maior valor arrecadado em cada concurso. 
Adicionalmente também deve ser exibido o total de acertadores e o valor da premiação em cada estado.
*/

select ci.uf, count(a.idaposta) as quantidade, a.idconcurso
from aposta a
  inner join cidade ci on ci.idcidade = a.idcidade
  inner join concurso co on co.idconcurso = a.idconcurso
group by ci.uf, a.idconcurso
order by idconcurso, quantidade desc;

----

select ci.uf, sum(a.valor) as valor, a.idconcurso
from aposta a
  inner join cidade ci on ci.idcidade = a.idcidade
  inner join concurso co on co.idconcurso = a.idconcurso
group by ci.uf, a.idconcurso
order by idconcurso, valor desc;

---

select c.uf, count(ap.IdAposta_Premiada) as TotalAcertadores, sum(ap.valor) as ValorPremiacao
from aposta_premiada ap
  inner join aposta a on a.idaposta = ap.idaposta
  inner join cidade c on a.idcidade = c.idcidade
group by c.uf
order by totalacertadores desc, valorpremiacao ;

--------------------------------------------------------------------------------------------------

/*
Exercício 3
Identificação de Fraude
Crie uma view para consultar possibilidades de fraudes. 
Inicialmente identifique apostas com registro (log) de criação/alteração executado após a data do sorteio.
*/

create or replace view vw_PossibilidadeFraude as

select la.idaposta, c.idconcurso, c.data_sorteio as DataSorteio, la.data as DataLog
from logaposta la
  inner join aposta a on a.idaposta = la.idaposta
  inner join concurso c on c.idconcurso = a.idconcurso
where la.data > c.data_sorteio
and la.operacao in ('I','U')

UNION

select a.idaposta, c.idconcurso, c.data_sorteio as DataSorteio, lna.data as DataLog
from lognumeroaposta lna
  inner join numero_aposta na on na.idnumero_aposta = lna.idnumeroaposta 
  inner join aposta a on a.idaposta = na.idaposta
  inner join concurso c on c.idconcurso = a.idconcurso
where lna.data > c.data_sorteio
and lna.operacao in ('I','U');








