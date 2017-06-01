angular.module('editoraCrescer').factory('LivrosService', function ($http) {
    var urlBase = 'http://localhost:52428/Api/Livros'

    function listarLivros() {
        return $http.get(urlBase);
    };

    function listarLancamentos() {
        return $http.get(urlBase + "/Lancamentos");
    };

    function detalharLivro(isbn) {
        return $http.get(urlBase + "/" + isbn);
    };

    function cadastrarLivro(livro) {
        return $http.post(urlBase, livro);
    };

    function alterarLivro(livro) {
        return $http.put(urlBase, livro);
    };

    return {
        listarLivros: listarLivros,
        listarLancamentos: listarLancamentos,
        detalharLivro: detalharLivro,
        cadastrarLivro: cadastrarLivro,
        alterarLivro: alterarLivro
    };

})