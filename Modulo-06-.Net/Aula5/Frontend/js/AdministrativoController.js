angular.module('editoraCrescer').controller('AdministrativoController', 
            function ($scope, $routeParams, $localStorage, LivrosService, AutoresService, $location) {
        
    ListarLivros();
    ListarAutores();

    $scope.revisar = revisar;
    $scope.publicar = publicar;
    $scope.cadastrarLivro = cadastrarLivro;
    $scope.cadastrarAutor = cadastrarAutor;
    $scope.excluirLivro = excluirLivro;
    $scope.excluirAutor = excluirAutor;
    $scope.editarAutor = editarAutor;

    function ListarLivros() {
        LivrosService
        .listarLivros()
        .then(response => {
            $scope.livros = response.data.dados;
        })
    };

    function ListarAutores() {
        AutoresService
        .listarAutores()
        .then(response => {
            $scope.autores = response.data.dados;
        })
    };

    function excluirLivro(livro){

    let confirmou = confirm('Confirma exclusão do livro?');
    if(confirmou){
       LivrosService   .excluirLivro(livro.Isbn)
                        .then(response => {
                            window.alert('Livro excluído com sucesso!');
                            ListarLivros();
                        })
    }}

    function excluirAutor(autor){
    let confirmou = confirm('Confirma exclusão do autor?');
    if(confirmou){
       AutoresService   .excluirAutor(autor.Id)
                        .then(response => {
                            window.alert('Autor excluído com sucesso!');
                            ListarAutores();
                        })
    }}


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

    function editarAutor(autor){
      $location.path('/editarAutor/' + autor.Id);
    }
})