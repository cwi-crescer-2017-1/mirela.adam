angular.module('app').factory('AmigoService', function ($http) {
    var urlBase = 'http://localhost:9090/amigos';

    function buscarAmigos(id){
    	return $http.get(urlBase, id);
    };

    return {
    	buscarAmigos: buscarAmigos;
    };
});