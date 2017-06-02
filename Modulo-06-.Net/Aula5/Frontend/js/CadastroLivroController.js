angular.module('editoraCrescer').controller('CadastroLivroController', 
            function ($scope, $routeParams, $localStorage, AutoresService, LivrosService, $location) {
            
    ListarAutores();
    $scope.autores = []; 
    $scope.cadastrar = cadastrar;

    function ListarAutores() {
        AutoresService
        .listarAutores()
        .then(response => {
           $scope.autores = response.data.dados;
        })
    };

    function cadastrar(livro){
        livro.Isbn = 0;
        livro.IdRevisor = 0;
        let codAutor = livro.idAutor;
        console.log(codAutor);
        console.log(livro.idautor);
        LivrosService.cadastrarLivro(livro)
                    .then( function() {
                        window.alert('Cadastrado com sucesso!')
                        $location.path('/administrativo' + livro.Isbn); 
                    });
    };

});