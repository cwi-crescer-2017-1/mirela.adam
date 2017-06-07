angular.module('app').factory('OpcionaisService', function ($http) {
    var urlBase = 'http://localhost:55732/Api/Opcionais'

    function listarOpcionais() {
        return $http.get(urlBase);
    };

    return {
        listarOpcionais: listarOpcionais
    };

})