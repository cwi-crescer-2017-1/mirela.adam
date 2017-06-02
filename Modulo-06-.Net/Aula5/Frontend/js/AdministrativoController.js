angular.module('editoraCrescer').controller('AdministrativoController', 
            function ($scope, $routeParams, $localStorage, LivrosService, $location) {
        
    ListarLivros();
    $scope.revisar = revisar;
    $scope.publicar = publicar;
    $scope.cadastrarLivro = cadastrarLivro;
    $scope.cadastrarAutor = cadastrarAutor;

    function ListarLivros() {
        LivrosService
        .listarLivros()
        .then(response => {
            $scope.livros = response.data.dados;
        })
    };

    function revisar(livro){

    };

    function publicar(livro){

    };

    function cadastrarAutor(){
         $location.path('/cadastrarAutor');
    };

    function cadastrarLivro(){
         $location.path('/cadastrarLivro');
    };
})