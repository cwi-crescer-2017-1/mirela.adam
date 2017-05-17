
document.addEventListener('DOMContentLoaded', function() { 

var imgPokemon = document.getElementById('img-pokemon');
let btnPesquisar = document.getElementById('btnPesquisar');
var inputNumeroPokemon = document.getElementById('numeroPkm');
var nomePokemon = document.getElementById('nomePokemon');
var tiposPkm = document.getElementById('tipos');

btnPesquisar.onclick = function () {
	fetch('https://pokeapi.co/api/v2/pokemon/'+inputNumeroPokemon.value+'/')
	.then(response => response.json()) 
  	.then(json => { 
    	let div = document.getElementById('detalhesPokemon'); 
      	let img = document.createElement('img'); 
      	let h1 = document.createElement('h1');
      	let h3 = document.createElement('h3');
      	
      	nomePokemon.innerText = "Nome: " +  json.name;
    	numeroPokemon.innerText = "Número: " + json.id;

      	img.src = json.sprites.front_default; 
      	 
      	div.append(h1);
      	div.append(img);
        let tiposDoPokemon = json.types;
    	
    	for (tipos of tiposDoPokemon){
	        var elemento = document.createElement('li');  
    	    var textoElemento = document.createTextNode(tipos.type.name);  
        	elemento.appendChild(textoElemento);
        	tiposPkm.appendChild(elemento);
    	}
    })
   }
})    