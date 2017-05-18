var myApp = angular.module('Exercicio01', []);

myApp.controller('Exercicio', function($scope) {
  $scope.pokemons = [
      { nome: ' Poke 1 ', tipo: 'água' },
      { nome: ' Poke 2 ', tipo: 'fogo' },
      { nome: ' Poke 3', tipo: 'ar' }
      ];
});
