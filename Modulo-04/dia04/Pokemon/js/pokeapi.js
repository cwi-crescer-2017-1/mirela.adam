
document.addEventListener('DOMContentLoaded', function() { 

var imgPokemon = document.getElementById('img-pokemon');
let btnPesquisar = document.getElementById('btnPesquisar');
var inputNumeroPokemon = document.getElementById('numeroPkm');

btnPesquisar.onclick = function () {
	fetch('https://pokeapi.co/api/v2/pokemon/'+inputNumeroPokemon.value+'/')
	.then(response => response.json()) 
  	.then(json => { 
    	let div = document.getElementById('detalhesPokemon'); 
      	let img = document.createElement('img'); 
      	let nomePokemon = document.createElement('h1');
      	let numeroPokemon = document.createElement('h3');
      	
      	nomePokemon.innerText = "Nome: " +  json.name;
    	numeroPokemon.innerText = "Número: " + json.id;

      	img.src = json.sprites.front_default; 
      	 
      	div.append(nomePokemon);
		div.append(numeroPokemon);
      	div.append(img);
		
        let tiposDoPokemon = json.types;
    	
    	for (tipos of tiposDoPokemon){
	        var elemento = document.createElement('li');  
    	    var textoElemento = document.createTextNode(tipos.type.name);  
        	elemento.appendChild(textoElemento);
        	div.appendChild(elemento);
    	}
    
    	json.stats.forEach (x => {
            let s = document.createElement("h3");
            s.innerText = x.stat.name;
            let progress = document.createElement("progress");
            progress.max = 100;
            progress.value = x.base_stat;
            div.appendChild(s);
            div.appendChild(progress);
        });

    })
   }
})    