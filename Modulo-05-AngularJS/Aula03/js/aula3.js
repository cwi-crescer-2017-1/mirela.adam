var myApp = angular.module('Aula3', []);

myApp.controller('MainController', function($scope) {
  $scope.nomes = ['Bernardo', 'Nunes'];

  $scope.incluir = function(novoNome) {
    if($scope.formulario.$invalid){
      return;
    }
    $scope.nomes.push(novoNome);
    $scope.novoNome = "";
  }

});