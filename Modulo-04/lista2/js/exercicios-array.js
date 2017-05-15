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
function creditosIlluminatis(serie) {
  	function ordenaPorSobrenome(a,b){
  		a = a.split(' ');
    	b = b.split(' ');
    	a = a[a.length - 1];
    	b = b[b.length - 1];

    	if (a < b) {
      		return -1
    	} else if (a > b) {
      		return 1;
    	} else {
      		return 0;
    	}
	}

	 return console.log(
    `Título:\n${serie.titulo}\n
    Diretores:\n${serie.diretor.sort(ordenaPorSobrenome).join(', ')}\n
    Elenco:\n${serie.elenco.sort(ordenaPorSobrenome).join(', ')}`
  );
}
//ex8
function easterEgg (series) {
	let letras = [];
	let elencoComAbreviacao=[];

	for (let s of series){
		let todosNomesComAbreviacao = true;
		let elenco = Object.values(s.elenco);

		for (let nome of elenco) {
      		if (!nome.includes('.')) {
        	todosNomesComAbreviacao = false;

      	}
		}
		if(todosNomesComAbreviacao && s.elenco.length-1 === elenco.length-1 ){
			elencoComAbreviacao.push(Object.values(s.elenco));
		}
	}
	elencoComAbreviacao = elencoComAbreviacao.toString().split(' ');

	for (let l of elencoComAbreviacao) {
    	if ( l[(l.indexOf(" ") + 2)] === "." ) {
      		letras.push(l[l.indexOf(".") - 1]);
  	}
	}

  return console.log( `# ${letras.join('')}` );

}
