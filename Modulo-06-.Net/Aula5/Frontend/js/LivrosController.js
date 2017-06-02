angular.module('editoraCrescer').controller('LivrosController', 
            function ($scope, $routeParams, $localStorage, LivrosService) {

    $scope.ListarLancamentos = ListarLancamentos;
    $scope.ListarLivros = ListarLivros;
    $scope.VerDetalhes = VerDetalhes;
    ListarLancamentos();
    ListarLivros();

    function ListarLancamentos() {
        LivrosService
        .listarLancamentos()
        .then(response => {
            $scope.lancamentos = response.data.dados;
        })
    }

    function ListarLivros() {
        LivrosService
        .listarLivros()
        .then(response => {
            $scope.livros = response.data.dados;
        })
    }

    function VerDetalhes(livro){
        $sope.livroDetalhado = livro;
        location.href = '#!/detalhesLivro';
    }
})

/*

$scope.paginacao = {
    quantidadePular: ...
    quantidadeTrazer: 6;
}

$http(
    {
      url: localhost...
      method: GET
      params:  ...
    }
)

 */