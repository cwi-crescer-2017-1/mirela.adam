angular.module('app').factory('PostService', function ($http) {
    var urlBase = 'http://localhost:9090/postagens';

    function buscarPostagens(id) {
        return $http.get(urlBase + "/home/" + id);
    };

    function cadastrarPost(postagem) {
        return $http.post(urlBase, postagem);
    };

    function buscarPostagensPorUsuario(id){
        return $http.get(urlBase + "/" + id);
    }

    return {
        cadastrarPost: cadastrarPost,
        buscarPostagens: buscarPostagens,
        buscarPostagensPorUsuario: buscarPostagensPorUsuario
    };

})