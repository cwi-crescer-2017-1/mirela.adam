angular.module('app').controller('CadastroUsuarioController', function ($scope, $location, toastr, UsuarioService) {

  $scope.cadastrar = function (usuario) {
    if ($scope.formCadastro.$valid) {
       
        UsuarioService.cadastrarUsuario(usuario).then( function (){
            toastr.success('Cadastro com sucesso! Faça o Login');
            $location.path('/login.html');
        });
    } else {
        toastr.warning('Preencha todos os dados corretamente.', 'Dados inválidos!');
    }
  };

  $scope.voltar = function(){
    $location.path('/login.html');
  };
});