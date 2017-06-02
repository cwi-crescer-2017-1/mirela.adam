angular.module('editoraCrescer').factory('AutoresService', function ($http) {
    var urlBase = 'http://localhost:52428/Api/Autores'

    function listarAutores() {
        return $http.get(urlBase);
    };

    function cadastrarAutor(autor) {
        return $http.post(urlBase, autor);
    };

    function alterarAutor(autor) {
        return $http.put(urlBase, autor);
    };

    function deletarAutor(autor) {
        return $http.delete(urlBase, autor);
    };

    function detalharAutor(autor) {
        return $http.get(urlBase +  "/" + id);
    }

    return {
        listarAutores: listarAutores,
        cadastrarAutor: cadastrarAutor,
        alterarAutor: alterarAutor,
        deletarAutor: deletarAutor,
        detalharAutor: detalharAutor
    };

})