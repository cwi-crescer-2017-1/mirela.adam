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

//outra solucao
function seriesInvalidas1(series){
	function serieInvalida1(serie) {
		let algumCampoInvalido = Object.values(serie).some(v => v === null || typeof v === 'undefined');
		let anoEstreiaInvalido = serie.anoEstreia > new Date().getFullYear();
		return anoEstreiaInvalido || algumCampoInvalido;
	}
	let invalidas = series.filter(serieInvalida1);
	return `Séries inválidas: ${invalidas.map(s => s.titulo).join(" - ") }`;
}

//ex2
function filtrarSeriesPorAno(series, ano) {
    return series.filter( s => s.anoEstreia >= ano );
}

//ex3
function mediaDeEpisodios(series) {
	let quantidadeEpisodios = 0;
	series.forEach( serie => quantidadeEpisodios += serie.numeroEpisodios );
	return quantidadeEpisodios / series.length;
}

//outras soluções
function mediaDeEpisodios1(series){
	return series.reduce( (a,b) => a + b.numeroEpisodios, 0 ) / series.length;
}

function mediaDeEpisodios2(series){
	return series
		.map(e => e.numeroEpisodios)
		.reduce( (a,b) => a + b ) / series.length;
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
//outra soluçao
function procurarPorNome1 (series, nome) {
	return series.some( s => s.elenco.some(e => e.includes(nome) ));
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

//outra solução
function queroGenero1 (genero) {
	return series
		.filter (s => s.genero.includes(genero))
		.map(m => m.titulo);
}

function queroTitulo(texto) {
	let lista = [];
	series.forEach((s) => {
		if(s.titulo.toLowerCase().includes(texto.toLowerCase())){
			lista.push(s.titulo); }
	})
	return lista;
}
//outra solução
function queroTitulo1 (titulo){
	return series
		.filter(s => s.titulo.toLowerCase().includes(titulo.toLowerCase()))
		.map(m => m.titulo);
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

//outra solucao
function creditosIlluminatis1(serie){
	let criterioOrdenacao = (s1,s2) => {
		let obterUltimoNome = (s) => {
			let partesNome = s.split(" ");
			return partesNome[partesNome.length - 1];
		}

		return obterUltimoNome(s1).localeCompare(obterUltimoNome(s2));
	}

	let diretoresOrdenados = serie.diretor.sort(criterioOrdenacao);
	let elencoOrdenado = serie.elenco.sort(criterioOrdenacao);

	console.log(serie.titulo);
	console.log("Diretor(es)");
	console.log(diretoresOrdenados);
	console.log("Elenco");
	console.log(elencoOrdenado);
}

String.prototype.pegarUltimoNome = function() {
	let partesNome = this.trim().split(" ");
	return partesNome[partesNome.length - 1];
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

//outra solucao
function easterEgg1(){
	let elencoSerie = series
		.find(s => s.elenco.every(e => e.temAbreviacao()))
		.elenco
		.map(e => e.match(/ [a-z][.] /gi)[0][1])
		.join("");
	return `#${ elencoSerie }`;
}
