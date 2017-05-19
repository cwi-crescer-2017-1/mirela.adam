
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
      	let tiposTitulo = document.createElement('h3');
        let nomePkmJson = json.name;

        nomePokemon.innerText = "Nome: " +  nomePkmJson.replace(nomePkmJson.charAt(0), nomePkmJson.charAt(0).toUpperCase());
    	  numeroPokemon.innerText = "Número: " + json.id;
        tiposTitulo.innerText = "Tipos:";

      	img.src = json.sprites.front_default; 
       	div.append(nomePokemon);
		    div.append(numeroPokemon);
      	div.append(img);
		    div.append(tiposTitulo);
        let tiposDoPokemon = json.types;
    	
    	for (tipos of tiposDoPokemon){
	        var elemento = document.createElement('li');  
    	    var textoElemento = document.createTextNode(tipos.type.name.replace(tipos.type.name.charAt(0), 
                                                      tipos.type.name.charAt(0).toUpperCase()));  
        	elemento.appendChild(textoElemento);
        	div.appendChild(elemento);
    	}
    
    	json.stats.forEach (x => {
            let s = document.createElement("p");
            s.innerText = x.stat.name.replace(x.stat.name.charAt(0), x.stat.name.charAt(0).toUpperCase());
            let progress = document.createElement("progress");
            progress.max = 100;
            progress.value = x.base_stat;
            div.appendChild(s);
            div.appendChild(progress);
        });

    })
   }
})    