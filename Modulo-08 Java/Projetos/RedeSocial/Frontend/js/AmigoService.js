angular.module('app').factory('AmigoService', function ($http) {
    var urlBase = 'http://localhost:9090/amigos';

    function buscarAmigos(){
    	return $http.get(urlBase);
    };

    return {
    	buscarAmigos: buscarAmigos
    };
});