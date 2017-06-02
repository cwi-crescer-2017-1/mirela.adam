angular.module('editoraCrescer')
    .controller('DetalhesLivroController', function ($scope, LivrosService, $routeParams, $location) {
    $scope.Voltar = Voltar;

    buscarLivro($routeParams.isbn);

    function buscarLivro(isbn) {
        LivrosService.detalharLivro(isbn).then(function (response) {
             $scope.livroDetalhado = response.data.dados;
      })
    };

    function Voltar(){
        $location.path('/homepage');
    }
});