angular.module('app').factory('PostService', function ($http) {
    var urlBase = 'http://localhost:9090/postagens';

    function listarPosts() {
        return $http.get(urlBase);
    };

    function cadastrarPost(postagem) {
        return $http.post(urlBase, postagem);
    };

    return {
        cadastrarPost: cadastrarPost,
        buscarPostagens: listarPosts
    };

})