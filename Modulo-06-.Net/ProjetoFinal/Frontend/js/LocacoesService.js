angular.module('app').factory('LocacoesService', function ($http) {
    var urlBase = 'http://localhost:55732/Api/Locacoes'

    function listarLocacoes() {
        return $http.get(urlBase);
    };

    function cadastrarLocacao(locacao) {
        return $http.post(urlBase, locacao);
    };

    function listarLocacoesNaoDevolvidas(){
        return $http.get(urlBase + '/devolucoes');
    };

    function listarLocacoesAtrasadas(){
        return $http.get(urlBase + '/atrasadas');
    }

    function devolver(locacao){
        return $http.put(urlBase + '/' + locacao.Id, locacao);
    };

    function listarLocacoesMensais(dataFiltro) {
        return $http.get(`${urlBase}/${dataFiltro.toISOString().split('T')[0]}`);
    }

    return {
        listarLocacoes: listarLocacoes,
        devolver: devolver,
        cadastrarLocacao: cadastrarLocacao,
        listarLocacoesNaoDevolvidas: listarLocacoesNaoDevolvidas,
        listarLocacoesAtrasadas: listarLocacoesAtrasadas,
        listarLocacoesMensais: listarLocacoesMensais
    };

})