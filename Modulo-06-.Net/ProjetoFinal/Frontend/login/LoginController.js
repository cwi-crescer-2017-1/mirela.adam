angular.module('app').controller('LoginController', function ($scope, authService, $location) {

if(authService.isAutenticado()){
  $location.path('/homepage');
}
  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          alert('Login com sucesso!');

        },
        function (response) {
          alert('Erro no Login!');
        });
  };

});