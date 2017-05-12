<!-- ex1 -->
function daisyGame(n) {  
  if(n % 2 === 0) {
  	return "Love me not"
  } else {
  	return "Love me"
  }
} 

<!-- ex2 -->
function maiorTexto(texto) {
 var maior = texto[0];
 for (var i = 1; i < texto.length; i++) { 
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

<!-- ex4 -->
function somarA(a){
	function somarB(b){
		return a+b;
	}
	return somarB;
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
	var precosAbaixo = [0];
	var i = 0;

	for (var valor of precos) { 
  		 if(valor <= mascada){
  		 	precosAbaixo[i++] = valor
  		 }
	}

	for(var cont = 0; cont < precosAbaixo.length; cont++){
		if(precosAbaixo[cont] > precosAbaixo[cont+1]){
			var auxiliar = precosAbaixo[cont];
			precosAbaixo[cont] = precosAbaixo[cont+1];
			precosAbaixo[cont+1] = auxiliar;  
		}
	}


	return precosAbaixo.toString();
}





















