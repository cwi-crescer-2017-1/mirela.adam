angular.module('app').config(function ($routeProvider) { 
        $routeProvider 
            .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login/login.html'
        })
        .when('/cadastroUsuario', {
            controller: 'CadastroUsuarioController',
            templateUrl: 'cadastroUsuario/cadastroUsuario.html'
        })
            .when('/homepage', { 
            controller: 'HomepageController', 
            templateUrl: 'homepage/homepage.html',
            resolve: {
                autenticado: function (authService) {
                  return authService.isAutenticadoPromise();
                }
              } 
        	})
            .otherwise({redirectTo:'/login'}); 
});
