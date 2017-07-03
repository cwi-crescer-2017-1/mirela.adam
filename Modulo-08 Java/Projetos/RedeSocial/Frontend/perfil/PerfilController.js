angular.module('app').controller('PerfilController', 
            function ($scope, $routeParams, $localStorage, $location, authService, UsuarioService) {
buscarUsuario($routeParams.id);
$scope.logout = authService.logout;
$scope.voltar = voltar;

function buscarUsuario(id) {
      UsuarioService.buscarUsuarioPorId(id).then(function (response) {
             $scope.usuario = response.data;
      })
    };

function voltar(){
    window.history.go(-1);
}

});