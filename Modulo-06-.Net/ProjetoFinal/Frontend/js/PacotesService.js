angular.module('app').factory('PacotesService', function ($http) {
    var urlBase = 'http://localhost:55732/Api/Pacotes'

    function listarPacotes() {
        return $http.get(urlBase);
    };

    return {
        listarPacotes: listarPacotes
    };

})