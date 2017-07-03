angular.module('app').controller('LoginController', function ($scope, authService, $location, toastr) {

  $scope.login = function (usuario) {

    if ($scope.formLogin.$valid) {
      authService.login(usuario)
        .then(function (response) {
          toastr.success('Login com sucesso!');
          $location.path('/homepage');

        },
        function (response) {
          toastr.error('Login ou Senha inválidos!');
        });
    } else {
      toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
    }
  };

  $scope.cadastrar = function () {
    $location.path('/cadastroUsuario');
  };
});