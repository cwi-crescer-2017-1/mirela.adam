//ex1
function seriesInvalidas(series) {
	let anoAtual = (new Date()).getFullYear();
	let arrayDeSeriesInvalidas = [];
	
	for (let s of series){
		let invalida = false;
		if( s.anoEstreia > anoAtual ) {
			invalida = true;
		}
		
		for (let campo in s) {
			let valor = s[campo];
			if(typeof valor === "undefined" || valor === null) {
				invalida = true;
			}
		}
		
		if(invalida) {
			arrayDeSeriesInvalidas.push(s.titulo);	
		} 
	}
	return "Séries inválidas: " + (arrayDeSeriesInvalidas).join(" - ");
}


//ex2
function filtrarSeriesPorAno(series, ano) {
    return series.filter( (s) => s.anoEstreia >= ano );
}

//ex3 
function mediaDeEpisodios(series) {
	let quantidadeEpisodios = 0;
	series.forEach( (serie) => quantidadeEpisodios += serie.numeroEpisodios );
	return quantidadeEpisodios / series.length;
}

// ex4
function procurarPorNome(series, nome){
	for(let s of series){
		for(let e of s.elenco){
			if(e.toLowerCase().includes(nome.toLowerCase())){
				return true;
			}
		}
	}
	return false;
}

//ex5
function mascadaEmSerie(serie){
	return (serie.diretor.length * 100000) + (serie.elenco.length * 40000);
}

//ex6  
function queroGenero(genero){
	let lista = [];
	for(let s of series){
		for(let g of s.genero){
			if(g.toLowerCase().includes(genero.toLowerCase())){
				lista.push(s.titulo);
			}
		}
	}
	return lista;
}

function queroTitulo(texto) {
	let lista = [];
	series.forEach((s) => {
		if(s.titulo.toLowerCase().includes(texto.toLowerCase())){
			lista.push(s.titulo); }
	})
	return lista;
}

//ex7



//ex8 