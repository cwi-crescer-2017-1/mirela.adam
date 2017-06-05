angular.module('editoraCrescer')
    .controller('EdicaoAutorController', function ($scope, AutoresService, $routeParams, $location) {
    buscarAutor($routeParams.id);
   
    $scope.Voltar = Voltar;
    $scope.editar = editar;

    function buscarAutor(id) {
        AutoresService.detalharAutor(id).then(function (response) {
             $scope.autor = response.data.dados[0];
      })
    };

    function editar(autor){
        AutoresService  .alterarAutor(autor).then(function (response){
             window.alert('Autor alterado com sucesso!');
             $location.path('/administrativo');
        })
    }

    function Voltar(){
        $location.path('/administrativo');
    }
});