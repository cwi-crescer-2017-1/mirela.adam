angular.module('editoraCrescer').config(function ($routeProvider) { 
        $routeProvider 
            .when('/homepage', { 
            controller: 'LivrosController', 
            templateUrl: '/homepage.html' 
        	})
        	.when('/livros/:isbn', {
            controller: 'DetalhesLivroController',
            templateUrl: 'detalhesLivro.html'
            })
            .otherwise({redirectTo:'/homepage'}); 
    });