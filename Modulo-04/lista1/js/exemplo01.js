<!-- ex1 -->
function daisyGame(numero) {
  return numero % 2 !== 0 ? 'Love me' : 'Love me not';
}

<!-- ex2 -->
function maiorTexto(texto) {
 var maior = texto.length > 0 ? texto[0] : "";
 for (let i = 1; i < texto.length; i++) {
   if (texto[i].length > maior.length){
   	maior = texto[i];
   }
 }
 return maior;
}

<!-- ex3 -->
function imprime(arrayStrings,funcao){

	if(typeof funcao === 'function'){
    for (var instrutor of arrayStrings) {
  			funcao(instrutor);
		}
	} else {
		console.log("Chamada incorreta, ao invés de uma função foi passado um(a): ", typeof funcao);
	}
}

function instrutor(nome){
	console.log("Olá querido instrutor: ", nome);
}

//outra solução
function imprime(textos, funcaoParaExecutar) {
  textos.forEach(funcaoParaExecutar);
}

imprime (
  ['bernardo','nunes','php','zanatta','fabricio','jotz','carlos'],
  function(instrutor){
    console.log('ola querido instrutor: ', instrutor);
  }
);


<!-- ex4 -->
function somarA(a){
	function somarB(b){
		return a+b;
	}
	return somarB;
}

//outra solucao
function adicionar(numero1){
    return function(numero2) {
      return numero1 + numero2;
    }
}


<!-- ex5 -->
function fiboSum(n){
	var soma =0;
	while(n > 0){
		soma += (fibonacci(n));
		n--;
	}
	return soma;
}


function fibonacci (a){
	if(a <= 2){
		return 1;
	} else {
		return fibonacci(a-1) + fibonacci(a-2);
	}
}

<!-- ex6 -->
function queroCafe(mascada, precos){
	var precosAbaixo = [];

	for (var valor of precos) {
  		 if(valor <= mascada){
  		 	precosAbaixo.push(valor);
  		 }
	}

	for(var i = 0; i < precosAbaixo.length; i++){
		if(precosAbaixo[i] > precosAbaixo[i+1]){
			var auxiliar = precosAbaixo[i];
			precosAbaixo[i] = precosAbaixo[i+1];
			precosAbaixo[i+1] = auxiliar;
		}
	}


	return precosAbaixo.toString();
}
//v.sort
