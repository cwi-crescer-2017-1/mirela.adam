<!-- ex1 -->
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


<!-- ex2 -->
function filtrarSeriesPorAno(series, ano) {
    return series.filter( (s) => s.anoEstreia >= ano );
}

<!-- ex3 -->

function mediaDeEpisodios(series) {
	let quantidadeEpisodios = 0;
	series.forEach( (serie) => quantidadeEpisodios += serie.numeroEpisodios );
	return quantidadeEpisodios / series.length;
}
<!-- ex4 -->
<!-- ex5 -->
<!-- ex6 --> 
<!-- ex7 --> 
<!-- ex8 --> 