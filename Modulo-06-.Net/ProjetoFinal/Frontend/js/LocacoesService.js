angular.module('app').factory('LocacoesService', function ($http) {
    var urlBase = 'http://localhost:55732/Api/Locacoes'

    function listarLocacoes() {
        return $http.get(urlBase);
    };

    function cadastrarLocacao(locacao) {
        return $http.post(urlBase, locacao);
    };

    return {
        listarLocacoes: listarLocacoes,
        cadastrarLocacao: cadastrarLocacao
    };

})