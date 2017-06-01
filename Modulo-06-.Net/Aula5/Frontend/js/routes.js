angular.module('editoraCrescer').config(function ($routeProvider) { 
        $routeProvider 
            .when('/homepage', { 
            controller: 'LivrosController', 
            templateUrl: '/homepage.html' 
        })
            .otherwise({redirectTo:'/homepage'}); 
    });