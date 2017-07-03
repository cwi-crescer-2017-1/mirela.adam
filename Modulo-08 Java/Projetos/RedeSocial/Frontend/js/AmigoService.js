angular.module('app').factory('AmigoService', function ($http) {
    var urlBase = 'http://localhost:9090/amigos';

    function buscarAmigos() {
        return $http.get(urlBase);
    };

    function adicionarAmizade(id){
        return $http.post(urlBase + '/adicionar/' + id);
    };

    function aceitarSolicitacao(id){
        return $http.post(urlBase + '/aceitar/' + id);
    };

    function recusarSolicitacao(id){
        return $http.post(urlBase + '/recusar/' + id);
    };

    return {
        recusarSolicitacao: recusarSolicitacao,
        adicionarAmizade: adicionarAmizade,
        aceitarSolicitacao: aceitarSolicitacao,
        buscarAmigos: buscarAmigos
    };
}); 