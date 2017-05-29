angular.module('chatCrescer').config(function ($routeProvider) { 
        $routeProvider 
            .when('/chat', { 
            controller: 'MensagensController', 
            templateUrl: './chat.html' 
        })
            .when('/login', { 
            controller: 'UsuariosController', 
            templateUrl: './login.html' 
        })
            .otherwise({redirectTo:'/login'}); 
    });