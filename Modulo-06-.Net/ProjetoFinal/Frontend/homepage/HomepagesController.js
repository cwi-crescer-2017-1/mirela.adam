angular.module('app').controller('HomepagesController', 
            function ($scope, $routeParams, $localStorage, $location) {

    $scope.cadastrarCliente = cadastrarCliente;
    $scope.cadastrarLocacao = cadastrarLocacao;

    function cadastrarCliente(){
        $location.path('/cadastrarCliente');
    }

    function cadastrarLocacao(){
        $location.path('/cadastrarLocacao');
    }
});