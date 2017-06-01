angular.module('editoraCrescer').controller('LivrosController', 
            function ($scope, $routeParams, $localStorage, LivrosService) {

    $scope.ListarLancamentos = ListarLancamentos;
    $scope.ListarLivros = ListarLivros;

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