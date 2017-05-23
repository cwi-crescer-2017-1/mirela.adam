angular.module('myApp').config(function ($routeProvider) { 
 
  $routeProvider 
    .when('/home', {
      controller: 'HomeController', 
      templateUrl: 'home/home.html'
    })
    .when('/aulas', { 
      controller: 'AulaController', 
      templateUrl: 'aula/aulas.html' 
    }) 
    .when('/instrutores', { 
      controller: 'InstrutorController', 
      templateUrl: 'instrutor/instrutores.html' 
    }) 
    .otherwise({redirectTo: '/home'}); 
}); 
