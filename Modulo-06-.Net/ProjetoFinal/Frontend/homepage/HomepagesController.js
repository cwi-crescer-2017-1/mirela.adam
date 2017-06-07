angular.module('app').controller('HomepagesController', 
            function ($scope, $routeParams, $localStorage, $location, authService) {

    $scope.cadastrarCliente = cadastrarCliente;
    $scope.cadastrarLocacao = cadastrarLocacao;
    $scope.gerarRelatorioMensal = gerarRelatorioMensal;
    $scope.gerarRelatorioAtrasos = gerarRelatorioAtrasos;
    $scope.devolver = devolver;
    $scope.logout = authService.logout;
    $scope.colaborador = authService.possuiPermissao('Colaborador');
    $scope.gerente = authService.possuiPermissao('Gerente');
    
    function gerarRelatorioMensal(){
        $location.path('/relatorioMensal');
    };

    function gerarRelatorioAtrasos(){
        $location.path('/relatorioAtrasos');
    };

    function devolver() {
        $location.path('/devolucao');
    };

    function cadastrarCliente(){
        $location.path('/cadastrarCliente');
    };

    function cadastrarLocacao(){
        $location.path('/cadastrarLocacao');
    };

});