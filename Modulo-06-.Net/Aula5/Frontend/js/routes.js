angular.module('editoraCrescer').config(function ($routeProvider) { 
        $routeProvider 
            .when('/homepage', { 
            controller: 'LivrosController', 
            templateUrl: '/homepage.html' 
        	})
        	.when('/detalhesLivro',{
        	controller: 'LivrosController',
        	templateUrl: '/detalhesLivro.html'
        	})
            .otherwise({redirectTo:'/homepage'}); 
    });