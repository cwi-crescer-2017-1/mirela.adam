var myApp = angular.module('Exercicio01', []);

myApp.controller('Exercicio', function($scope) {
  $scope.pokemons = [
      { nome: 'Venusaur', tipo: 'Grass' },
      { nome: 'Charmander', tipo: 'Fire' },
      { nome: 'Persian', tipo: 'Normal' },
	  { nome: 'Pikachu', tipo: 'Electric' },
	  { nome: 'Nidoran-m', tipo: 'Poison' },
	  { nome: 'Kingler', tipo: 'Water' },
	  { nome: 'Kakuna', tipo: 'Poison' },
	  { nome: 'Vileplume', tipo: 'Grass' },
	  { nome: 'Meowth', tipo: 'Normal' },
	  { nome: 'Swablu', tipo: 'Flying' }
      ];
});
