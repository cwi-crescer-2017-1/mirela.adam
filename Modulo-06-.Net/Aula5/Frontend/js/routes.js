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
            .when('/administrativo', {
            controller: 'AdministrativoController',
            templateUrl: 'administrativo.html'
            })
            .when('/cadastrarLivro', {
            controller: 'CadastroLivroController',
            templateUrl: 'cadastrarLivro.html'
            })
            .when('/cadastrarAutor', {
            controller: 'CadastroAutorController',
            templateUrl: 'cadastrarAutor.html'
            })
            .otherwise({redirectTo:'/homepage'}); 
    });