angular.module('app').controller('HomepageController', 
            function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService) {
    $scope.logout = authService.logout;
    $scope.buscarContatos = buscarContatos;
    $scope.buscarAmigos = buscarAmigos;

    function buscarAmigos(){
    	$location.path('/buscaAmigos');
    }

    function buscarContatos(){
    	$location.path('/buscaUsuarios');
    };
});