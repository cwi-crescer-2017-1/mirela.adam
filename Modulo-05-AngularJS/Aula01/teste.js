var myApp = angular.module('Exercicio01', []);

myApp.controller('MainController', function($scope) {
  $scope.pokemon = { nome: 'TESTE', tipo: 'água' };
});

myApp.controller('Exemplo2', function($scope) {
  $scope.pokemons = [
      { nome: ' Poke 1 ', tipo: 'água' },
      { nome: ' Poke 2 ', tipo: 'fogo' },
      { nome: ' Poke 3', tipo: 'ar' }
      ];
});
