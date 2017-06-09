angular.module('app').controller('LoginController', function ($scope, authService, $location, toastr) {

if(authService.isAutenticado()){
  $location.path('/homepage');
}
  $scope.login = function (usuario) {

    authService.login(usuario)
      .then(
        function (response) {
          toastr.success('Login com sucesso!');

        },
        function (response) {
          toastr.error('Erro no Login!');
        });
  };

});