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

    function devolver(locacao){
        return $http.put(urlBase + '/' + locacao.Id, locacao);
    };

    return {
        listarLocacoes: listarLocacoes,
        devolver: devolver,
        cadastrarLocacao: cadastrarLocacao,
        listarLocacoesNaoDevolvidas: listarLocacoesNaoDevolvidas
    };

})