angular.module('app').factory('SolicitacaoService', function ($http) {
    var urlBase = 'http://localhost:9090/solicitacoes';

    function carregarSolicitacoes() {
        return $http.get(urlBase);
    };

    return {
        carregarSolicitacoes: carregarSolicitacoes
    };
}); 