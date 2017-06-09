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
            .when('/relatorioMensal', { 
            controller: 'RelatoriosController', 
            templateUrl: 'relatorios/relatorioMensal.html' 
        	})
            .when('/relatorioAtrasos', { 
            controller: 'RelatoriosController', 
            templateUrl: 'relatorios/relatorioAtrasos.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              }
        	})
            .when('/cadastrarCliente', {
            controller: 'CadastroClienteController',
            templateUrl: 'cadastroCliente/cadastrarCliente.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              }
             })
            .when('/devolucao', { 
            controller: 'DevolucoesController', 
            templateUrl: 'devolucao/devolucao.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        	})
            .when('/cadastrarLocacao', {
            controller: 'CadastroLocacaoController',
            templateUrl: 'cadastroLocacao/cadastrarLocacao.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              }
            })
            .otherwise({redirectTo:'/login'}); 
    });