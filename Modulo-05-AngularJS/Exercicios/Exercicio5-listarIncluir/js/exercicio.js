var myApp = angular.module('Aula3', []);

myApp.controller('MainController', function($scope) {
  let aulas = [ 
  'OO', 
  'HTML e CSS' ,
  'Javascript' ,
  'AngularJS' ,
  'Banco de Dados I' 
  ]; 
  
  $scope.aulas = aulas;

  var instrutores = [{
    nome: 'Bernardo',
    sobrenome: 'Rezende',
    idade: 30,
    email: 'bernardo@cwi.com.br',
    jaDeuAula: true,
    aula: 'OO'
  }
];

  $scope.instrutores = instrutores;

  $scope.incluir = function() {
      if($scope.formulario.$invalid){
         return;
      }
      let copiaNovoInstrutor = angular.copy($scope.novoInstrutor);
      $scope.instrutores.push(copiaNovoInstrutor);

      $scope.novoInstrutor = {};
  }

});