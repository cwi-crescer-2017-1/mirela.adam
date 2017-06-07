angular.module('app').config(function ($routeProvider) { 
        $routeProvider 
            .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login/login.html'
            })
            .when('/homepage', { 
            controller: 'HomepagesController', 
            templateUrl: 'homepage/homepage.html' 
        	})
            .when('/cadastrarCliente', {
            controller: 'CadastroClienteController',
            templateUrl: 'cadastroCliente/cadastrarCliente.html'
             })
            .when('/cadastrarLocacao', {
            controller: 'CadastroLocacaoController',
            templateUrl: 'cadastroLocacao/cadastrarLocacao.html'
            })
            .otherwise({redirectTo:'/homepage'}); 
    });